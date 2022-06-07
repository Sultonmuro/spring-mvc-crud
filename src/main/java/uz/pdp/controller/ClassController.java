package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.entity.Class;
import uz.pdp.repository.ClassRepository;

import java.util.List;

@Controller
@RequestMapping("/class")
public class ClassController {
    @Autowired
    ClassRepository classRepository;
    @GetMapping("/allClass")
    public ModelAndView getAll(ModelAndView mv){
        List<Class> class_list = classRepository.read();
        mv.addObject("classList",class_list);
        mv.setViewName("/read");
        return mv;
    }

    @PostMapping("/add_class")
    public ModelAndView Add_class (@ModelAttribute("class")Class sinf,ModelAndView mv){
        int count = classRepository.create(sinf);
        if(count== 0){
            mv.addObject("ketmon","Saved");
        }else{
            mv.addObject("ketmon","Error");
        }
        return  mv;
    }
}

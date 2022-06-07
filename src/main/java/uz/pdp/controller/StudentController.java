package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.entity.Student;
import uz.pdp.repository.StudentRepository;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @GetMapping("/all")
    public ModelAndView getAll(ModelAndView mv){
        List<Student> studentList = studentRepository.read();
        mv.addObject("listStudent",studentList);
       mv.setViewName("/read");
       return mv;
    }
@PostMapping("/add")
    public ModelAndView getAddPage(ModelAndView w ){
        w.setViewName("create");
        return w;
}
@PostMapping ( "/add")
    public ModelAndView saveStudent(@ModelAttribute("student") Student student,ModelAndView modelAndView){
        int num = studentRepository.create(student);
        if(num==0){
            modelAndView.addObject("ketmon","Saved");
        }else{
            modelAndView.addObject("ketmon","Error");
        }
        return modelAndView;
}
@PostMapping("/update/{id}")
    public ModelAndView getUpdate(@PathVariable Integer id,ModelAndView mv){
        List<Student> students = studentRepository.read();
        Student student = new Student();
        mv.addObject("ketmon",student);
        mv.setViewName("update");
        return mv;
}
@PostMapping("/update")
    public  ModelAndView updateStudent(@ModelAttribute Student student,ModelAndView mv){
    int update = studentRepository.update(student);
    if(update>0){
        mv.addObject("ketmon","Student records are not available");
    }else if (update >=1 ){
        mv.addObject("ketmon","Student records are available");

    }
    return  mv;}

    @PostMapping("/delete")
    public ModelAndView deleteStudent(@ModelAttribute int student, ModelAndView mv){
        int delete = studentRepository.delete(student);
        if(delete == 0){
            mv.addObject("ketmon","Error");

        }else if (delete ==1 || delete ==2 ){
            mv.addObject("ketmon","Success");
        }
        mv.setViewName("delete");
        return mv;
    }

    @GetMapping("/test")
public String test(){
    return "Salum ";
}
}

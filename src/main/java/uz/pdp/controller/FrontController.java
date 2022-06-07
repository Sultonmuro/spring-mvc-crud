package uz.pdp.controller;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import uz.pdp.config.WebMvcConfig;

public class FrontController extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebMvcConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}

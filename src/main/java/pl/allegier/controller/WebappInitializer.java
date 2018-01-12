package pl.allegier.controller;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import pl.allegier.controller.MvcConfig;
import pl.allegier.controller.WebSecurityConfig;

/**
 * Created by Pawel Szczepkowski | GoreIT on 03.04.17.
 */
public class WebappInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {MvcConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

}
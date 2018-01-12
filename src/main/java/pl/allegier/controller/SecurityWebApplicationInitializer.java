package pl.allegier.controller;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @author Pawel Szczepkowski | GoreIT on 18.04.17.
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityWebApplicationInitializer() {
        super(WebSecurityConfig.class);
    }


}

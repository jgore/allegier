package pl.allegier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * @author Pawel Szczepkowski | GoreIT on 18.04.17.
 */
@Configuration("mySecurityConfig")
@EnableWebSecurity
@ComponentScan("pl.allegier.controller")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * custom Auth Provider because default doesnt work
      */

    @Autowired
    private AuthenticationProvider authenticationProvider;

    /**
     * Conf globals
     * @param auth
     * @throws Exception
     */

    @Autowired
    public final void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
        User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN", "USER").build();
        auth.authenticationProvider(authenticationProvider);
    }

    /**
     * configure for web only
     * @param web web paaram
     * @throws Exception exception
     */

    public final void configure(final WebSecurity web) throws Exception {
        web
                .ignoring().
                antMatchers("/resources/**");
    }

    /**
     * configure for app
     * @param http http param
     * @throws Exception exception
     */

    public final void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

        http
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();

        http.authorizeRequests().mvcMatchers("/user/**").hasRole("USER").and().httpBasic();
    }
}
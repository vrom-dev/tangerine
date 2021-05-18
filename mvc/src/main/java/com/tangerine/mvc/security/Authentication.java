package com.tangerine.mvc.security;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;


@Configuration
@RequestMapping("/admin")
public class Authentication extends WebSecurityConfigurerAdapter {


    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/assets/**", "/css/**", "/fonts/**", "/img/**", "/js/**", "/contacto", "/proyectos", "/socios", "/").permitAll()
                .antMatchers("/admin/**").authenticated().and().httpBasic();

        //Este pide contraseña para todas las rutas
//        http
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}admin") // Spring Security 5 requires specifying the password storage format
                .roles("ADMIN");
    }

}

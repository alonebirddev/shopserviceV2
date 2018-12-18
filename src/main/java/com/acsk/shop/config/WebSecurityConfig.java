//
//package com.acsk.shop.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Value("${spring-security-username}")
//    private String USERNAME;
//    @Value("${spring-security-password}")
//    private String PASSWORD;
//    @Value("${spring-security-role}")
//    private String ROLE;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/v2/api-docs").authenticated()
//                .antMatchers(HttpMethod.POST, "/**/").authenticated()
//                .antMatchers(HttpMethod.GET, "/**/").authenticated()
//                .and()
//                .csrf().disable()
//                .httpBasic();
//
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser(USERNAME).password(PASSWORD).roles(ROLE);
//    }
//}
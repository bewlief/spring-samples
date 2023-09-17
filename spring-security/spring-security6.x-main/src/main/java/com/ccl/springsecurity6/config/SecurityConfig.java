package com.ccl.springsecurity6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring()
//                // Spring Security should completely ignore URLs starting with /resources/
//                .requestMatchers("/resources/**");
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        /**
         * 6.x 的样式
         */
        // login 登录页面需要匿名访问
        // permitAll: 具有所有权限，也就可以匿名访问
        http.authorizeHttpRequests(authorizeHttpRequests->
                authorizeHttpRequests
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated()

        );

        // http:后面可以一直点 但是太多内容之后不美观
        // loginPage: 设置登录页面
        // loginProcessingUrl: 登录接口，过滤器
        // defaultSuccessUrl: 登录成功之后跳转的页面
        http.formLogin(formLogin->
                formLogin
                        .loginPage("/login")
                        .loginProcessingUrl("/login").permitAll()
                        .defaultSuccessUrl("/index")
        );
        http.csrf(csrf -> csrf.disable());
//        http.csrf((e) -> e.disable());
        http.logout(logout->logout.invalidateHttpSession(true));

        /**
         * 5.x 的样式
         */
/*        http.authorizeHttpRequests().requestMatchers("/public/**").permitAll().anyRequest()
                .hasRole("USER").and()
                // Possibly more configuration ...
                .formLogin() // enable form based log in
                // set permitAll for all URLs associated with Form Login
                .permitAll();*/
        return http.build();
    }
}

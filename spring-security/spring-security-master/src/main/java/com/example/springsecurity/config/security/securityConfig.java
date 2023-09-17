package com.example.springsecurity.config.security;

import com.example.springsecurity.config.security.filter.CorsFilter;
import com.example.springsecurity.config.security.filter.JwtAuthenticationTokenFilter;
import com.example.springsecurity.config.security.handle.AuthenticationEntryPointImpl;
import com.example.springsecurity.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class securityConfig {

    /**
     * 自定义用户认证逻辑
     */
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /**
     * token认证过滤器
     */
    @Autowired
    private JwtAuthenticationTokenFilter authenticationTokenFilter;


    /**
     * 跨域过滤器
     */
    @Autowired
    private CorsFilter corsFilter;


    /**
     * 认证失败处理类
     */
    @Autowired
    private AuthenticationEntryPointImpl unauthorizedHandler;

    /**
     *  权限认证对象[AuthenticationManager]注册到容器里面，其他类可以取到
     * @return
     */
    @Bean
    public AuthenticationManager authenticationManager()  {
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return new ProviderManager(daoAuthenticationProvider);
    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //配置web授权访问,"/login",这些统统无需权限
        http
                // 认证失败处理类
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                // 过滤请求
                .authorizeHttpRequests()
                // 对于登录login  允许匿名访问
                .requestMatchers("/user/login").permitAll()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated()
                //成功的链接,也就是后续访问的链接放在这个里,我这里是成功页需要USER权限才能访问
//                .requestMatchers("/success").hasRole("USER")
                .and()


                //禁用表单登录
                .formLogin().disable()
                // CSRF禁用，因为不使用session
                .csrf().disable()
                // 基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                //禁用'X-Frame-Options‘响应头
                .headers().frameOptions().disable();


        /**
         * 自定义登陆页面是loginSelf.html页(这里看你模板引擎怎么配),表单提交的处理链接是"/upLogin"
         * 就是<form action="/upLogin"></form>这样,这个"/upLogin"不需要自己处理,就自己决定
         * usernameParameter和passwordParameter,就是表单提交所带的参数,
         * 这里我是"username"和"password";
         */
//                .loginProcessingUrl("/user/login")
//                .usernameParameter("username")
//                .passwordParameter("password");

        // 添加JWT filter
        http.addFilterBefore(authenticationTokenFilter, LogoutFilter.class);
        //添加corsFilter
        http.addFilterBefore(corsFilter, JwtAuthenticationTokenFilter.class);

        return http.build();
    }


    /**
     * 强散列哈希加密实现
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

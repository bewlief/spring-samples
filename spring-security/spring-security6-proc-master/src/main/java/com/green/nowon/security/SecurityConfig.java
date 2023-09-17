package com.green.nowon.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authorize -> authorize
					.antMatchers("/css/**", "/js/**", "/webjars/**", "/images/**", "/favicon.ico*").permitAll()
					.antMatchers("/", "/signup", "/signin", "/common/**").permitAll()
					.antMatchers("/admin/**").hasRole("ADMIN")
					.anyRequest().authenticated() //나머지 주소에 대해서는 보안처리
			)
			.formLogin(login -> login //UserDetailsService가 로그인 인증작업 시작
					.loginPage("/signin")
					.usernameParameter("email") //default: username
					.passwordParameter("pass") //default: password
					.permitAll()
					)
			.logout(logout -> logout //csrf 적용시 post로 요청해야 함
					.logoutUrl("/logout") //get
					.logoutSuccessUrl("/") //default: "/login?logout"
					)
			//.csrf(csrf -> csrf.disable()) //명시하지 않으면 default: csrf 적용 >> jwt 사용?
			;
		
		return http.build();
	}

}

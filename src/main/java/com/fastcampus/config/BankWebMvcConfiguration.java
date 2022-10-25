package com.fastcampus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.fastcampus.security.jpa.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity // @EnableWebSecurity : security를 customizing하기 위해서 security와 관련된 몇몇 객체들 제거
                   // extends WebSecurityConfigurerAdapter : security를 customizing하기 위해서 security와 관련된 몇몇 객체들 제거
public class BankWebMvcConfiguration extends WebSecurityConfigurerAdapter{//implements WebMvcConfigurer{

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Override // security가 기본으로 제공해주는 계정 사용하지않겠다
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 다음 경로에 대한 요청은 인증 없이 접근을 허용한다. 이미지나 js파일, css관련 webjar도 허용해줘야한다.
		http.authorizeRequests().antMatchers("/", "/auth/**", "/js/**", "/image/**", "/webjars/**").permitAll();
		
		// 위에서 언급한 경로 외에는 모두 인증을 거치도록 설정한다
		http.authorizeRequests().anyRequest().authenticated();
		
		// 시큐리티가 제공하는 기본 로그인 화면은 CSRF 토큰을 무조건 전달한다
		// 하지만 사용자 정의 로그인 화면에서는 CSRF 토큰을 전달하지 않는다
		http.csrf().disable();
		
		// 사용자가 만든 로그인 화면을 띄운다
		http.formLogin().loginPage("/auth/login");
		
		// 로그아웃 설정
		http.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/"); // 디폴트는 logoutUrl("/logout"), logoutSuccessUrl("/") : 로그아웃 성공시 index 페이지로 이동
	}
}

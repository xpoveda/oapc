package com.openwebinars.springrest;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("luismi").password("lopez").roles("USER")
			.and().withUser("admin").password("admin").roles("ADMIN");
	}

	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET,"/api/hello").hasAnyRole("USER", "ADMIN")
			.antMatchers(HttpMethod.GET,"/api/admin/hello").hasRole("ADMIN")
			.antMatchers(HttpMethod.POST,"/api/admin/hello").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.httpBasic();
			
		
	}*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.csrf().disable()
			.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.httpBasic();
			
		
	}

}

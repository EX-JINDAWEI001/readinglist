package com.example.readinglist.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.readinglist.dao.ReaderRepository;

@Profile("production")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private ReaderRepository readerRepository;
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		System.out.println("你还是啊"+http);
		http.authorizeRequests()
				.antMatchers("/abc/**").access("hasRole('READER')")
				.antMatchers("/abc/**").permitAll()
			.and()
			
			.formLogin()
				.loginPage("/login")
					.failureUrl("/login?error=true");
	}
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		System.out.println("很大很快"+auth);
		auth.userDetailsService(new UserDetailsService() {
			
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				return readerRepository.findOne(username);
			}
			
		});
	}

}

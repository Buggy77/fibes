package com.fibeso.captacion.pfuneraria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.WebMvcSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import com.fibeso.captacion.pfuneraria.service.UsuariosOperadorDetailsServiceImpl;

import javax.sql.DataSource;

/**
 * 
 * @author Bug
 *@since 15/12/2019
 */
@Configuration
//@EnableWebMvcSecurity
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	String[] resources = new String[] {
			"/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**","/fonts/**"
	};
	
	/*
	 * @Override public void configureViewResolvers(ViewResolverRegistry registry) {
	 * ThymeleafViewResolver resolver = new ThymeleafViewResolver();
	 * resolver.setTemplateEngine(templateEngine());
	 * resolver.setCharacterEncoding("UTF-8"); // <- this was added
	 * resolver.setForceContentType(true); // <- this was added
	 * resolver.setContentType("text/html; charset=UTF-8"); // <- this was added
	 * registry.viewResolver(resolver); }
	 */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		
		http
			.authorizeRequests()
			.antMatchers(resources).permitAll()
			.antMatchers("/","index").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login").permitAll()
				.defaultSuccessUrl("/clienteForm")
				.failureUrl("/login?error=true")
				.usernameParameter("username")
				.passwordParameter("password")
				.and()
				.csrf().disable()
			.logout().permitAll()
				.logoutSuccessUrl("/login?logout");
	}
	
	
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(4);
	}
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		//auth
		//		.jdbcAuthentication()
		//		.dataSource(dataSource)
		//		.usersByUsernameQuery(SQL_LOGIN)
		//		.passwordEncoder(passwordEnconde());
	}
	
	
	
	public static final String SQL_LOGIN
		    ="SELECT IdOperador, Pass, Activo \n" +
		    "FROM usr_operadores WHERE IdOperador = ?";

	@Autowired
	private DataSource dataSource;
	
	
}

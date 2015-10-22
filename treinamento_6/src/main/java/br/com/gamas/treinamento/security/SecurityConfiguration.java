package br.com.gamas.treinamento.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private UserDetailsService userDetailsService;
	
	private String[] AREA_PUBLICA = {"/js/**", "/css/**", "/images/**", "/fonts/**", "/", "/home", "/formulario/inscricao", "/formulario/visualizar/*", "/formulario/salvar"};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		HttpSecurity httpSecurity = http.authorizeRequests().antMatchers(AREA_PUBLICA).permitAll().anyRequest().fullyAuthenticated().and();
		httpSecurity = httpSecurity.formLogin().loginPage("/login").failureUrl("/login?error").permitAll().and();
		httpSecurity = httpSecurity.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").and();
		// @formatter:on
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}

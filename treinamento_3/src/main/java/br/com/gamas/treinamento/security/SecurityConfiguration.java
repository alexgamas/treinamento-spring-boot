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
// @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
// @EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//super.configure(http);
		// @formatter:off
		//"/formulario/inscricao", "/formulario/visualizar/*", "/formulario/salvar"
		
		HttpSecurity httpSecurity = http.authorizeRequests().antMatchers("/images/**", "/", "/home", "/formulario/**").permitAll().anyRequest().fullyAuthenticated().and();
		httpSecurity = httpSecurity.formLogin().loginPage("/login").failureUrl("/login?error").permitAll().and();
		httpSecurity = httpSecurity.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").and();
		//httpSecurity = httpSecurity.exceptionHandling().accessDeniedPage("/access?error").and();
		// @formatter:on
		
		//.hasAuthority("ADMIN")
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemoryAuth = auth.inMemoryAuthentication();
//        inMemoryAuth.withUser("admin").password("admin").roles("ADMIN", "USER");
//        inMemoryAuth.withUser("user").password("user").roles("USER");
//        inMemoryAuth.withUser("alex").password("gamas").roles("USER");
		
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	
	}
}

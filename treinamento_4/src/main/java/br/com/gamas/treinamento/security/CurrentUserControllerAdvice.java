package br.com.gamas.treinamento.security;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import br.com.gamas.treinamento.model.Usuario;

@ControllerAdvice
public class CurrentUserControllerAdvice {
	
	@ModelAttribute("currentUser")
	public Usuario getCurrentUser(Authentication authentication) {
		if (isAuthenticated(authentication) && authentication.getPrincipal() instanceof Usuario) {
			Usuario usuario = (Usuario) authentication.getPrincipal();
			usuario.setPassword("<secreto>");
			return usuario;
		}
		return null;
	}
	
	@ModelAttribute("isAuthenticated")
	public boolean isAuthenticated(Authentication authentication) {
		return authentication != null && authentication.getPrincipal() != null;
	}
}
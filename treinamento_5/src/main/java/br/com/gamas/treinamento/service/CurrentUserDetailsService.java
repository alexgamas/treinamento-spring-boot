package br.com.gamas.treinamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gamas.treinamento.model.Usuario;
import br.com.gamas.treinamento.repository.UsuarioRepository;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.loadUserByUsername(username);
		
		if (usuario != null) {
			return usuario;
		} else {
			throw new UsernameNotFoundException(username);
		}
		
	}
	
}
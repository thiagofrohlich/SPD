package br.ufpr.tcc.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import br.com.spd.enums.Roles;
import br.com.spd.model.Usuario;
import br.ufpr.tcc.service.handler.UsuarioServiceHandler;


@Component
public class SpdAuthenticationProvider  implements AuthenticationProvider{
	
	@Autowired
	private UsuarioServiceHandler usuarioService;
	
	@Override
	public Authentication authenticate(Authentication authentication) {
		String login = (String) authentication.getName();
		String password = (String) authentication.getCredentials();
		
		if(usuarioService.canLogin(login, password)) {
			Usuario usuario = usuarioService.getByLogin(login);
			Collection<GrantedAuthority> authorities = getAuthorities(usuario.getRole());
			return new UsernamePasswordAuthenticationToken(login, password, authorities);
		} else {
			throw new BadCredentialsException("Usuário não encontrado.");
		}
	}

	private Collection<GrantedAuthority> getAuthorities(Integer roleId) {
		Roles role = Roles.valueOf(roleId);
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new Role(role.getDescricao()));
		return authorities;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}


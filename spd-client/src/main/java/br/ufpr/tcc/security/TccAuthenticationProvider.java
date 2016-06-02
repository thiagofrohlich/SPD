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
public class TccAuthenticationProvider  implements AuthenticationProvider{
	
	@Autowired
	private UsuarioServiceHandler usuarioService;
	
	@Override
	public Authentication authenticate(Authentication authentication) {
		String login = (String) authentication.getName();
		String password = (String) authentication.getCredentials();
		
		Usuario usuario = usuarioService.getByLogin(login);
		throwExceptionIfNotFound(usuario);
		throwExceptionIfPasswordIsInvalid(password, usuario);
		
		Collection<GrantedAuthority> authorities = getAuthorities(usuario.getRole());
		
		return new UsernamePasswordAuthenticationToken(login, password, authorities);
	}

	private Collection<GrantedAuthority> getAuthorities(Integer roleId) {
		Roles role = Roles.valueOf(roleId);
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new Role(role.getDescricao()));
		return authorities;
	}

	private void throwExceptionIfPasswordIsInvalid(String password,
			Usuario usuario) {
		if(!password.equals(usuario.getSenha())) {
			throw new BadCredentialsException("Senha inv�lida");
		}
	}

	private void throwExceptionIfNotFound(Usuario usuario) {
		if(usuario == null) {
			throw new BadCredentialsException("Usu�rio n�o encontrado.");
		}
	}

	
	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}


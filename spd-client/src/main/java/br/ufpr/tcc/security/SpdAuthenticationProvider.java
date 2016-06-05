package br.ufpr.tcc.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import br.com.spd.enums.Roles;
import br.com.spd.model.Usuario;
import br.ufpr.tcc.service.handler.UsuarioServiceHandler;
import br.ufpr.tcc.service.handler.impl.UsuarioServiceHandlerImpl;


@Component
public class SpdAuthenticationProvider  implements AuthenticationProvider{
	
	private UsuarioServiceHandler usuarioService;
	

	public SpdAuthenticationProvider() {
		usuarioService = new UsuarioServiceHandlerImpl();
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) {
		String login = (String) authentication.getName();
		String password = (String) authentication.getCredentials();
		Usuario usuario = usuarioService.getByLogin(login);
		
		if(usuario.getResetarSenha()) {
			return passwordResetLogin(login, password);
		} else {
			return login(login, password, usuario);
		}
		
	}

	private Authentication passwordResetLogin(String login, String password) {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new Role(Roles.PASSWORD_RESET.getDescricao()));
		return new UsernamePasswordAuthenticationToken(login, password, authorities);
	}

	private Authentication login(String login, String password, Usuario usuario) {
		if(usuarioService.canLogin(login, password)) {
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


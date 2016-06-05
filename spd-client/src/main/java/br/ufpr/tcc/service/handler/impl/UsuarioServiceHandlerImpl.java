package br.ufpr.tcc.service.handler.impl;

import br.com.spd.model.Usuario;
import br.com.spd.wrapper.UsuarioWrapper;
import br.ufpr.tcc.service.handler.UsuarioServiceHandler;
public class UsuarioServiceHandlerImpl  extends AbstractServiceHandler<Usuario,Integer> implements UsuarioServiceHandler{

	@Override
	public String getRelativePath() {
		return "/usuario";
	}

	@Override
	public UsuarioWrapper findAll() {
		return getRestTemplate().getForObject(getPath(), UsuarioWrapper.class);
	}
	
	@Override
	public Usuario getByLogin(String login) {
		return (Usuario) getRestTemplate().getForObject(getPath()+"/login/{login}", Usuario.class, login);
	}
	
	@Override
	public UsuarioWrapper getByLoginLike(String login) {
		return (UsuarioWrapper) getRestTemplate().getForObject(getPath()+"/loginlike/{login}", UsuarioWrapper.class, login);
	}
	
	@Override
	public String encodePassword(String password) {
		return getRestTemplate().getForObject(getPath()+"/password/encode/{password}", String.class, password);
	}
	
	@Override
	public Boolean canLogin(String login, String password) {
		return getRestTemplate().getForObject(getPath()+"/login/{login}/{password}", Boolean.class, login, password);
	}

}

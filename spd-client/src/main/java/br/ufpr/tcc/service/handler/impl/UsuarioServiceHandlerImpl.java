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
		return (Usuario) getRestTemplate().getForObject(getPath()+"login/{login}", Usuario.class, login);
	}

}

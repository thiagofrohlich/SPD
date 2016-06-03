package br.ufpr.tcc.service.handler.impl;

import br.com.spd.model.Usuario;
import br.com.spd.wrapper.UsuarioWrapper;
import br.ufpr.tcc.service.handler.UsuarioServiceHandler;

public class UsuarioServiceHandlerImpl extends AbstractServiceHandler<Usuario, Integer> implements UsuarioServiceHandler{

	@Override
	public String getRelativePath() {
		return "/usuario";
	}
	
	@Override
	public UsuarioWrapper findByLogin(String login) {
		
		return (UsuarioWrapper) getRestTemplate().getForObject(getPath()+"/loginlike/{login}", UsuarioWrapper.class, login);
	}

}

package br.ufpr.tcc.service.handler;

import br.com.spd.model.Usuario;
import br.com.spd.wrapper.UsuarioWrapper;


public interface UsuarioServiceHandler  extends ServiceHandler<Usuario, Integer>{

	UsuarioWrapper findAll();

	Usuario getByLogin(String login);

	String encodePassword(String password);

	Boolean canLogin(String login, String password);
	
	UsuarioWrapper getByLoginLike(String login);
}

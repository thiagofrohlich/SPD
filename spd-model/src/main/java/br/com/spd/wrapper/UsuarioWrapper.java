package br.com.spd.wrapper;

import org.springframework.data.domain.Page;

import br.com.spd.model.Usuario;

public class UsuarioWrapper extends Wrapper<Usuario> {
	
	private static final long serialVersionUID = 1L;

	public UsuarioWrapper(Page<? extends Object> page) {
		super(page);
	}

	public UsuarioWrapper() {
		super();
	}
	
}

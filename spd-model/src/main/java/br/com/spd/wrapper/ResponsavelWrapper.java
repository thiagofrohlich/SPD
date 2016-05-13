package br.com.spd.wrapper;

import org.springframework.data.domain.Page;

import br.com.spd.model.Responsavel;

public class ResponsavelWrapper extends Wrapper<Responsavel> {
	
	private static final long serialVersionUID = 1L;

	public ResponsavelWrapper(Page<? extends Object> page) {
		super(page);
	}

	public ResponsavelWrapper() {
		super();
	}
	
}

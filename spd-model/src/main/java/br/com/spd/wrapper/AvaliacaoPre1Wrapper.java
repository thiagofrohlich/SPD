package br.com.spd.wrapper;

import org.springframework.data.domain.Page;

import br.com.spd.model.AvaliacaoPre1;

public class AvaliacaoPre1Wrapper extends Wrapper<AvaliacaoPre1> {
	
	private static final long serialVersionUID = 1L;

	public AvaliacaoPre1Wrapper(Page<? extends Object> page) {
		super(page);
	}

	public AvaliacaoPre1Wrapper() {
		super();
	}
	
}

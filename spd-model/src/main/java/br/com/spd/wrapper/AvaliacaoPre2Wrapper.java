package br.com.spd.wrapper;

import org.springframework.data.domain.Page;

import br.com.spd.model.AvaliacaoPre2;

public class AvaliacaoPre2Wrapper extends Wrapper<AvaliacaoPre2> {
	
	private static final long serialVersionUID = 1L;

	public AvaliacaoPre2Wrapper(Page<? extends Object> page) {
		super(page);
	}

	public AvaliacaoPre2Wrapper() {
		super();
	}
	
}

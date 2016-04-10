package br.com.spd.wrapper;

import org.springframework.data.domain.Page;

import br.com.spd.model.AvaliacaoMat2;

public class AvaliacaoMat2Wrapper extends Wrapper<AvaliacaoMat2> {
	
	private static final long serialVersionUID = 1L;

	public AvaliacaoMat2Wrapper(Page<? extends Object> page) {
		super(page);
	}

	public AvaliacaoMat2Wrapper() {
		super();
	}
	
}

package br.com.spd.wrapper;

import org.springframework.data.domain.Page;

import br.com.spd.model.Pessoa;

public class PessoaWrapper extends Wrapper<Pessoa> {
	
	private static final long serialVersionUID = 1L;

	public PessoaWrapper(Page<? extends Object> page) {
		super(page);
	}

	public PessoaWrapper() {
		super();
	}
	
}

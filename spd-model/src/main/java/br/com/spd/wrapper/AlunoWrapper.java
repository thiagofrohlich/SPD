package br.com.spd.wrapper;

import org.springframework.data.domain.Page;

import br.com.spd.model.Aluno;

public class AlunoWrapper extends Wrapper<Aluno> {
	
	private static final long serialVersionUID = 1L;

	public AlunoWrapper(Page<? extends Object> page) {
		super(page);
	}

	public AlunoWrapper() {
		super();
	}
	
}

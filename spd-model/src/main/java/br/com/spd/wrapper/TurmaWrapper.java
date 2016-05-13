package br.com.spd.wrapper;

import org.springframework.data.domain.Page;

import br.com.spd.model.Turma;

public class TurmaWrapper extends Wrapper<Turma> {
	
	private static final long serialVersionUID = 1L;

	public TurmaWrapper(Page<? extends Object> page) {
		super(page);
	}

	public TurmaWrapper() {
		super();
	}
	
}

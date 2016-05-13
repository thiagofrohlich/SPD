package br.com.spd.wrapper;

import org.springframework.data.domain.Page;

import br.com.spd.model.Professor;

public class ProfessorWrapper extends Wrapper<Professor> {
	
	private static final long serialVersionUID = 1L;

	public ProfessorWrapper(Page<? extends Object> page) {
		super(page);
	}

	public ProfessorWrapper() {
		super();
	}
	
}

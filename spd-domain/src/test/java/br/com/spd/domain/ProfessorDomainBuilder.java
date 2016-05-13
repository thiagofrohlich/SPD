package br.com.spd.domain;

public class ProfessorDomainBuilder {
	
	private Long id = 1l;
	private Pessoa pessoa = null;
	private Turma turma = null;
	
	public Professor build() {
		Professor professor = new Professor();
		professor.setId(id);
		professor.setPessoa(pessoa);
		professor.setTurma(turma);
		return professor;
	}

	public ProfessorDomainBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	public ProfessorDomainBuilder withPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
		return this;
	}

	public ProfessorDomainBuilder withTurma(Turma turma) {
		this.turma = turma;
		return this;
	}
	

}

package br.com.spd.domain;

public class TurmaDomainBuilder {

	private Long id;
	private String descricao;
	
	public Turma build() {
		Turma turma = new Turma();
		turma.setId(id);
		turma.setDescricao(descricao);
		return turma;
	}

	public TurmaDomainBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	public TurmaDomainBuilder withDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}
	
}

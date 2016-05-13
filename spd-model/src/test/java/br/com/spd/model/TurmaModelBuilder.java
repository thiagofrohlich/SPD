package br.com.spd.model;

public class TurmaModelBuilder {

	private Long id;
	private String descricao;
	
	public Turma build() {
		Turma turma = new Turma();
		turma.setId(id);
		turma.setDescricao(descricao);
		return turma;
	}
	
	public TurmaModelBuilder withId(Long id) {
		this.id = id;
		return this;
	}
	public TurmaModelBuilder withDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}
	
}

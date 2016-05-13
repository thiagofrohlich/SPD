package br.com.spd.domain;

public class ResponsavelDomainBuilder {
	
	private Long id = 1l;
	private Aluno aluno = null;
	private String parentesco = "test-parentesco";
	private Boolean responsavel = false;
	private Pessoa pessoa = null;
	
	public Responsavel build() {
		Responsavel resp = new Responsavel();
		resp.setAluno(aluno);
		resp.setId(id);
		resp.setParentesco(parentesco);
		resp.setResponsavel(responsavel);
		resp.setPessoa(pessoa);
		return resp;
	}
	
	public ResponsavelDomainBuilder withId(Long id) {
		this.id = id;
		return this;
	}
	public ResponsavelDomainBuilder withAluno(Aluno aluno) {
		this.aluno = aluno;
		return this;
	}
	public ResponsavelDomainBuilder withParentesco(String parentesco) {
		this.parentesco = parentesco;
		return this;
	}
	public ResponsavelDomainBuilder withResponsavel(Boolean responsavel) {
		this.responsavel = responsavel;
		return this;
	}
	public ResponsavelDomainBuilder withPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
		return this;
	}

}

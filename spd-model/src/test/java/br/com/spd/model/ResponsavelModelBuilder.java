package br.com.spd.model;

public class ResponsavelModelBuilder {
	
	private Aluno aluno = null;
	private Long codpessoa = 1l;
	private Long id = 1l;
	private String celular = "test-celular";
	private String cpf = "test-cpf";
	private String escolaridade = "test-escolaridade";
	private String localtrabalho = "test-localtrabalho";
	private String nome = "test-nome";
	private String parentesco = "test-parentesco";
	private String profissao = "test-profissao";
	private Boolean responsavel = false;
	private String rg = "test-rg";
	private String telefone = "test-telefone";
	
	public Responsavel build() {
		Responsavel resp = new Responsavel();
		resp.setAluno(aluno);
		resp.setId(id);
		resp.setCodpessoa(codpessoa);
		resp.setCelular(celular);
		resp.setCpf(cpf);
		resp.setEscolaridade(escolaridade);
		resp.setLocaltrabalho(localtrabalho);
		resp.setNome(nome);
		resp.setParentesco(parentesco);
		resp.setProfissao(profissao);
		resp.setResponsavel(responsavel);
		resp.setRg(rg);
		resp.setTelefone(telefone);
		return resp;
	}
	
	public ResponsavelModelBuilder withAluno(Aluno aluno) {
		this.aluno = aluno;
		return this;
	}
	public ResponsavelModelBuilder withCodresponsavel(Long codresponsavel) {
		this.codpessoa = codresponsavel;
		return this;
	}
	public ResponsavelModelBuilder withCelular(String celular) {
		this.celular = celular;
		return this;
	}
	public ResponsavelModelBuilder withCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}
	public ResponsavelModelBuilder withEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
		return this;
	}
	public ResponsavelModelBuilder withLocaltrabalho(String localtrabalho) {
		this.localtrabalho = localtrabalho;
		return this;
	}
	public ResponsavelModelBuilder withNome(String nome) {
		this.nome = nome;
		return this;
	}
	public ResponsavelModelBuilder withParentesco(String parentesco) {
		this.parentesco = parentesco;
		return this;
	}
	public ResponsavelModelBuilder withProfissao(String profissao) {
		this.profissao = profissao;
		return this;
	}
	public ResponsavelModelBuilder withResponsavel(Boolean responsavel) {
		this.responsavel = responsavel;
		return this;
	}
	public ResponsavelModelBuilder withRg(String rg) {
		this.rg = rg;
		return this;
	}
	public ResponsavelModelBuilder withTelefone(String telefone) {
		this.telefone = telefone;
		return this;
	}
	
}

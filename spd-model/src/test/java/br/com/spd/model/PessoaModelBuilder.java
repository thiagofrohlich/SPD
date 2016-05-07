package br.com.spd.model;

public class PessoaModelBuilder {
	
	private Aluno aluno = null;
	private Long codpessoa = 1l;
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
	
	public Pessoa build() {
		Pessoa pessoa = new Pessoa();
		pessoa.setAluno(aluno);
		pessoa.setCodpessoa(codpessoa);
		pessoa.setCelular(celular);
		pessoa.setCpf(cpf);
		pessoa.setEscolaridade(escolaridade);
		pessoa.setLocaltrabalho(localtrabalho);
		pessoa.setNome(nome);
		pessoa.setParentesco(parentesco);
		pessoa.setProfissao(profissao);
		pessoa.setResponsavel(responsavel);
		pessoa.setRg(rg);
		pessoa.setTelefone(telefone);
		return pessoa;
	}
	
	public PessoaModelBuilder withAluno(Aluno aluno) {
		this.aluno = aluno;
		return this;
	}
	public PessoaModelBuilder withCodpessoa(Long codpessoa) {
		this.codpessoa = codpessoa;
		return this;
	}
	public PessoaModelBuilder withCelular(String celular) {
		this.celular = celular;
		return this;
	}
	public PessoaModelBuilder withCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}
	public PessoaModelBuilder withEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
		return this;
	}
	public PessoaModelBuilder withLocaltrabalho(String localtrabalho) {
		this.localtrabalho = localtrabalho;
		return this;
	}
	public PessoaModelBuilder withNome(String nome) {
		this.nome = nome;
		return this;
	}
	public PessoaModelBuilder withParentesco(String parentesco) {
		this.parentesco = parentesco;
		return this;
	}
	public PessoaModelBuilder withProfissao(String profissao) {
		this.profissao = profissao;
		return this;
	}
	public PessoaModelBuilder withResponsavel(Boolean responsavel) {
		this.responsavel = responsavel;
		return this;
	}
	public PessoaModelBuilder withRg(String rg) {
		this.rg = rg;
		return this;
	}
	public PessoaModelBuilder withTelefone(String telefone) {
		this.telefone = telefone;
		return this;
	}
	
}

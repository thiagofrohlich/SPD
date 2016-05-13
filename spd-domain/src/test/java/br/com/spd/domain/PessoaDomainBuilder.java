package br.com.spd.domain;

public class PessoaDomainBuilder {

	private Long codpessoa = 1l;
	private String celular = "test-celular";
	private String cpf = "test-cpf";
	private String escolaridade = "test-escolaridade";
	private String localtrabalho = "test-localtrabalho";
	private String nome = "test-nome";
	private String profissao = "test-profissao";
	private String rg = "test-rg";
	private String telefone = "test-telefone";
	
	public Pessoa build() {
		Pessoa resp = new Pessoa();
		resp.setCodpessoa(codpessoa);
		resp.setCelular(celular);
		resp.setCpf(cpf);
		resp.setEscolaridade(escolaridade);
		resp.setLocaltrabalho(localtrabalho);
		resp.setNome(nome);
		resp.setProfissao(profissao);
		resp.setRg(rg);
		resp.setTelefone(telefone);
		return resp;
	}
	
	public PessoaDomainBuilder withCodpessoa(Long codpessoa) {
		this.codpessoa = codpessoa;
		return this;
	}
	public PessoaDomainBuilder withCelular(String celular) {
		this.celular = celular;
		return this;
	}
	public PessoaDomainBuilder withCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}
	public PessoaDomainBuilder withEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
		return this;
	}
	public PessoaDomainBuilder withLocaltrabalho(String localtrabalho) {
		this.localtrabalho = localtrabalho;
		return this;
	}
	public PessoaDomainBuilder withNome(String nome) {
		this.nome = nome;
		return this;
	}
	public PessoaDomainBuilder withProfissao(String profissao) {
		this.profissao = profissao;
		return this;
	}
	public PessoaDomainBuilder withRg(String rg) {
		this.rg = rg;
		return this;
	}
	public PessoaDomainBuilder withTelefone(String telefone) {
		this.telefone = telefone;
		return this;
	}
	
}

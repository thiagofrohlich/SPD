package br.com.spd.model;

public class ProfessorModelBuilder {
	
	private Long codpessoa = 1l;
	private Long id = 1l;
	private String celular = "test-celular";
	private String cpf = "test-cpf";
	private String escolaridade = "test-escolaridade";
	private String localtrabalho = "test-localtrabalho";
	private String nome = "test-nome";
	private String profissao = "test-profissao";
	private String rg = "test-rg";
	private String telefone = "test-telefone";
	private Pessoa pessoa = null;
	private Turma turma = null;
	private String cep = "teste-cep";
	private String rua = "teste-rua";
	private String numero = "teste-numero";
	private String bairro = "teste-bairro";
	private String cidade = "teste-cidade";
	private String estado = "teste-estado";
	private String email = "teste-email";
	
	public Professor build() {
		Professor professor = new Professor();
		professor.setId(id);
		professor.setCodpessoa(codpessoa);
		professor.setCelular(celular);
		professor.setCpf(cpf);
		professor.setEscolaridade(escolaridade);
		professor.setLocaltrabalho(localtrabalho);
		professor.setNome(nome);
		professor.setProfissao(profissao);
		professor.setRg(rg);
		professor.setTelefone(telefone);
		professor.setTurma(turma);
		professor.setCep(cep);
		professor.setRua(rua);
		professor.setNumero(numero);
		professor.setBairro(bairro);
		professor.setCidade(cidade);
		professor.setEstado(estado);
		professor.setTelefone(telefone);
		professor.setEmail(email);
		return professor;
	}
	
	public ProfessorModelBuilder withCodpessoa(Long codpessoa) {
		this.codpessoa = codpessoa;
		return this;
	}
	public ProfessorModelBuilder withId(Long id) {
		this.id = id;
		return this;
	}
	public ProfessorModelBuilder withCelular(String celular) {
		this.celular = celular;
		return this;
	}
	public ProfessorModelBuilder withCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}
	public ProfessorModelBuilder withEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
		return this;
	}
	public ProfessorModelBuilder withLocaltrabalho(String localtrabalho) {
		this.localtrabalho = localtrabalho;
		return this;
	}
	public ProfessorModelBuilder withNome(String nome) {
		this.nome = nome;
		return this;
	}
	public ProfessorModelBuilder withProfissao(String profissao) {
		this.profissao = profissao;
		return this;
	}
	public ProfessorModelBuilder withRg(String rg) {
		this.rg = rg;
		return this;
	}
	public ProfessorModelBuilder withTelefone(String telefone) {
		this.telefone = telefone;
		return this;
	}
	public ProfessorModelBuilder withPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
		return this;
	}
	public ProfessorModelBuilder withTurma(Turma turma) {
		this.turma = turma;
		return this;
	}

	public ProfessorModelBuilder withCep(String cep) {
		this.cep = cep;
		return this;
	}

	public ProfessorModelBuilder withRua(String rua) {
		this.rua = rua;
		return this;
	}

	public ProfessorModelBuilder withNumero(String numero) {
		this.numero = numero;
		return this;
	}

	public ProfessorModelBuilder withBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public ProfessorModelBuilder withCidade(String cidade) {
		this.cidade = cidade;
		return this;
	}

	public ProfessorModelBuilder withEstado(String estado) {
		this.estado = estado;
		return this;
	}

	public ProfessorModelBuilder withEmail(String email) {
		this.email = email;
		return this;
	}
	
}
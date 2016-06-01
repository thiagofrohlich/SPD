package br.com.spd.domain;

public class ProfessorDomainBuilder {
	
	private Long id = 1l;
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
		professor.setPessoa(pessoa);
		professor.setTurma(turma);
		professor.setCep(cep);
		professor.setRua(rua);
		professor.setNumero(numero);
		professor.setBairro(bairro);
		professor.setCidade(cidade);
		professor.setEstado(estado);
		professor.setEmail(email);
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

	public ProfessorDomainBuilder withCep(String cep) {
		this.cep = cep;
		return this;
	}

	public ProfessorDomainBuilder withRua(String rua) {
		this.rua = rua;
		return this;
	}

	public ProfessorDomainBuilder withNumero(String numero) {
		this.numero = numero;
		return this;
	}

	public ProfessorDomainBuilder withBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public ProfessorDomainBuilder withCidade(String cidade) {
		this.cidade = cidade;
		return this;
	}

	public ProfessorDomainBuilder withEstado(String estado) {
		this.estado = estado;
		return this;
	}

	public ProfessorDomainBuilder withEmail(String email) {
		this.email = email;
		return this;
	}
	

}

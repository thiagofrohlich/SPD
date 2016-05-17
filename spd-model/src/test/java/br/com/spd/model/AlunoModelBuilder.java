package br.com.spd.model;

import java.util.Date;
import java.util.List;

public class AlunoModelBuilder {

	private Long matricula = 1l;
	private String alergia = "test-alergia";
	private Date anoinicio = new Date();
	private Date anoletivo = new Date();
	private String bairro = "test-bairro";
	private String cep = "test-cep";
	private String cidade = "test-cidade";
	private String cirurgias = "test-cirurgias";
	private Integer codmed = 1;
	private Date datanasc = new Date();
	private String email = "test-email";
	private String estado = "test-estado";
	private String horario = "test-horario";
	private String modalidade = "test-modalidade";
	private String nivel = "test-nivel";
	private String nome = "test-nome";
	private String numero = "test-numero";
	private String periodo = "test-periodo";
	private String religiao = "test-religiao";
	private String restalimentar = "test-restalimentar";
	private String rua = "test-rua";
	private Integer serie = 1;
	private String sitpais = "test-sitpais";
	private String telefone = "test-telefone";
	private String temperamento = "test-temperamento";
	private String tratamento = "test-tratamento";
	private double valor = 1d;
	private List<AvaliacaoMat2> avaliacaoMat2s = null;
	private List<AvaliacaoPre1> avaliacaoPre1s = null;
	private List<AvaliacaoPre2> avaliacaoPre2s = null;
	private List<Ocorrencia> ocorrencias = null;
	private List<Responsavel> responsaveis = null;

	public Aluno build() {
		Aluno aluno = new Aluno();
		aluno.setAlergia(alergia);
		aluno.setAnoinicio(anoinicio);
		aluno.setAnoletivo(anoletivo);
		aluno.setAvaliacaoMat2s(avaliacaoMat2s);
		aluno.setAvaliacaoPre1s(avaliacaoPre1s);
		aluno.setAvaliacaoPre2s(avaliacaoPre2s);
		aluno.setBairro(bairro);
		aluno.setCep(cep);
		aluno.setCidade(cidade);
		aluno.setCirurgias(cirurgias);
		aluno.setCodmed(codmed);
		aluno.setDatanasc(datanasc);
		aluno.setEmail(email);
		aluno.setEstado(estado);
		aluno.setHorario(horario);
		aluno.setMatricula(matricula);
		aluno.setModalidade(modalidade);
		aluno.setNivel(nivel);
		aluno.setNome(nome);
		aluno.setNumero(numero);
		aluno.setOcorrencias(ocorrencias);
		aluno.setPeriodo(periodo);
		aluno.setReligiao(religiao);
		aluno.setResponsaveis(responsaveis);
		aluno.setRestalimentar(restalimentar);
		aluno.setRua(rua);
		aluno.setSerie(serie);
		aluno.setSitpais(sitpais);
		aluno.setTelefone(telefone);
		aluno.setTemperamento(temperamento);
		aluno.setTratamento(tratamento);
		aluno.setValor(valor);
		return aluno;
	}

	public AlunoModelBuilder withMatricula(Long matricula) {
		this.matricula = matricula;
		return this;
	}

	public AlunoModelBuilder withAlergia(String alergia) {
		this.alergia = alergia;
		return this;
	}

	public AlunoModelBuilder withAnoinicio(Date anoinicio) {
		this.anoinicio = anoinicio;
		return this;
	}

	public AlunoModelBuilder withAnoletivo(Date anoletivo) {
		this.anoletivo = anoletivo;
		return this;
	}

	public AlunoModelBuilder withBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public AlunoModelBuilder withCep(String cep) {
		this.cep = cep;
		return this;
	}

	public AlunoModelBuilder withCidade(String cidade) {
		this.cidade = cidade;
		return this;
	}

	public AlunoModelBuilder withCirurgias(String cirurgias) {
		this.cirurgias = cirurgias;
		return this;
	}

	public AlunoModelBuilder withCodmed(Integer codmed) {
		this.codmed = codmed;
		return this;
	}

	public AlunoModelBuilder withDatanasc(Date datanasc) {
		this.datanasc = datanasc;
		return this;
	}

	public AlunoModelBuilder withEmail(String email) {
		this.email = email;
		return this;
	}

	public AlunoModelBuilder withEstado(String estado) {
		this.estado = estado;
		return this;
	}

	public AlunoModelBuilder withHorario(String horario) {
		this.horario = horario;
		return this;
	}

	public AlunoModelBuilder withModalidade(String modalidade) {
		this.modalidade = modalidade;
		return this;
	}

	public AlunoModelBuilder withNivel(String nivel) {
		this.nivel = nivel;
		return this;
	}

	public AlunoModelBuilder withNome(String nome) {
		this.nome = nome;
		return this;
	}

	public AlunoModelBuilder withNumero(String numero) {
		this.numero = numero;
		return this;
	}

	public AlunoModelBuilder withPeriodo(String periodo) {
		this.periodo = periodo;
		return this;
	}

	public AlunoModelBuilder withReligiao(String religiao) {
		this.religiao = religiao;
		return this;
	}

	public AlunoModelBuilder withRestalimentar(String restalimentar) {
		this.restalimentar = restalimentar;
		return this;
	}

	public AlunoModelBuilder withRua(String rua) {
		this.rua = rua;
		return this;
	}

	public AlunoModelBuilder withSerie(Integer serie) {
		this.serie = serie;
		return this;
	}

	public AlunoModelBuilder withSitpais(String sitpais) {
		this.sitpais = sitpais;
		return this;
	}

	public AlunoModelBuilder withTelefone(String telefone) {
		this.telefone = telefone;
		return this;
	}

	public AlunoModelBuilder withTemperamento(String temperamento) {
		this.temperamento = temperamento;
		return this;
	}

	public AlunoModelBuilder withTratamento(String tratamento) {
		this.tratamento = tratamento;
		return this;
	}

	public AlunoModelBuilder withValor(double valor) {
		this.valor = valor;
		return this;
	}

	public AlunoModelBuilder withAvaliacaoMat2s(List<AvaliacaoMat2> avaliacaoMat2s) {
		this.avaliacaoMat2s = avaliacaoMat2s;
		return this;
	}

	public AlunoModelBuilder withAvaliacaoPre1s(List<AvaliacaoPre1> avaliacaoPre1s) {
		this.avaliacaoPre1s = avaliacaoPre1s;
		return this;
	}

	public AlunoModelBuilder withAvaliacaoPre2s(List<AvaliacaoPre2> avaliacaoPre2s) {
		this.avaliacaoPre2s = avaliacaoPre2s;
		return this;
	}

	public AlunoModelBuilder withOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
		return this;
	}

	public AlunoModelBuilder withResponsaveis(List<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
		return this;
	}

}

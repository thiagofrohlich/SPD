package br.com.spd.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the aluno database table.
 * 
 */
@Entity
@NamedQuery(name="Aluno.findAll", query="SELECT a FROM Aluno a")
public class Aluno implements Serializable, Domain {
	private static final long serialVersionUID = 1L;
	private Long matricula;
	private String alergia;
	private Date anoinicio;
	private Date anoletivo;
	private String bairro;
	private String cep;
	private String cidade;
	private String cirurgias;
	private Integer codmed;
	private Date datanasc;
	private String email;
	private String estado;
	private String horario;
	private String modalidade;
	private String nivel;
	private String nome;
	private String numero;
	private String periodo;
	private String religiao;
	private String restalimentar;
	private String rua;
	private Integer serie;
	private String sitpais;
	private String telefone;
	private String temperamento;
	private String tratamento;
	private double valor;
	private List<AvaliacaoMat2> avaliacaoMat2s;
	private List<AvaliacaoPre1> avaliacaoPre1s;
	private List<AvaliacaoPre2> avaliacaoPre2s;
	private List<Ocorrencia> ocorrencias;
	private Pessoa pessoa;

	public Aluno() {
	}


	@Id
	public Long getMatricula() {
		return this.matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}


	public String getAlergia() {
		return this.alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}


	@Temporal(TemporalType.DATE)
	public Date getAnoinicio() {
		return this.anoinicio;
	}

	public void setAnoinicio(Date anoinicio) {
		this.anoinicio = anoinicio;
	}


	@Temporal(TemporalType.DATE)
	public Date getAnoletivo() {
		return this.anoletivo;
	}

	public void setAnoletivo(Date anoletivo) {
		this.anoletivo = anoletivo;
	}


	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getCirurgias() {
		return this.cirurgias;
	}

	public void setCirurgias(String cirurgias) {
		this.cirurgias = cirurgias;
	}


	public Integer getCodmed() {
		return this.codmed;
	}

	public void setCodmed(Integer codmed) {
		this.codmed = codmed;
	}


	@Temporal(TemporalType.DATE)
	public Date getDatanasc() {
		return this.datanasc;
	}

	public void setDatanasc(Date datanasc) {
		this.datanasc = datanasc;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}


	public String getModalidade() {
		return this.modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}


	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}


	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}


	public String getReligiao() {
		return this.religiao;
	}

	public void setReligiao(String religiao) {
		this.religiao = religiao;
	}


	public String getRestalimentar() {
		return this.restalimentar;
	}

	public void setRestalimentar(String restalimentar) {
		this.restalimentar = restalimentar;
	}


	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}


	public Integer getSerie() {
		return this.serie;
	}

	public void setSerie(Integer serie) {
		this.serie = serie;
	}


	public String getSitpais() {
		return this.sitpais;
	}

	public void setSitpais(String sitpais) {
		this.sitpais = sitpais;
	}


	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getTemperamento() {
		return this.temperamento;
	}

	public void setTemperamento(String temperamento) {
		this.temperamento = temperamento;
	}


	public String getTratamento() {
		return this.tratamento;
	}

	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}


	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


	//bi-directional many-to-one association to AvaliacaoMat2
	@OneToMany(mappedBy="aluno")
	public List<AvaliacaoMat2> getAvaliacaoMat2s() {
		return this.avaliacaoMat2s;
	}

	public void setAvaliacaoMat2s(List<AvaliacaoMat2> avaliacaoMat2s) {
		this.avaliacaoMat2s = avaliacaoMat2s;
	}

	public AvaliacaoMat2 addAvaliacaoMat2(AvaliacaoMat2 avaliacaoMat2) {
		getAvaliacaoMat2s().add(avaliacaoMat2);
		avaliacaoMat2.setAluno(this);

		return avaliacaoMat2;
	}

	public AvaliacaoMat2 removeAvaliacaoMat2(AvaliacaoMat2 avaliacaoMat2) {
		getAvaliacaoMat2s().remove(avaliacaoMat2);
		avaliacaoMat2.setAluno(null);

		return avaliacaoMat2;
	}


	//bi-directional many-to-one association to AvaliacaoPre1
	@OneToMany(mappedBy="aluno")
	public List<AvaliacaoPre1> getAvaliacaoPre1s() {
		return this.avaliacaoPre1s;
	}

	public void setAvaliacaoPre1s(List<AvaliacaoPre1> avaliacaoPre1s) {
		this.avaliacaoPre1s = avaliacaoPre1s;
	}

	public AvaliacaoPre1 addAvaliacaoPre1(AvaliacaoPre1 avaliacaoPre1) {
		getAvaliacaoPre1s().add(avaliacaoPre1);
		avaliacaoPre1.setAluno(this);

		return avaliacaoPre1;
	}

	public AvaliacaoPre1 removeAvaliacaoPre1(AvaliacaoPre1 avaliacaoPre1) {
		getAvaliacaoPre1s().remove(avaliacaoPre1);
		avaliacaoPre1.setAluno(null);

		return avaliacaoPre1;
	}


	//bi-directional many-to-one association to AvaliacaoPre2
	@OneToMany(mappedBy="aluno")
	public List<AvaliacaoPre2> getAvaliacaoPre2s() {
		return this.avaliacaoPre2s;
	}

	public void setAvaliacaoPre2s(List<AvaliacaoPre2> avaliacaoPre2s) {
		this.avaliacaoPre2s = avaliacaoPre2s;
	}

	public AvaliacaoPre2 addAvaliacaoPre2(AvaliacaoPre2 avaliacaoPre2) {
		getAvaliacaoPre2s().add(avaliacaoPre2);
		avaliacaoPre2.setAluno(this);

		return avaliacaoPre2;
	}

	public AvaliacaoPre2 removeAvaliacaoPre2(AvaliacaoPre2 avaliacaoPre2) {
		getAvaliacaoPre2s().remove(avaliacaoPre2);
		avaliacaoPre2.setAluno(null);

		return avaliacaoPre2;
	}


	//bi-directional many-to-one association to Ocorrencia
	@OneToMany(mappedBy="aluno")
	public List<Ocorrencia> getOcorrencias() {
		return this.ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	public Ocorrencia addOcorrencia(Ocorrencia ocorrencia) {
		getOcorrencias().add(ocorrencia);
		ocorrencia.setAluno(this);

		return ocorrencia;
	}

	public Ocorrencia removeOcorrencia(Ocorrencia ocorrencia) {
		getOcorrencias().remove(ocorrencia);
		ocorrencia.setAluno(null);

		return ocorrencia;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
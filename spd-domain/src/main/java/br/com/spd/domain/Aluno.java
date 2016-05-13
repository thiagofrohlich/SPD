package br.com.spd.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the aluno database table.
 * 
 */
@Entity
@NamedQuery(name="Aluno.findAll", query="SELECT a FROM Aluno a")
public class Aluno implements Serializable, Domain {
	private static final long serialVersionUID = 1L;
	
	@Id
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
	private String sitpais;
	private String telefone;
	private String temperamento;
	private String tratamento;
	private double valor;

	//bi-directional many-to-one association to Turma
	@ManyToOne
	@JoinColumn(name="id_turma")
	private Turma turma;

	public Aluno() {
	}

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

	public Date getAnoinicio() {
		return this.anoinicio;
	}

	public void setAnoinicio(Date anoinicio) {
		this.anoinicio = anoinicio;
	}

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

}
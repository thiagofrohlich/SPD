package br.com.spd.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Aluno implements Serializable, Model {
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
	private Double valor;
	private List<AvaliacaoMat2> avaliacaoMat2s;
	private List<AvaliacaoPre1> avaliacaoPre1s;
	private List<AvaliacaoPre2> avaliacaoPre2s;
	private List<Ocorrencia> ocorrencias;
	private List<Responsavel> responsaveis;
	
	public Aluno() {
	}
	
	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	public String getAlergia() {
		return alergia;
	}
	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}
	public Date getAnoinicio() {
		return anoinicio;
	}
	public void setAnoinicio(Date anoinicio) {
		this.anoinicio = anoinicio;
	}
	public Date getAnoletivo() {
		return anoletivo;
	}
	public void setAnoletivo(Date anoletivo) {
		this.anoletivo = anoletivo;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCirurgias() {
		return cirurgias;
	}
	public void setCirurgias(String cirurgias) {
		this.cirurgias = cirurgias;
	}
	public Integer getCodmed() {
		return codmed;
	}
	public void setCodmed(Integer codmed) {
		this.codmed = codmed;
	}
	public Date getDatanasc() {
		return datanasc;
	}
	public void setDatanasc(Date datanasc) {
		this.datanasc = datanasc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getReligiao() {
		return religiao;
	}
	public void setReligiao(String religiao) {
		this.religiao = religiao;
	}
	public String getRestalimentar() {
		return restalimentar;
	}
	public void setRestalimentar(String restalimentar) {
		this.restalimentar = restalimentar;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getSerie() {
		return serie;
	}
	public void setSerie(Integer serie) {
		this.serie = serie;
	}
	public String getSitpais() {
		return sitpais;
	}
	public void setSitpais(String sitpais) {
		this.sitpais = sitpais;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTemperamento() {
		return temperamento;
	}
	public void setTemperamento(String temperamento) {
		this.temperamento = temperamento;
	}
	public String getTratamento() {
		return tratamento;
	}
	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public List<AvaliacaoMat2> getAvaliacaoMat2s() {
		return avaliacaoMat2s;
	}
	public void setAvaliacaoMat2s(List<AvaliacaoMat2> avaliacaoMat2s) {
		this.avaliacaoMat2s = avaliacaoMat2s;
	}
	public List<AvaliacaoPre1> getAvaliacaoPre1s() {
		return avaliacaoPre1s;
	}
	public void setAvaliacaoPre1s(List<AvaliacaoPre1> avaliacaoPre1s) {
		this.avaliacaoPre1s = avaliacaoPre1s;
	}
	public List<AvaliacaoPre2> getAvaliacaoPre2s() {
		return avaliacaoPre2s;
	}
	public void setAvaliacaoPre2s(List<AvaliacaoPre2> avaliacaoPre2s) {
		this.avaliacaoPre2s = avaliacaoPre2s;
	}
	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}
	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	public List<Responsavel> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(List<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}
	

}
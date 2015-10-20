package br.com.spd.model;

import java.io.Serializable;


public class AvaliacaoMat2 implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long codavaliacao;
	private String artCorpo;
	private String artCria;
	private String artMateriais;
	private String lingDiferencia;
	private String lingExpressa;
	private String lingNarra;
	private String lingOuve;
	private String lingReconhece;
	private String lingRegistra;
	private String lingRepete;
	private String lingVogais;
	private String matAgrupa;
	private String matCompara;
	private String matContagem;
	private String matElementos;
	private String matFormasGeometricas;
	private String matTempo;
	private String natCorpo;
	private String natEspecies;
	private String natFamilia;
	private String natMusicas;
	private String natPercepcao;
	private String natSentimento;
	private String socAuxilio;
	private String socCuida;
	private String socExpressa;
	private String socExpressoesCorporais;
	private String socInteresse;
	private String socRelaciona;
	private String socRespeita;
	private String trimestre;
	private Aluno aluno;

	public AvaliacaoMat2() {
	}

	public Long getCodavaliacao() {
		return codavaliacao;
	}

	public void setCodavaliacao(Long codavaliacao) {
		this.codavaliacao = codavaliacao;
	}

	public String getArtCorpo() {
		return artCorpo;
	}

	public void setArtCorpo(String artCorpo) {
		this.artCorpo = artCorpo;
	}

	public String getArtCria() {
		return artCria;
	}

	public void setArtCria(String artCria) {
		this.artCria = artCria;
	}

	public String getArtMateriais() {
		return artMateriais;
	}

	public void setArtMateriais(String artMateriais) {
		this.artMateriais = artMateriais;
	}

	public String getLingDiferencia() {
		return lingDiferencia;
	}

	public void setLingDiferencia(String lingDiferencia) {
		this.lingDiferencia = lingDiferencia;
	}

	public String getLingExpressa() {
		return lingExpressa;
	}

	public void setLingExpressa(String lingExpressa) {
		this.lingExpressa = lingExpressa;
	}

	public String getLingNarra() {
		return lingNarra;
	}

	public void setLingNarra(String lingNarra) {
		this.lingNarra = lingNarra;
	}

	public String getLingOuve() {
		return lingOuve;
	}

	public void setLingOuve(String lingOuve) {
		this.lingOuve = lingOuve;
	}

	public String getLingReconhece() {
		return lingReconhece;
	}

	public void setLingReconhece(String lingReconhece) {
		this.lingReconhece = lingReconhece;
	}

	public String getLingRegistra() {
		return lingRegistra;
	}

	public void setLingRegistra(String lingRegistra) {
		this.lingRegistra = lingRegistra;
	}

	public String getLingRepete() {
		return lingRepete;
	}

	public void setLingRepete(String lingRepete) {
		this.lingRepete = lingRepete;
	}

	public String getLingVogais() {
		return lingVogais;
	}

	public void setLingVogais(String lingVogais) {
		this.lingVogais = lingVogais;
	}

	public String getMatAgrupa() {
		return matAgrupa;
	}

	public void setMatAgrupa(String matAgrupa) {
		this.matAgrupa = matAgrupa;
	}

	public String getMatCompara() {
		return matCompara;
	}

	public void setMatCompara(String matCompara) {
		this.matCompara = matCompara;
	}

	public String getMatContagem() {
		return matContagem;
	}

	public void setMatContagem(String matContagem) {
		this.matContagem = matContagem;
	}

	public String getMatElementos() {
		return matElementos;
	}

	public void setMatElementos(String matElementos) {
		this.matElementos = matElementos;
	}

	public String getMatFormasGeometricas() {
		return matFormasGeometricas;
	}

	public void setMatFormasGeometricas(String matFormasGeometricas) {
		this.matFormasGeometricas = matFormasGeometricas;
	}

	public String getMatTempo() {
		return matTempo;
	}

	public void setMatTempo(String matTempo) {
		this.matTempo = matTempo;
	}

	public String getNatCorpo() {
		return natCorpo;
	}

	public void setNatCorpo(String natCorpo) {
		this.natCorpo = natCorpo;
	}

	public String getNatEspecies() {
		return natEspecies;
	}

	public void setNatEspecies(String natEspecies) {
		this.natEspecies = natEspecies;
	}

	public String getNatFamilia() {
		return natFamilia;
	}

	public void setNatFamilia(String natFamilia) {
		this.natFamilia = natFamilia;
	}

	public String getNatMusicas() {
		return natMusicas;
	}

	public void setNatMusicas(String natMusicas) {
		this.natMusicas = natMusicas;
	}

	public String getNatPercepcao() {
		return natPercepcao;
	}

	public void setNatPercepcao(String natPercepcao) {
		this.natPercepcao = natPercepcao;
	}

	public String getNatSentimento() {
		return natSentimento;
	}

	public void setNatSentimento(String natSentimento) {
		this.natSentimento = natSentimento;
	}

	public String getSocAuxilio() {
		return socAuxilio;
	}

	public void setSocAuxilio(String socAuxilio) {
		this.socAuxilio = socAuxilio;
	}

	public String getSocCuida() {
		return socCuida;
	}

	public void setSocCuida(String socCuida) {
		this.socCuida = socCuida;
	}

	public String getSocExpressa() {
		return socExpressa;
	}

	public void setSocExpressa(String socExpressa) {
		this.socExpressa = socExpressa;
	}

	public String getSocExpressoesCorporais() {
		return socExpressoesCorporais;
	}

	public void setSocExpressoesCorporais(String socExpressoesCorporais) {
		this.socExpressoesCorporais = socExpressoesCorporais;
	}

	public String getSocInteresse() {
		return socInteresse;
	}

	public void setSocInteresse(String socInteresse) {
		this.socInteresse = socInteresse;
	}

	public String getSocRelaciona() {
		return socRelaciona;
	}

	public void setSocRelaciona(String socRelaciona) {
		this.socRelaciona = socRelaciona;
	}

	public String getSocRespeita() {
		return socRespeita;
	}

	public void setSocRespeita(String socRespeita) {
		this.socRespeita = socRespeita;
	}

	public String getTrimestre() {
		return trimestre;
	}

	public void setTrimestre(String trimestre) {
		this.trimestre = trimestre;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
package br.com.spd.model;

import java.io.Serializable;


public class AvaliacaoPre2 implements Serializable, Model {
	private static final long serialVersionUID = 1L;
	private Long codavaliacao;
	private String artCria;
	private String artExplora;
	private String artParticipa;
	private String lingAlfabetico;
	private String lingBrinca;
	private String lingDesenho;
	private String lingEscreve;
	private String lingEspacamento;
	private String lingOrganiza;
	private String lingOuve;
	private String lingPreSilabico;
	private String lingRelacionaLetras;
	private String lingSilabico;
	private String lingTentativaLeitura;
	private String matContagem;
	private String matDecimais;
	private String matDesenho;
	private String matQuantidade;
	private String matRealizaContagem;
	private String matSimbolo;
	private String matTempo;
	private String natAmbientes;
	private String natComunicacao;
	private String natHipoteses;
	private String natInfluencia;
	private String natMusicas;
	private String natRecursos;
	private String natTemperatura;
	private String socBrinca;
	private String socCuida;
	private String socExpressa;
	private String socFrustracao;
	private String socIniciativa;
	private String socInteresse;
	private String socOrienta;
	private String socRaciocinio;
	private String socRelaciona;
	private String trimestre;
	private Aluno aluno;

	public AvaliacaoPre2() {
	}

	public Long getCodavaliacao() {
		return codavaliacao;
	}

	public void setCodavaliacao(Long codavaliacao) {
		this.codavaliacao = codavaliacao;
	}

	public String getArtCria() {
		return artCria;
	}

	public void setArtCria(String artCria) {
		this.artCria = artCria;
	}

	public String getArtExplora() {
		return artExplora;
	}

	public void setArtExplora(String artExplora) {
		this.artExplora = artExplora;
	}

	public String getArtParticipa() {
		return artParticipa;
	}

	public void setArtParticipa(String artParticipa) {
		this.artParticipa = artParticipa;
	}

	public String getLingAlfabetico() {
		return lingAlfabetico;
	}

	public void setLingAlfabetico(String lingAlfabetico) {
		this.lingAlfabetico = lingAlfabetico;
	}

	public String getLingBrinca() {
		return lingBrinca;
	}

	public void setLingBrinca(String lingBrinca) {
		this.lingBrinca = lingBrinca;
	}

	public String getLingDesenho() {
		return lingDesenho;
	}

	public void setLingDesenho(String lingDesenho) {
		this.lingDesenho = lingDesenho;
	}

	public String getLingEscreve() {
		return lingEscreve;
	}

	public void setLingEscreve(String lingEscreve) {
		this.lingEscreve = lingEscreve;
	}

	public String getLingEspacamento() {
		return lingEspacamento;
	}

	public void setLingEspacamento(String lingEspacamento) {
		this.lingEspacamento = lingEspacamento;
	}

	public String getLingOrganiza() {
		return lingOrganiza;
	}

	public void setLingOrganiza(String lingOrganiza) {
		this.lingOrganiza = lingOrganiza;
	}

	public String getLingOuve() {
		return lingOuve;
	}

	public void setLingOuve(String lingOuve) {
		this.lingOuve = lingOuve;
	}

	public String getLingPreSilabico() {
		return lingPreSilabico;
	}

	public void setLingPreSilabico(String lingPreSilabico) {
		this.lingPreSilabico = lingPreSilabico;
	}

	public String getLingRelacionaLetras() {
		return lingRelacionaLetras;
	}

	public void setLingRelacionaLetras(String lingRelacionaLetras) {
		this.lingRelacionaLetras = lingRelacionaLetras;
	}

	public String getLingSilabico() {
		return lingSilabico;
	}

	public void setLingSilabico(String lingSilabico) {
		this.lingSilabico = lingSilabico;
	}

	public String getLingTentativaLeitura() {
		return lingTentativaLeitura;
	}

	public void setLingTentativaLeitura(String lingTentativaLeitura) {
		this.lingTentativaLeitura = lingTentativaLeitura;
	}

	public String getMatContagem() {
		return matContagem;
	}

	public void setMatContagem(String matContagem) {
		this.matContagem = matContagem;
	}

	public String getMatDecimais() {
		return matDecimais;
	}

	public void setMatDecimais(String matDecimais) {
		this.matDecimais = matDecimais;
	}

	public String getMatDesenho() {
		return matDesenho;
	}

	public void setMatDesenho(String matDesenho) {
		this.matDesenho = matDesenho;
	}

	public String getMatQuantidade() {
		return matQuantidade;
	}

	public void setMatQuantidade(String matQuantidade) {
		this.matQuantidade = matQuantidade;
	}

	public String getMatRealizaContagem() {
		return matRealizaContagem;
	}

	public void setMatRealizaContagem(String matRealizaContagem) {
		this.matRealizaContagem = matRealizaContagem;
	}

	public String getMatSimbolo() {
		return matSimbolo;
	}

	public void setMatSimbolo(String matSimbolo) {
		this.matSimbolo = matSimbolo;
	}

	public String getMatTempo() {
		return matTempo;
	}

	public void setMatTempo(String matTempo) {
		this.matTempo = matTempo;
	}

	public String getNatAmbientes() {
		return natAmbientes;
	}

	public void setNatAmbientes(String natAmbientes) {
		this.natAmbientes = natAmbientes;
	}

	public String getNatComunicacao() {
		return natComunicacao;
	}

	public void setNatComunicacao(String natComunicacao) {
		this.natComunicacao = natComunicacao;
	}

	public String getNatHipoteses() {
		return natHipoteses;
	}

	public void setNatHipoteses(String natHipoteses) {
		this.natHipoteses = natHipoteses;
	}

	public String getNatInfluencia() {
		return natInfluencia;
	}

	public void setNatInfluencia(String natInfluencia) {
		this.natInfluencia = natInfluencia;
	}

	public String getNatMusicas() {
		return natMusicas;
	}

	public void setNatMusicas(String natMusicas) {
		this.natMusicas = natMusicas;
	}

	public String getNatRecursos() {
		return natRecursos;
	}

	public void setNatRecursos(String natRecursos) {
		this.natRecursos = natRecursos;
	}

	public String getNatTemperatura() {
		return natTemperatura;
	}

	public void setNatTemperatura(String natTemperatura) {
		this.natTemperatura = natTemperatura;
	}

	public String getSocBrinca() {
		return socBrinca;
	}

	public void setSocBrinca(String socBrinca) {
		this.socBrinca = socBrinca;
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

	public String getSocFrustracao() {
		return socFrustracao;
	}

	public void setSocFrustracao(String socFrustracao) {
		this.socFrustracao = socFrustracao;
	}

	public String getSocIniciativa() {
		return socIniciativa;
	}

	public void setSocIniciativa(String socIniciativa) {
		this.socIniciativa = socIniciativa;
	}

	public String getSocInteresse() {
		return socInteresse;
	}

	public void setSocInteresse(String socInteresse) {
		this.socInteresse = socInteresse;
	}

	public String getSocOrienta() {
		return socOrienta;
	}

	public void setSocOrienta(String socOrienta) {
		this.socOrienta = socOrienta;
	}

	public String getSocRaciocinio() {
		return socRaciocinio;
	}

	public void setSocRaciocinio(String socRaciocinio) {
		this.socRaciocinio = socRaciocinio;
	}

	public String getSocRelaciona() {
		return socRelaciona;
	}

	public void setSocRelaciona(String socRelaciona) {
		this.socRelaciona = socRelaciona;
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
package br.com.spd.model;

import java.io.Serializable;


public class AvaliacaoPre1 implements Serializable, Model {
	private static final long serialVersionUID = 1L;
	private Long codavaliacao;
	private String artCria;
	private String artExplora;
	private String artUtiliza;
	private String lingInterage;
	private String lingOuve;
	private String lingPensamento;
	private String lingReconheceIlust;
	private String lingReconheceNome;
	private String lingRegistra;
	private String lingRelata;
	private String matCompara;
	private String matCompreende;
	private String matContagem;
	private String matParticipa;
	private String matPercebeAtributos;
	private String matPercebeComparacao;
	private String matRealizaContagem;
	private String natIdentificaComunicacao;
	private String natPapeis;
	private String natParticipaJogos;
	private String natReconheceFamilia;
	private String natRelacao;
	private String natValoriza;
	private String socConhece;
	private String socCuida;
	private String socExpressa;
	private String socIniciativa;
	private String socInteresseEscolar;
	private String socNomenclatura;
	private String socRelaciona;
	private String trimestre;
	private Aluno aluno;

	public AvaliacaoPre1() {
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

	public String getArtUtiliza() {
		return artUtiliza;
	}

	public void setArtUtiliza(String artUtiliza) {
		this.artUtiliza = artUtiliza;
	}

	public String getLingInterage() {
		return lingInterage;
	}

	public void setLingInterage(String lingInterage) {
		this.lingInterage = lingInterage;
	}

	public String getLingOuve() {
		return lingOuve;
	}

	public void setLingOuve(String lingOuve) {
		this.lingOuve = lingOuve;
	}

	public String getLingPensamento() {
		return lingPensamento;
	}

	public void setLingPensamento(String lingPensamento) {
		this.lingPensamento = lingPensamento;
	}

	public String getLingReconheceIlust() {
		return lingReconheceIlust;
	}

	public void setLingReconheceIlust(String lingReconheceIlust) {
		this.lingReconheceIlust = lingReconheceIlust;
	}

	public String getLingReconheceNome() {
		return lingReconheceNome;
	}

	public void setLingReconheceNome(String lingReconheceNome) {
		this.lingReconheceNome = lingReconheceNome;
	}

	public String getLingRegistra() {
		return lingRegistra;
	}

	public void setLingRegistra(String lingRegistra) {
		this.lingRegistra = lingRegistra;
	}

	public String getLingRelata() {
		return lingRelata;
	}

	public void setLingRelata(String lingRelata) {
		this.lingRelata = lingRelata;
	}

	public String getMatCompara() {
		return matCompara;
	}

	public void setMatCompara(String matCompara) {
		this.matCompara = matCompara;
	}

	public String getMatCompreende() {
		return matCompreende;
	}

	public void setMatCompreende(String matCompreende) {
		this.matCompreende = matCompreende;
	}

	public String getMatContagem() {
		return matContagem;
	}

	public void setMatContagem(String matContagem) {
		this.matContagem = matContagem;
	}

	public String getMatParticipa() {
		return matParticipa;
	}

	public void setMatParticipa(String matParticipa) {
		this.matParticipa = matParticipa;
	}

	public String getMatPercebeAtributos() {
		return matPercebeAtributos;
	}

	public void setMatPercebeAtributos(String matPercebeAtributos) {
		this.matPercebeAtributos = matPercebeAtributos;
	}

	public String getMatPercebeComparacao() {
		return matPercebeComparacao;
	}

	public void setMatPercebeComparacao(String matPercebeComparacao) {
		this.matPercebeComparacao = matPercebeComparacao;
	}

	public String getMatRealizaContagem() {
		return matRealizaContagem;
	}

	public void setMatRealizaContagem(String matRealizaContagem) {
		this.matRealizaContagem = matRealizaContagem;
	}

	public String getNatIdentificaComunicacao() {
		return natIdentificaComunicacao;
	}

	public void setNatIdentificaComunicacao(String natIdentificaComunicacao) {
		this.natIdentificaComunicacao = natIdentificaComunicacao;
	}

	public String getNatPapeis() {
		return natPapeis;
	}

	public void setNatPapeis(String natPapeis) {
		this.natPapeis = natPapeis;
	}

	public String getNatParticipaJogos() {
		return natParticipaJogos;
	}

	public void setNatParticipaJogos(String natParticipaJogos) {
		this.natParticipaJogos = natParticipaJogos;
	}

	public String getNatReconheceFamilia() {
		return natReconheceFamilia;
	}

	public void setNatReconheceFamilia(String natReconheceFamilia) {
		this.natReconheceFamilia = natReconheceFamilia;
	}

	public String getNatRelacao() {
		return natRelacao;
	}

	public void setNatRelacao(String natRelacao) {
		this.natRelacao = natRelacao;
	}

	public String getNatValoriza() {
		return natValoriza;
	}

	public void setNatValoriza(String natValoriza) {
		this.natValoriza = natValoriza;
	}

	public String getSocConhece() {
		return socConhece;
	}

	public void setSocConhece(String socConhece) {
		this.socConhece = socConhece;
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

	public String getSocIniciativa() {
		return socIniciativa;
	}

	public void setSocIniciativa(String socIniciativa) {
		this.socIniciativa = socIniciativa;
	}

	public String getSocInteresseEscolar() {
		return socInteresseEscolar;
	}

	public void setSocInteresseEscolar(String socInteresseEscolar) {
		this.socInteresseEscolar = socInteresseEscolar;
	}

	public String getSocNomenclatura() {
		return socNomenclatura;
	}

	public void setSocNomenclatura(String socNomenclatura) {
		this.socNomenclatura = socNomenclatura;
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
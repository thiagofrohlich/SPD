package br.com.spd.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the avaliacao_pre1 database table.
 * 
 */
@Entity
@Table(name="avaliacao_pre1")
@NamedQuery(name="AvaliacaoPre1.findAll", query="SELECT a FROM AvaliacaoPre1 a")
public class AvaliacaoPre1 implements Serializable {
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


	@Id
	public Long getCodavaliacao() {
		return this.codavaliacao;
	}

	public void setCodavaliacao(Long codavaliacao) {
		this.codavaliacao = codavaliacao;
	}


	@Column(name="art_cria")
	public String getArtCria() {
		return this.artCria;
	}

	public void setArtCria(String artCria) {
		this.artCria = artCria;
	}


	@Column(name="art_explora")
	public String getArtExplora() {
		return this.artExplora;
	}

	public void setArtExplora(String artExplora) {
		this.artExplora = artExplora;
	}


	@Column(name="art_utiliza")
	public String getArtUtiliza() {
		return this.artUtiliza;
	}

	public void setArtUtiliza(String artUtiliza) {
		this.artUtiliza = artUtiliza;
	}


	@Column(name="ling_interage")
	public String getLingInterage() {
		return this.lingInterage;
	}

	public void setLingInterage(String lingInterage) {
		this.lingInterage = lingInterage;
	}


	@Column(name="ling_ouve")
	public String getLingOuve() {
		return this.lingOuve;
	}

	public void setLingOuve(String lingOuve) {
		this.lingOuve = lingOuve;
	}


	@Column(name="ling_pensamento")
	public String getLingPensamento() {
		return this.lingPensamento;
	}

	public void setLingPensamento(String lingPensamento) {
		this.lingPensamento = lingPensamento;
	}


	@Column(name="ling_reconhece_ilust")
	public String getLingReconheceIlust() {
		return this.lingReconheceIlust;
	}

	public void setLingReconheceIlust(String lingReconheceIlust) {
		this.lingReconheceIlust = lingReconheceIlust;
	}


	@Column(name="ling_reconhece_nome")
	public String getLingReconheceNome() {
		return this.lingReconheceNome;
	}

	public void setLingReconheceNome(String lingReconheceNome) {
		this.lingReconheceNome = lingReconheceNome;
	}


	@Column(name="ling_registra")
	public String getLingRegistra() {
		return this.lingRegistra;
	}

	public void setLingRegistra(String lingRegistra) {
		this.lingRegistra = lingRegistra;
	}


	@Column(name="ling_relata")
	public String getLingRelata() {
		return this.lingRelata;
	}

	public void setLingRelata(String lingRelata) {
		this.lingRelata = lingRelata;
	}


	@Column(name="mat_compara")
	public String getMatCompara() {
		return this.matCompara;
	}

	public void setMatCompara(String matCompara) {
		this.matCompara = matCompara;
	}


	@Column(name="mat_compreende")
	public String getMatCompreende() {
		return this.matCompreende;
	}

	public void setMatCompreende(String matCompreende) {
		this.matCompreende = matCompreende;
	}


	@Column(name="mat_contagem")
	public String getMatContagem() {
		return this.matContagem;
	}

	public void setMatContagem(String matContagem) {
		this.matContagem = matContagem;
	}


	@Column(name="mat_participa")
	public String getMatParticipa() {
		return this.matParticipa;
	}

	public void setMatParticipa(String matParticipa) {
		this.matParticipa = matParticipa;
	}


	@Column(name="mat_percebe_atributos")
	public String getMatPercebeAtributos() {
		return this.matPercebeAtributos;
	}

	public void setMatPercebeAtributos(String matPercebeAtributos) {
		this.matPercebeAtributos = matPercebeAtributos;
	}


	@Column(name="mat_percebe_comparacao")
	public String getMatPercebeComparacao() {
		return this.matPercebeComparacao;
	}

	public void setMatPercebeComparacao(String matPercebeComparacao) {
		this.matPercebeComparacao = matPercebeComparacao;
	}


	@Column(name="mat_realiza_contagem")
	public String getMatRealizaContagem() {
		return this.matRealizaContagem;
	}

	public void setMatRealizaContagem(String matRealizaContagem) {
		this.matRealizaContagem = matRealizaContagem;
	}


	@Column(name="nat_identifica_comunicacao")
	public String getNatIdentificaComunicacao() {
		return this.natIdentificaComunicacao;
	}

	public void setNatIdentificaComunicacao(String natIdentificaComunicacao) {
		this.natIdentificaComunicacao = natIdentificaComunicacao;
	}


	@Column(name="nat_papeis")
	public String getNatPapeis() {
		return this.natPapeis;
	}

	public void setNatPapeis(String natPapeis) {
		this.natPapeis = natPapeis;
	}


	@Column(name="nat_participa_jogos")
	public String getNatParticipaJogos() {
		return this.natParticipaJogos;
	}

	public void setNatParticipaJogos(String natParticipaJogos) {
		this.natParticipaJogos = natParticipaJogos;
	}


	@Column(name="nat_reconhece_familia")
	public String getNatReconheceFamilia() {
		return this.natReconheceFamilia;
	}

	public void setNatReconheceFamilia(String natReconheceFamilia) {
		this.natReconheceFamilia = natReconheceFamilia;
	}


	@Column(name="nat_relacao")
	public String getNatRelacao() {
		return this.natRelacao;
	}

	public void setNatRelacao(String natRelacao) {
		this.natRelacao = natRelacao;
	}


	@Column(name="nat_valoriza")
	public String getNatValoriza() {
		return this.natValoriza;
	}

	public void setNatValoriza(String natValoriza) {
		this.natValoriza = natValoriza;
	}


	@Column(name="soc_conhece")
	public String getSocConhece() {
		return this.socConhece;
	}

	public void setSocConhece(String socConhece) {
		this.socConhece = socConhece;
	}


	@Column(name="soc_cuida")
	public String getSocCuida() {
		return this.socCuida;
	}

	public void setSocCuida(String socCuida) {
		this.socCuida = socCuida;
	}


	@Column(name="soc_expressa")
	public String getSocExpressa() {
		return this.socExpressa;
	}

	public void setSocExpressa(String socExpressa) {
		this.socExpressa = socExpressa;
	}


	@Column(name="soc_iniciativa")
	public String getSocIniciativa() {
		return this.socIniciativa;
	}

	public void setSocIniciativa(String socIniciativa) {
		this.socIniciativa = socIniciativa;
	}


	@Column(name="soc_interesse_escolar")
	public String getSocInteresseEscolar() {
		return this.socInteresseEscolar;
	}

	public void setSocInteresseEscolar(String socInteresseEscolar) {
		this.socInteresseEscolar = socInteresseEscolar;
	}


	@Column(name="soc_nomenclatura")
	public String getSocNomenclatura() {
		return this.socNomenclatura;
	}

	public void setSocNomenclatura(String socNomenclatura) {
		this.socNomenclatura = socNomenclatura;
	}


	@Column(name="soc_relaciona")
	public String getSocRelaciona() {
		return this.socRelaciona;
	}

	public void setSocRelaciona(String socRelaciona) {
		this.socRelaciona = socRelaciona;
	}


	public String getTrimestre() {
		return this.trimestre;
	}

	public void setTrimestre(String trimestre) {
		this.trimestre = trimestre;
	}


	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="matricula")
	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
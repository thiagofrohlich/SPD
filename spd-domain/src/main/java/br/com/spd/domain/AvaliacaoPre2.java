package br.com.spd.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the avaliacao_pre2 database table.
 * 
 */
@Entity
@Table(name="avaliacao_pre2")
@NamedQuery(name="AvaliacaoPre2.findAll", query="SELECT a FROM AvaliacaoPre2 a")
public class AvaliacaoPre2 implements Serializable, Domain {
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


	@Id
	@SequenceGenerator(name="pk_avaliacao_pre2",sequenceName="avaliacao_pre2_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="pk_avaliacao_pre2")
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


	@Column(name="art_participa")
	public String getArtParticipa() {
		return this.artParticipa;
	}

	public void setArtParticipa(String artParticipa) {
		this.artParticipa = artParticipa;
	}


	@Column(name="ling_alfabetico")
	public String getLingAlfabetico() {
		return this.lingAlfabetico;
	}

	public void setLingAlfabetico(String lingAlfabetico) {
		this.lingAlfabetico = lingAlfabetico;
	}


	@Column(name="ling_brinca")
	public String getLingBrinca() {
		return this.lingBrinca;
	}

	public void setLingBrinca(String lingBrinca) {
		this.lingBrinca = lingBrinca;
	}


	@Column(name="ling_desenho")
	public String getLingDesenho() {
		return this.lingDesenho;
	}

	public void setLingDesenho(String lingDesenho) {
		this.lingDesenho = lingDesenho;
	}


	@Column(name="ling_escreve")
	public String getLingEscreve() {
		return this.lingEscreve;
	}

	public void setLingEscreve(String lingEscreve) {
		this.lingEscreve = lingEscreve;
	}


	@Column(name="ling_espacamento")
	public String getLingEspacamento() {
		return this.lingEspacamento;
	}

	public void setLingEspacamento(String lingEspacamento) {
		this.lingEspacamento = lingEspacamento;
	}


	@Column(name="ling_organiza")
	public String getLingOrganiza() {
		return this.lingOrganiza;
	}

	public void setLingOrganiza(String lingOrganiza) {
		this.lingOrganiza = lingOrganiza;
	}


	@Column(name="ling_ouve")
	public String getLingOuve() {
		return this.lingOuve;
	}

	public void setLingOuve(String lingOuve) {
		this.lingOuve = lingOuve;
	}


	@Column(name="ling_pre_silabico")
	public String getLingPreSilabico() {
		return this.lingPreSilabico;
	}

	public void setLingPreSilabico(String lingPreSilabico) {
		this.lingPreSilabico = lingPreSilabico;
	}


	@Column(name="ling_relaciona_letras")
	public String getLingRelacionaLetras() {
		return this.lingRelacionaLetras;
	}

	public void setLingRelacionaLetras(String lingRelacionaLetras) {
		this.lingRelacionaLetras = lingRelacionaLetras;
	}


	@Column(name="ling_silabico")
	public String getLingSilabico() {
		return this.lingSilabico;
	}

	public void setLingSilabico(String lingSilabico) {
		this.lingSilabico = lingSilabico;
	}


	@Column(name="ling_tentativa_leitura")
	public String getLingTentativaLeitura() {
		return this.lingTentativaLeitura;
	}

	public void setLingTentativaLeitura(String lingTentativaLeitura) {
		this.lingTentativaLeitura = lingTentativaLeitura;
	}


	@Column(name="mat_contagem")
	public String getMatContagem() {
		return this.matContagem;
	}

	public void setMatContagem(String matContagem) {
		this.matContagem = matContagem;
	}


	@Column(name="mat_decimais")
	public String getMatDecimais() {
		return this.matDecimais;
	}

	public void setMatDecimais(String matDecimais) {
		this.matDecimais = matDecimais;
	}


	@Column(name="mat_desenho")
	public String getMatDesenho() {
		return this.matDesenho;
	}

	public void setMatDesenho(String matDesenho) {
		this.matDesenho = matDesenho;
	}


	@Column(name="mat_quantidade")
	public String getMatQuantidade() {
		return this.matQuantidade;
	}

	public void setMatQuantidade(String matQuantidade) {
		this.matQuantidade = matQuantidade;
	}


	@Column(name="mat_realiza_contagem")
	public String getMatRealizaContagem() {
		return this.matRealizaContagem;
	}

	public void setMatRealizaContagem(String matRealizaContagem) {
		this.matRealizaContagem = matRealizaContagem;
	}


	@Column(name="mat_simbolo")
	public String getMatSimbolo() {
		return this.matSimbolo;
	}

	public void setMatSimbolo(String matSimbolo) {
		this.matSimbolo = matSimbolo;
	}


	@Column(name="mat_tempo")
	public String getMatTempo() {
		return this.matTempo;
	}

	public void setMatTempo(String matTempo) {
		this.matTempo = matTempo;
	}


	@Column(name="nat_ambientes")
	public String getNatAmbientes() {
		return this.natAmbientes;
	}

	public void setNatAmbientes(String natAmbientes) {
		this.natAmbientes = natAmbientes;
	}


	@Column(name="nat_comunicacao")
	public String getNatComunicacao() {
		return this.natComunicacao;
	}

	public void setNatComunicacao(String natComunicacao) {
		this.natComunicacao = natComunicacao;
	}


	@Column(name="nat_hipoteses")
	public String getNatHipoteses() {
		return this.natHipoteses;
	}

	public void setNatHipoteses(String natHipoteses) {
		this.natHipoteses = natHipoteses;
	}


	@Column(name="nat_influencia")
	public String getNatInfluencia() {
		return this.natInfluencia;
	}

	public void setNatInfluencia(String natInfluencia) {
		this.natInfluencia = natInfluencia;
	}


	@Column(name="nat_musicas")
	public String getNatMusicas() {
		return this.natMusicas;
	}

	public void setNatMusicas(String natMusicas) {
		this.natMusicas = natMusicas;
	}


	@Column(name="nat_recursos")
	public String getNatRecursos() {
		return this.natRecursos;
	}

	public void setNatRecursos(String natRecursos) {
		this.natRecursos = natRecursos;
	}


	@Column(name="nat_temperatura")
	public String getNatTemperatura() {
		return this.natTemperatura;
	}

	public void setNatTemperatura(String natTemperatura) {
		this.natTemperatura = natTemperatura;
	}


	@Column(name="soc_brinca")
	public String getSocBrinca() {
		return this.socBrinca;
	}

	public void setSocBrinca(String socBrinca) {
		this.socBrinca = socBrinca;
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


	@Column(name="soc_frustracao")
	public String getSocFrustracao() {
		return this.socFrustracao;
	}

	public void setSocFrustracao(String socFrustracao) {
		this.socFrustracao = socFrustracao;
	}


	@Column(name="soc_iniciativa")
	public String getSocIniciativa() {
		return this.socIniciativa;
	}

	public void setSocIniciativa(String socIniciativa) {
		this.socIniciativa = socIniciativa;
	}


	@Column(name="soc_interesse")
	public String getSocInteresse() {
		return this.socInteresse;
	}

	public void setSocInteresse(String socInteresse) {
		this.socInteresse = socInteresse;
	}


	@Column(name="soc_orienta")
	public String getSocOrienta() {
		return this.socOrienta;
	}

	public void setSocOrienta(String socOrienta) {
		this.socOrienta = socOrienta;
	}


	@Column(name="soc_raciocinio")
	public String getSocRaciocinio() {
		return this.socRaciocinio;
	}

	public void setSocRaciocinio(String socRaciocinio) {
		this.socRaciocinio = socRaciocinio;
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
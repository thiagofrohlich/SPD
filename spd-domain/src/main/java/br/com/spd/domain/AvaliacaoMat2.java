package br.com.spd.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the avaliacao_mat2 database table.
 * 
 */
@Entity
@Table(name="avaliacao_mat2")
@NamedQuery(name="AvaliacaoMat2.findAll", query="SELECT a FROM AvaliacaoMat2 a")
public class AvaliacaoMat2 implements Serializable, Domain {
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


	@Id
	@SequenceGenerator(name="pk_avaliacao_mat2",sequenceName="avaliacao_mat2_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="pk_avaliacao_mat2")
	public Long getCodavaliacao() {
		return this.codavaliacao;
	}

	public void setCodavaliacao(Long codavaliacao) {
		this.codavaliacao = codavaliacao;
	}


	@Column(name="art_corpo")
	public String getArtCorpo() {
		return this.artCorpo;
	}

	public void setArtCorpo(String artCorpo) {
		this.artCorpo = artCorpo;
	}


	@Column(name="art_cria")
	public String getArtCria() {
		return this.artCria;
	}

	public void setArtCria(String artCria) {
		this.artCria = artCria;
	}


	@Column(name="art_materiais")
	public String getArtMateriais() {
		return this.artMateriais;
	}

	public void setArtMateriais(String artMateriais) {
		this.artMateriais = artMateriais;
	}


	@Column(name="ling_diferencia")
	public String getLingDiferencia() {
		return this.lingDiferencia;
	}

	public void setLingDiferencia(String lingDiferencia) {
		this.lingDiferencia = lingDiferencia;
	}


	@Column(name="ling_expressa")
	public String getLingExpressa() {
		return this.lingExpressa;
	}

	public void setLingExpressa(String lingExpressa) {
		this.lingExpressa = lingExpressa;
	}


	@Column(name="ling_narra")
	public String getLingNarra() {
		return this.lingNarra;
	}

	public void setLingNarra(String lingNarra) {
		this.lingNarra = lingNarra;
	}


	@Column(name="ling_ouve")
	public String getLingOuve() {
		return this.lingOuve;
	}

	public void setLingOuve(String lingOuve) {
		this.lingOuve = lingOuve;
	}


	@Column(name="ling_reconhece")
	public String getLingReconhece() {
		return this.lingReconhece;
	}

	public void setLingReconhece(String lingReconhece) {
		this.lingReconhece = lingReconhece;
	}


	@Column(name="ling_registra")
	public String getLingRegistra() {
		return this.lingRegistra;
	}

	public void setLingRegistra(String lingRegistra) {
		this.lingRegistra = lingRegistra;
	}


	@Column(name="ling_repete")
	public String getLingRepete() {
		return this.lingRepete;
	}

	public void setLingRepete(String lingRepete) {
		this.lingRepete = lingRepete;
	}


	@Column(name="ling_vogais")
	public String getLingVogais() {
		return this.lingVogais;
	}

	public void setLingVogais(String lingVogais) {
		this.lingVogais = lingVogais;
	}


	@Column(name="mat_agrupa")
	public String getMatAgrupa() {
		return this.matAgrupa;
	}

	public void setMatAgrupa(String matAgrupa) {
		this.matAgrupa = matAgrupa;
	}


	@Column(name="mat_compara")
	public String getMatCompara() {
		return this.matCompara;
	}

	public void setMatCompara(String matCompara) {
		this.matCompara = matCompara;
	}


	@Column(name="mat_contagem")
	public String getMatContagem() {
		return this.matContagem;
	}

	public void setMatContagem(String matContagem) {
		this.matContagem = matContagem;
	}


	@Column(name="mat_elementos")
	public String getMatElementos() {
		return this.matElementos;
	}

	public void setMatElementos(String matElementos) {
		this.matElementos = matElementos;
	}


	@Column(name="mat_formas_geometricas")
	public String getMatFormasGeometricas() {
		return this.matFormasGeometricas;
	}

	public void setMatFormasGeometricas(String matFormasGeometricas) {
		this.matFormasGeometricas = matFormasGeometricas;
	}


	@Column(name="mat_tempo")
	public String getMatTempo() {
		return this.matTempo;
	}

	public void setMatTempo(String matTempo) {
		this.matTempo = matTempo;
	}


	@Column(name="nat_corpo")
	public String getNatCorpo() {
		return this.natCorpo;
	}

	public void setNatCorpo(String natCorpo) {
		this.natCorpo = natCorpo;
	}


	@Column(name="nat_especies")
	public String getNatEspecies() {
		return this.natEspecies;
	}

	public void setNatEspecies(String natEspecies) {
		this.natEspecies = natEspecies;
	}


	@Column(name="nat_familia")
	public String getNatFamilia() {
		return this.natFamilia;
	}

	public void setNatFamilia(String natFamilia) {
		this.natFamilia = natFamilia;
	}


	@Column(name="nat_musicas")
	public String getNatMusicas() {
		return this.natMusicas;
	}

	public void setNatMusicas(String natMusicas) {
		this.natMusicas = natMusicas;
	}


	@Column(name="nat_percepcao")
	public String getNatPercepcao() {
		return this.natPercepcao;
	}

	public void setNatPercepcao(String natPercepcao) {
		this.natPercepcao = natPercepcao;
	}


	@Column(name="nat_sentimento")
	public String getNatSentimento() {
		return this.natSentimento;
	}

	public void setNatSentimento(String natSentimento) {
		this.natSentimento = natSentimento;
	}


	@Column(name="soc_auxilio")
	public String getSocAuxilio() {
		return this.socAuxilio;
	}

	public void setSocAuxilio(String socAuxilio) {
		this.socAuxilio = socAuxilio;
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


	@Column(name="soc_expressoes_corporais")
	public String getSocExpressoesCorporais() {
		return this.socExpressoesCorporais;
	}

	public void setSocExpressoesCorporais(String socExpressoesCorporais) {
		this.socExpressoesCorporais = socExpressoesCorporais;
	}


	@Column(name="soc_interesse")
	public String getSocInteresse() {
		return this.socInteresse;
	}

	public void setSocInteresse(String socInteresse) {
		this.socInteresse = socInteresse;
	}


	@Column(name="soc_relaciona")
	public String getSocRelaciona() {
		return this.socRelaciona;
	}

	public void setSocRelaciona(String socRelaciona) {
		this.socRelaciona = socRelaciona;
	}


	@Column(name="soc_respeita")
	public String getSocRespeita() {
		return this.socRespeita;
	}

	public void setSocRespeita(String socRespeita) {
		this.socRespeita = socRespeita;
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
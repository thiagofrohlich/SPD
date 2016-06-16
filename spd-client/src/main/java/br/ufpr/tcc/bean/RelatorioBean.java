package br.ufpr.tcc.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import br.com.spd.enums.Trimestre;
import br.com.spd.model.Aluno;
import br.com.spd.model.Turma;
import br.ufpr.tcc.service.handler.AlunoServiceHandler;
import br.ufpr.tcc.service.handler.RelatorioServiceHandler;
import br.ufpr.tcc.service.handler.TurmaServiceHandler;
import br.ufpr.tcc.service.handler.impl.AlunoServiceHandlerImpl;
import br.ufpr.tcc.service.handler.impl.RelatorioServiceHandlerImpl;
import br.ufpr.tcc.service.handler.impl.TurmaServiceHandlerImpl;

@ViewScoped
@ManagedBean(name = "relatorioBean")
public class RelatorioBean {
	
	private Aluno aluno;
	private String nome;
	private Long turmaId;
	private Long turmaIdAvaliacao;
	private Aluno alunoSelecionado;
	private List<Aluno> lstAluno;
	private RelatorioServiceHandler relatorioServiceHandler;
	private List<Turma> listTurma;
	private TurmaServiceHandler turmaServiceHandler;
	private String relType;
	private AlunoServiceHandler alunoServiceHandler;
	private String trimestre;
	private String trimestreAluno;
	private boolean showTrimestre;
	private String nomeOcorrencia;
	
	
	
	@PostConstruct
	public void init(){
		alunoServiceHandler = new AlunoServiceHandlerImpl();
		relatorioServiceHandler = new RelatorioServiceHandlerImpl();
		turmaServiceHandler = new TurmaServiceHandlerImpl();
		listTurma = turmaServiceHandler.findAll().getList();
		aluno = new Aluno();
		alunoSelecionado = new Aluno();
		lstAluno = new ArrayList<>();
		showTrimestre = false;
	}
	
	public void geraRelatorio() throws IOException{
		byte[] bt = null;
		bt = buscaRelatorios(bt);
		FacesContext context = FacesContext.getCurrentInstance();  
		HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();  
		response.reset();  
		response.setContentType("application/pdf");  
		response.setHeader("Content-Disposition", "attachment; filename=Relatorio.pdf");  
		response.setHeader("Cache-Control", "no-cache");  
		response.getOutputStream().write(bt);  
		response.getOutputStream().flush();  
		response.getOutputStream().close();  
		context.responseComplete(); 
	}

	private byte[] buscaRelatorios(byte[] bt) {
		switch (relType) {
		case "alunoTurma":
			bt = relatorioServiceHandler.getAlunoPorTurma(turmaId);
			break;
		
		case "avaliacaoTurma":
			bt = relatorioServiceHandler.getAvaliacaoTurma(turmaIdAvaliacao, trimestre);
			break;
			
		case "avaliacaoAluno":
			bt = relatorioServiceHandler.getavaliacaoAluno(alunoSelecionado.getTurma().getId(), alunoSelecionado.getMatricula(), trimestreAluno);
			break;
			
		case "ocorrenciaAluno":
			bt = relatorioServiceHandler.getOcorrenciaAluno(aluno.getMatricula());
			break;
			
		default:
			break;
		}
		return bt;
	}

	public void buscaAluno(){
		lstAluno = alunoServiceHandler.findByNome(nome).getList();
	}

	public void buscaAlunoOcorrencia(){
		lstAluno = alunoServiceHandler.findByNome(nomeOcorrencia).getList();
	}
	
	
	
	public void fillRelatorio(String type){
		relType = type;
		if(type.equals("avaliacaoAluno")){
			showTrimestre = true;
		}else{
			showTrimestre = false;
		}
	}
	
	public Trimestre[] getLstTrimestre(){
		return Trimestre.values();
	}
	
	public Aluno getAlunoSelecionado() {
		return alunoSelecionado;
	}

	public void setAlunoSelecionado(Aluno alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}

	public List<Aluno> getLstAluno() {
		return lstAluno;
	}

	public void setLstAluno(List<Aluno> lstAluno) {
		this.lstAluno = lstAluno;
	}

	public List<Turma> getListTurma() {
		return listTurma;
	}

	public void setListTurma(List<Turma> listTurma) {
		this.listTurma = listTurma;
	}

	public Long getTurmaId() {
		return turmaId;
	}

	public void setTurmaId(Long turmaId) {
		this.turmaId = turmaId;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTrimestre(String trimestre) {
		this.trimestre = trimestre;
	}

	public String getTrimestre() {
		return trimestre;
	}

	public boolean isShowTrimestre() {
		return showTrimestre;
	}

	public void setShowTrimestre(boolean showTrimestre) {
		this.showTrimestre = showTrimestre;
	}

	public String getNomeOcorrencia() {
		return nomeOcorrencia;
	}

	public void setNomeOcorrencia(String nomeOcorrencia) {
		this.nomeOcorrencia = nomeOcorrencia;
	}

	public String getTrimestreAluno() {
		return trimestreAluno;
	}

	public void setTrimestreAluno(String trimestreAluno) {
		this.trimestreAluno = trimestreAluno;
	}

	public Long getTurmaIdAvaliacao() {
		return turmaIdAvaliacao;
	}

	public void setTurmaIdAvaliacao(Long turmaIdAvaliacao) {
		this.turmaIdAvaliacao = turmaIdAvaliacao;
	}

	 
}

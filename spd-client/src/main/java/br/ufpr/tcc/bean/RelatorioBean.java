package br.ufpr.tcc.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import br.com.spd.model.Aluno;
import br.ufpr.tcc.service.handler.RelatorioServiceHandler;
import br.ufpr.tcc.service.handler.impl.RelatorioServiceHandlerImpl;

@ViewScoped
@ManagedBean(name = "relatorioBean")
public class RelatorioBean {

	
	private Aluno alunoSelecionado;
	private List<Aluno> lstAluno;
	private RelatorioServiceHandler relatorioServiceHandler;
	@PostConstruct
	public void init(){
		relatorioServiceHandler = new RelatorioServiceHandlerImpl();
	}
	
	public void teste() throws IOException{
		byte[] bt = null;
		bt = relatorioServiceHandler.getTeste();
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
}

package br.ufpr.tcc.bean;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.spd.enums.Roles;
import br.com.spd.model.Usuario;
import br.ufpr.tcc.service.handler.UsuarioServiceHandler;
import br.ufpr.tcc.service.handler.impl.UsuarioServiceHandlerImpl;

@SessionScoped
@ManagedBean(name="loginBean")
@Component
public class LoginBean {

	
	private static final long serialVersionUID = 1L;
	private String user;
	private Usuario usuario;
	private boolean cadastroAluno;
	private boolean avaliacao;
	private boolean cadastroProfessor;
	private boolean cadastroUsuario;
	private boolean ocorrencia;
	private boolean relatorio;
	private boolean trocaSenha;
	private UsuarioServiceHandler usuarioSerivceHandler;
	
	public void init(){
		usuarioSerivceHandler = new UsuarioServiceHandlerImpl();
		user = (String)SecurityContextHolder.getContext().getAuthentication().getName();
		usuario = usuarioSerivceHandler.getByLogin(user);
		if(usuario.getRole().equals(Roles.ADMINISTRADOR.getId())){
			cadastroAluno = true;
			avaliacao = true;
			cadastroProfessor = true;
			cadastroUsuario = true;
			ocorrencia = true;
			relatorio = true;
			trocaSenha = true;
		}
		if(usuario.getRole().equals(Roles.PEDAGOGO.getId())){
			cadastroAluno = true;
			avaliacao = true;
			cadastroProfessor = true;
			cadastroUsuario = false;
			ocorrencia = true;
			relatorio = true;
			trocaSenha = true;
		}
		if(usuario.getRole().equals(Roles.PROFESSOR.getId())){
			cadastroAluno = false;
			avaliacao = true;
			cadastroProfessor = false;
			cadastroUsuario = false;
			ocorrencia = true;
			relatorio = false;
			trocaSenha = true;
		}
		if(usuario.getResetarSenha()){
			cadastroAluno = false;
			avaliacao = false;
			cadastroProfessor = false;
			cadastroUsuario = false;
			ocorrencia = false;
			relatorio = false;
			trocaSenha = false;
		}
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public boolean isCadastroAluno() {
		return cadastroAluno;
	}


	public void setCadastroAluno(boolean cadastroAluno) {
		this.cadastroAluno = cadastroAluno;
	}


	public boolean isAvaliacao() {
		return avaliacao;
	}


	public void setAvaliacao(boolean avaliacao) {
		this.avaliacao = avaliacao;
	}


	public boolean isCadastroProfessor() {
		return cadastroProfessor;
	}


	public void setCadastroProfessor(boolean cadastroProfessor) {
		this.cadastroProfessor = cadastroProfessor;
	}


	public boolean isCadastroUsuario() {
		return cadastroUsuario;
	}


	public void setCadastroUsuario(boolean cadastroUsuario) {
		this.cadastroUsuario = cadastroUsuario;
	}


	public boolean isOcorrencia() {
		return ocorrencia;
	}


	public void setOcorrencia(boolean ocorrencia) {
		this.ocorrencia = ocorrencia;
	}


	public boolean isRelatorio() {
		return relatorio;
	}


	public void setRelatorio(boolean relatorio) {
		this.relatorio = relatorio;
	}


	public boolean isTrocaSenha() {
		return trocaSenha;
	}


	public void setTrocaSenha(boolean trocaSenha) {
		this.trocaSenha = trocaSenha;
	}


	public UsuarioServiceHandler getUsuarioSerivceHandler() {
		return usuarioSerivceHandler;
	}


	public void setUsuarioSerivceHandler(UsuarioServiceHandler usuarioSerivceHandler) {
		this.usuarioSerivceHandler = usuarioSerivceHandler;
	}


}

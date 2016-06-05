package br.ufpr.tcc.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.spd.enums.Roles;
import br.com.spd.model.Usuario;
import br.ufpr.tcc.service.handler.UsuarioServiceHandler;
import br.ufpr.tcc.service.handler.impl.UsuarioServiceHandlerImpl;

@ViewScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean {

	
	private Usuario usuario;
	private String nome;
	private boolean resetarSenha;
	private ResourceBundle rb;
	private List<Usuario> listUsuario;
	private Usuario usuarioSelecionado;
	private String senha;
	private String confirmaSenha;
	private UsuarioServiceHandler usuarioServiceHandler;

	@PostConstruct
	public void init(){
		usuario = new Usuario();
		usuario.setAtivo(true);
		resetarSenha = false;
		rb = ResourceBundle.getBundle("msg");
		listUsuario = new ArrayList<>();
		usuarioSelecionado = new Usuario();
		usuarioServiceHandler = new UsuarioServiceHandlerImpl();
	}
	
	public void resetarSenha(){
		usuario.setResetarSenha(true);
		FacesContext.getCurrentInstance().addMessage("messageAavaliacao", new FacesMessage(FacesMessage.SEVERITY_INFO, "", rb.getString("resetSenhaSuccess")));
	}
	
	public void buscaUsuario(){
		listUsuario = usuarioServiceHandler.getByLoginLike(nome).getList();
	}
	
	public void selecionaUsuario(){
		usuario = usuarioSelecionado;
		resetarSenha = true;
		usuarioSelecionado = new Usuario();
	}
	
	public void salvaUsuario(){
		try{
			usuario.setResetarSenha(true);
			usuarioServiceHandler.create(usuario);
			FacesContext.getCurrentInstance().addMessage("messageUsuario", new FacesMessage(FacesMessage.SEVERITY_INFO, "", rb.getString("salvaUsuarioSuccess")));
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage("messageUsuario", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", rb.getString("salvaUsuarioFailure")));
		}
	}
	
	public Roles[] getRoles(){
		return Roles.values();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isResetarSenha() {
		return resetarSenha;
	}

	public void setResetarSenha(boolean resetarSenha) {
		this.resetarSenha = resetarSenha;
	}

	public List<Usuario> getListUsuario() {
		return listUsuario;
	}

	public void setListUsuario(List<Usuario> listUsuario) {
		this.listUsuario = listUsuario;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	
}

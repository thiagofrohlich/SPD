package br.ufpr.tcc.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;

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
		usuarioSelecionado = new Usuario();
		resetarSenha = !usuario.getResetarSenha();
	}
	
	public void trocarSenha(){
		if(senha.equals(confirmaSenha)){
			try{
				String user = (String)SecurityContextHolder.getContext().getAuthentication().getName();
				usuario = usuarioServiceHandler.getByLogin(user);
				usuario.setResetarSenha(false);
				usuario.setSenha(usuarioServiceHandler.encodePassword(senha));
				usuarioServiceHandler.update(usuario);
				doLogout();
				FacesContext.getCurrentInstance().addMessage("messageLogin", new FacesMessage(FacesMessage.SEVERITY_INFO, "", rb.getString("salvaSenhaSuccess")));
			}catch(Exception e){
				FacesContext.getCurrentInstance().addMessage("messageSenha", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", rb.getString("salvaSenhaFailure")));
			}
		}else{
			FacesContext.getCurrentInstance().addMessage("messageSenha", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", rb.getString("senhaConfirmFailure")));
		}
	}
	
	public void salvaUsuario(){
		try{
			if(usuario.getSenha() == null ||usuario.getSenha().equals("")){
				usuario.setResetarSenha(true);
			}
			usuarioServiceHandler.create(usuario);
			FacesContext.getCurrentInstance().addMessage("messageUsuario", new FacesMessage(FacesMessage.SEVERITY_INFO, "", rb.getString("salvaUsuarioSuccess")));
			usuario = new Usuario();
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage("messageUsuario", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", rb.getString("salvaUsuarioFailure")));
		}
	}
	
	
	private String doLogout() throws ServletException, IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
                .getRequestDispatcher("/j_spring_security_logout");

        dispatcher.forward((ServletRequest) context.getRequest(),
                (ServletResponse) context.getResponse());

        FacesContext.getCurrentInstance().responseComplete();

        return null;
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

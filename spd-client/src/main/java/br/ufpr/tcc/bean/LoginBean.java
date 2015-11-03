package br.ufpr.tcc.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@SessionScoped
@ManagedBean(name="loginBean")
@Component
public class LoginBean {

	
	private static final long serialVersionUID = 1L;
	private String user;
	private String senha;
	
	
	public void init(){
		String nome = null;
		user = (String)SecurityContextHolder.getContext().getAuthentication().getName();
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
}

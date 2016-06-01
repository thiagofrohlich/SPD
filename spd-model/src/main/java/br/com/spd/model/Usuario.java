package br.com.spd.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Usuario implements Serializable, Model {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Boolean ativo;
	private String login;
	private Boolean resetarSenha;
	private String roles;
	private String senha;

	public Usuario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Boolean getResetarSenha() {
		return this.resetarSenha;
	}

	public void setResetarSenha(Boolean resetarSenha) {
		this.resetarSenha = resetarSenha;
	}

	public String getRoles() {
		return this.roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
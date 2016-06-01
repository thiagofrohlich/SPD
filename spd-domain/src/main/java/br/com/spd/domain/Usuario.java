package br.com.spd.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable, Domain {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="pk_usuario",sequenceName="usuario_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="pk_professor")
	private Integer id;
	private Boolean ativo;
	private String login;
	@Column(name="resetar_senha")
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
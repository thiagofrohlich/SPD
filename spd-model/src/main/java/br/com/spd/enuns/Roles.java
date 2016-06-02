package br.com.spd.enuns;

public enum Roles {
	ADMINISTRADOR(1, "ADMINISTRADOR"),
	PEDAGOGO(2, "PEDAGOGO"),
	PROFESSOR(3, "PROFESSOR");

	private Integer id;
	private String descricao;
	
	Roles(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
	
}

package br.com.spd.enums;

public enum Roles {
	ADMINISTRADOR(1, "ADMINISTRADOR"),
	PEDAGOGO(2, "PEDAGOGO"),
	PROFESSOR(3, "PROFESSOR"),
	PASSWORD_RESET(999, "PASSWORD_RESET");

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
	
	public static Roles valueOf(Integer key) {
		for(Roles role : Roles.values()) {
			if(role.getId().equals(key)) {
				return role;
			}
		}
		return null;
	}
	
}

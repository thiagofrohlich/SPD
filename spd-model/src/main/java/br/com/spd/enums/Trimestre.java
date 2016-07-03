package br.com.spd.enums;

public enum Trimestre {

PRIMEIRO("Primeiro", "1"), SEGUNDO("Segundo", "2"), TERCEIRO("Terceiro", "3");
	
	private String descricao;
	private String id;
	
	Trimestre(String descricao,String id){
		this.descricao = descricao;
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}


	public String getId() {
		return id;
	}
}

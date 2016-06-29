package br.com.spd.enums;

public enum Modalidade {
	
BERCARIO("Berçario"), PRE("Pré-escola");
	
	private String descricao;
	
	Modalidade(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}


}

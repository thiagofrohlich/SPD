package br.com.spd.enums;

public enum Periodo {

MEIO_PERIODO("Meio Período"), INTERMEDIARIO("Intermediario"), INTEGRAL("Integral");
	
	private String descricao;
	
	Periodo(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}


}

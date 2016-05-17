package br.com.spd.enuns;

public enum Notas {
	MUITO_BOM("Muito bom", "M"), BOM("Bom", "B"), EM_PROGRESSO("Em Progresso", "E");
	
	private String descricao;
	private String id;
	
	Notas(String descricao,String id){
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

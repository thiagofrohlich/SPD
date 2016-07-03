package br.com.spd.enums;

public enum Modalidade {
	
BERCARIO("Berçário" , 1), PRE("Pré-escola", 2);
	
	private String descricao;
	private Integer id;
	Modalidade(String descricao, Integer id){
		this.descricao = descricao;
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Integer getId() {
		return id;
	}
	
	public static String getName(Integer id){
		for( Modalidade m : Modalidade.values()){
			if(m.getId() == id){
				return m.getDescricao();
			}
		}
		return null;
	}

	public static Integer valueOfDescricao(String key) {
		for(Modalidade modalidade : Modalidade.values()) {
			if(modalidade.getDescricao().equals(key)) {
				return modalidade.getId();
			}
		}
		return null;
	}

}

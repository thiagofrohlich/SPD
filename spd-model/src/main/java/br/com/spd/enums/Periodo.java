package br.com.spd.enums;

public enum Periodo {

MEIO_PERIODO("Meio Período", 1), INTERMEDIARIO("Intermediario", 2), INTEGRAL("Integral", 3);
	
	private String descricao;
	private Integer id;
	Periodo(String descricao, Integer id){
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
		for( Periodo p : Periodo.values()){
			if(p.getId() == id){
				return p.getDescricao();
			}
		}
		return null;
	}
	
	public static Integer valueOfDescricao(String key) {
		for(Periodo periodo : Periodo.values()) {
			if(periodo.getDescricao().equals(key)) {
				return periodo.getId();
			}
		}
		return null;
	}

}

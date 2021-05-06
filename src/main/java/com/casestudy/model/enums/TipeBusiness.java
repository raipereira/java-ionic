package com.casestudy.model.enums;

public enum TipeBusiness {
	
	PRIVATEINDIVIDUAL(1, "Private Individual"),
	LEGALENTITY(2, "Legal Entity");
	
	private int cod;
	private String description;
	
	private TipeBusiness(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	
	public int getCod() {
		return cod;
	}


	public String getDescription() {
		return description;
	}


	public static TipeBusiness convertToEnum(Integer cod) {
		if(cod == null) 
			return null;
		
		for(TipeBusiness x : TipeBusiness.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("cod it's invalid" + cod);
	}
	

}

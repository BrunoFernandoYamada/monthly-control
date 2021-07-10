package com.bfyamada.monthlycontrol.core.enums;

public enum Month {
	
	JANUARY(1, "January"), 
	FEBRUARY(2, "February"),
	MARCH(3, "March"),
	APRIL(4, "April"),
	MAY(5, "May"),
	JUNE(6, "June"),
	JULY(7, "July"),
	AUGUST(8, "August"),
	SEPTEMBER(9, "September"),
	OCTOBER(10, "October"),
	NOVENBER(11, "November"),
	DECEMBER(12, "December");
	
	private int cod;
	private String name;
	
	private Month(int cod, String name) {
		this.cod = cod;
		this.name = name;
	}
	
	public int getCod() {
		return this.cod;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static Month toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Month x: Month.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
		
	}


}

package com.cash.ms.model;

import javax.validation.constraints.Size;


public class CustomerEntity {

	
	private String idC;
	

	private String nameC;

	private String lastNameC;
	

	@Size(min = 8, max = 8, message = "must contain 8 characters")
	private String dniC;


	private String Addr;


	public String getIdC() {
		return idC;
	}

	public void setIdC(String idC) {
		this.idC = idC;
	}

	public String getNameC() {
		return nameC;
	}

	public void setNameC(String nameC) {
		this.nameC = nameC;
	}

	public String getLastNameC() {
		return lastNameC;
	}

	public void setLastNameC(String lastNameC) {
		this.lastNameC = lastNameC;
	}

	public String getDniC() {
		return dniC;
	}

	public void setDniC(String dniC) {
		this.dniC = dniC;
	}

	public String getAddr() {
		return Addr;
	}

	public void setAddr(String addr) {
		Addr = addr;
	}

}

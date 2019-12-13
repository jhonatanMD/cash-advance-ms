package com.cash.ms.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Document(collection =  "CashAdvance")
public class EntityCashAdvance {
	@Id
	private String id;
	private String docCli;
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private Date dateRg;
	private Double cash;
	private String status;
	private CustomerEntity customerEntity;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDocCli() {
		return docCli;
	}
	public void setDocCli(String docCli) {
		this.docCli = docCli;
	}
	public Date getDateRg() {
		return dateRg;
	}
	public void setDateRg(Date dateRg) {
		this.dateRg = dateRg;
	}
	public Double getCash() {
		return cash;
	}
	public void setCash(Double cash) {
		this.cash = cash;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}
	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}
	
	
	

}

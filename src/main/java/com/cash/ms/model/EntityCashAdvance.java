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
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private Date dateRg;
	private Double cash;
	private String status;
	private HeadLineEntity customerEntity;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	public HeadLineEntity getCustomerEntity() {
		return customerEntity;
	}
	public void setCustomerEntity(HeadLineEntity customerEntity) {
		this.customerEntity = customerEntity;
	}
	
	
	

}

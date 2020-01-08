package com.logicbig.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.Type;

@Entity
public class Report {
    @Id
    @GeneratedValue
    private long id;
    
    private long serialid;
    
    
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String data;

	public Report(long id, String data,long serialid) {
		super();
		this.id = id;
		this.data = data;
		this.serialid=serialid;
	}

	public Report() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public long getSerialid() {
		return serialid;
	}

	public void setSerialid(long serialid) {
		this.serialid = serialid;
	}

	@Override
	public String toString() {
		return "Report [id=" + id + ", serialid=" + serialid + ", data=" + data + "]";
	}

	
    
}
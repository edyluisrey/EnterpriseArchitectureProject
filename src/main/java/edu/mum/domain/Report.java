package edu.mum.domain;

import java.util.Date;

public class Report {
	
	private Date date;
	private int id;
	private double totalIncome;
	private int totalCheckins;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}
	public int getTotalCheckins() {
		return totalCheckins;
	}
	public void setTotalCheckins(int totalCheckins) {
		this.totalCheckins = totalCheckins;
	}
	

}

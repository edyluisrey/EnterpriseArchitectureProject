package edu.mum.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Audit implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String who;
	private String description;
	private String methodInvoke;
	private String successful;
	private Date time;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMethodInvoke() {
		return methodInvoke;
	}

	public void setMethodInvoke(String methodInvoke) {
		this.methodInvoke = methodInvoke;
	}

	public String getSuccessful() {
		return successful;
	}

	public void setSuccessful(String successful) {
		this.successful = successful;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}

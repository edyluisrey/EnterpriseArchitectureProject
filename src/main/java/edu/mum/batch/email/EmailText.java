package edu.mum.batch.email;

//import org.apache.commons.lang3.builder.ToStringBuilder;

public class EmailText {
	
	private String emailType;
	private String emailSubject;
	private String emailText;
		
	public String getEmailType() {
		return emailType;
	}
 
	public void setEmailType(String emailType) {
		this.emailType = emailType.trim();
	}
 
	public String getEmailSubject() {
		return emailSubject;
	}
 
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject.trim();
	}
 
	public String getEmailText() {
		return emailText;
	}
 
	public void setEmailText(String emailText) {
		this.emailText = emailText.trim();
	}
 
/*	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
*/ 
}
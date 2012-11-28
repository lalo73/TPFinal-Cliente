package client;

import java.util.Calendar;

import interfaces.IHeader;

public class Header implements IHeader {
	
	private String subject;
	private Calendar date;
	private String sender;
	private String reciver;
	
	public Header(String sender,String reciver,String subject,Calendar date){
		this.setSender(sender);
		this.setReciver(reciver);
		this.setSubject(subject);
		this.setDate(date);
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReciver() {
		return reciver;
	}
	public void setReciver(String reciver) {
		this.reciver = reciver;
	}

	

}

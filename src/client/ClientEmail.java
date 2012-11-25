package client;

import java.util.*;

public class ClientEmail implements IEmail {
	
     private ClientEmailHead head;
     private boolean isReaded;
     private ArrayList<ClientEmailAttachment> attachment;
     private String body;
	
     
     
    public boolean isReaded() {
		return isReaded;
	}
	public void setReaded(boolean isReaded) {
		this.isReaded = isReaded;
	}
	public ArrayList<ClientEmailAttachment> getAttachment() {
		return attachment;
	}
	public void setAttachment(ArrayList<ClientEmailAttachment> attachment) {
		this.attachment = attachment;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public void setHead(ClientEmailHead head) {
		this.head = head;
	}
	public ClientEmailHead getHead() {
		return head;
		
		
	}
	public ClientEmail(ClientEmailHead head,ArrayList<ClientEmailAttachment> attachment, String body) {
		super();
		this.head = head;
		this.isReaded = false;
		this.attachment = attachment;
		this.body = body;
	}
}
	
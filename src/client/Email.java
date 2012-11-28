package client;

import java.util.ArrayList;

import interfaces.IAttachment;
import interfaces.IEmail;
import interfaces.IHeader;

public class Email implements IEmail {
	
    private IHeader head;
    private boolean isReaded;
    private ArrayList<IAttachment> attachment;
    private String body;
    private boolean full;
    
    public Email(IHeader head,String body,ArrayList<IAttachment> attachment,boolean full){
    	this(head,body,full);
    	this.setAttachment(attachment);
    }
    
    public Email(IHeader head,String body,boolean full){
    	this(head,full);
    	this.setBody(body);
    }
    public Email(IHeader head,ArrayList<IAttachment> attachment,boolean full){
    	this(head,full);
    	this.setAttachment(attachment);
    }
    
    public Email(IHeader head,boolean full){
    	this.setHead(head);
    	this.setReaded(false);
    	this.setFull(full);
    }
    
	@Override
	public void setAttachment(ArrayList<IAttachment> new_attachment) {
		attachment = new_attachment;
		
	}
	@Override
	public void setReaded(boolean b) {
		isReaded = b;
		
	}
	@Override
	public void setBody(String new_body) {
		body = new_body;
		
	}
	@Override
	public void setHead(IHeader new_head) {
		head = new_head;
		
	}
	@Override
	public boolean isReaded() {
		return isReaded;
	}
	@Override
	public ArrayList<IAttachment> getAttachment() {
		return attachment;
	}
	@Override
	public String getBody() {
		return body;
	}
	@Override
	public IHeader getHead() {
		return head;
	}

	public boolean isFull() {
		return full;
	}

	public void setFull(boolean full) {
		this.full = full;
	}

	

}

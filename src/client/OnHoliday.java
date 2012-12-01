package client;

import interfaces.IClient;
import interfaces.IEmail;

import java.util.ArrayList;
import exceptions.NoLoggedUserException;

public class OnHoliday extends LoggedUserClientState {
	
	private int reSendToNumber;
	private String reSendToEmail;
	
	
	public OnHoliday(int resendeed){
		this.setReSendToNumber(resendeed);
		
	}
	
	public OnHoliday(String resendeed){
		this.setReSendToEmail(resendeed);
	}
	

	public void askEmails(IClient cl) throws Exception {
		ArrayList<IEmail> emails = this.getAccesType(cl).askEmails(cl, false);
		this.filtrar(cl, emails);
		this.reSendAllEmails(emails,cl);

	}
	
	public void reSendAllEmails(ArrayList<IEmail> emails, IClient client) throws NoLoggedUserException{
		for (IEmail email : emails)
			this.reSendEmail(email, client);
	}
	
	public void reSendEmail(IEmail e,IClient cl) throws NoLoggedUserException{
		if(this.getReSendToEmail() != null)
			cl.sendEmail(e);
		if(this.getReSendToNumber() != 0)
			cl.sendMessage(this.getReSendToNumber(), e.getHead().getSender() + " sended "+e.getBody());
		
	}
	
	public int getReSendToNumber() {
		return reSendToNumber;
	}

	public void setReSendToNumber(int reSendToNumber) {
		this.reSendToNumber = reSendToNumber;
	}

	public String getReSendToEmail() {
		return reSendToEmail;
	}

	public void setReSendToEmail(String reSendToEmail) {
		this.reSendToEmail = reSendToEmail;
	}
	
	

}

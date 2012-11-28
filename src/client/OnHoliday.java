package client;

import interfaces.IClient;
import interfaces.IEmail;

import java.util.List;

import exception.CannotFindUserException;
import exceptions.NoLoggedUserException;

public class OnHoliday extends LoggedUserClientState {
	
	private int reSendTo;
	
	private OnHoliday(int resendeed){
		this.setReSendTo(resendeed);
		
	}
	
	public onHolidayToSMS(int number){
		return new OnHoliday();
	}

	public void askEmails(IClient cl) throws NoLoggedUserException,
			CannotFindUserException {
		List<IEmail> emails = this.getAccesType(cl).askEmails(cl, false);
		this.filtrar(cl, emails);
		this.reSendEmails()

	}

}

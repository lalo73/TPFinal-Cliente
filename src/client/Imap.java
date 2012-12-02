package client;

import interfaces.IClient;
import interfaces.IEmail;
import interfaces.IHeader;
import interfaces.IUser;

import java.util.ArrayList;

import server.ServerEmailHead;

import exception.CannotFindUserException;
import exceptions.CannotFindEmailException;
import exceptions.NoLoggedUserException;

public class Imap extends Pop3 {

	@Override
	public ArrayList<IEmail> askEmails(IClient cl, boolean delete)
			throws CannotFindUserException, Exception {
		ArrayList<IHeader> heads = new ArrayList<IHeader>();
		for (ServerEmailHead head : cl.getLoggedUser().getServer()
				.sendEmailWithIMAP(cl.getLoggedUser().getName()))
			heads.add(changeToClientHeader(head));
		ArrayList<IEmail> emails = new ArrayList<IEmail>();
		for (IHeader head : heads)
			emails.add(new Email(head, false));

		return emails;
	}

	@Override
	public void delete(IClient client, IHeader header)
			throws NoLoggedUserException, CannotFindEmailException, Exception {
		super.delete(client, header);
		IUser user = client.getLoggedUser();
		user.getServer().removeEmailByHeader(user.getName(),
				changeToServerEmailHead(header));

	}

	@Override
	public void delete(IClient client, IEmail email)
			throws NoLoggedUserException, CannotFindEmailException, Exception {
		super.delete(client, email);
		IUser user = client.getLoggedUser();
		user.getServer().removeEmailByReader(user.getName(),
				changeToServerEmail(email));

	}

	@Override
	public IEmail read(IClient client, IEmail email) throws exception.CannotFindEmailException, CannotFindUserException {
		if (email.isFull())
			return email;
		IEmail complete_email = changeToClientEmail(client.getLoggedUser().getServer().sendEmail(changeToServerEmailHead(email.getHead()), client.getLoggedUser().getName()));
		complete_email.setFull(true);
		return complete_email;
	}
	
	@Override
	public IEmail read(IClient client, IHeader header)
			throws Exception {
		IUser user = client.getLoggedUser(); 
		return changeToClientEmail(user.getServer().sendEmail(changeToServerEmailHead(header), user.getName()));
	}
}

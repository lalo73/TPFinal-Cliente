package client;

import interfaces.IClient;
import interfaces.IEmail;
import interfaces.IFolder;
import interfaces.IHeader;

import java.util.ArrayList;

import exception.CannotFindUserException;
import exceptions.CannotFindEmailException;
import exceptions.NoLoggedUserException;

public class Pop3 extends AccessType {

	@Override
	public ArrayList<IEmail> askEmails(IClient cl, boolean delete)
			throws CannotFindUserException, Exception {

		return changeToClientEmails(cl.getLoggedUser().getServer()
				.sendEmailWithPOP3(cl.getLoggedUser().getName(), delete));
	}

	@Override
	public void delete(IClient client, IHeader header)
			throws NoLoggedUserException, CannotFindEmailException, Exception {
		ArrayList<IFolder> folders = client.getFolders();
		for (IFolder folder : folders)
			if (folder.includes(header))
				folder.removeEmailByHeader(header);

	}

	@Override
	public void delete(IClient client, IEmail email)
			throws NoLoggedUserException, CannotFindEmailException, Exception {
		ArrayList<IFolder> folders = client.getFolders();
		for (IFolder folder : folders)
			if (folder.includes(email))
				folder.removeEmail(email);

	}

	@Override
	public IEmail read(IClient client, IEmail email) throws exception.CannotFindEmailException, CannotFindUserException {
		return email;
	}

	@Override
	public IEmail read(IClient client, IHeader header)
			throws Exception {
		ArrayList<IFolder> folders = client.getFolders();
		for (IFolder folder : folders)
			if (folder.includes(header))
				return folder.getEmail(header);
	
		throw new CannotFindEmailException();
	}

}

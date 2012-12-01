package interfaces;

import client.AccessType;
import exception.CannotFindUserException;
import exceptions.CannotFindEmailException;
import exceptions.NoLoggedUserException;

public class Imap extends AccessType {

	@Override
	public void delete(IClient client, IHeader header)
			throws NoLoggedUserException, CannotFindEmailException, Exception {
		super.delete(client, header);
		IUser user = client.getLoggedUser();
		user.getServer().removeEmailByHeader(user.getName(),
				this.changeToServerEmailHead(header));

	}

	@Override
	public void delete(IClient client, IEmail email) throws Exception {
		super.delete(client, email);
		IUser user = client.getLoggedUser();
		user.getServer().removeEmailByReader(user.getName(),
				this.changeToServerEmail(email));

	}

	@Override
	public IEmail read(IClient client, IHeader header)
			throws CannotFindEmailException, NoLoggedUserException,
			exception.CannotFindEmailException, CannotFindUserException {
		IUser user = client.getLoggedUser();
		return this.changeToClientEmail(user.getServer().sendEmail(
				this.changeToServerEmailHead(header), user.getName()));
	}

}

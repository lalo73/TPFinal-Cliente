package interfaces;

import java.util.List;

import server.ServerEmail;

import exception.CannotFindUserException;
import exceptions.CannotFindEmailException;
import exceptions.NoLoggedUserException;

public interface IAccesType {

	public List<IEmail> askEmails(IClient cl, boolean delete)
			throws CannotFindUserException, Exception;

	public void delete(IClient client, IHeader header) throws NoLoggedUserException, CannotFindEmailException, Exception;

	public void delete(IClient client, IEmail email) throws NoLoggedUserException, CannotFindEmailException;

	public IEmail read(IClient client, IEmail email);

	public IEmail read(IClient client, IHeader header) throws CannotFindEmailException, NoLoggedUserException, exception.CannotFindEmailException, CannotFindUserException;
	
	public List<IEmail> changeToClientEmails(List<ServerEmail>server_emails);

}

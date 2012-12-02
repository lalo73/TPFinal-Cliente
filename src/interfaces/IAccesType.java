package interfaces;

import java.util.ArrayList;
import exception.CannotFindUserException;
import exceptions.CannotFindEmailException;
import exceptions.NoLoggedUserException;

public interface IAccesType {

	public ArrayList<IEmail> askEmails(IClient cl, boolean delete)
			throws CannotFindUserException, Exception;

	public void delete(IClient client, IHeader header) throws NoLoggedUserException, CannotFindEmailException, Exception;

	public void delete(IClient client, IEmail email) throws NoLoggedUserException, CannotFindEmailException, Exception;

	public IEmail read(IClient client, IEmail email) throws exception.CannotFindEmailException, CannotFindUserException;

	public IEmail read(IClient client, IHeader header) throws CannotFindEmailException, NoLoggedUserException, exception.CannotFindEmailException, CannotFindUserException, Exception;

}

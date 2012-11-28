package interfaces;

import java.util.List;

import server.ServerEmail;

import exception.CannotFindUserException;

public interface IAccesType {

	public List<IEmail> askEmails(IClient cl, boolean delete)
			throws CannotFindUserException;

	public void delete(IClient client, IHeader header);

	public void delete(IClient client, IEmail email);

	public IEmail read(IClient client, IEmail email);

	public IEmail read(IClient client, IHeader header);
	
	public List<IEmail> changeToClientEmails(List<ServerEmail>server_emails);

}

package client;

import java.util.ArrayList;
import java.util.List;
import server.ServerEmail;
import server.ServerEmailAttachment;
import server.ServerEmailHead;
import exception.CannotFindUserException;
import exceptions.CannotFindEmailException;
import exceptions.NoLoggedUserException;
import interfaces.IAccesType;
import interfaces.IAttachment;
import interfaces.IClient;
import interfaces.IEmail;
import interfaces.IHeader;
/**
 * Represent a abstract class, that access to a Server of a specific class.
 * It's got several class method to convert a ServerImail to a Email
 * 
 * @author Leandro Gomez
 *
 */

public abstract class AccessType implements IAccesType {

	/**
	 * Must be implemented by a subclass.
	 * @return a list of Email, taken to the server and convert them to
	 *   cliene Email 
	 */
	@Override
	public abstract ArrayList<IEmail> askEmails(IClient cl, boolean delete)
			throws CannotFindUserException, Exception;

	/**
	 * Delete a Email,find it by its head.
	 * If is necessary, delete it from the server
	 */
	@Override
	public abstract void delete(IClient client, IHeader header)
			throws NoLoggedUserException, CannotFindEmailException, Exception;

	/**
	 * Delete a Email.
	 * If is necessary, delete it from the server
	 */
	@Override
	public abstract void delete(IClient client, IEmail email)
			throws NoLoggedUserException, CannotFindEmailException, Exception;

	/**
	 * return a Email. if it need, give email attributes from sever 
	 * 
	 * @return full Email
	 */
	@Override
	public abstract IEmail read(IClient client, IHeader header)
			throws CannotFindEmailException, NoLoggedUserException,
			exception.CannotFindEmailException, CannotFindUserException, Exception;

	/**
	 * Make a instance of ServerEmailHead taking its attributes from header
	 * parameter
	 * 
	 * @param header
	 * @return a instance of ServerEmailHead
	 */
	public static ServerEmailHead changeToServerEmailHead(IHeader header) {
		return new ServerEmailHead(header.getReciver(), header.getSubject(),
				header.getDate(), header.getSender());
	}

	/**
	 * make a instance of ServerEmail taking its attributes from email parameter
	 * 
	 * @param email
	 * @return a instance of ServerEmail
	 */
	public static ServerEmail changeToServerEmail(IEmail email) {

		return new ServerEmail(changeToServerEmailHead(email.getHead()),
				changeToServerAttachments(email.getAttachment()),
				email.getBody());

	}

	/**
	 * convert a list of ServerEmailAttachement on a list of objects of a class
	 * that implements a interface IAttachement
	 * 
	 * @param attachments
	 * @return list of objects of a class that implements a interface
	 *         IAttachement
	 */

	public static ArrayList<ServerEmailAttachment> changeToServerAttachments(
			List<IAttachment> attachments) {

		ArrayList<ServerEmailAttachment> list = new ArrayList<ServerEmailAttachment>();
		for (IAttachment attachment : attachments) {
			list.add(changeToServerAttachment(attachment));

		}

		return list;
	}

	/**
	 * this method take a Object of a class that implements a IAttachment
	 * interface
	 * 
	 * @param attach
	 * @return a instance of ServerEmailAttachment
	 */
	public static ServerEmailAttachment changeToServerAttachment(
			IAttachment attach) {
		return new ServerEmailAttachment(attach.getFileName(), attach.getFile());

	}

	/**
	 * convert a list Email to a list of ServerEmail
	 * 
	 * @param emails
	 * @return a array list of ServerEmail
	 */

	public static ArrayList<ServerEmail> changeToServerEmails(
			ArrayList<IEmail> emails) {
		ArrayList<ServerEmail> server_emails = new ArrayList<ServerEmail>();
		for (IEmail email : emails) {
			server_emails.add(changeToServerEmail(email));
		}

		return server_emails;

	}

	/**
	 * Convert a list of ServerEmail instances on a list of objects of a class
	 * that implements a IEmail interface
	 * 
	 * @param server_emails
	 * @return a list of instances of objects of a class that implements IEmail
	 *         interface
	 */
	public static ArrayList<IEmail> changeToClientEmails(
			List<ServerEmail> server_emails) {
		ArrayList<IEmail> list = new ArrayList<IEmail>();
		for (ServerEmail email : server_emails)
			list.add(changeToClientEmail(email));
		return list;
	}

	/**
	 * convert a ServerEmailHead instance on a object of a class that implement
	 * a interface IHeader
	 * 
	 * @param head
	 * @return a instance of a class that implements a interface IHEader
	 */

	public static IHeader changeToClientHeader(ServerEmailHead head) {
		return new Header(head.getSender(), head.getReciver(),
				head.getSubject(), head.getDate());

	}

	/**
	 * Convert a list of ServerEmailAttachment to a list of Attachment
	 * 
	 * @param attachments
	 * @return an array list of Attachment
	 */

	public static ArrayList<IAttachment> changeClientAttachments(
			ArrayList<ServerEmailAttachment> attachments) {
		ArrayList<IAttachment> attachs = new ArrayList<IAttachment>();
		for (ServerEmailAttachment attach : attachments) {
			attachs.add(changeClientAttachment(attach));
		}

		return attachs;
	}

	public static IAttachment changeClientAttachment(
			ServerEmailAttachment attach) {
		return new Attachment(attach.getFileName(), attach.getFile());
	}

	/**
	 * this method take a ServerEmail and convert it to a Email
	 * 
	 * @param email
	 * @return a instance of a class that implements a IEmail interface
	 */

	public static IEmail changeToClientEmail(ServerEmail email) {
		IHeader head = changeToClientHeader(email.getHead());
		ArrayList<IAttachment> attachs;
		String body;
		attachs = changeClientAttachments(email.getAttachment());
		body = email.getBody();
		return new Email(head, body, attachs, true);

	}

}

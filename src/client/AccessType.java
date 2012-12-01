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

public class AccessType implements IAccesType {

	@Override
	public ArrayList<IEmail> askEmails(IClient cl, boolean delete)
			throws CannotFindUserException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(IClient client, IHeader header)
			throws NoLoggedUserException, CannotFindEmailException, Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(IClient client, IEmail email)
			throws NoLoggedUserException, CannotFindEmailException, Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public IEmail read(IClient client, IEmail email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEmail read(IClient client, IHeader header)
			throws CannotFindEmailException, NoLoggedUserException,
			exception.CannotFindEmailException, CannotFindUserException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ServerEmailHead changeToServerEmailHead(IHeader header) {
		return new ServerEmailHead(header.getReciver(), header.getSubject(),
				header.getDate(), header.getSender());
	}

	public ServerEmail changeToServerEmail(IEmail email) {

		return new ServerEmail(this.changeToServerEmailHead(email.getHead()),
				this.changeToServerAttachment(email.getAttachment()),
				email.getBody());

	}

	@Override
	public ArrayList<IEmail> changeToClientEmails(
			List<ServerEmail> server_emails) {
		return null;
	}

	public IHeader changeToClientHeader(ServerEmailHead head) {
		return new Header(head.getSender(), head.getReciver(),
				head.getSubject(), head.getDate());

	}

	public IEmail changeToClientEmail(ServerEmail email) {
		IHeader head = this.changeToClientHeader(email.getHead());
		ArrayList<IAttachment> attachs;
		String body;
		if (email.getAttachment() != null) {
			attachs = this.changeClientAttachment(email.getAttachment());

		} else {
			attachs = new ArrayList<IAttachment>();
		}
		if (email.getBody() != null) {
			body = email.getBody();

		} else {
			body = "";
		}

		return new Email(head, body, attachs, true);

	}
	
	public ArrayList<ServerEmailAttachment> changeToServerAttachment(
			List<IAttachment> attachments) {

		ArrayList<ServerEmailAttachment> list = new ArrayList<ServerEmailAttachment>();
		for (IAttachment attachment : attachments) {
			list.add(new ServerEmailAttachment(attachment.getFileName(),
					attachment.getFile()));

		}

		return list;
	}

	public ArrayList<IAttachment> changeClientAttachment(
			ArrayList<ServerEmailAttachment> attachments) {
		ArrayList<IAttachment> attachs = new ArrayList<IAttachment>();
		for (ServerEmailAttachment attach : attachments) {
			attachs.add(new Attachment(attach.getFileName(), attach.getFile()));
		}

		return attachs;
	}

}

package interfaces;

import java.util.ArrayList;
import java.util.List;

import client.Attachment;
import client.Email;
import client.Header;
import client.Pop3;

import server.ServerEmail;
import server.ServerEmailAttachment;
import server.ServerEmailHead;
import exception.CannotFindUserException;
import exceptions.CannotFindEmailException;
import exceptions.NoLoggedUserException;

public class Imap extends Pop3 implements IAccesType {

	@Override
	public void delete(IClient client, IHeader header)
			throws NoLoggedUserException, CannotFindEmailException, Exception {
		super.delete(client, header);
		IUser user = client.getLoggedUser();
		user.getServer().removeEmailByHeader(user.getName(), header);

	}

	@Override
	public void delete(IClient client, IEmail email)
			throws NoLoggedUserException, CannotFindEmailException {
		super.delete(client, email);
		IUser user = client.getLoggedUser();
		user.getServer().removeEmail(user.getName(), email);

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

	@Override
	public IEmail read(IClient client, IHeader header)
			throws CannotFindEmailException, NoLoggedUserException,
			exception.CannotFindEmailException, CannotFindUserException {
		IUser user = client.getLoggedUser();
		return this.changeToClientEmail(user.getServer().sendEmail(
				this.changeToServerEmailHead(header), user.getName()));
	}

	@Override
	public List<IEmail> changeToClientEmails(List<ServerEmail> server_emails) {
		return null;
	}

	public IHeader changeToClientHeader(ServerEmailHead head) {
		return new Header(head.getSender(), head.getReciver(),
				head.getSubject(), head.getDate());

	}

	public IEmail changeToClientEmail(ServerEmail email){
		IHeader head = this.changeToClientHeader(email.getHead());
		ArrayList<IAttachment> attachs;
		String body;
		if(email.getAttachment() != null){
			attachs = this.changeClientAttachment(email.getAttachment());
		
		} else{
			attachs = new ArrayList<IAttachment>();
		}
		if(email.getBody()!=null){
			body = email.getBody();
			
		}else{
			body = "";
		}
		
		return new Email(head, body, attachs, true);
		
		
		
	}
}

package client;

import interfaces.IAccesType;
import interfaces.IAttachment;
import interfaces.IClient;
import interfaces.IEmail;
import interfaces.IFolder;
import interfaces.IHeader;
import interfaces.IUser;

import java.util.ArrayList;
import java.util.List;

import exception.CannotFindUserException;
import exceptions.CannotFindEmailException;
import exceptions.NoLoggedUserException;

import server.ServerEmail;
import server.ServerEmailAttachment;
import server.ServerEmailHead;

public class Pop3 implements IAccesType {

	@Override
	public List<IEmail> askEmails(IClient cl,boolean delete) throws Exception {
		IUser user = cl.getLoggedUser();
		List<ServerEmail> server_emails = user.getServer().sendEmailWithPOP3(user.getName(), delete);
		
		return this.changeToClientEmails(server_emails);
		
	}

	@Override
	public void delete(IClient client, IHeader header) throws NoLoggedUserException, CannotFindEmailException, Exception {
		
		for(IFolder folder : client.getFolders()){
			if(folder.includes(header)){
				folder.removeEmailByHeader(header);
				return;
			}
			
		}
		throw new CannotFindEmailException();
		
		
	}

	@Override
	public void delete(IClient client, IEmail email) throws NoLoggedUserException, CannotFindEmailException {
		for(IFolder folder : client.getFolders()){
			if(folder.includes(email)){
				folder.removeEmail(email);
				return;
			}
			
		}
		throw new CannotFindEmailException();
		
	}

	@Override
	public IEmail read(IClient client, IEmail email) {
		return email;
	}

	@Override
	public IEmail read(IClient client, IHeader header) throws CannotFindEmailException, NoLoggedUserException {
		return client.find(header);
	}

	@Override
	public List<IEmail> changeToClientEmails(List<ServerEmail> server_emails) {
		List<IEmail> client_emails = new ArrayList<IEmail>();
		for (ServerEmail server_email : server_emails){
			
			IHeader client_head = this.changeToClientHead(server_email.getHead());
			ArrayList<IAttachment> client_attachment = this.changeToClientAttachment(server_email.getAttachment());
			
			IEmail email = new Email(client_head,server_email.getBody(),client_attachment,true);
			client_emails.add(email);
		}
		return client_emails;
	}

	private ArrayList<IAttachment> changeToClientAttachment(List<ServerEmailAttachment> server_attachs) {
		ArrayList<IAttachment> client_attachment = new ArrayList<IAttachment>();
		for(ServerEmailAttachment server_attach: server_attachs){
			IAttachment attachment = new Attachment(server_attach.getFileName(),server_attach.getFile());
			client_attachment.add(attachment);
		}
		
		return client_attachment;
	}

	private IHeader changeToClientHead(ServerEmailHead head) {
		
		String subject;
		if (head.getSubject() == null){
			subject = "";
		} else {
			subject = head.getSubject();
		}
		
		return new Header(head.getSender(),head.getReciver(),subject,head.getDate());
	}


}

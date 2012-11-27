package client;

import java.util.List;

import server.Server;
import server.ServerEmail;
import server.ServerEmailHead;

public abstract class TypeAccess {
	
	public abstract List<ServerEmail> askFullEmails(Server server,IUser user);
	
	public abstract ServerEmail askEmailByHeader(IHeader h, IUser user);
	
	public abstract List<ServerEmailHead> askHeaders(IUser use);
	
	

}

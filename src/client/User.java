package client;

import interfaces.IAccesType;
import interfaces.IUser;
import server.Server;

public class User implements IUser{
	
	private String name;
	private String password;
	private Server server;
	private IAccesType accesType;
	

	public User(String userName, String password, Server server, IAccesType accesType) {
		this.setName(userName);
		this.setPassword(password);
		this.setAccesType(accesType);
		this.setServer(server);
		
	}

	@Override
	public boolean equals(IUser u) {
		return (
				this.getName().equals(u.getName()) && 
				this.getPassword().equals(u.getPassword()) && 
				this.getServer().equals(u.getServer())
				);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String newName) {
		name = newName;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String newPassword) {
		password = newPassword;
		
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public IAccesType getAccesType() {
		return accesType;
	}

	public void setAccesType(IAccesType accesType) {
		this.accesType = accesType;
	}
	
	

}

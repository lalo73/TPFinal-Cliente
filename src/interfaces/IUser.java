package interfaces;

import server.Server;

public interface IUser {
	
	public boolean equals(IUser u);
	public String getName();
	public void setName(String name);
	public String getPassword();
	public void setPassword(String newPassword);
	public Server getServer();
	public void setServer(Server server);
	public void setAccesType(IAccesType accessType);
	public IAccesType getAccesType();

}

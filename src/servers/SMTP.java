package servers;

import interfaces.IEmail;

public class SMTP {
	
	private String serverSMTP;
	private String userName;
	private String password;
	
	public SMTP(String userName,String password, String serverSMTP){
		this.setServerSMTP(serverSMTP);
	}
	
	/**
	 * Simula el logueo de un usuario
	 */
	public boolean logIn(String userName,String password, String serverSMTP){
		
		return true;
	}
	
	public void send(IEmail email){}

	public boolean logOut(){
		return true;
	}
	
	public String getServerSMTP() {
		return serverSMTP;
	}

	public void setServerSMTP(String serverSMTP) {
		this.serverSMTP = serverSMTP;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}

package client;

import java.util.ArrayList;

public interface IEmail {
	 public boolean isReaded();
	 public ArrayList<ClientEmailAttachment> getAttachment();
	 public String getBody();
	 public ClientEmailHead getHead();
	 
	 

}

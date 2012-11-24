package client;

import java.util.ArrayList;

public interface IEmail {
	 public void setAttachment(ArrayList<ClientEmailAttachment> attachment);
	 public void setReaded(boolean b);
	 public void setBody(String body) ;
	 public void setHead(ClientEmailHead head);
	 public boolean isReaded();
	 public ArrayList<ClientEmailAttachment> getAttachment();
	 public String getBody();
	 public ClientEmailHead getHead();
	 
	 

}

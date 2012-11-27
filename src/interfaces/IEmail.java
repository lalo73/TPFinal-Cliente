package interfaces;

import java.util.ArrayList;

import client.ClientEmailAttachment;
import client.ClientEmailHead;

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

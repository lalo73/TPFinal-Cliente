package client;
import client.IEmail;



	public interface IFolder {
		
		public void add(IEmail e);
		public void removeEmail(IEmail e);
		public boolean includes(IEmail e);
		public void clearList();
		public IEmail getEmail(IEmail e) throws Exception;
		public void setFolderName(String folderName);
		
		
	}



package client;

import java.util.ArrayList;

import client.IEmail;



	public interface IFolder {
		
		public void add(IEmail e);
	<<<<<<< HEAD
		public void removeEmail(IEmail e);
	=======
		public void remove(IEmail e);

	>>>>>>> branch 'master' of https://github.com/lalo73/TPFinal-Cliente.git
		public boolean includes(IEmail e);
		public void clearList();
		public IEmail getEmail(IEmail e) throws Exception;
		public void setFolderName(String folderName);
	<<<<<<< HEAD
	=======
		public void setEmail(ArrayList<IEmail> email);

	>>>>>>> branch 'master' of https://github.com/lalo73/TPFinal-Cliente.git
	}

}

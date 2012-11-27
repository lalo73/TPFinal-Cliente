package interfaces;

import java.util.List;

public interface IContact {
	
	public String getName();
	public void setName(String newName);
	public List<IEmail> getEmails();

}

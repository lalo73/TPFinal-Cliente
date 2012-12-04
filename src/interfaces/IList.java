package interfaces;

import java.util.List;

public interface IList extends IContact{
	
	public List<IContact> getContacts();
	public boolean includes(IContact c);
	public boolean empty();
	public int size();
	public void add(IPerson c);
	public void remove(IPerson c);

}

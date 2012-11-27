package interfaces;

import java.util.List;

public interface IList extends IContact{
	
	public void add(IContact c);
	public void remove(IContact c);
	public List<IContact> getContacts();
	public boolean includes(IContact c);

}

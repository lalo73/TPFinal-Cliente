package client;

public interface IFolder {
	
	public void add(IEmail e);
	public void remove(IEmail e);
	public boolean includes(IEmail e);

}

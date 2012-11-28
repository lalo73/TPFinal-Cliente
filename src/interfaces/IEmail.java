package interfaces;

import java.util.ArrayList;

public interface IEmail {

	public void setAttachment(ArrayList<IAttachment> attachment);

	public void setReaded(boolean b);

	public void setBody(String body);

	public void setHead(IHeader head);

	public boolean isReaded();

	public ArrayList<IAttachment> getAttachment();

	public String getBody();

	public IHeader getHead();

}

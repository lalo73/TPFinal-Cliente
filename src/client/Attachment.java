package client;

import interfaces.IAttachment;

/**
 * 
 * 
 * @author Leandro Gomez
 *
 */
public class Attachment implements IAttachment {
	
	private String FileName;
	private String file;
	public Attachment(String fileName,String file){
		this.setFileName(fileName);
		this.setFile(file);
	}
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	
	

}

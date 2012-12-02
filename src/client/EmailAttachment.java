package client;

/**
 * @Author: Flores Jorge
 */

public class EmailAttachment {
	String fileName;
	String file;
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	
	
	public EmailAttachment(String fileName, String file) {
		super();
		this.fileName = fileName;
		this.file = file;
	}
	
	
	

}

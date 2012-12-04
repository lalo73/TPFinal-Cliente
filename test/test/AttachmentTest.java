package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import client.Attachment;

public class AttachmentTest {

	Attachment attachment;

	@Before
	public void setUp() {
		attachment = new Attachment("FileName", "FileOnMimeFormat");
	}

	@Test
	public void testAAttachmentHasAFile() {

		assertTrue(!attachment.getFile().isEmpty());
	}

	@Test
	public void testAAttachmentHasAFileName() {
		assertTrue(!attachment.getFileName().isEmpty());
	}
	
	@Test
	public void testSetAFileName(){
		assertEquals(attachment.getFileName(),"FileName");
		attachment.setFileName("NewFileName");
		assertEquals(attachment.getFileName(),"NewFileName");
	}
	
	@Test
	public void testSetAFile(){
		assertEquals(attachment.getFile(),"FileOnMimeFormat");
		attachment.setFile("NewFileOnMimeFormat");
		assertEquals(attachment.getFile(),"NewFileOnMimeFormat");
	}
}

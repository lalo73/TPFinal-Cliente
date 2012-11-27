package test;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import client.ClientEmailAttachment;

public class TestClientEmailAttachment {
   ClientEmailAttachment at;
   
   @Before
   public void setUp(){
	   at = new ClientEmailAttachment("photo","aPicture");
	   
   }
   @Test
   public void testgetFileName(){
	   assertEquals(at.getFileName(),"photo");
	   assertFalse (at.getFileName() == "aPicture");
   }
   @Test
   public void testgetFile(){
	   assertEquals(at.getFile(),"aPicture");
	   assertFalse(at.getFile() == "photo");
   }

}
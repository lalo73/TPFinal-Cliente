package test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import events.EveryDay;


public class TestEveryDay {

	Calendar d = Calendar.getInstance();
	EveryDay e;
	
	@Before
	public void setUp()throws Exception {
	    d.set(Calendar.DAY_OF_MONTH,20);
	    d.set(Calendar.MONTH,3);
	    d.set(Calendar.YEAR,2009);
	    e = new EveryDay(d);
	}

	@SuppressWarnings("static-access")
	@Test
	public void testNextDate() {
		Calendar h = Calendar.getInstance();
		h.set(Calendar.DAY_OF_MONTH,21);
		h.set(Calendar.MONTH,3);
		h.set(Calendar.YEAR,2009);
		e.nextDate();
		assertEquals(e.getDate().DAY_OF_MONTH,h.DAY_OF_MONTH);
	}
	
	@Test
	public void testShouldAct() throws Exception{
		Calendar t = Calendar.getInstance();
		t.set(Calendar.DAY_OF_MONTH,20);
		t.set(Calendar.MONTH,3);
		t.set(Calendar.YEAR,2009);
		assertTrue(e.shouldAct(t));
		t.set(Calendar.DAY_OF_MONTH,25);
		assertFalse(e.shouldAct(t));
	}

}

package test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import events.PerMonth;

public class TestPerMonth {

	Calendar d = Calendar.getInstance();
	PerMonth e;
	
	@Before
	public void setUp()throws Exception {
	    d.set(Calendar.DAY_OF_MONTH,20);
	    d.set(Calendar.MONTH,3);
	    d.set(Calendar.YEAR,2009);
	    e = new PerMonth(d);
	}

	@SuppressWarnings("static-access")
	@Test
	public void testNextDate() {
		Calendar h = Calendar.getInstance();
		h.set(Calendar.DAY_OF_MONTH,21);
		h.set(Calendar.MONTH,4);
		h.set(Calendar.YEAR,2009);
		e.nextDate();
		assertEquals(e.getDate().DAY_OF_MONTH,h.DAY_OF_MONTH);
		assertEquals(e.getDate().MONTH,h.MONTH);
	}
	
	@Test
	public void testShouldAct(){
		Calendar t = Calendar.getInstance();
		t.set(Calendar.DAY_OF_MONTH,20);
		t.set(Calendar.MONTH,3);
		t.set(Calendar.YEAR,2009);
		assertTrue(e.shouldAct(t));
	}

}

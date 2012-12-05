package filtersTest;

import java.util.Calendar;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import client.*;
import filter.Date;

public class DateTest {

	Date date;
	Header head;
	Email email;
	String res;
	Calendar d;

	@Before
	public void setUp() throws Exception {

		d = Calendar.getInstance();
		d.set(Calendar.YEAR, 2012);
		d.set(Calendar.MONTH, 12);
		d.set(Calendar.DAY_OF_MONTH, 12);

		// Mocks de header
		head = mock(Header.class);
		when(head.getDate()).thenReturn(d);

		email = mock(Email.class);// Mock de Email
		when(email.getHead()).thenReturn(head);

		date = new Date();
		res = date.getField(email);
	}

	@Test
	public void dateTest() {
		System.out.println(res);

		assertEquals("12/12/2012", res);
	}

}

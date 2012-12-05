package test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import client.Client;

import events.EveryDay;
import events.Notifier;
import exceptions.NoLoggedUserException;
import static org.mockito.Mockito.*;

public class TestNotifier {
	Calendar d = Calendar.getInstance();
	Client c;
	Notifier n;
	EveryDay f;
	
	@Before
	public void setUp()throws Exception {
	    d.set(Calendar.DAY_OF_MONTH,20);
	    d.set(Calendar.MONTH,3);
	    d.set(Calendar.YEAR,2009);
	    c = mock(Client.class);
	    f = mock(EveryDay.class);
	    when(f.shouldAct(d)).thenReturn(true);
	    n = new Notifier(d, f, "hi",2);
	}

	@Test
	public void testRun() throws NoLoggedUserException {
		n.run(c);
		verify(c).sendMessage(231231,"Event");
		verify(f).nextDate();
	}

}

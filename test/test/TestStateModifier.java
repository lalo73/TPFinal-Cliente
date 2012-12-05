package test;



import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import client.Client;
import static org.mockito.Mockito.*;
import events.EveryDay;
import events.StateModifier;

public class TestStateModifier {
    StateModifier st;
    EveryDay f;
    Calendar d = Calendar.getInstance();
    Client c;
    
    @Before
    public void setUp() throws Exception {
    	f = mock(EveryDay.class);
    	when(f.shouldAct(d)).thenReturn(true);
    	c = mock(Client.class);
    	st = new StateModifier(d,f,"hi",2);
    }
	@Test
	public void testRun() throws Exception {
		st.run(c);
		verify(c).changeToHolidayState(2333);
		verify(c).changeToHolidayState("On Holidays");
		verify(f).nextDate();
	}
	 
}

package filtersTest;
import java.util.ArrayList;

import filter.*;
import client.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

public class AndTest {

	Different dif;
	Equal eq;
	Email e;
	CompoundAnd cAnd;
	boolean res;
	ArrayList<Rule>reglas=new ArrayList<Rule>();
	@Before
	public void setUp() throws Exception {
		dif=mock(Different.class);
		eq=mock(Equal.class);
		when(dif.satisfy(e)).thenReturn(true);
		when(eq.satisfy(e)).thenReturn(true);
		reglas.add(dif);
		reglas.add(eq);
		cAnd=new CompoundAnd(reglas);
		res=cAnd.satisfy(e);
	}

	@Test
	public void testAndTrue(){
		when(eq.satisfy(e)).thenReturn(true);
		assertTrue(res);
		}
	
	public void testAndFalse(){
		when(eq.satisfy(e)).thenReturn(false);
	    assertFalse(res);
	    }
}
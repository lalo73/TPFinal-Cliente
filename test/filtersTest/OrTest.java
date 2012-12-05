package filtersTest;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import filter.*;
import client.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class OrTest {
	

	Different dif;
	Equal eq;
	Email e;
	CompoundOr cOR;
	boolean res;
	ArrayList<Rule>reglas=new ArrayList<Rule>();
	
	@Before
	public void setUp() throws Exception {
		//Mock de Different
		dif=mock(Different.class);
		
		//Mock de Equal
		eq=mock(Equal.class);
		
		
		reglas.add(dif);
		reglas.add(eq);
		cOR=new CompoundOr(reglas);
	}
	
	@Test
	public void testOrTrue(){
		//Las 2 reglas son true por lo tanto la disyncion sera true.
		when(eq.satisfy(e)).thenReturn(true);
		when(dif.satisfy(e)).thenReturn(true);
		assertTrue(cOR.satisfy(e));
		}

	@Test
	public void testOrFalse(){
		when(eq.satisfy(e)).thenReturn(false);
		when(dif.satisfy(e)).thenReturn(false);
		assertFalse(cOR.satisfy(e));
	}
}

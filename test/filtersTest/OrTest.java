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
		when(dif.satisfy(e)).thenReturn(true);
		//Mock de Equal
		eq=mock(Equal.class);
		when(eq.satisfy(e)).thenReturn(true);
		
		reglas.add(dif);
		reglas.add(eq);
		cOR=new CompoundOr(reglas);
		res=cOR.satisfy(e);
	}
	
	@Test
	public void testAndTrue(){
		//Las 2 reglas son true por lo tanto la disyncion sera true.
		assertTrue(res);
		}

}

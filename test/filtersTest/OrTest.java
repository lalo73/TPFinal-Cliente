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
		dif=mock(Different.class);
		eq=mock(Equal.class);
		when(dif.satisfy(e)).thenReturn(true);
		when(eq.satisfy(e)).thenReturn(true);
		reglas.add(dif);
		reglas.add(eq);
		cOR=new CompoundOr(reglas);
		res=cOR.satisfy(e);
	}
	
	@Test
	public void testAndTrue(){
		assertTrue(res);
		}

}

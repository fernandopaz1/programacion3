package semana4;

import java.util.Set;
import static org.junit.Assert.*;

public class Assert {

	public static void iguales(int[] esperados, Set<Integer> alcanzables) {
		assertEquals(esperados.length,alcanzables.size());		
		for(int element:esperados) {
			assertTrue(alcanzables.contains(element));
		}
	}

}

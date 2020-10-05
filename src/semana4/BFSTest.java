package semana4;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class BFSTest {
	Grafo  grafo;
	
	@Before
	public void setUp() throws Exception {
		grafo=new Grafo(5);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(2, 3);
	
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNull() {
		BFS.esConexo(null);
	}

	@Test
	public void testConexo() {
		Set<Integer> alcanzables = BFS.alcanzables(grafo,0);
		int[] esperados = {0,1,2,3};
		
		Assert.iguales(esperados, alcanzables);
		
	}

}

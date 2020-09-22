package semana2;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class ConsultaDeVecinosTest {

	@Test(expected = IllegalArgumentException.class)
	public void vacinosNegativosTest() {
		Grafo grafo = new Grafo(5);
		grafo.vecinos(2).size();
	}

	@Test(expected = IllegalArgumentException.class)
	public void vacinosExcedidosTest() {
		Grafo grafo = new Grafo(5);
		grafo.vecinos(2).size();
	}

	@Test
	public void todosAisladosTest() {
		Grafo grafo = new Grafo(5);
		assertEquals(0, grafo.vecinos(2).size());
	}

	@Test
	public void verticeUniversalTest() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 0);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		Set<Integer> set = grafo.vecinos(1);
		assertEquals(3, set.size());
		assertTrue(set.contains(0));
		assertTrue(set.contains(2));
		assertTrue(set.contains(3));
	}

	@Test
	public void verticeNormal() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(1, 3);
		grafo.agregarArista(2, 3);
		grafo.agregarArista(2, 4);

		Set<Integer> set = grafo.vecinos(3);
		assertEquals(2, set.size());
		assertTrue(set.contains(1));
		assertTrue(set.contains(2));
	}

}

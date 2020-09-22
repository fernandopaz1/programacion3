package semana2;

import static org.junit.Assert.*;

import org.junit.Test;

public class EdicionDeAristasTest {

	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeNegativoTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(-1, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeExcedidoTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(5, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeNegativoTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(1, -3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeExcedidoTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(1, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void agregarLoopsTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(1, 1);
	}

	@Test
	public void testExisteArista() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3);
		assertTrue(grafo.existeArista(2, 3));
		assertFalse(grafo.existeArista(1, 1));
	}

	@Test
	public void testExisteAristaOpuesta() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3);
		assertTrue(grafo.existeArista(3, 2));
	}

	@Test
	public void testAristaInexistente() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3);
		assertFalse(grafo.existeArista(1, 1));
	}

	@Test
	public void eliminarAristaExistente() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 4);
		grafo.borrarArista(2, 4);
		assertFalse(grafo.existeArista(2, 4));
	}

	@Test
	public void eliminarAristaInexistente() {
		Grafo grafo = new Grafo(5);
		grafo.borrarArista(2, 4);
		assertFalse(grafo.existeArista(2, 4));
	}

	@Test
	public void eliminarAristaDosVeces() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 4);
		grafo.borrarArista(2, 4);
		grafo.borrarArista(2, 4);
		assertFalse(grafo.existeArista(2, 4));
	}

	@Test
	public void agregarAristaDosVeces() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 4);
		grafo.agregarArista(2, 4);
		assertTrue(grafo.existeArista(2, 4));
	}

}

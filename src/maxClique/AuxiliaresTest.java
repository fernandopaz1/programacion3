package maxClique;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import semana8.Grafo;

public class AuxiliaresTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void todosAilsadosTest() {
		Grafo grafo = new  Grafo(5);
		Set<Integer> conjunto = new HashSet<Integer>();
		conjunto.add(2);
		conjunto.add(3);
		conjunto.add(4);
		
		assertFalse(Auxiliares.esClique(grafo, conjunto));
	}

	
	@Test
	public void vacioTest() {
		Grafo grafo = new  Grafo(5);
		Set<Integer> conjunto = new HashSet<Integer>();
		
		assertTrue(Auxiliares.esClique(grafo, conjunto));
	}
	
	@Test
	public void trianguloTest() {
		Grafo grafo = new  Grafo(5);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(3, 1);		
		Set<Integer> conjunto = new HashSet<Integer>();
		conjunto.add(0);
		conjunto.add(1);
		conjunto.add(2);
		
		assertTrue(Auxiliares.esClique(grafo, conjunto));
	}
	
	@Test
	public void noTrianguloTest() {
		Grafo grafo = new  Grafo(5);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(3, 1);		
		Set<Integer> conjunto = new HashSet<Integer>();
		conjunto.add(0);
		conjunto.add(1);
		conjunto.add(3);
		
		assertFalse(Auxiliares.esClique(grafo, conjunto));
	}
	
	@Test
	public void aristaTest() {
		Grafo grafo = new  Grafo(5);
		grafo.agregarArista(0, 1);
		Set<Integer> conjunto = new HashSet<Integer>();
		conjunto.add(0);
		conjunto.add(1);
		
		assertTrue(Auxiliares.esClique(grafo, conjunto));
	}
}

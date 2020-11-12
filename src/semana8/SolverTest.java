 package semana8;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import maxClique.Solver;
import semana4.Assert;
import semana8.Grafo;

public class SolverTest {
 
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void cliqueTest() {
		Solver solver = new Solver(trianguloConAntena());
		Set<Integer> mejor = solver.resolver();
		int[] esperados= {0,1,2};
		
		Assert.iguales(esperados,mejor);
	}
	
	
	@Test
	public void aisladoTest() {
		Grafo aislado = new Grafo(5);
		Solver solver = new Solver(aislado);
		Set<Integer> mejor = solver.resolver();
		
		assertEquals(1,mejor.size());
	}

	@Test
	public void completoTest() {
		Solver solver = new Solver(completo(5));
		Set<Integer> mejor = solver.resolver();
		int[] esperados= {0,1,2,3,4};
		
		Assert.iguales(esperados,mejor);
	}

	
	
	private Grafo completo(int n) {
		Grafo g = new Grafo(n);
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i!=j) {
					g.agregarArista(i, j);
				}
			}
		}
		
		return g;
	}
	
	private Grafo trianguloConAntena() {
		Grafo  grafo= new Grafo(4);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(3, 1);
		return grafo;
	}
}

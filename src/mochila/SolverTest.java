package mochila;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SolverTest {

	@Before
	public void setUp() throws Exception {
	}

	private Instancia ejemplo() {
		Instancia ret = new Instancia(10);
		ret.agregar(new Objeto("Mapa", 2,8));
		ret.agregar(new Objeto("Calentador", 3,9));
		ret.agregar(new Objeto("Carpa", 4,10));
		ret.agregar(new Objeto("Botas", 3,6));
		ret.agregar(new Objeto("Hacha", 4,8));
		ret.agregar(new Objeto("Lenia", 5,7));
		
		return ret;
	}
	
	@Test
	public void resolverTest() {
		
		Solver solver = new Solver(ejemplo());
		Solucion solucion = solver.resolver();
		assertEquals(3, solucion.getCardinal());
		assertEquals(9, solucion.getPeso());
		assertEquals(27, solucion.getBeneficio());
	}

}

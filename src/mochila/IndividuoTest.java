package mochila;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IndividuoTest {

	
	//En este caso como individuo depende de un random en prod
	// lo que hay que hacer es desacoplar ese random del codigo
	// lo testeamos inyectandole codigo que haga que
	//el comporamiento sea predecible
	private Instancia _instancia;

	@Before
	public void setUp() throws Exception {
		_instancia = new Instancia(10);
		_instancia.agregar(new Objeto("Mapa", 2, 8));
		_instancia.agregar(new Objeto("Calentador", 3, 9));
		_instancia.agregar(new Objeto("Carpa", 4, 10));
		_instancia.agregar(new Objeto("Botas", 3, 6));
		_instancia.agregar(new Objeto("Hacha", 4, 8));
		_instancia.agregar(new Objeto("Lenia", 5, 7));

	}

	@Test
	public void pesoVacioTest() {
		Individuo individuo = crearIndividuo("000000");
		assertEquals(0, individuo.peso(), 1e-3);

	}
	
	@Test
	public void pesoCompletoTest() {
		Individuo individuo = crearIndividuo("111111");
		assertEquals(21, individuo.peso(), 1e-3);

	}
	
	@Test
	public void pesoAlgunosTest() {
		Individuo individuo = crearIndividuo("100001");
		assertEquals(7, individuo.peso(), 1e-3);

	}
	
	@Test
	public void beneficioAlgunosTest() {
		Individuo individuo = crearIndividuo("011010");
		assertEquals(27, individuo.beneficio(), 1e-3);

	}
	
	@Test
	public void beneficioTotalTest() {
		Individuo individuo = crearIndividuo("111111");
		assertEquals(48, individuo.beneficio(), 1e-3);

	}
	
	
	@Test
	public void mutarTest() {
		Individuo individuo = crearIndividuo("110001");
		mutar(individuo, 2);
		assertEquals(14, individuo.peso(), 1e-3);

	}
	
	
	private void mutar(Individuo individuo, int posicion) {
		GeneradorPrefijado generador = new GeneradorPrefijado(posicion);
		Individuo.setGenerador(generador);
		
		individuo.mutar();
	}

	private Individuo crearIndividuo(String str) {
		boolean[] bits = toBooleanArray(str);
		GeneradorPrefijado generador = new GeneradorPrefijado(bits);
		Individuo.setGenerador(generador);
		
		return  Individuo.aleatorio(_instancia);
	}

	private boolean[] toBooleanArray(String str) {
		boolean[] bits = new boolean[str.length()];
		for(int i=0 ; i<str.length();++i) {
			bits[i]= str.charAt(i) == '1';
		}
		return bits;
	}

}

package maxClique;

import java.util.HashSet;
import java.util.Set;

import semana8.Grafo;

//El solver es una clase que uso para resolver un problema

//Sirve cuando quiero tener estadisticas del problema
//Puedo crear variables de instancias que tengan informacion
//sobre la solucion
//Solver es el objeto responsable de ejecutar el codigo

public class Solver {
	// Solver es un solucionador para un problema

	// El grafo donde busco la cliqueMax
	private Grafo _grafo;

	// auxiliar donde guardo la clique actual
	private Set<Integer> _actual;

	// Aca guardo la clique mayor que encuentro
	private Set<Integer> _mayor;

	public Solver(Grafo grafo) {
		_grafo = grafo;
	}

	public Set<Integer> resolver() {

		_mayor = new HashSet<Integer>();

		_actual = new HashSet<Integer>();
		// En este metodo esta la fuerza bruta

		// Para generar subconjuntos de un conjunto
		// represento al conjunto como una tira de ceros y unos
		// un subconjunto es una eleccion dada de 0 y 1
		// hay que tener todas las combinaciones de 0 y 1 posible
		// Son 2^n

		generarDesde(0);

		return _mayor;
	}

	private void generarDesde(int vertice) {  //O(n^2*2^n)
		
		
		// caso base {O(n^2)}
		if (vertice == _grafo.vertices()) {
			// En el caso base revisamos si es una clique
			// Cuando estoy en el caso base es porque
			// ya considero que es un subconjunto

			if (_actual.size() > _mayor.size()) {
				_mayor = clonar(_actual);
			}
			
			
		}else if(Auxiliares.esClique(_grafo, _actual)) {
		
			//caso base2 actuak no es una clique
			//entonces cortamos la recursion y
			//hacemos backtracking
			
			// Agrego el vertice 0
			_actual.add(vertice);
			// genero desde el 1 teniendo el 0 _actual
			generarDesde(vertice + 1);

			// Elimino el 0
			_actual.remove(vertice);
			// Genero desde 1 con nada en _actual
			generarDesde(vertice + 1);

			// este metodo me permite mediante recursion generar todos
			// las posibles combinaciones de vertice
		}
	}

	private Set<Integer> clonar(Set<Integer> original) {
		Set<Integer> nuevo = new HashSet<Integer>();
		for (Integer i : original) {
			nuevo.add(i);
		}
		return nuevo;
	}

}

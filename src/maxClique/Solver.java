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

	// auxiliar para la recursion
	private Set<Integer> _actual;

	public Solver(Grafo grafo) {
		_grafo = grafo;
	}

	public Set<Integer> resolver() {

		_actual = new HashSet<Integer>();
		// En este metodo esta la fuerza bruta

		// Para generar subconjuntos de un conjunto
		// represento al conjunto como una tira de ceros y unos
		// un subconjunto es una eleccion dada de 0 y 1
		// hay que tener todas las combinaciones de 0 y 1 posible
		// Son 2^n

		generarDesde(0);

		return null;
	}

	private void generarDesde(int vertice) {
		// caso base
		if (vertice == _grafo.vertices()) {

		} else {

			// Agrego el vertice 0
			_actual.add(vertice);
			// genero desde el 1 teniendo el 0 _actual
			generarDesde(vertice + 1);

			// Elimino el 0
			_actual.remove(vertice);
			// Genero desde 1 con nada en _actual
			generarDesde(vertice + 1);
			
			//este metodo me permite mediante recursion generar todos
			//las posibles combinaciones de vertice
		}
	}
}

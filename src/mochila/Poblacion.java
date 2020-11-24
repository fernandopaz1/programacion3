package mochila;

import java.util.ArrayList;
import java.util.Collections;

public class Poblacion {

	// Los individuos de la poblacion
	private ArrayList<Individuo> _individuos;

	// Instancia asociada
	private Instancia _instancia;

	// parametros de la poblacion
	private int _tamanio = 100;

	// cuantos se mutan en cada iteracion
	private int _mutadosPorIteracion = 10;

	// cuantos se mutan en cada iteracion
	private int _recombinadosPorIteracion = 20;

	// es la cantidad de eliminados en cada iteracion
	private int _eliminadoPorIteracion = 60;

	// Generador de numeros aleatorios
	private Generador _random;

	// Me dice por que iteracion voy
	private int _iteracion = 0;
	
	// Me dice por que iteracion voy
		private int _maxIteraciones = 1000;

	public Poblacion(Instancia instancia, Generador generador) {
		_instancia = instancia;
		Individuo.setGenerador(new GeneradorRandom());
		_random = generador;
	}

	public Individuo simular() {
		generarIndividuos();
		_iteracion = 0;
		while (!satisfactoria()) {
			mutarAlgunos();
			recombinarAlgunos();
			eliminarPeores();
			agregarNuevos();
			estadisticas();
			_iteracion++;
		}
		return mejorIndividuo();
	}

	private void estadisticas() {
		System.out.print("It: " + _iteracion);
		System.out.print(" - Mejor: " + mejorIndividuo().fitness());
		System.out.print(" - Prom: " + fitnessPromedio());
		System.out.print(" - Peor: " + peorIndividuo().fitness());
		System.out.println();
	}

	private void generarIndividuos() {
		_individuos = new ArrayList<Individuo>(_tamanio);
		for (int i = 0; i < _tamanio; ++i) {
			_individuos.add(Individuo.aleatorio(_instancia));
		}
	}

	private boolean satisfactoria() {
		return _iteracion>_maxIteraciones;
	}

	private void mutarAlgunos() {
		for (int i = 0; i < _mutadosPorIteracion; ++i) {
			Individuo individuo = individuoAleatorio();
			individuo.mutar();
		}
	}

	private void recombinarAlgunos() {
		for (int i = 0; i < _recombinadosPorIteracion; ++i) {
			Individuo padre1 = individuoAleatorio();
			Individuo padre2 = individuoAleatorio();
			for (Individuo hijo : padre1.recombinar(padre2)) {
				_individuos.add(hijo);
			}
		}
	}

	private Individuo individuoAleatorio() {
		int k = _random.nextInt(_individuos.size());
		Individuo padre2 = _individuos.get(k);
		return padre2;
	}

	private void eliminarPeores() {
		Collections.sort(_individuos); // ordena de menor a mayor
		Collections.reverse(_individuos); // Invierto porque es mas facil eliminar los ultimos
		for (int i = 0; i < _eliminadoPorIteracion; ++i) {
			_individuos.remove(_individuos.size() - 1);
		}
	}

	private void agregarNuevos() {
		// Si mi poblacion decrece agrego aleatorios
		while (_individuos.size() < 100) {
			_individuos.add(Individuo.aleatorio(_instancia));
		}
	}

	public Individuo mejorIndividuo() {
		return Collections.max(_individuos);
	}

	private Individuo peorIndividuo() {
		return Collections.min(_individuos);
	}

	private double fitnessPromedio() {
		double suma = 0;
		for (Individuo individuo : _individuos) {
			suma += individuo.fitness();
		}
		return suma / _individuos.size();
	}
}

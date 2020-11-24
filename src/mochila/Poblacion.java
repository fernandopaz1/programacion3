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
	private int _eliminadoPorIteracion=60;
	
	// Generador de numeros aleatorios
	private Generador _random;

	public Poblacion(Instancia instancia, Generador generador) {
		_instancia = instancia;
		Individuo.setGenerador(new GeneradorRandom());
		_random = generador;
	}

	public Individuo simular() {
		generarIndividuos();

		while (!satisfactoria()) {
			mutarAlgunos();
			recombinarAlgunos();
			eliminarPeores();
			agregarNuevos();
		}
		return mejorIndividuo();
	}

	private void generarIndividuos() {
		_individuos = new ArrayList<Individuo>(_tamanio);
		for (int i = 0; i < _tamanio; ++i) {
			_individuos.add(Individuo.aleatorio(_instancia));
		}
	}

	private boolean satisfactoria() {
		// TODO Auto-generated method stub
		return false;
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
		Collections.sort(_individuos); //ordena de menor a mayor
		Collections.reverse(_individuos); //Invierto porque es mas facil eliminar los ultimos
		for(int i=0 ;i<_eliminadoPorIteracion; ++i) {
			_individuos.remove(_individuos.size()-1);
		}
	}

	private void agregarNuevos() {
		//Si mi poblacion decrece agrego aleatorios
		while(_individuos.size()<100) {
			_individuos.add(Individuo.aleatorio(_instancia));
		}
	}

	public Individuo mejorIndividuo() {		
		return Collections.max(_individuos);
	}
}

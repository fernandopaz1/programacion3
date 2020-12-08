package mochila;

import java.util.ArrayList;
import java.util.Collections;

public class Poblacion {

	// Los individuos de la poblacion
	private ArrayList<Individuo> _individuos;

	
	//con pocos individuos la convergencia es lenta y hasta puede estancarse
	
	//Con muchos individuos la convergencia es mas rapida pero tarda mas en cada iteracion
	
	//Sin mutados le cuesta llegar a la convergencia
	//La mutacion ayuda a la evolucion ya que a veces permite escapar
	//del estancamiento
	
	//Si hay much mutacion el proceso es muy aleatorio
	
	
	//sin recombinacion no pude avanzar mucho
	//la solucion solo se crearia por mutaciones y los nuevos ingresados
	//aleatoriamente, no hay forma de premiar los individuos exitosos
	
	//Si hago que muchos se recobinen tambien va a tardar 
	
	
	//si no agregamos indiciduos aleatorios tenemos el riesgo de estancarnos
	//muy rapido.
	//Puede que la poblacion se corte en una poblacion de clones
	//sean todos iguales y no haya forma de salir de ahi
	//La unica chance es que salga por mutacion
	
	// Instancia asociada
	private Instancia _instancia;

	// parametros de la poblacion
	private int _tamanio = 1000;

	// cuantos se mutan en cada iteracion
	private int _mutadosPorIteracion = 200;

	// cuantos se mutan en cada iteracion
	private int _recombinadosPorIteracion = 200;

	// es la cantidad de eliminados en cada iteracion
	private int _eliminadoPorIteracion = 600;

	// Generador de numeros aleatorios
	private Generador _random;

	// Me dice por que iteracion voy
	private int _iteracion = 0;
	
	// Me dice por que iteracion voy
		private int _maxIteraciones = 1000;
		
	//implemento observador
	private ArrayList<Observador> _observadores;

	public Poblacion(Instancia instancia, Generador generador) {
		_instancia = instancia;
		Individuo.setGenerador(new GeneradorRandom());
		_random = generador;
		_observadores = new ArrayList<Observador>();
	}
	
	//REgristra observador
	public void Registrar(Observador observador) {
		_observadores.add(observador);
	}
	

	public Individuo simular() {
		generarIndividuos();
		_iteracion = 0;
		while (!satisfactoria()) {
			mutarAlgunos();
			recombinarAlgunos();
			eliminarPeores();
			agregarNuevos();
			notificarObservadores();
			_iteracion++;
		}
		return mejorIndividuo();
	}

	private void notificarObservadores() {
		for(Observador observador : _observadores) {
			observador.notificar();
		}
		
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
		while (_individuos.size() < _tamanio) {
			_individuos.add(Individuo.aleatorio(_instancia));
		}
	}

	public Individuo mejorIndividuo() {
		return Collections.max(_individuos);
	}

	public Individuo peorIndividuo() {
		return Collections.min(_individuos);
	}

	public double fitnessPromedio() {
		double suma = 0;
		for (Individuo individuo : _individuos) {
			suma += individuo.fitness();
		}
		return suma / _individuos.size();
	}

	public int getIteracion() {
		return _iteracion;
	}
}

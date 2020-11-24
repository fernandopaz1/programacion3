package mochila;


public class Individuo implements Comparable<Individuo> {

	// Es el idividuo determinado por una
	// secuencia de bits (cromosomas)

	private boolean[] _bits;

	//No puedo tener random dentro del individuo ya
	//que el comportamiento es erratico a la hora de testear
	//lo que podemos hacer es que el random sea inyectable
	//y en los test le inyecto algo que no sea random
	//de esta forma desacoplo la parte aleatoria del codigo
	
	
	private static Generador _random;

	private Instancia _instancia;
	
	public static void setGenerador(Generador generador) {
		_random = generador;
	}

	//factory method para construir un individuo aleatorio
	//Como los factory methods tienen nombres puedo tener 
	//la cantidad que quiera
	public static Individuo aleatorio(Instancia instancia) {
		Individuo ret = new Individuo(instancia);
		for (int i = 0; i < instancia.getTamanio(); ++i) {
			ret.set(i, _random.nextBoolean());
		}
		return ret;
	}
	
	private Individuo(Instancia instancia) {
		_bits = new boolean[instancia.getTamanio()];
		_instancia = instancia;
	}


	public void mutar() {
		int i = _random.nextInt(_bits.length);
		_bits[i] = !_bits[i];
	}

	public Individuo[] recombinar(Individuo otro) {
		int k = _random.nextInt(_bits.length);
		//Usando el factory function estos individuos
		//se generan vacios
		Individuo hijo1 = new Individuo(_instancia);
		Individuo hijo2 = new Individuo(_instancia);

		for (int i = 0; i < k; ++i) {
			hijo1.set(i, this.get(i));
			hijo2.set(i, otro.get(i));
		}

		for (int i = k; i < _bits.length; ++i) {
			hijo1.set(i, otro.get(i));
			hijo2.set(i, this.get(i));
		}

		return new Individuo[] { hijo1, hijo2 };

	}

	// Funcion de fittness
	public double fitness() {
		if(peso()>_instancia.getCapacidad()) 
			//Esto devuelve un fitness negativo
			//Por lo que si me paso del peso es penalizado
			//pero no inmediatamente descartado
			return _instancia.getCapacidad()-peso();
		else
			return beneficio();
	}

	public int peso() {
		int ret = 0;
		for (int i = 0; i < _bits.length; ++i) {
			if (get(i) == true) {
				ret += _instancia.getObjeto(i).getPeso();
			}
		}
		return ret;
	}

	public double beneficio() {
		double ret = 0;
		for (int i = 0; i < _bits.length; ++i) {
			if (get(i) == true) {
				ret += _instancia.getObjeto(i).getBeneficio();
			}
		}
		return ret;
	}

	// Puedo usar getters y setters privados
	//esto esta bueno ya que son getters y setter solo
	//para uso dentro de esta clase
	//el codigo de esta clase se ve mejor
	//y no rompo encapsulamiento

	private boolean get(int i) {
		return _bits[i];
	}

	private void set(int i, boolean valor) {
		_bits[i] = valor;
	}

	@Override
	public int compareTo(Individuo otro) {
		if(this.fitness() < otro.fitness())
			return -1;
		else if(this.fitness()==otro.fitness())
			return 0;
		else 
			return 1;
	}

	

}

package mochila;

public class Objeto implements Comparable<Objeto> {
	
	private String _nombre;
	private int _peso;
	private int _beneficio;
	
	
	public Objeto(String nombre, int peso,int beneficio) {
		_nombre=nombre;
		_peso= peso;
		_beneficio = beneficio;
	}


	public String getNombre() {
		return _nombre;
	}


	public int getPeso() {
		return _peso;
	}


	public int getBeneficio() {
		return _beneficio;
	}


	@Override
	public int compareTo(Objeto otro) {
		//devuelve negativo si es menor que el otro
		//positivo si es mayor
		//0 si son iguales
		return this.getBeneficio()-otro.getBeneficio();
	}
	
	
}

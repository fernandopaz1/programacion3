package mochila;

import java.util.ArrayList;

public class Instancia {

	private int _capacidad;
	private ArrayList<Objeto> _objetos;

	
	public Instancia(int capacidad) {
		_capacidad = capacidad;
		_objetos = new ArrayList<Objeto>();
	}
	
	public void agregar(Objeto objeto) {
		_objetos.add(objeto);
	}
	
	public int getCapacidad() {
		return _capacidad;
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<Objeto> getObjeto(){
		return (ArrayList<Objeto>) _objetos.clone();
	}
	
	
}

package mochila;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SolverGoloso {
	
	private Instancia _instancia;
	private Comparator<Objeto> _comparador;
	
	public SolverGoloso(Instancia instancia, Comparator<Objeto> comparador) {
		_instancia = instancia;
		_comparador = comparador;
	}
	
	public Solucion resolver() {
		Solucion ret = new Solucion();
		
		//objetosOrdenados() me debe devolver los objetos 
		//ordenados de mayor beneficio a menor beneficio
		//voy considerando de mayor beneficio a menor beneficio
		//Los agrego si entra en la mochila
		for(Objeto o : objetosOrdenados()) {
			if(ret.getPeso()+ o.getPeso() <= _instancia.getCapacidad()) {
				ret.agregarObjeto(o);
			}
		}
		
		return ret;
		
	}

	private ArrayList<Objeto> objetosOrdenados() {
		ArrayList<Objeto> ret = _instancia.getObjeto();
		
		//Para poder usar esto objeto debe ser comparable
		
		//esto es injeccion de codigo
		//la Interfaz comparator nos dice como se comporta la funcion 
		//de comparacion sobreescribiendo su metodo puedo decirle a Collection.sort
		//como se ordenan los objetos de cierta clase sin que implementen compareTo
		//De esta forma estoy inyectando el codigo que escribi en la clase
		//ComparadorPorBeneficio en la funcion sort
		Collections.sort(ret, _comparador);
		return ret;
	}


}

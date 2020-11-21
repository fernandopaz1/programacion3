package mochila;

import java.util.ArrayList;
import java.util.Collections;

public class Solver {
	
	private Instancia _instancia;
	
	public Solver(Instancia instancia) {
		_instancia = instancia;
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
		Collections.sort(ret);
		//esta ordenado de menor a mayor
		//aplico reverse para que sea de mayor beneficio a menor
		Collections.reverse(ret);
		return ret;
	}


}

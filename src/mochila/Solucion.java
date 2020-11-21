package mochila;

import java.util.ArrayList;

public class Solucion {

	private ArrayList<Objeto> _objetos;

	public Solucion() {
		_objetos = new ArrayList<Objeto>();
	}

	public void agregarObjeto(Objeto objeto) {
		_objetos.add(objeto);
	}

	public int getCardinal() {
		return _objetos.size();
	}

	public int getPeso() {
		int ret=0;
				for(Objeto o : _objetos) {
					ret+= o.getPeso();					
				}
		return ret;
	}
	
	public int getBeneficio() {
		int ret=0;
				for(Objeto o : _objetos) {
					ret+= o.getBeneficio();					
				}
		return ret;
	}

}

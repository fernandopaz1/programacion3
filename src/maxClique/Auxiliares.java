package maxClique;

import java.util.Set;

import semana8.Grafo;

public class Auxiliares {
	//Si no indico public o private
		//es accesible solo dentro del paquete
		//de esta forma se puede testear sin romper el encapsulamiento
		static boolean esClique(Grafo grafo, Set<Integer> conjunto) {
			for(Integer v1 : conjunto) {
				for(Integer v2 : conjunto) { 
					if(!grafo.existeArista(v1, v2)  && v1!=v2) {
						return false;
					}
				}
			}
			return true;
		}

}

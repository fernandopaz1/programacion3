package semana4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BFS {

	private static ArrayList<Integer> lista;
	private static boolean[] marcados;
	

	
	public static boolean esConexo(Grafo g) {
		if(g==null)
			throw new IllegalArgumentException("Se intento consultar un grafo null");
		return false;
	}


	public static Set<Integer> alcanzables(Grafo grafo, int origen) {
		Set<Integer> ret = new HashSet<Integer>();
		inicializar(grafo,origen);
		
		while (lista.size()>0) {
			int i = lista.get(0);
			marcados[i]=true;
			agregarVecinosPendientes(grafo, i);
			ret.add(i);
			lista.remove(0);
		}
		return ret;
	}


	private static void agregarVecinosPendientes(Grafo grafo, int i) {
		for (int vertice : grafo.vecinos(i)) {
			if(!marcados[vertice] && !lista.contains(vertice)) {
				lista.add(vertice);
			}
		}
	
	}


	private static void inicializar(Grafo grafo, int origen) {
		lista= new ArrayList<Integer>();
		lista.add(origen);
		marcados = new boolean[grafo.vertices()];
		
	}

}

package semana4;

import java.util.Set;

public class Grafo {

	private boolean[][] A; // matriz de adyacencia
 
	// El grafo se construye a partir de la cantidad de vertices
	public Grafo(int vertices) {
		A = new boolean[vertices][vertices];
		// El grafo se crea sin aristas
	}

	// Agregando aristas

	public void agregarArista(int i, int j) {
		// codigo defensivo, reaccionamos frente a inputs
		// no deseados
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		A[i][j] = true;
		A[j][i] = true;
	}
	
	public void borrarArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		A[i][j] = false;
		A[j][i] = false;
	}

	private void verificarDistintos(int i, int j) {
		if(i==j)
			throw new IllegalArgumentException("No se permiten loops: (" +"i="+i +", j="+j);
	}

	private void verificarVertice(int i) {
		if (i < 0)
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
		if (i >= A.length)
			throw new IllegalArgumentException("El vertice no existe: " + i);
	}

	public boolean existeArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		return A[i][j];
	}
	
	public Set<Integer> vecinos(int i){
		throw new RuntimeException("Aun no implementado");
		
	}

	public int vertices() {
		return A.length;
	}

}

package semana2;

public class Grafo {

	private boolean[][] A; // matriz de adyacencia

	// El grafo se construye a partir de la cantidad de vertices
	public Grafo(int vertices) {
		A = new boolean[vertices][vertices];
		// El grafo se crea sin aristas
	}

	// Agregando aristas

	public void agregarArista(int i, int j) {
		A[i][j] = true;
		A[j][i] = true;
	}

	public boolean existeArista(int i,int j) {
		return A[i][j];
	}
	  
}

package semana2;

public class Grafo {

	private boolean[][] _A; // matriz de adyacencia

	// El grafo se construye a partir de la cantidad de vertices
	public Grafo(int vertices) {
		_A = new boolean[vertices][vertices];
		// El grafo se crea sin aristas
	}

	// Agregando aristas

	public void agregarArista(int i, int j) {
		_A[i][j] = true;
		_A[j][i] = true;
	}

	public boolean existeArista(int i,int j) {
		return _A[i][j];
	}
}

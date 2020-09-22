package semana2;

public class Grafo {
	
	private boolean[][] _A; //matriz de adyacencia

	//El  grafo se construye a partir de la cantidad de vertices
	public Grafo(int vertices) {
		_A = new boolean[vertices][vertices];
		//El grafo se crea sin aristas
	}

}

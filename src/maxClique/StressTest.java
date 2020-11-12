package maxClique;

import java.util.Random;

import semana8.Grafo;

public class StressTest {
	
	//Esta es una case donde sobrecargamos el alogritmo
	//y vemos como se comporta en esa condicion
	
	
	public static void main(String[] args) {
		
		for(int n= 2; n<1000; ++n) {
			long inicio = System.currentTimeMillis();
			
			Solver solver = new Solver(aleatorio(n));
			
			solver.resolver();
			long fin= System.currentTimeMillis();
			
			double tiempo = (fin-inicio)/1000.0;
			
			System.out.println("n = "+n+": "+ tiempo+" seg.");
		}

	}

	
	private static Grafo aleatorio(int n) {
		Grafo g = new Grafo(n);
		Random random = new Random(0);
		
		for (int i=0; i<n; ++i) {
			for (int j=i+1; i<n; ++i) {
				if(random.nextDouble()< 0.3) {
					g.agregarArista(i, j);
				}
				
			}
		}
		
		return g;
	}
}

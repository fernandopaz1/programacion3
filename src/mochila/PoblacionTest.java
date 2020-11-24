package mochila;

import java.util.Random;

public class PoblacionTest {

	public static void main(String[] args) {
		
		Instancia instancia = instanciaAleatoria(400);
		Generador generador = new GeneradorRandom();
		Poblacion poblacion = new Poblacion(instancia, generador);
		poblacion.simular();
	}

	private static Instancia instanciaAleatoria(int n) {
		Random random = new Random(0);
		Instancia instancia = new Instancia(n);
		
		for (int i=0; i<n; ++i) {
			int peso = random.nextInt(10)+1;
			int beneficio = random.nextInt(10)+1;
			
			instancia.agregar(new Objeto("", peso, beneficio));
		}
		
		return instancia;
	}
	
}

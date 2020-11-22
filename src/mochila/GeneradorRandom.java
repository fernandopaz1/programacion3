package mochila;

import java.util.Random;

public class GeneradorRandom implements Generador {

	//este generador en realidad es un strategy
	//Puedo tener otro tipo de generador random
	private Random _random;
	
	public GeneradorRandom() {
		_random = new Random();
	}
	
	@Override
	public boolean nextBoolean() {
		return _random.nextBoolean();
	}

	@Override
	public int nextInt(int rango) {
		return _random.nextInt(rango);
	}
	
}

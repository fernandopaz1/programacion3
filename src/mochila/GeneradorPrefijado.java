package mochila;

public class GeneradorPrefijado implements Generador {

	private boolean[] _bits;
	private int _indice;
	private int _entero;
	// Esta strategy de generador me permite prefijar
	// los valor que van cambiar en los individuos
	// y de esa forma testearlos

	public GeneradorPrefijado(boolean[] bits) {
		_bits = bits;
		_indice = 0;
		_entero = 0 ;
	}
	
	public GeneradorPrefijado(int entero) {
		_entero = entero;
	}
	

	@Override
	public boolean nextBoolean() {
		// devuelvo el boolean prefijado para el indice actual
		// y me muevo un indice
		return _bits[_indice++];
	}

	@Override
	public int nextInt(int rango) {
		return _entero;
	}

}
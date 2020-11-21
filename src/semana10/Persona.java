package semana10;

public class Persona {

	private String _nombre;
	private int _edad;
	private boolean _casado;
	
	public Persona(String _nombre, int _edad, boolean _casado) {
		super();
		this._nombre = _nombre;
		this._edad = _edad;
		this._casado = _casado;
	}

	public String nombre() {
		return _nombre;
	}

	public int edad() {
		return _edad;
	}

	public boolean esCasado() {
		return _casado;
	}
	
	
}

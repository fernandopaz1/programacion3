package semana10;

public class MenorDe21Condicion implements Condicion {

	@Override
	public boolean cumple(Persona p) {
		return p.edad()<21;
	}
}

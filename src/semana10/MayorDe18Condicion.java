package semana10;

public class MayorDe18Condicion implements Condicion{
	
	//esto es una implementacion de 
	//la interfaz condicion
	
	@Override
	public boolean cumple(Persona p) {
		return p.edad()>18;
	}

}

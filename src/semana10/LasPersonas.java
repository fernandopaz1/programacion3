package semana10;

import java.util.ArrayList;

public class LasPersonas {
	private ArrayList<Persona> lasPersonas;
	
	public LasPersonas() {
		lasPersonas = new ArrayList<Persona>();
	}
	
	public void agregar(Persona p) {
		lasPersonas.add(p);
	}
	
	public int cantidad() {
		return lasPersonas.size();
	}
	
	public LasPersonas buscar(Condicion condicion) {
		LasPersonas ret = new LasPersonas();
		for (Persona p: lasPersonas) {
			if(condicion.cumple(p)) {
				ret.agregar(p);
			}
		}
		return ret;
	}
	
	
	@Override
	public String toString() {
		String ret="";
		
		for (Persona p : lasPersonas) {
			ret += p.nombre()+ " edad"+p.edad()+ " "+p.esCasado()+"\n";
		}
		return ret;
	}
	
}

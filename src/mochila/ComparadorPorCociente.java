package mochila;

import java.util.Comparator;

public class ComparadorPorCociente implements Comparator<Objeto>{

	@Override
	public int compare(Objeto uno, Objeto otro) {
		double cociente1= uno.getBeneficio()/(double)uno.getPeso();
		double cociente2= otro.getBeneficio()/(double)otro.getPeso();
		if(cociente1<cociente2)
			return 1;
		else if(cociente1==cociente2)
			return 0;
		else
			return -1;
	}

}

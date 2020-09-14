package semana1;

import java.math.BigInteger;

public class EjemploBigInteger {

	public static void main(String[] args) {
		System.out.println("Este es el mayor valor de un Integer: " + Integer.MAX_VALUE + 1);
		System.out.println("Este es el mayor valor de un Long: " + Long.MAX_VALUE + 1);

		BigInteger miNumero = new BigInteger("12312312361982471057106521834613640174");

		System.out.println("Este es un numero con BigInteger: " + miNumero);
	}

}

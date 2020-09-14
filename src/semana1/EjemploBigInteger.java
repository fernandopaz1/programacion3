package semana1;

import java.math.BigInteger;
import java.util.Random;

public class EjemploBigInteger {

	public static void main(String[] args) {
		System.out.println("Este es el mayor valor de un Integer: " + Integer.MAX_VALUE + 1);
		System.out.println("Este es el mayor valor de un Long: " + Long.MAX_VALUE + 1);

		BigInteger miNumero = new BigInteger("12312312361982471057106521834613640174");
		BigInteger otroNumero = new BigInteger("124135246786101630323023702362398236");

		System.out.println("Este es un numero con BigInteger: " + miNumero);

		// Para sumar uno hay que usar
		miNumero = miNumero.add(BigInteger.ONE);
		System.out.println("Este es el mismo numero mas uno: " + miNumero);

		// Para restar hay que usar
		miNumero = miNumero.subtract(BigInteger.ONE);
		System.out.println("Este es el mismo numero mas uno: " + miNumero);

		// Para multiplicar
		System.out.println("Multiplicacion: " + miNumero.multiply(otroNumero));

		System.out.println("La cantidad de bits de miNumero es: "+miNumero.bitLength());

		System.out.println("La cantidad de bits de prendidos de miNumero es: "+miNumero.bitCount());
		
		
		// Para crear un BigInteger aleatorio
		Random random = new Random();
		
		//generamos un BigInteger aleatorio de 100 bits
		BigInteger aleatorio = new BigInteger(100, random);  
		System.out.println("El BigInteger aleatorio es: " + aleatorio);

		
		BigInteger big1024 = new BigInteger("1024");
		System.out.println("Divido big1024: " + big1024.divide(new BigInteger("2")));
		System.out.println("shiftRigth de big1024: " + big1024.shiftRight(1));
		System.out.println("shiftLeft de big1024: " + big1024.shiftLeft(1));

	}

}

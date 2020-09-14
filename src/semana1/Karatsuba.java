package semana1;

import java.math.BigInteger;
import java.util.Random;

public class Karatsuba {

	public static void main(String[] args) {

		Random random = new Random(0);

		BigInteger x = new BigInteger(400, random);
		BigInteger y = new BigInteger(400, random);

		BigInteger resultadoKaratsuba = karatsuba(x, y);
		BigInteger resultadoMultiply = x.multiply(y);

		System.out.println("El resultado de usar karatsuba es: " + resultadoKaratsuba);
		System.out.println("El resultado de usar multiply es: " + resultadoMultiply);
		System.out.println("Los resultados son iguales es:  "+ resultadoKaratsuba.equals(resultadoMultiply));
	}

}

package semana1;

import java.math.BigInteger;
import java.util.Random;

public class Karatsuba {

	private static BigInteger karatsuba(BigInteger x, BigInteger y) {

		int m = Math.max(x.bitLength(), y.bitLength()) / 2; // promedio de longitud

		if (m <= 100) {
			// si es suficientemente pequeño utilizo multiply
			return x.multiply(y);
		}

		BigInteger x1 = x.shiftRight(m);
		BigInteger y1 = y.shiftRight(m);

		BigInteger x2 = x.subtract(x1.shiftLeft(m));
		BigInteger y2 = y.subtract(y1.shiftLeft(m));
		
		BigInteger A = karatsuba(x1,y1);
		BigInteger B = karatsuba(x2,y2);
		BigInteger C =  karatsuba(x1.add(x2),y1.add(y2));
		BigInteger K = C.subtract(A.add(B));

		return A.shiftLeft(2*m).add(B.add(K.shiftLeft(m)));
	}

	public static void main(String[] args) {

		Random random = new Random(0);

		BigInteger x = new BigInteger(200, random);
		BigInteger y = new BigInteger(200, random);

		BigInteger resultadoKaratsuba = karatsuba(x, y);
		BigInteger resultadoMultiply = x.multiply(y);

		System.out.println("El resultado de usar karatsuba es: " + resultadoKaratsuba);
		System.out.println("El resultado de usar multiply es: " + resultadoMultiply);
		System.out.println("Los resultados son iguales es:  " + resultadoKaratsuba.equals(resultadoMultiply));
	}

}

package semana11ExpresionesLambda;

import java.util.function.Consumer;

public class Consumidor {
	
	public static void main(String[] args) {
		
		//Esta seria la forma clasica de implementar un consumer
		//con una clase anonima
		Consumer<Integer> elDoble = new Consumer<Integer>() {
			@Override
			public void accept(Integer x) {
				System.out.println(2*x);
				
			}
		};
		
		System.out.println("Probando el doble");
		//aca uso la implenentacion del consumer anterior
		System.out.println("Implementacion del consumidor elDoble");
		elDoble.accept(4);
		elDoble.accept(9);
		
		//Implementacion de consumer via expresiones lambda;
		//si la implementacion de accept es de una sola linea
		//se puede evitar poner las llaves {}
		System.out.println("Implementacion del consumidor elTriple");
		Consumer<Integer> elTriple = x -> System.out.println(3*x);
		elTriple.accept(7);
	}

}

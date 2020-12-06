package semana11ExpresionesLambda;

import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<Persona> personas = new ArrayList<Persona>();
		
		personas.add(new Persona("Patricia", 43,70));
		personas.add(new Persona("Alberto", 27,80));
		personas.add(new Persona("Jose", 31,100));
		personas.add(new Persona("Ana", 18,80));
		personas.add(new Persona("Roberto", 15,85));
		personas.add(new Persona("Anna", 24,55));
		personas.add(new Persona("Sergio", 50,81));
		personas.add(new Persona("Manuela", 20,85));
		
		//sumando el peso de las personas de mas de 18 anios
		
		int peso = personas
					.stream()
					.filter( p -> p.getEdad() >18)
					.mapToInt(Persona::getPeso)
					.sum();
		System.out.println("Suma del peso de las personas de mas de 18 anios: "+ peso);
	
		//Promedio de edad de los que pesan mas de 45 kg
		
		//La variable es un optional de double porque puede no devolver nada
		OptionalDouble promedioEdad = personas
										.stream()
										.filter(p -> p.getPeso()>45)
										.mapToInt(Persona::getEdad)
										.average();
		System.out.println("El promedio de edad de las personas que pesan mas de 45 kg es de: "+ promedioEdad);
	
		
		int valorInicial = 0;
		System.out.println(IntStream
							.range(1, 4)
							.reduce(valorInicial, ( a, b) -> a+b));
		
		//la idea es aplicar la operacion terminal como ultima operacion 
		//del stream
		
		//Es importante que todo el filtrado se haga antes de realizar operaciones,
		//ya que en ese caso es mas sencillo hacerlas
		
		//si el stream no se cierra con un a operacion terminal es necesario 
		// cerrarlo con la operacion close()
		
		//si no cerramos el stream este queda abierto y ocupa memoria durante
		//toda la ejecucion del programa
	
	
		//a sorted le tengo que pasar una interfaz tipo comparador
		//Como es una interfaz le puedo pasar la lambda del metodo que tiene que implementar
		personas
			.stream()
			.sorted((una, otra) -> una.getNombre().compareTo(otra.getNombre()))
			.forEach(System.out::println);;
	}

}

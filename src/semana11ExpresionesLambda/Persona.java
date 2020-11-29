package semana11ExpresionesLambda;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class Persona {
	public String _nombre;
	public int _edad;

	public Persona(String nombre, int edad) {
		_nombre = nombre;
		_edad = edad;
	}

	// En java aparece algo que se llama interfaces funcionales
	// Son interfaces que tienen un unico metodo necesario para implementar
	// una vez implementado ese metodo podemos trabajar con ellas

	// consumer

	// Consumer: Es una interfaz funcional, que realiza una accion
	// sobre una instancia de una clase. Toma como parametro una instancia
	// y no retorna resultados

	// Este metodo es uno que cumple todo lo de arriba
	// por lo tanto se puede escribir como funcion lambda
	public void mostrarNombre() {
		System.out.println(this._nombre);
	}

	public void mostrarEdad() {
		System.out.println(this._edad);
	}

	// el consumer seria un metodo y lo estaria pasando como parametro
	private static void aplicar(ArrayList<Persona> personas, Consumer<Persona> consumidor) {
		for (Persona p : personas) {
			consumidor.accept(p);
		}
	}
	// Este metodo se llama de la forma
	// aplicar(personas, p -> p.mostrNombre())

	// -----------------------------------------------------------
	// -----------------------------------------------------------

	// Predicado es una metodo que toma una instancia de una clase y retorna un
	// valor
	// boolean. Sirve para filtrar colecciones

	private static ArrayList<Persona> filtrar(ArrayList<Persona> personas, Predicate<Persona> filtro) {
		ArrayList<Persona> ret = new ArrayList<Persona>();
		for (Persona p : personas) {
			if (filtro.test(p)) {
				ret.add(p);
			}
		}
		return ret;
	}
	
	private static void filtrar2(ArrayList<Persona> personas, Predicate<Persona> filtro) {
		for (Persona p : personas) {
			if (filtro.test(p)) {
				p.mostrarNombre();
			}
		}
	}
	// test recibe una persona y retorna boolean de acuerdo al
	// codigo de la expresion lambda que le pase

	
	//-----------------------------------------------------------
	//------------------------------------------------------------
	//Funciones toman una instancia de una clase y retornan un resultado
	//el metodo que tengo que escibir de esta interfaz el aply y se le aplica
	//a
	
	public static void calcular (ArrayList<Persona> personas, Function<Persona, String> funcion) {
		for(Persona p : personas) {
			System.out.println(p._nombre + " = "+ funcion.apply(p));
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona("Patricia", 43));
		personas.add(new Persona("Alberto", 27));
		personas.add(new Persona("Jose", 31));
		personas.add(new Persona("Ana", 18));
		personas.add(new Persona("Roberto", 15));

		// p -> p.mostrarNombre()
		// es un consumer y sabemos que debe implementar el metodo acep
		// acepta una persona y realiza una accion sobre la persona
		// Lo que viene despues de la flecha es la implementacion del metodo
		// accept

		System.out.println("Imprimo todos los nombres");
		aplicar(personas, p -> p.mostrarNombre());

		System.out.println("Imprimo todas las edades");
		aplicar(personas, p -> p.mostrarEdad());

		// tambien podria definir el la implementacion de dentro de la
		// misma expresion. No es necesario definir una funcion
//		aplicar(personas, p -> {System.out.println(p._nombre);});
//		aplicar(personas, p-> {System.out.println(p._nombre);});

		// solo puedo pasar funciones void por definicion de consumer
		// el consumer no devuelve nada solo realiza una accion

		System.out.println("Filtro todas las personas menores");
		System.out.println(filtrar(personas, p -> p.esMenor()));
		
		System.out.println("Filtro todas las personas mayores a 30");
		System.out.println(filtrar(personas, p -> p._edad > 30));

		System.out.println("Filtro todas las personas de 15");
		System.out.println(filtrar(personas, p -> p._edad == 15));

		
		System.out.println("Aplico la interfaz Function");
		calcular(personas, p -> aMayusculas(p._nombre));
	}

	private static String aMayusculas(String s) {
		return s.toUpperCase();
	}

	private boolean esMenor() {
		return _edad < 18;
	}

	@Override
	public String toString() {
		return "\n"+_nombre + ", edad=" + _edad;
	}
	
	

}

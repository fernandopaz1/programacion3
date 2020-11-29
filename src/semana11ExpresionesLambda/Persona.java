package semana11ExpresionesLambda;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Persona {
	public String _nombre;
	public int _edad;
	
	public Persona(String nombre, int edad) {
		_nombre = nombre;
		_edad = edad;
	}
	
	//En java aparece algo que se llama interfaces funcionales
	//Son interfaces que tienen un unico metodo necesario para implementar
	//una vez implementado ese metodo podemos trabajar con ellas
	
	//consumer
	
	//Consumer: Es una interfaz funcional, que realiza una accion
	//sobre una instancia de una clase. Toma como parametro una instancia
	// y no retorna resultados
	
	//Este metodo es uno que cumple todo lo de arriba
	//por lo tanto se puede escribir como funcion lambda
	public void mostrarNombre() {
		System.out.println(this._nombre);
	}
	public void mostrarEdad() {
		System.out.println(this._edad);
	}
	
	//el consumer seria un metodo y lo estaria pasando como parametro
	private static void aplicar(ArrayList<Persona> personas, Consumer<Persona> consumidor) {
		for(Persona p : personas) {
			consumidor.accept(p);
		}
	}
	//Este metodo se llama de la forma
	//aplicar(personas, p -> p.mostrNombre())
	
	public static void main(String[] args) {
		ArrayList<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona("Patricia", 43));
		personas.add(new Persona("Alberto", 27));
		personas.add(new Persona("Jose", 31));
		
		//p -> p.mostrarNombre()
		//es un consumer y sabemos que debe implementar el metodo acep
		//acepta una persona y realiza una accion sobre la persona
		//Lo que viene despues de la flecha es la implementacion del metodo 
		//accept
		aplicar(personas, p -> p.mostrarNombre());
		aplicar(personas, p-> p.mostrarEdad());
		
		//tambien podria definir el la implementacion de dentro de la 
		//misma expresion. No es necesario definir una funcion
//		aplicar(personas, p -> {System.out.println(p._nombre);});
//		aplicar(personas, p-> {System.out.println(p._nombre);});
		
		//solo puedo pasar funciones void por definicion de consumer
		//el consumer no devuelve nada solo realiza una accion
	}

}

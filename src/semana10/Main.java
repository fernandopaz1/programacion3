package semana10;

public class Main {

	public static void main(String[] args) {
		LasPersonas personas = new LasPersonas();

		for (int i = 15; i < 30; i++) {
			personas.agregar(new Persona("Persona" + i, i, i > 20));
		}

		System.out.println("Mayor de 18: \n" + personas.buscar(new MayorDe18Condicion()));

		System.out.println("Menor de 21: \n" + personas.buscar(new MenorDe21Condicion()));

		System.out.println("Casadas: \n" + personas.buscar(new Condicion() {
			@Override
			public boolean cumple(Persona p) {

				return p.esCasado();
			}

		}));

		System.out.println("Casadas menores a 28: \n" + personas.buscar(new Condicion() {
			@Override
			public boolean cumple(Persona p) {
				return p.esCasado() && p.edad() < 28;
			}

		}));
	}

}

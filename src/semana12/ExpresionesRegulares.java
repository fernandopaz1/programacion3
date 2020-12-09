package semana12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpresionesRegulares {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("\\d{4}-\\d{4}");
		Matcher matcher = pattern.matcher("Su telefono es 4455-4332 el laboral es 4754-2354");
		
		while(matcher.find()) {
			System.out.println("Encontre "+ matcher.group() + " comenzando en "
					+matcher.start()+ " y terminando en "+ matcher.end());
		}
			System.out.println("Fin de la busqueda");
			
			//telefono de buenos aires (011)4455-3442
			Pattern pattern2 = Pattern.compile("\\(011\\)\\s?4\\d{3}-\\d{4}");
			Matcher matcher2 = pattern2.matcher("Su telefono es (011) 4455-4332 el laboral es 4754-2354, (011) 4222-4332, (011) 0000-4332");
			
			while(matcher2.find()) {
				System.out.println("Encontre "+ matcher2.group() + " comenzando en "
						+matcher2.start()+ " y terminando en "+ matcher2.end());
			}
			System.out.println("Busqueda finalizada");
			
			
			//expresion regular para reconocer un email
			//w engloba las letras _ y los numeros
			Pattern pattern3 = Pattern.compile("[a-zA-Z]\\w+@\\w+(\\.\\w+)+");
			Matcher matcher3 = pattern3.matcher(" mail fernando_983@gmail.com.ar.edu.ar");
			
			while(matcher3.find()) {
				System.out.println("Encontre "+ matcher3.group() + " comenzando en "
						+matcher3.start()+ " y terminando en "+ matcher3.end());
			}
			System.out.println("Busqueda finalizada");
			
			
			String texto = "El atleta ha rebidido medallas de oro: 25, plata: 19, de bronce:0";
			
			//cuantas medallas de oro gano
			Pattern p = Pattern.compile("oro: (\\d*)");
			Matcher m = p.matcher(texto);
			
			//todo lo que pongo entre parentesis es un grupo
			//accedo al contenido del grupo 1 con matcher.group()
			if(m.find()) {
				System.out.println("Encontre "+ m.group(1) + " comenzando en "
						+m.start()+ " y terminando en "+ m.end());
			}
			System.out.println("Busqueda finalizada");
			
	}

}

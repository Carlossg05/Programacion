package Animal;
import java.util.HashMap;

public class SistemaDeAnimales {
	private HashMap<String, Animal> animales = new HashMap<>();
	
	public void altaAnimal (Animal animal) {
		if (animales.containsKey(animal.getnumero_de_chip())) {
			System.out.println("Este n�mero de chip ya est� registrado.");
		} else {
			animales.put((String) animal.getnumero_de_chip(), animal);
			System.out.println ("El animal ha sido a�adido correctamente.");
		}
	}
	
	public void IdAnimal (String numero_de_chip) {
		Animal animal = animales.get(numero_de_chip);
		if (animal != null) {
			animal.mostrarDatos();
		} else {
			System.out.println ("Este animal no existe.");
		}
	}
}

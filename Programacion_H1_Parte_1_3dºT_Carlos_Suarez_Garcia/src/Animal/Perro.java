package Animal;

public class Perro extends Animal {
	String tama�o;
	
	public Perro ( int numeroChip, String nombre, int edad, String raza, boolean adoptado, String tama�o) {
		super (numeroChip, nombre, edad, raza, adoptado);
			this.tama�o = tama�o;
	}
	
	public Perro(String string, String nombre, int edad, String raza, boolean adoptado, String tama�o2) {
	}

	@Override
	public void mostrarDatos() {
		System.out.println ("Chip del perro: " + numeroChip);
		System.out.println ("Nombre: " + nombre);
		System.out.println ("Edad: " + edad);
		System.out.println ("Raza: " + raza);
		System.out.println ("Adoptado: " + adoptado);
		System.out.println ("Tama�o: " + tama�o);
	}

	@Override
	protected Object getnumero_de_chip() {

		return null;
	}
}

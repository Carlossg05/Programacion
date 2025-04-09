package Animal;

public abstract class Animal {
	int numeroChip; // Identificador del animal.
	String nombre;   // Nombre del animal.
	int edad;      // Edad del animal.
	String raza;      // Raza del animal.
	boolean adoptado; // Indica si está adoptado.

	public Animal (int i, String nombre, int edad, String raza, boolean adoptado) {
		this.numeroChip = i;
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.adoptado = adoptado;
	}

	public Animal(String string, String nombre2, int edad2, String raza2, boolean adoptado2) {
		// Otro constructor (sin lógica de asignación).
	}

	public abstract void mostrarDatos(); // Método para mostrar datos del animal.

	protected abstract Object getnumero_de_chip(); // Obtener número de chip.

	protected abstract String getChip(); // Obtener chip como String.
}
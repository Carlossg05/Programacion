package Animal;

public abstract class Animal {
	int numeroChip; // Identificador del animal.
	String nombre;   // Nombre del animal.
	int edad;      // Edad del animal.
	String raza;      // Raza del animal.
	boolean adoptado; // Indica si est� adoptado.

	public Animal (int i, String nombre, int edad, String raza, boolean adoptado) {
		this.numeroChip = i;
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.adoptado = adoptado;
	}

	public Animal(String string, String nombre2, int edad2, String raza2, boolean adoptado2) {
		// Otro constructor (sin l�gica de asignaci�n).
	}

	public abstract void mostrarDatos(); // M�todo para mostrar datos del animal.

	protected abstract Object getnumero_de_chip(); // Obtener n�mero de chip.

	protected abstract String getChip(); // Obtener chip como String.
}
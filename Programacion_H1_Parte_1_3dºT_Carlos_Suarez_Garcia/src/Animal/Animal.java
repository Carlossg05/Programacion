package Animal;

public abstract class Animal {
	int numeroChip;
	String nombre;
	int edad;
	String raza;
	boolean adoptado;
	
	public Animal (int numeroChip, String nombre, int edad, String raza, boolean adoptado) {
	
		this.numeroChip = numeroChip;
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.adoptado = adoptado;
	}
	
	public abstract void mostrarDatos();

	protected abstract Object getnumero_de_chip();
}

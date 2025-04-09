package Animal;

public class Perro extends Animal {
    String tama�o; // Tama�o del perro.

    public Perro(String string, String nombre, int edad, String raza, boolean adoptado, String tama�o) {
        super(string, nombre, edad, raza, adoptado); // Llama al constructor de Animal.
        this.tama�o = tama�o; // Asigna el tama�o del perro.
    }

    public Perro(String nombre, int edad, String raza, boolean adoptado, String tama�o) {
        super(0, nombre, edad, raza, adoptado); // Llama al constructor de Animal con chip 0.
        this.tama�o = tama�o; // Asigna el tama�o del perro.
    }

    @Override
    public void mostrarDatos() { // Muestra los datos del perro.
        System.out.println("Chip del perro: " + numeroChip);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Raza: " + raza);
        System.out.println("Adoptado: " + adoptado);
        System.out.println("Tama�o: " + tama�o);
    }

    @Override
    protected Object getnumero_de_chip() { // Devuelve el n�mero de chip.
        return numeroChip;
    }

	@Override
	protected String getChip() { // TODO: Implementar obtenci�n de chip como String.
		return null;
	}
}
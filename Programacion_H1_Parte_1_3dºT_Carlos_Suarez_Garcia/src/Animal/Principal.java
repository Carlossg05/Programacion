package Animal;

public class Principal {
	public static void main (String []args) {
		SistemaDeAnimales sistema = new SistemaDeAnimales()
		
		//Alta de perros
		sistema.altaAnimal(new Perro ("001", "Max", 2, "Salchicha", true, "Peque�o"));
		sistema.altaAnimal(new Perro ("002", "Maya", 5, "D�lmata", false, "Grande"));
		sistema.altaAnimal(new Perro ("003", "Arturo", 1, "Caniche", true, "Peque�o"));
		sistema.altaAnimal(new Perro ("004", "Gast�n", 4, "Rotwiller", false, "Grande"));
		
		
		//Alta de gatos
		sistema.altaAnimal(new Gato ("005", "F�garo", 2, "Salchicha", true, false));
		sistema.altaAnimal(new Gato ("006", "Michu", 6, "Salchicha", false, true));
		sistema.altaAnimal(new Gato ("007", "Kira", 3, "Salchicha", true, true));
		sistema.altaAnimal(new Gato ("008", "Aaron", 1, "Salchicha", false, false));
		System.out.println();
	
	}
}

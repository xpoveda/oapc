
public class Persona implements Comparable<Persona> {
	private String nombre;
	private int edad;
	private int id;
	
	public Persona(String nombre, int edad, int id) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(Persona o) {
		return this.nombre.compareTo(o.nombre);
	}
	
	@Override
	public String toString() {
		return "Persona - id: "+id+", nombre: "+ nombre+", edad: "+edad+"\n\n";
	}
	
	
	
	
}

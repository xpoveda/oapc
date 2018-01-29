
public class TestEmpleado {
	public static void setEdadEmpleado(int edad) throws EdadEmpleadoNoValidaException {
		if(edad<18) {
			// Lanzaríamos una excepción personalizada EdadEmpleadoNoValidaException
			throw new EdadEmpleadoNoValidaException("La edad es menor de 18 años");
		} else {
			System.out.println("La edad del empleado es válida!");
		}
	}
	
}


public class Main {

	public static void main(String[] args) {
		
		/*
		try {
			
			TestEmpleado.setEdadEmpleado(17);
			
		} catch (EdadEmpleadoNoValidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}finally{
			
		}*/
		
		try {
			System.out.println("Instrucción 1");
			System.out.println("Instrucción 2");
			Integer.parseInt("3");
			System.out.println("Instrucción 3");
		
		} catch (NumberFormatException e) {
			System.out.println("No ha indicado un parámetro numérico");
		} finally {
			System.out.println("Instrucción final");
		}
		
	}
}
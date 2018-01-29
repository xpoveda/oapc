
public class Seat implements IVehiculo {
	private int velocidadActual;
	private int depositoActual = 50;

	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void frenar() {
		// TODO Auto-generated method stub
		velocidadActual = 0;
	}

	@Override
	public void acelerar() {
		// TODO Auto-generated method stub
		velocidadActual += 40;
		if(velocidadActual>150) {
			velocidadActual = 150;
		}
		
		depositoActual -= 5;
		System.out.println("Velocidad del Seat: "+velocidadActual);
	}

	@Override
	public void mostrarDeposito() {
		// TODO Auto-generated method stub
		System.out.println("Depósito: "+depositoActual+"litros");
	}
	
	
}

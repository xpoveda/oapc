
public class Ferrari implements IVehiculo {
	private int velocidadActual;
	private int depositoActual = 75;
	
	
	@Override
	public void frenar() {
		// TODO Auto-generated method stub
		velocidadActual = 0;
	}

	@Override
	public void acelerar() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				velocidadActual += 40;
				if(velocidadActual>250) {
					velocidadActual = 250;
				}
				
				depositoActual -= 10;
				System.out.println("Velocidad del ferrari: "+velocidadActual);
	}

	@Override
	public void mostrarDeposito() {
		// TODO Auto-generated method stub
		System.out.println("Depósito: "+depositoActual+"litros");
	}

}

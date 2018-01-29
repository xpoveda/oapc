import java.util.Comparator;

public class OrdenarPersonasPorEdad implements Comparator<Persona> {

	@Override
	public int compare(Persona o1, Persona o2) {
		return o1.getEdad()-o2.getEdad();
	}

}

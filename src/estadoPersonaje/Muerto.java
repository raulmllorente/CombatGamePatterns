package estadoPersonaje;

//Clase Muerto que representa el estado "muerto" del jugador
public class Muerto extends EstadoPersonaje{

	public Muerto(ContextoPersonaje personaje) {
		super(personaje);
	}

	@Override
	public void infoPersonaje(ContextoPersonaje personaje) {
		System.out.println("HAS MUERTO... ACEPTA TU DERROTA");
	}

	@Override
	public EstadoPersonaje estadoSiguiente() {
		return this;
	}

}

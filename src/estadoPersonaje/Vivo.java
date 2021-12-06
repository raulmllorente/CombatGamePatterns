package estadoPersonaje;

//Clase Vivo que representa el estado "vivo" del jugador
public class Vivo extends EstadoPersonaje{

	public Vivo(ContextoPersonaje personaje) {
		super(personaje);
	}

	@Override
	public void infoPersonaje(ContextoPersonaje personaje) {
		System.out.println("SIGUES VIVO... ESTO NO HA ACABADO");
	}

	@Override
	public EstadoPersonaje estadoSiguiente() {//se pasa al siguiente estado que sería "muerto"
		return new Muerto(personaje);
	}

}

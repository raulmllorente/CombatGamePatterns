package estadoPersonaje;

//contexto del estado del personaje, para implementar el patrón State
public class ContextoPersonaje {
	protected EstadoPersonaje estadoPersonaje;
	
	public ContextoPersonaje() {//constructor del contexto del personaje, que invoca a la clase Vivo, que será el primer estado del personaje
		estadoPersonaje = new Vivo(this);
	}
	
	public void infoPersonaje(ContextoPersonaje personaje) {//metodo que imprimirá la info del personaje
		estadoPersonaje.infoPersonaje(personaje);
	}
	
	public void estadoSiguiente() {//metodo que sirve para cambiar de estado del patrón State
		estadoPersonaje = estadoPersonaje.estadoSiguiente();
	}
}

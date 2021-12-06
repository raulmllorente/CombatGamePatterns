package estadoPersonaje;

//contexto del estado del personaje, para implementar el patr�n State
public class ContextoPersonaje {
	protected EstadoPersonaje estadoPersonaje;
	
	public ContextoPersonaje() {//constructor del contexto del personaje, que invoca a la clase Vivo, que ser� el primer estado del personaje
		estadoPersonaje = new Vivo(this);
	}
	
	public void infoPersonaje(ContextoPersonaje personaje) {//metodo que imprimir� la info del personaje
		estadoPersonaje.infoPersonaje(personaje);
	}
	
	public void estadoSiguiente() {//metodo que sirve para cambiar de estado del patr�n State
		estadoPersonaje = estadoPersonaje.estadoSiguiente();
	}
}

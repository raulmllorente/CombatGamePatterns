package estadoPersonaje;

//Clase abstracta del patrón State que tiene los constructores del estado del personaje
public abstract class EstadoPersonaje {
	protected ContextoPersonaje personaje;

	public EstadoPersonaje(ContextoPersonaje personaje) {
		this.personaje = personaje;
	}
	
	public abstract void infoPersonaje(ContextoPersonaje personaje);
	public abstract EstadoPersonaje estadoSiguiente();
}

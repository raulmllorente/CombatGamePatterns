package decoracionAcciones;

//Clase abstracta Decorator que implementa el patrón Decorator para la gestión de los ataques del jugador
public abstract class Decorator implements Ataques{
private Ataques ataques;
	
	public Decorator(Ataques ataques) {//Constructor de la clase Decorator
		setAtaques(ataques);
	}

	protected Ataques getAtaques() {//getters y setters de los ataques
		return ataques;
	}
	
	protected void setAtaques(Ataques ataques) {
		this.ataques = ataques;
	}
}

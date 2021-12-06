package StatsPersonaje;

//Clase Enemigo que contiene las estadisticas de vida, fuerza y defensa del enemigo a crear
//Tambien se incluyen el constructor y todos los getters y setters necesarios
public class Enemigo {
	private int vida;
	private int fuerza;
	private int defensa;
	
	public Enemigo(int vida, int fuerza, int defensa) {
		super();
		this.vida = vida;
		this.fuerza = fuerza;
		this.defensa = defensa;
	}
	
	public int getVida() {
		return vida;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public int getFuerza() {
		return fuerza;
	}
	
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	
	public int getDefensa() {
		return defensa;
	}
	
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
}

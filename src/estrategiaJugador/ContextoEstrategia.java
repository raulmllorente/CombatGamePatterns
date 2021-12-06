package estrategiaJugador;

import StatsPersonaje.Personaje;

//Clase ContextoEstrategia del patrón Strategy que crea las funciones necesarias para establecer la estrategia deseada
public class ContextoEstrategia {
	private Estrategia estrategia;
	
	public ContextoEstrategia(Estrategia estrategia) {
		super();
		this.estrategia = estrategia;
	}
	
	public Estrategia getEstrategia(){
		return estrategia;
	}
	
	public void setEstrategia(Estrategia estrategia){
		this.estrategia = estrategia;
	}
	
	public void eleccionInicial(Personaje p){//metodo que modificará los valores pertinentes según la estrategia elegida
		this.estrategia.eleccionInicial(p);
	}
}

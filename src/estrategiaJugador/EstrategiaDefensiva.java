package estrategiaJugador;

import StatsPersonaje.Personaje;

//Implementaci�n de la estrategia defensiva
public class EstrategiaDefensiva implements Estrategia{
	@Override
	public void eleccionInicial(Personaje p) {
		int defensaExtra = 10;
		int defensaPersonaje = p.getDefensa();
		int defensaAumentada = defensaPersonaje + defensaExtra;//se incrementa 10 puntos la defensa del personaje
		
		System.out.println("HAS ELEGIDO DEFENSIVA, AUMENTO DE DEFENSA: " + defensaAumentada);
	}



}

package estrategiaJugador;

import StatsPersonaje.Personaje;

//Implementación de la estrategia agresiva
public class EstrategiaAgresiva implements Estrategia{
	@Override
	public void eleccionInicial(Personaje p) {
		int fuerzaExtra = 10;
		int fuerzaPersonaje = p.getFuerza();
		int fuerzaAumentada = fuerzaPersonaje + fuerzaExtra;//se incrementa 10 puntos la fuerza del personaje
		
		System.out.println("HAS ELEGIDO AGRESIVA, AUMENTO DE ATAQUE: " + fuerzaAumentada);
	}
}

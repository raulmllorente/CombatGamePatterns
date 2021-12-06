package calculadora;

import StatsPersonaje.Enemigo;
import StatsPersonaje.Personaje;

//Para la calculadora de daño durante la partida usamos el patrón Singleton
public class Calculadora {
	
	private static Calculadora instancia = null;
	
	public static Calculadora instance(){//creamos una funcion instance() que comprobará si hay otra instancia creada y si no la crea
		if (instancia == null) {
			instancia = new Calculadora();
		}
		return instancia;
	}
	
	//Función calcDano() que calculará el daño estandar realizado en combate
	public void calcDano(Personaje p, Enemigo e ,boolean enemigo) {
		int danoPersonaje = p.getVida() - (e.getFuerza() / p.getDefensa()); //para el calculo del daño restamos la vida del que va a ser atacado con la fuerza del atacante entre la defensa del atacado
		int danoEnemigo = e.getVida() - (p.getFuerza() / e.getDefensa());
		int vidaActualPersonaje = danoPersonaje;
		int vidaActualEnemigo = danoEnemigo;
		
		if(enemigo) {//si es un enemigo el que ataca se modifica la vida del personaje
			p.setVida(vidaActualPersonaje);
		}else {
			e.setVida(vidaActualEnemigo);//si es un personaje el que ataca se modifica la vida del enemigo
		}
		
		System.out.println("La vida de: ");
		
		if(enemigo) {//se imprime la vida del personaje/enemigo afectado
			System.out.println("Pesonaje: " + p.getVida());
		} else {
			System.out.println("Enemigo: " + e.getVida());
		}
		
	}
	
	//Función calcDanoEspecialBruh() que calculará el daño especial por el ataque "Bruh" realizado en combate
	public void calcDanoEspecialBruh(Personaje p, Enemigo e ,boolean enemigo) {
		int danoPersonaje = p.getVida() - ((e.getFuerza() * 2) / p.getDefensa()); //para el calculo del daño restamos la vida del que va a ser atacado con la fuerza del atacante por dos (porque es un ataque especial) entre la defensa del atacado
		int danoEnemigo = e.getVida() - ((p.getFuerza() * 2) / e.getDefensa());
		int vidaActualPersonaje = danoPersonaje;
		int vidaActualEnemigo = danoEnemigo;
		
		if(enemigo) {
			p.setVida(vidaActualPersonaje);//si es un enemigo el que ataca se modifica la vida del personaje
		} else {
			e.setVida(vidaActualEnemigo);//si es un personaje el que ataca se modifica la vida del enemigo
		}
		
		System.out.println("La vida de: ");
		
		if(enemigo) {//se imprime la vida del personaje/enemigo afectado
			System.out.println("Pesonaje: "+ p.getVida());
		}else {
			System.out.println("Enemigo: "+ e.getVida());
		}
	}
}

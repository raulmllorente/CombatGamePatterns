package Juego;

import java.util.Scanner;

import StatsPersonaje.Enemigo;
import StatsPersonaje.Personaje;
import calculadora.Calculadora;
import decoracionAcciones.AtaquesJugador;
import decoracionAcciones.Bruh;
import decoracionAcciones.Magia;
import decoracionAcciones.Punos;
import estadoPersonaje.ContextoPersonaje;
import estrategiaJugador.ContextoEstrategia;
import estrategiaJugador.EstrategiaAgresiva;
import estrategiaJugador.EstrategiaDefensiva;
import templateAcciones.AtaqueBruh;
import templateAcciones.AtaqueFuego;
import templateAcciones.AtaqueTemblor;
import templateAcciones.AtaquesEnemTemplate;

public class Combate {
	Personaje p = new Personaje (100,50,20);//Se crea un personaje con las estadisticas de fuerza, ataque y resistencia deseadas
	Enemigo e = new Enemigo(80,40,30);//Se crea un enemigo con las estadisticas de fuerza, ataque y resistencia deseadas
	ContextoPersonaje estadoPersonaje = new ContextoPersonaje();//Objeto de tipo ContextoPersonaje del patrón State para controlar el estado del personaje
	AtaquesJugador ataquesJugador = new AtaquesJugador();//Objeto de tipo AtaquesJugador del patrón Decorator para gestionar los ataques del jugador
	Scanner sc = new Scanner(System.in);
	
	public void todo() {//función que llamará a las funciones que controlan la estrategia del juego y los combates
		this.estrategiaJugador();
		this.combate();
	}
	
	//Metodo que gestiona la estrategia elegida por el jugador para la partida
	public void estrategiaJugador() {
		System.out.println("ELECCION DE ESTRATEGIA");
		System.out.println("PARA ESTRATEGIA AGRESIVA PULSAR 1");
		System.out.println("PARA ESTRATEGIA DEFENSIVA PULSAR 2");
		System.out.println("Dime que estrategia quieres coger:");
		int opcion = sc.nextInt();
		
		switch(opcion) {//se crea un switch para la elección de la estrategia
			case 1:
				System.out.println("ELEGIDO AGRESIVIDAD 'MU LOCO', AUMENTO DE FUERZA");
				ContextoEstrategia EAGR = new ContextoEstrategia(new EstrategiaAgresiva());//Se crea un objeto EstrategiaAgresiva si se elige esta opcion
				EAGR.eleccionInicial(p);
				break;
				
			case 2:
				System.out.println("ELEGIDO DEFENSIVO 'NO ME TOQUES', AUMENTO DE DEFENSA");
				ContextoEstrategia EDEF = new ContextoEstrategia(new EstrategiaDefensiva());//Se crea un objeto EstrategiaDefensiva si se elige esta opcion
				EDEF.eleccionInicial(p);
				break;
				
			default:
				System.err.println("**** ERROR ****");//si la eleccion es incorrecta sale un mensaje de error
				break;
		}
	}
	
	public void combate() {
		do {
			System.out.println();
			System.out.println("**** EMPEZAMOS EL COMBATE ****");
			System.out.println("PARA ATAQUE CON PUÑOS PULSAR 1");
			System.out.println("PARA ATAQUE CON MAGIA PULSAR 2");
			System.out.println("PARA ATAQUE ESPECIAL BRUH PULSAR 3");
			System.out.println("Escoge una accion de ataque:");
			int opcion = sc.nextInt();
			Calculadora calc = Calculadora.instance();//se crea un objeto de tipo Calculadora para calcular el daño durante el combate
			
			switch(opcion) {//se crea un switch para la elección del ataque del jugador
				case 1:
					Punos punos = new Punos(ataquesJugador);//Se crea un objeto Punos si se elige la opcion de ataque con puños
					System.out.println(punos.infoAtaque());
					calc.calcDano(p, e, false);//se calcula el daño
					break;
					
				case 2:
					Magia magia = new Magia(ataquesJugador);//Se crea un objeto Magia si se elige la opcion de ataque con magia
					System.out.println(magia.infoAtaque());
					calc.calcDano(p, e, false);//se calcula el daño
					break;
					
				case 3:
					Bruh bruh = new Bruh(ataquesJugador);//Se crea un objeto Bruh si se elige la opcion de ataque Bruh
					System.out.println(bruh.infoAtaque());
					calc.calcDanoEspecialBruh(p, e, false);//se calcula el daño pero como esta ocasion es un ataque especial se usa la funcion calcDanoEspecialBruh
					break;
					
				default:
					System.err.println("EL ATAQUE FALLÓ!!!!");//Se imprime mensaje de fallo si se introduce un ataque no valido
					break;
			}
			
			System.out.println();
			
			int opcRand = (int) (Math.random() * (5 - 1 + 1) + 1);//se crea un valor aleatorio entre 1 y 5 para que se elija (o falle) un ataque del enemigo
			
			switch(opcRand) {//se crea un switch para la acción del ataque del enemigo
				case 1:
					AtaquesEnemTemplate fuego = new AtaqueFuego();//Se crea un objeto de tipo Template para los ataques de fuego
					fuego.go();
					calc.calcDano(p, e, true);//se calcula el daño
					break;
					
				case 2:
					AtaquesEnemTemplate temblor = new AtaqueTemblor();//Se crea un objeto de tipo Template para los ataques temblor
					temblor.go();
					calc.calcDano(p, e, true);//se calcula el daño
					break;
					
				case 3:
					AtaquesEnemTemplate bruh = new AtaqueBruh();//Se crea un objeto de tipo Template para los ataques Bruh
					bruh.go();
					calc.calcDanoEspecialBruh(p, e, true);//se calcula el daño pero como esta ocasion es un ataque especial se usa la funcion calcDanoEspecialBruh
					break;
					
				default:
					System.err.println("EL ATAQUE FALLÓ!!!!");//Se imprime mensaje de fallo si es un ataque no valido
					break;
			}
			
			int vidaEnemigo = e.getVida();
			int vidaJugador = p.getVida();
			
			System.out.println("ENEMIGO CON VIDA RESTANTE: " + vidaEnemigo);//se imprime la vida restante del enemigo a modo de informacion
			System.out.println("TIENES VIDA RESTANTE: " + vidaJugador);//se imprime la vida restante del personaje a modo de informacion
			estadoPersonaje();//se comprueba el estado del personaje en cada iteración, para ello se llama a la funcion estadoPersonaje()
			
		} while((e.getVida() > 0) && (p.getVida() > 0));//la partida termina si la vida del enemigo o del personaje llega a 0 o menor que 0
	}
	
	public void estadoPersonaje() {
		if(p.getVida() <= 0) {//si la vida del personaje es menor o igual que 0 pasamos al siguiente estado que es "muerto"
			estadoPersonaje.estadoSiguiente();
			estadoPersonaje.infoPersonaje(estadoPersonaje);
		} else {
			estadoPersonaje.infoPersonaje(estadoPersonaje);//si la vida es mayor que 0 sigue en estado "vivo"
		}
	}
	
}

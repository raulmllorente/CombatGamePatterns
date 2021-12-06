package templateAcciones;

//Clase AtaquesEnemTemplate que implementa el patrón Template para gestionar los ataques de los enemigos
public abstract class AtaquesEnemTemplate {
	
	protected abstract void infoAtaque();//función que mostrará la información del ataque del enemigo
	
	public final void go() {//función go() que llama a las funciones que mostrarán/modificarán datos
		infoAtaque();
	}
}

package templateAcciones;

//Clase AtaquesEnemTemplate que implementa el patr�n Template para gestionar los ataques de los enemigos
public abstract class AtaquesEnemTemplate {
	
	protected abstract void infoAtaque();//funci�n que mostrar� la informaci�n del ataque del enemigo
	
	public final void go() {//funci�n go() que llama a las funciones que mostrar�n/modificar�n datos
		infoAtaque();
	}
}

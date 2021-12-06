package decoracionAcciones;

public class Punos extends Decorator{

	public Punos(Ataques ataques) {//constructor de Punos
		super(ataques);
	}

	@Override
	public String infoAtaque() {//metodo infoAtaque() que da informacion sobre el ataque con pu�os
		return getAtaques().infoAtaque() + "Ataque con pu�os\n";
	}

}

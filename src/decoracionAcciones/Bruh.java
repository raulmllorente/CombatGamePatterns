package decoracionAcciones;

public class Bruh extends Decorator{

	public Bruh(Ataques ataques) {//constructor de Bruh
		super(ataques);
	}

	@Override
	public String infoAtaque() {//metodo infoAtaque() que da informacion sobre el ataque Bruh
		return getAtaques().infoAtaque() + "Ataque especial BRUH\n";
	}

}

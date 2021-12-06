package decoracionAcciones;

public class Magia extends Decorator{

	public Magia(Ataques ataques) {//constructor de Magia
		super(ataques);
	}

	@Override
	public String infoAtaque() {//metodo infoAtaque() que da informacion sobre el ataque con magia
		return getAtaques().infoAtaque() + "Ataque con magia\n";
	}

}

package cartes;

public class Attaque extends Bataille{

	public Attaque(Type type,String nom) {
		super(type,nom);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Un adversaire a déposé une attaque de type "+super.getType().getAttaque();
	}	
	
}

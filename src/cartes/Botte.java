package cartes;

public class Botte extends Probleme {

	public Botte(Type type,String nom) {
		super(type,nom);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Un adversaire a déposé une botte de type " + super.getType().getBotte();
	}
	
	
}

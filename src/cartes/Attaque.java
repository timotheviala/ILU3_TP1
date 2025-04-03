package cartes;

public class Attaque extends Bataille{

	public Attaque(Type type,String nom) {
		super(type,nom);
		// TODO Auto-generated constructor stub
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Attaque) {
			Attaque attaque=(Attaque) obj;
			return getType().equals(attaque.getType()) && getNom().equals(attaque.getNom());
		}
		return false;
	}
	
}

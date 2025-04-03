package cartes;

public class Botte extends Probleme {

	public Botte(Type type,String nom) {
		super(type,nom);
		// TODO Auto-generated constructor stub
	}	
	
	public boolean equals(Object obj) {
		if(obj instanceof Botte) {
			Botte botte=(Botte) obj;
			return getType().equals(botte.getType()) && getNom().equals(botte.getNom()) ;
		}
		return false;
	}
	
}

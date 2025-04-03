package cartes;

public class Parade extends Bataille{

	public Parade(Type type,String nom) {
		super(type,nom);
		// TODO Auto-generated constructor stub
	}
	

	public boolean equals(Object obj) {
		if(obj instanceof Parade) {
			Parade parade=(Parade) obj;
			return getType().equals(parade.getType()) && getNom().equals(parade.getNom());
		}
		return false;
	}
	
}

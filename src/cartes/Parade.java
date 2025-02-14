package cartes;

public class Parade extends Bataille{

	public Parade(Type type,String nom) {
		super(type,nom);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Vous avez d�pos� une parade de type "+super.getType().getParade();
	}
	
	

}

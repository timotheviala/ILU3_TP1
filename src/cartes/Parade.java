package cartes;

public class Parade extends Bataille{

	public Parade(Type type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Vous avez déposé une parade de type "+super.getType().getParade();
	}
	
	

}

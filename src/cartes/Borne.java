package cartes;

public class Borne extends Carte{
	private int km;
	
	public Borne(int km,String nom) {
		super(nom);
		this.km=km;
	}

	@Override
	public String toString() {
		return super.getNom();
	}
}

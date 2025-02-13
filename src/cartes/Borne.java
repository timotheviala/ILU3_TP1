package cartes;

public class Borne {
	private int km;
	
	public Borne(int km) {
		this.km=km;
	}

	@Override
	public String toString() {
		return "Le joueur place une borne de "+km+"kms!";
	}
}

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
	
	public int getKm() {
		return km;
	}

	public boolean equals(Object obj) {
		if(obj instanceof Borne) {
			Borne carteAComparer=(Borne) obj;
			return carteAComparer.getKm()==km && carteAComparer.getNom().equals(nom);
		}
		return false;
	}
}

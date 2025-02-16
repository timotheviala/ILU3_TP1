package cartes;

public abstract class Limite extends Carte{
	public Limite(String nom) {
		super(nom);
	}

	@Override
	public String toString() {
		return super.getNom();
	}
	
	
}


package cartes;

public abstract class Limite extends Carte{
	public Limite(String nom) {
		super(nom);
	}

	@Override
	public String toString() {
		return super.getNom();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Limite) {
			Limite carteAComparer=(Limite) obj;
			return carteAComparer.getNom().equals(nom);
		}
		return false;
	}
	
	
}


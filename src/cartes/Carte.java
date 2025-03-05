package cartes;

public abstract class Carte {
	String nom;
	
	public Carte(String nom) {
		this.nom=nom;
	}

	public String getNom() {
		return nom;
	}
	
}

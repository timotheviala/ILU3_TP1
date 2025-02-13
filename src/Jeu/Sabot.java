package Jeu;

import cartes.Carte;

public class Sabot {
	private Carte[] sabot;
	private int nbCartes;
	
	public Sabot(Carte[] sabot) {
		this.sabot=sabot;
		this.nbCartes=sabot.length;
	}

	public boolean estVide() {
		return nbCartes==0;
	}
	
	public void ajouterCarte(Carte carte) throws ArrayIndexOutOfBoundsException{
		if(nbCartes==sabot.length-1) {
			throw new ArrayIndexOutOfBoundsException();
		}
		sabot[nbCartes]=carte;
		nbCartes++;
	}
}

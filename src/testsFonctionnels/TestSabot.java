package testsFonctionnels;

import cartes.Botte;
import cartes.Carte;
import cartes.JeuDeCartes;

import java.util.Iterator;

import Jeu.Sabot;

public class TestSabot {
	JeuDeCartes jeu = new JeuDeCartes();
	Sabot sabot;
	
	public TestSabot(){
		jeu.initialiserJeu();
		sabot = new Sabot<Carte>(jeu.donnerCartes());
	}
	

	// 4.2.a
	public void questionA() {

		while (!sabot.estVide()) {
			Carte carte = sabot.piocher();
			System.out.println("Je pioche " + carte);
		}
//		Console :
//		Je pioche Accident
//		Je pioche Accident
//		Je pioche Accident
//		Je pioche R�paration
//		Je pioche R�paration
//		Je pioche R�paration
//		Je pioche As du volant
	}

	// 4.2.b
	public void questionB() {
		for (Iterator<Carte> iterator = sabot.iterator(); iterator.hasNext();) {
			System.out.println("Je pioche " + iterator.next());
		}
	}

	// 4.2.c
	public void questionC() {
		//2 lignes à ajouter pour exception
		Carte cartePiochee = sabot.piocher();
		System.out.println("Je pioche " + cartePiochee);
		
		for (Iterator<Carte> iterator = sabot.iterator(); iterator.hasNext();) {
			Carte carte = iterator.next();
			System.out.println("Je pioche " + carte);
			//cartePiochee = sabot.piocher();
			//ligne pour exception
			sabot.ajouterCarte(new Botte(cartes.Type.ACCIDENT,"AsDuVolant"));
			
		}
		Iterator<Carte> iterator = sabot.iterator();
		System.out.println("\nLa pioche contient encore des cartes ? " + iterator.hasNext());
	}

	public static void main(String[] args) {
		TestSabot testPioche = new TestSabot();
		//testPioche.questionA();
		testPioche.questionB();
		//testPioche.questionC();
	}

}

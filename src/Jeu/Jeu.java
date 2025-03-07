package Jeu;
import java.util.*;

import cartes.*;
import utils.*;


public class Jeu {
	private Sabot sabot;
	
	public Jeu() {
		JeuDeCartes jeu=new JeuDeCartes();
		jeu.initialiserJeu();
		List<Carte> listeCartes=new ArrayList<>();
		Collections.addAll(listeCartes, jeu.donnerCartes());
		listeCartes=GestionCartes.melanger(listeCartes);
		sabot=new Sabot((Carte[]) listeCartes.toArray());
	}

}
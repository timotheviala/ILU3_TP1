package Jeu;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

import cartes.*;

public class Joueur {

	private ZoneDeJeu zoneDeJeu;
	private String nom;
	private MainJoueur mainJoueur=new MainJoueur();
	
	public Joueur(String nom,ZoneDeJeu zoneDeJeu) {
		this.nom=nom;
		this.zoneDeJeu=zoneDeJeu;
	}

	private static class MainJoueur{
			private LinkedList<Carte> mainJoueur;
			
			public void prendre(Carte carte) {
				mainJoueur.add(carte);
			}
			
			public void jouer(Carte carte) {
				mainJoueur.remove(carte);
			}
			
			public String toString() {
				StringBuilder retour=new StringBuilder("Voici la main du joueur :\n");
				for(ListIterator<Carte> it=mainJoueur.listIterator();it.hasNext();) {
					Carte carte=it.next();
					retour.append("- "+carte.getNom()+"\n");
				}
				return retour.toString();
			}
	}
	
	public String toString() {
		return nom;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Joueur) {
			Joueur joueur=(Joueur) obj;
			return joueur.toString().equals(nom);
		}
		return false;
	}
	
	public String LireMain() {
		return mainJoueur.toString();
	}
	
	public void donner(Carte carte) {
		mainJoueur.prendre(carte);
	}
	
	public Carte prendreCarte(Sabot sabot) {
		if(sabot.estVide()) {
			return null;
		}
		Carte premiereCarte=sabot.piocher();
		donner(premiereCarte);
		return premiereCarte;
	}
	
	public int donnerKmParcourues() {
		return zoneDeJeu.donnerKmParcourus();
	}
	
	public void deposer(Carte c) {
		zoneDeJeu.deposer(c);
	}
	
	public boolean estDepotAutorise(Carte carte) {
		return zoneDeJeu.estDepotAutorise(carte);
	}
	
}

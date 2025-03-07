package testsFonctionnels;

import cartes.JeuDeCartes;
import utils.GestionCartes;

import java.util.*;

import cartes.*;

public class TestJeuDeCartes {
	public static void main(String[] args) {
//		JeuDeCartes jeu1 = new JeuDeCartes();
//		
//		jeu1.initialiserJeu();
//		
//		System.out.println("JEU:\n" + jeu1.affichageJeuCartes());
//		
//		System.out.println("CheckCount du jeu: "+jeu1.checkCount());
//		
//        if (!jeu1.checkCount()) {
//            System.out.println("erreur de nombre");
//        }
        
        JeuDeCartes jeu = new JeuDeCartes();
        jeu.initialiserJeu();
        List<Carte> listeCarteNonMelangee = new LinkedList<>();
        for (Carte carte : jeu.donnerCartes()) {
        	listeCarteNonMelangee.add(carte);
        }
        List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
        System.out.println(listeCartes);
        listeCartes = GestionCartes.melanger(listeCartes);
        System.out.println(listeCartes);
        System.out.println("liste m�lang�e sans erreur ? "
        + GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));
        listeCartes = GestionCartes.rassembler(listeCartes);
        System.out.println(listeCartes);
        System.out.println("liste rassembl�e sans erreur ? "
        + GestionCartes.verifierRassemblement(listeCartes));
        System.out.println(GestionCartes.extraire(listeCartes).toString());
	}
}

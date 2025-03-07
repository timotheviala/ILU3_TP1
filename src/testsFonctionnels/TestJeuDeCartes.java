package testsFonctionnels;

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
        
		System.out.println("TEST DONNE\n");
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
        
        System.out.println("\nTEST AVEC UNE LISTE DANS LE DESORDRE\n");
        List<Carte> test=new ArrayList<Carte>();
        test.add(new Borne(30, "b30"));
        test.add(new DebutLimite("dl"));
        test.add(new Borne(30, "b30"));
        test.add(new DebutLimite("dl"));
        test.add(new DebutLimite("dl"));
    	System.out.println("Liste init : "+test);
    	test=GestionCartes.rassembler(test);
    	System.out.println("Liste rassembler : "+test);
    	System.out.println("Rassemblee sans erreur : "+GestionCartes.verifierRassemblement(test));
    	System.out.println("Trois cartes randoms : "+GestionCartes.extraire(test)+ " "+
    	GestionCartes.extraire(test)+" "+GestionCartes.extraire(test));
        }
}

package testsFonctionnels;

import Jeu.*;
import cartes.*;

public class TestZoneDeJeu {

	public TestZoneDeJeu() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TP3 PARTIE 2
//		ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
//		System.out.println("Deposer carte 25 km");
//		zoneDeJeu.deposer(new Borne(25,"Borne25"));
//		System.out.println("Deposer carte 50 km");
//		zoneDeJeu.deposer(new Borne(50,"Borne50"));
//		System.out.println("Deposer carte 75 km");
//		zoneDeJeu.deposer(new Borne(75,"Borne75"));
//		System.out.println("Total des bornes : " + zoneDeJeu.donnerKmParcourus());
//		
//		System.out.println("Limite : " + zoneDeJeu.donnerLimitationVitesse());
//		zoneDeJeu.deposer(new DebutLimite("DebutLimite"));
//		System.out.println("Limite : " + zoneDeJeu.donnerLimitationVitesse());
//		zoneDeJeu.deposer(new FinLimite("FinLimite"));
//		System.out.println("Limite : " + zoneDeJeu.donnerLimitationVitesse());	
		
		// TP3 PARTIE 3
		boolean depotOK = false;
		ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
		// Feu rouge
		System.out.println("Deposer carte Feu rouge");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_ROUGE);
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.FEU_ROUGE);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// accident
		System.out.println("Deposer carte attaque - accident");
		depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ACCIDENT,"Accident"));
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Attaque(Type.ACCIDENT,"Accident"));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// Feu vert
		System.out.println("Deposer carte Feu vert");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.FEU_VERT);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// panne d'essence
		System.out.println("Deposer carte attaque - essence");
		depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ESSENCE,"essence"));
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Attaque(Type.ESSENCE,"essence"));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// roue de secours
		System.out.println("Deposer carte parade - roue de secours");
		depotOK = zoneDeJeu.estDepotAutorise(new Parade(Type.CREVAISON,"roue de secours"));
		if (depotOK) {
			zoneDeJeu.deposer(new Parade(Type.CREVAISON,"roue de secours"));
		}
		System.out.println("dépot ok ? " + depotOK);
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// bidon d'essence
		System.out.println("Deposer carte parade - essence");
		depotOK = zoneDeJeu.estDepotAutorise(new Parade(Type.ESSENCE,"essence"));
		if (depotOK) {
			zoneDeJeu.deposer(new Parade(Type.ESSENCE,"essence"));
		}
		System.out.println("dépot ok ? " + depotOK);
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// Feu vert
		System.out.println("Deposer carte Feu vert");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.FEU_VERT);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// D�pot 100 bornes
		System.out.println("Deposer carte borne - 100");
		depotOK = zoneDeJeu.estDepotAutorise(new Borne(100,"Borne 100"));
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Borne(100,"Borne 100"));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// D�pot limitation de vitesse 50 bornes
		System.out.println("Deposer carte limite - 50");
		depotOK = zoneDeJeu.estDepotAutorise(new DebutLimite("Debut Limite"));
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new DebutLimite("Debut limite"));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		System.out.println(zoneDeJeu.estDepotLimiteAutorise(new FinLimite("fl"))+"whatt");
		// D�pot 100 bornes
		System.out.println("Deposer carte borne - 100");
		depotOK = zoneDeJeu.estDepotAutorise(new Borne(100,"Borne 100"));
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Borne(100,"Borne 100"));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// Depot 25 bornes
		System.out.println("Deposer carte borne - 25");
		depotOK = zoneDeJeu.estDepotAutorise(new Borne(25,"Borne 25"));
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Borne(25,"Borne 25"));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// D�pot fin limitation
		System.out.println("Deposer carte fin limite - 50");
		depotOK = zoneDeJeu.estDepotAutorise(new FinLimite("FinLimite"));
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new FinLimite("FinLimite"));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// D�pot 100 bornes
		System.out.println("Deposer carte borne - 100");
		depotOK = zoneDeJeu.estDepotAutorise(new Borne(100,"Borne 100"));
		System.out.println("dépot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Borne(100,"Borne 100"));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());

// RESULTAT ATTENDU POUR LA PARTIE 3 (ne pas d�commenter)
// 			Deposer carte Feu rouge
//			d�p�t ok ? false
//			peut avancer ? false
//			Deposer carte attaque - accident
//			d�p�t ok ? false
//			peut avancer ? false
//			Deposer carte Feu vert
//			d�p�t ok ? true
//			peut avancer ? true
//			Deposer carte attaque - essence
//			d�p�t ok ? true
//			peut avancer ? false
//			Deposer carte parade - roue de secours
//			d�p�t ok ? false
//			peut avancer ? false
//			Deposer carte parade - essence
//			d�p�t ok ? true
//			peut avancer ? false
//			Deposer carte Feu vert
//			d�p�t ok ? true
//			peut avancer ? true
//			Deposer carte borne - 100
//			d�p�t ok ? true
//			peut avancer ? true
//			Deposer carte limite - 50
//			d�p�t ok ? true
//			peut avancer ? true
//			Deposer carte borne - 100
//			d�p�t ok ? false
//			peut avancer ? true
//			Deposer carte borne - 25
//			d�p�t ok ? true
//			peut avancer ? true
//			Deposer carte fin limite - 50
//			d�p�t ok ? true
//			peut avancer ? true
//			Deposer carte borne - 100
//			d�p�t ok ? true
//			peut avancer ? true
	}

}

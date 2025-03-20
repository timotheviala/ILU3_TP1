package testsFonctionnels;

import Jeu.*;
import cartes.*;

public class TestZoneDeJeu {

	public TestZoneDeJeu() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TP3 PARTIE 2
		ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
		System.out.println("Deposer carte 25 km");
		zoneDeJeu.deposer(new Borne(25,"Borne25"));
		System.out.println("Deposer carte 50 km");
		zoneDeJeu.deposer(new Borne(50,"Borne50"));
		System.out.println("Deposer carte 75 km");
		zoneDeJeu.deposer(new Borne(75,"Borne75"));
		System.out.println("Total des bornes : " + zoneDeJeu.donnerKmParcourus());
		
		System.out.println("Limite : " + zoneDeJeu.donnerLimitationVitesse());
		zoneDeJeu.deposer(new DebutLimite("DebutLimite"));
		System.out.println("Limite : " + zoneDeJeu.donnerLimitationVitesse());
		zoneDeJeu.deposer(new FinLimite("FinLimite"));
		System.out.println("Limite : " + zoneDeJeu.donnerLimitationVitesse());	
		
	}

}

package cartes;

import java.util.Scanner;
import java.util.regex.Matcher;

public class JeuDeCartes {
	private Configuration[] typesDeCartes;
	
	public JeuDeCartes() {
		// TODO Auto-generated constructor stub
	}
	
	private static class Configuration{
		private int nbExemplaires;
		private Carte carte;
		
		private Configuration(Carte carte,int nbExemplaires) {
			this.nbExemplaires=nbExemplaires;
			this.carte=carte;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}

		public Carte getCarte() {
			return carte;
		}
		
	}
	
	private Type choixType(int typeChoisi){
		switch(typeChoisi) {
			case 1:
				return Type.FEU;
			case 2:
				return Type.ESSENCE;
			case 3:
				return Type.ACCIDENT;
			case 4:
				return Type.CREVAISON;
			default:
				throw new IllegalArgumentException("Unexpected value: " + typeChoisi);
		}
	}
	
	private Configuration ajouterConfigProbleme(Type typePb,int pb) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Veuillez saisir le nom de la carte:\n");
		String nom=scanner.next();
		System.out.println("Veuillez saisir un nombre d'exemplaires de cette carte:\n");
		int nbExemplaires=scanner.nextInt();
		//ajoute le pb en fonction du pb
		switch(pb) {
			case 1:
				return new Configuration(new Attaque(typePb, nom), nbExemplaires);
			case 2:
				return new Configuration(new Parade(typePb, nom), nbExemplaires);
			case 3:
				return new Configuration(new Botte(typePb, nom), nbExemplaires);
			default:
				throw new IllegalArgumentException("Unexpected value: " + pb);
		}
	}
	
	public String choixNom() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Veuillez saisir le nom de la carte:\n");
		String nomCarte=scanner.next();
		return nomCarte;
	}
	
	public void initialiserJeu() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Nombre de cartes dans le jeu:\n");
		int nbCartes=scanner.nextInt();
		typesDeCartes=new Configuration[nbCartes];
		int nbExemplaires;
		String nom;
		
		for(int i=0;i<nbCartes;i++) {
			System.out.println("Veuillez choisir votre type de carte � ajouter:\n"
					+ " 1 - Probleme\n 2 - Limite\n 3 - Borne\n");
			int choixCarteUn=scanner.nextInt();
			
			switch (choixCarteUn) {
				case 1: 
					System.out.println("Veuillez choisir la catégorie de probleme de votre carte � ajouter:\n"
						+" 1 - Feu\n 2 - Essence \n 3 - Accident \n 4 - Crevaison");
				
					//attribution du type
					int choixType=scanner.nextInt();
					Type typeProbleme=choixType(choixType);
				
					//choix du probleme souhaite
					System.out.println("Veuillez choisir le probleme souhaité\n"
						+ " 1 - Attaque \n 2 - Parade\n 3 - Botte\n");
					int pbSouhaite=scanner.nextInt();
					
					//ajout du probleme
					typesDeCartes[i]=ajouterConfigProbleme(typeProbleme,pbSouhaite);
					break;
				case 2:
					System.out.println("Veuillez saisir le type de limit:\n"
							+ " 1 - Debut limite\n 2 - Fin Limite");
					int choixLim=scanner.nextInt();
					System.out.println("Veuillez saisir le nom:\n");
					nom=scanner.next();
					System.out.println("Veuillez saisir le nombre d'exemplaires:\n");
					nbExemplaires=scanner.nextInt();
					if(choixLim==1) {
						typesDeCartes[i]=new Configuration(new DebutLimite(nom), nbExemplaires);
					}else {
						typesDeCartes[i]=new Configuration(new FinLimite(nom), nbExemplaires);
					}
					break;
				case 3:
					System.out.println("Veuillez saisir la distance de la borne:\n");
					int km=scanner.nextInt();
					System.out.println("Veuillez saisir le nom:\n");
					nom=scanner.next();
					System.out.println("Veuillez saisir le nombre d'exemplaires:\n");
					nbExemplaires=scanner.nextInt();
					typesDeCartes[i]=new Configuration(new Borne(km,nom), nbExemplaires);
					break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + choixCarteUn);
			}

		}
	}
	
	public String affichageJeuCartes() {
		StringBuilder affichage=new StringBuilder();
		for(Configuration config: typesDeCartes ) {
			affichage.append(config.getNbExemplaires()+" "+config.getCarte().getNom()+"\n");
		}
		
		return affichage.toString();
	}
	
	public Carte[] donnerCartes() {
		int nbToTalCartes=0;
		
		for(int i=0;i<19;i++) {
			nbToTalCartes+=typesDeCartes[i].getNbExemplaires();
		}
		
		Carte[] cartes=new Carte[nbToTalCartes];
		
		int indiceCartes=0;
		
		for(int i=0;i<19;i++) {
			for(int j=0;j<typesDeCartes[i].getNbExemplaires();j++) {
				cartes[indiceCartes]=typesDeCartes[i].getCarte();
				indiceCartes++;
			}
		}
		
		return cartes;
	}

}

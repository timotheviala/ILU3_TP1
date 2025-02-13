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
	
	public void initialiserJeu() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Nombre de cartes dans le jeu:\n");
		int nbCartes=scanner.nextInt();
		typesDeCartes=new Configuration[nbCartes];
		
		for(int i=0;i<nbCartes;i++) {
			System.out.println("Veuillez choisir votre type de carte à ajouter:\n"
					+ "1 - Probleme\n 2 - Limite\n 3 - Borne\n");
			int choixCarteUn=scanner.nextInt();
			
			/*arreter ici*/
			switch (choixCarteUn) {
			case 1: {
				System.out.println("Veuillez choisir votre carte à ajouter:\n"
						+"1 - Feu Rouge\n 2 - Limitation 50 \n 3 - Panne Essence \n 4 - Crevaison");
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choixCarteUn);
			}
				
			
			System.out.println("Veuillez saisir un nombre d'exemplaires de cette carte:\n");
			int nbExemplaires=scanner.nextInt();
			typesDeCartes[i]=new Configuration(null, nbExemplaires)
		}
	}
	
	public String affichageJeuCartes() {
		StringBuilder affichage=new StringBuilder();
		affichage.append("JEU:\n");
		for(Configuration config: typesDeCartes ) {
			affichage.append(config.getNbExemplaires()+" "+config.getCarte()+"\n");
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

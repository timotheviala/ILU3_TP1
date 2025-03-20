package utils;
import java.util.*;

import cartes.*;

public class GestionCartes {
	
	public Carte extraire(Carte[] cartes) {
<<<<<<< HEAD
		//on r�cup�re un nombre al�atoire compris entre 0 et la taille de la liste
		Random rand = new Random();
		int indiceAleatoire=rand.nextInt(cartes.length);
		//on r�cup�re la carte al�atoire
		Carte carteChoisie=cartes[indiceAleatoire];
		//on d�cale tous les �l�emnts de 1
=======
		//on récupère un nombre aléatoire compris entre 0 et la taille de la liste
		Random rand = new Random();
		int indiceAleatoire=rand.nextInt(cartes.length);
		//on récupère la carte aléatoire
		Carte carteChoisie=cartes[indiceAleatoire];
		//on décale tous les éléemnts de 1
>>>>>>> 42cd2838128b6e659b35aafa41228470050ae0e8
		for(int i=indiceAleatoire;i<cartes.length-1;i++) {
			cartes[i]=cartes[i+1];
		}
		return carteChoisie;
	}
	
	public static Carte extraire(List<Carte> cartes) {
<<<<<<< HEAD
		//on r�cup�re un nombre al�atoire compris entre 0 et la taille de la liste
		Random rand = new Random();
		int indiceAleatoire=rand.nextInt(cartes.size());
		//on r�cup�re la carte al�atoire
		Carte carteChoisie=cartes.get(indiceAleatoire);
		//on supprime cette carte
		ListIterator<Carte> iter=cartes.listIterator(indiceAleatoire);
=======
		//on récupère un nombre aléatoire compris entre 0 et la taille de la liste
		Random rand = new Random();
		int indiceAleatoire=rand.nextInt(cartes.size());
		//on récupère la carte aléatoire
		Carte carteChoisie=cartes.get(indiceAleatoire);
		//on supprime cette carte
		ListIterator<Carte> iter=cartes.listIterator(indiceAleatoire);
		iter.next();
>>>>>>> 42cd2838128b6e659b35aafa41228470050ae0e8
		iter.remove();
		return carteChoisie;
	}

	public static List<Carte> melanger(List<Carte> cartes){
		List<Carte> newList=new ArrayList<>();
		for(ListIterator<Carte> iter=cartes.listIterator();iter.hasNext();) {
			Carte current=iter.next();
			newList.add(current);
			iter.remove();
		}
		return newList;
	}
	
	public static boolean verifierMelange(List<Carte> list1,List<Carte> list2) {
		for(ListIterator<Carte> iter=list1.listIterator();iter.hasNext();) {
			Carte current=iter.next();
			if(Collections.frequency(list1,current)!=Collections.frequency(list2,current)) {
				return false;
			}
		}
		return true;
	}
	
	public static List<Carte> rassembler(List<Carte> listeATrier) {
<<<<<<< HEAD
		//nouvelle liste triee
		List<Carte> listeTriee=new ArrayList<>();
		
		//parcours de la liste non triee
		for(ListIterator<Carte> iter=listeATrier.listIterator();iter.hasNext();) {
			Carte carte=iter.next();
			
			//deuxieme iterateur pour coller les �l�ments identiques
			for(ListIterator<Carte> iter2=iter;iter2.hasNext();) {
				Carte current=iter2.next();
				
				if(carte.equals(current)) {
					listeTriee.add(current);
					iter2.remove();
				}
			}
			iter.remove();
		}
		return listeTriee;
	}
	
	public static boolean verifierRassemblement(List<Carte> listeAVerifier) {
		//on r�cup�re le premier �l�ment pour intiialiser precedent
		ListIterator<Carte> iter=listeAVerifier.listIterator();
		Carte prec=iter.next();
		
		//on initialise un it�rateur pour parcourir la liste
=======
	    List<Carte> listeTriee = new ArrayList<>();
	    
	    // Copie pour éviter les erreurs
	    List<Carte> listeATrier2 = new ArrayList<>(listeATrier); 
	    
	    //tant qu'elle n'est pas vide on traite
	    while (!listeATrier2.isEmpty()) {
	    	
	    	//récupération de la premiere carte et ajout à la liste triee
	        Carte carte = listeATrier2.get(0);
	        listeTriee.add(carte);
	        //supprime la carte qu'on traitait
	        listeATrier2.remove(0); 
	        
	        //parcours à partir de l'élément suivant
	        ListIterator<Carte> iter = listeATrier2.listIterator(0);
	        while (iter.hasNext()) {
	            Carte current = iter.next();
	            if (current.equals(carte)) {
	                listeTriee.add(current);
	                iter.remove();
	            }
	        }
	    }
	    return listeTriee;
	}
	
	public static boolean verifierRassemblement(List<Carte> listeAVerifier) {
		//on récupère le premier élément pour intiialiser precedent
		ListIterator<Carte> iter=listeAVerifier.listIterator();
		Carte prec=iter.next();
		//on initialise un itérateur pour parcourir la liste
>>>>>>> 42cd2838128b6e659b35aafa41228470050ae0e8
		ListIterator<Carte> iter1=listeAVerifier.listIterator();
		//on se positionne au deuxieme element pour commencer
		for(iter1.next();iter1.hasNext();) {
			Carte current=iter1.next();
			
<<<<<<< HEAD
			//si jamais le precedent est diff�rent du courant on v�rifie que le pr�c�dent n'est plus dans la liste
			if(!(prec.equals(current))) {	
				//on initialise un deuxi�me it�rateur pour parcourir le reste de la liste
				for(ListIterator<Carte> iter2=iter1;iter2.hasNext();) {
					Carte currentSecond=iter2.next();	
					if(current.equals(currentSecond)) {
=======
			//si jamais le precedent est différent du courant on vérifie que le précédent n'est plus dans la liste
			if(!(prec.equals(current))) {	
				//on initialise un deuxième itérateur pour parcourir le reste de la liste
				for(ListIterator<Carte> iter2=iter1;iter2.hasNext();) {
					Carte currentSecond=iter2.next();	
					if(prec.equals(currentSecond)) {
>>>>>>> 42cd2838128b6e659b35aafa41228470050ae0e8
						return false;
					}
				}
			}
			
<<<<<<< HEAD
			//avant de passer � l'�l�ment suivant on actualise prec
=======
			//avant de passer à l'élément suivant on actualise prec
>>>>>>> 42cd2838128b6e659b35aafa41228470050ae0e8
			prec=current;
		}
		return true;
	}
}



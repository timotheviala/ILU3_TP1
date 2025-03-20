package utils;
import java.util.*;

import cartes.*;

public class GestionCartes {
	
	public Carte extraire(Carte[] cartes) {
		//on r�cup�re un nombre al�atoire compris entre 0 et la taille de la liste
		Random rand = new Random();
		int indiceAleatoire=rand.nextInt(cartes.length);
		//on r�cup�re la carte al�atoire
		Carte carteChoisie=cartes[indiceAleatoire];
		//on d�cale tous les �l�emnts de 1
		for(int i=indiceAleatoire;i<cartes.length-1;i++) {
			cartes[i]=cartes[i+1];
		}
		return carteChoisie;
	}
	
	public static Carte extraire(List<Carte> cartes) {
		//on r�cup�re un nombre al�atoire compris entre 0 et la taille de la liste
		Random rand = new Random();
		int indiceAleatoire=rand.nextInt(cartes.size());
		//on r�cup�re la carte al�atoire
		Carte carteChoisie=cartes.get(indiceAleatoire);
		//on supprime cette carte
		ListIterator<Carte> iter=cartes.listIterator(indiceAleatoire);
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
		ListIterator<Carte> iter1=listeAVerifier.listIterator();
		//on se positionne au deuxieme element pour commencer
		for(iter1.next();iter1.hasNext();) {
			Carte current=iter1.next();
			
			//si jamais le precedent est diff�rent du courant on v�rifie que le pr�c�dent n'est plus dans la liste
			if(!(prec.equals(current))) {	
				//on initialise un deuxi�me it�rateur pour parcourir le reste de la liste
				for(ListIterator<Carte> iter2=iter1;iter2.hasNext();) {
					Carte currentSecond=iter2.next();	
					if(current.equals(currentSecond)) {
						return false;
					}
				}
			}
			
			//avant de passer � l'�l�ment suivant on actualise prec
			prec=current;
		}
		return true;
	}
}



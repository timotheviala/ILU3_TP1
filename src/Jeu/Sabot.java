package Jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot <T extends Carte> implements Iterable<T>{
	private T[] sabot;
	private int nbCartes;
	private int nbOperations=0;
	
	public Sabot(T[] sabot) {
		this.sabot=sabot;
		this.nbCartes=sabot.length;
	}

	public Iterator<T> iterator(){
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<T>{
		private int indiceIterateur=0;
		private boolean nextEffectue=false;
		private int nbOperationsRef=nbOperations;
		
		public boolean hasNext() {
			return indiceIterateur<nbCartes;
		}
		
		public T next() {
			verificationConcurrence();
			if(hasNext()) {
				indiceIterateur++;
				nextEffectue=true;
				return sabot[indiceIterateur-1];
			}
			throw new NoSuchElementException();
		}
		
		public void remove() {
			verificationConcurrence();
			if(!nextEffectue) {
				throw new IllegalStateException();
			}
			for(int i=indiceIterateur-1;i<nbCartes-1;i++) {
				sabot[i]=sabot[i+1];
			}
			nbOperations++;
			nbOperationsRef++;
			nbCartes--;
			nextEffectue=false;
		}
		
		private void verificationConcurrence() {
			if(nbOperations!=nbOperationsRef) {
				throw new ConcurrentModificationException();
			}
		}
	}
	
	public boolean estVide() {
		return nbCartes==0;
	}
	
	public void ajouterCarte(T carte) throws ArrayIndexOutOfBoundsException{
		if(nbCartes==sabot.length-1) {
			throw new ArrayIndexOutOfBoundsException();
		}
		sabot[nbCartes]=carte;
		nbCartes++;
	}
	
	public T piocher() {
		Iterator<T> it=iterator();
		T cartePiochee=it.next();
		it.remove();
		return cartePiochee;
	}
}

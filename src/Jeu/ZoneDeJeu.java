package Jeu;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NavigableSet;
import java.util.Set;


import cartes.*;

public class ZoneDeJeu {

	private LinkedList<Limite> limitesVitesse=new LinkedList<>();
	private LinkedList<Bataille> attaquesParades=new LinkedList<>();
	private Set<Borne> bornes=new HashSet<>();
	
	public int donnerLimitationVitesse() {
		if(limitesVitesse.isEmpty()) {
			return 200;
		}
		Limite limite=limitesVitesse.remove();
		if(limite instanceof FinLimite) {
			return 200;
		}
		return 50;
	}
	
	public int donnerKmParcourus() {
		int kmParcourus=0;
		for(Iterator<Borne> it=bornes.iterator();it.hasNext();) {
			Borne borne=it.next();
			kmParcourus+=borne.getKm();
		}
		return kmParcourus;
	}
	
	public void deposer(Carte c) {
		if(c instanceof Borne) {
			Borne borne=(Borne) c;
			bornes.add(borne);
		} else if(c instanceof Limite) {
			Limite limite=(Limite) c;
			limitesVitesse.add(limite);
		}else {
			Bataille bataille=(Bataille) c;
			attaquesParades.add(bataille);
		}
	}
	
	public boolean peutAvancer() {
		//rajouer
		if(!attaquesParades.isEmpty()) {
			System.out.println(attaquesParades.getFirst().getNom());
		}
		//end
	    return !attaquesParades.isEmpty() && !(attaquesParades.getLast() instanceof Attaque) && attaquesParades.getLast().getType() == Type.FEU && "FeuVert".equals(attaquesParades.getLast().getType().getParade());
	}

	public boolean estDepotFeuVertAutorise() {
	    return attaquesParades.isEmpty() || 
	           attaquesParades.getLast().getType().getAttaque().equals("FeuRouge") ||
	           !attaquesParades.getLast().getType().getParade().equals("FeuVert");
	}


	public boolean estDepotBorneAutorise(Borne borne) {
	    return peutAvancer() && (donnerLimitationVitesse() > borne.getKm()) && (donnerKmParcourus() + borne.getKm() < 1000);
	}

	public boolean estDepotLimiteAutorise(Limite limite) {
	    if (limite instanceof DebutLimite) {
	    	//rajouter
	    	if(limitesVitesse.isEmpty()) {
	    		System.out.println("ok pr debut limte");
	    	}
	    	//end
	        return limitesVitesse.isEmpty() || (limitesVitesse.getLast() instanceof FinLimite);
	    }
	    //rajouter
	    if(!limitesVitesse.isEmpty()) {
    		System.out.println(limitesVitesse.getLast().getNom());
    	}else {
    		System.out.println("vide");
    	}
	    //end
	    return !limitesVitesse.isEmpty() && limitesVitesse.getLast() instanceof DebutLimite;
	}

	public boolean estDepotBatailleAutorise(Bataille bataille) {
	    if (bataille instanceof Attaque) {
	        return peutAvancer();
	    }
	    if (bataille.getType() == Type.FEU && "FeuVert".equals(bataille.getType().getParade())) {
	        return estDepotFeuVertAutorise();
	    }
	    return !attaquesParades.isEmpty() && attaquesParades.getLast().getType() == bataille.getType();
	}

	public boolean estDepotAutorise(Carte carte) {
	    if (carte instanceof Borne) {
	        return estDepotBorneAutorise((Borne) carte);
	    }
	    if (carte instanceof Limite) {
	        return estDepotLimiteAutorise((Limite) carte);
	    }
	    return estDepotBatailleAutorise((Bataille) carte);
	}

}

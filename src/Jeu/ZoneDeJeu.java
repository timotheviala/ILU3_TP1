package Jeu;
import java.util.ArrayList;
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
	private Set<Botte> bottes=new HashSet<>();
	
	public int donnerLimitationVitesse() {
		if(limitesVitesse.isEmpty() || estPrioritaire()) {
			return 200;
		}
		Limite limite=limitesVitesse.getLast();
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
			Limite limite;
			if(c instanceof DebutLimite) {
				limite=(DebutLimite) c;
			}else {
				limite=(FinLimite) c;
			}
			limitesVitesse.add(limite);
		}else if(c instanceof Bataille) {
			Bataille bataille;
			if(c instanceof Attaque) {
				bataille=(Attaque) c;
			}else {
				bataille=(Parade) c;
			}
			attaquesParades.add(bataille);
			System.out.println(bataille.getType().getBotte());
		}else {
			Botte botte=(Botte) c;
			if(c.getNom()=="AsDuVolant") {
				System.out.println("Type: "+botte.getType()+" Nom: "+botte.getNom());
			}
			bottes.add(botte);
			Botte newelle=new Botte(botte.getType(),botte.getNom());
			System.out.println(bottes.contains(newelle));
			System.out.println("---egalite: "+botte.equals(new Botte(Type.ACCIDENT,"AsDuVolant"))+"------Apres ajout:"+bottes.contains(new Botte(Type.ACCIDENT,"AsDuVolant")));
		}
	}
	
	private boolean lastCond() {
		if(!attaquesParades.isEmpty()) {
		System.out.println("Bottes:"+bottes+" Derniere attaque:"+attaquesParades.getLast().getType().toString());}
		System.out.println(bottes.contains(new Botte(Type.FEU,"AsDuVolant")));
		System.out.println("Contient une carte AsDuVolant de type accident:"+bottes.contains(new Botte(Type.ACCIDENT,"AsDuVolant")));
		System.out.println(!attaquesParades.isEmpty() && (attaquesParades.getLast() instanceof Attaque) && !(bottes.isEmpty()) && estPrioritaire()
				&& bottes.contains(new Botte(attaquesParades.getLast().getType(),attaquesParades.getLast().getType().getBotte())));
		return (!attaquesParades.isEmpty() && (attaquesParades.getLast() instanceof Attaque) && !(bottes.isEmpty()) && estPrioritaire()
				&& bottes.contains(new Botte(attaquesParades.getLast().getType(),attaquesParades.getLast().getType().getBotte())));
	}
	
	public boolean peutAvancer() {
	    return (attaquesParades.isEmpty() && estPrioritaire())
	    		|| (!attaquesParades.isEmpty() && (attaquesParades.getLast() instanceof Parade) && estPrioritaire() ) 
	    		 || (!attaquesParades.isEmpty() && attaquesParades.getLast().getType() == Type.FEU && "FeuVert".equals(attaquesParades.getLast().getNom()))
	    		 || (!attaquesParades.isEmpty() && (attaquesParades.getLast() instanceof Attaque) && attaquesParades.getLast().getType() == Type.FEU && estPrioritaire())
	    		 || lastCond();
	}

	public boolean estDepotFeuVertAutorise() {
		if(estPrioritaire()){
			return false;
		}
	    return attaquesParades.isEmpty() || 
	           attaquesParades.getLast().getType().getAttaque().equals("FeuRouge") ||
	           !attaquesParades.getLast().getType().getParade().equals("FeuVert")
	           || bottes.contains(new Botte(attaquesParades.getLast().getType(),attaquesParades.getLast().getType().getParade()));
	}


	public boolean estDepotBorneAutorise(Borne borne) {
	    return peutAvancer() && (donnerLimitationVitesse() > borne.getKm()) && (donnerKmParcourus() + borne.getKm() < 1000);
	}

	public boolean estDepotLimiteAutorise(Limite limite) {
		if(estPrioritaire()) {
			return false;
		}
	    if (limite instanceof DebutLimite) {
	        return limitesVitesse.isEmpty() || (limitesVitesse.getLast() instanceof FinLimite);
	    }
	    return !limitesVitesse.isEmpty() && limitesVitesse.getLast() instanceof DebutLimite;
	}

	public boolean estDepotBatailleAutorise(Bataille bataille) {
		if(bottes.contains(new Botte(bataille.getType(), bataille.getType().getParade()))){
			return false;
		}
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
	    return (carte instanceof Botte)||(estDepotBatailleAutorise((Bataille) carte)) ;
	}
	
	public boolean estPrioritaire() {
		return bottes.contains(Cartes.PRIORITAIRE);
	}

}

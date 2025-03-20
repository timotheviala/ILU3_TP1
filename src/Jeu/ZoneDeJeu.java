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
}

package Jeu;

import cartes.*;

public interface Cartes {
	public static final Botte PRIORITAIRE=new Botte(Type.FEU,"V�hiculePrioritaire");
	public static final Attaque FEU_ROUGE=new Attaque(Type.FEU,"FeuRouge");
	public static final Parade FEU_VERT=new Parade(Type.FEU,"FeuVert");	
}

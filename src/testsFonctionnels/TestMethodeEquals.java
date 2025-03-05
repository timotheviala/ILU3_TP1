package testsFonctionnels;

import cartes.*;

public class TestMethodeEquals {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//comparaison de deux bornes 25
		Borne borne1=new Borne(25,"borne25");
		Borne borne2=new Borne(25,"borne25");
		System.out.println("Comparaison entre deux bornes : "+borne1.equals(borne2));
		
		//comparaison entre deux feux rouge
		Type type=Type.FEU;
		Attaque attaque1=new Attaque(type, "FeuRouge");
		Attaque attaque2=new Attaque(type, "FeuRouge");
		System.out.println("Comparaison entre deux feu rouge : "+attaque1.equals(attaque2));
		
		//comparaison entre une carte feu vert et une carte feu rouge
		Attaque feuRouge=new Attaque(type,"FeuRouge");
		Attaque feuVert=new Attaque(type,"FeuVert");
		System.out.println("Comparaison entre un feu vert et un feu rouge : "+feuRouge.equals(feuVert));

	}

}

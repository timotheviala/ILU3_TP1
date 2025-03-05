package cartes;

public enum Type {
	FEU("FeuVert","FeuRouge","VehiculePrioritaire"),ESSENCE("Essence","PanneEssence","Citerne"),CREVAISON("RoueDeSecours","Crevaison","Increvable"),ACCIDENT("R�parations","Accident","AsDuVolant");
	
	private String parade;
	private String attaque;
	private String botte;
	
	Type(String parade,String attaque,String botte){
		this.parade=parade;
		this.attaque=attaque;
		this.botte=botte;
	}

	public String getParade() {
		return parade;
	}

	public String getAttaque() {
		return attaque;
	}

	public String getBotte() {
		return botte;
	}
	
	
	
}

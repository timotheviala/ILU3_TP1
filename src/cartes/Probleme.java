package cartes;

public abstract class Probleme extends Carte {
	private Type type;
	
	public Probleme(Type type,String nom) {
		super(nom);
		this.type=type;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return super.getNom();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Probleme) {
			Probleme carteAComparer=(Probleme) obj;
			return type.equals(carteAComparer.getType()) && carteAComparer.getNom().equals(nom);
		}
		return false;
	}
	
	
}

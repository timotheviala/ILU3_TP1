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
	
	
	
}

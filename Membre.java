package fr.voxi.administration;

public class Membre extends Utilisateur{
	private boolean bloque = false ;

	public Membre(String nom, String prenom, String email, String mdp, int etat,  boolean bloque) {
		super(nom, prenom, email, mdp, etat);
		this.bloque = bloque;
	}
	
	public boolean seConnecter(String email, String mdp) {
		if( this.getEtat() == DECONNECTE  ){
			if (email == this.getEmail() && mdp == this.getMdp()) {
				this.setEtat(CONNECTE) ;
				return true ;
			}
		}
		return false ;
		
	}
	public boolean isBloque() {
		return bloque;
	}


	public void setBloque(boolean bloque) {
		this.bloque = bloque;
	}

		

	@Override
	public String toString() {
		return "Membre [bloque=" + bloque + "]";
	}


	public void visuNotif(String msg) {
		System.out.println(msg);
	}
	
}

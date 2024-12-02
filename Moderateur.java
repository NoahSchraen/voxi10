package fr.voxi.administration;

public class Moderateur extends Utilisateur implements Administrateur{
	private String login ;
	private int nbAlertesEnvoyees ;
	
	
	public Moderateur(String nom, String prenom, String email, String mdp, int etat,  String login, int nbAlertesEnvoyees) {
		super(nom, prenom, email, mdp, etat);
		this.login = login;
		this.nbAlertesEnvoyees = nbAlertesEnvoyees;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public int getNbAlertesEnvoyees() {
		return nbAlertesEnvoyees;
	}


	public void setNbAlertesEnvoyees(int nbAlertesEnvoyees) {
		this.nbAlertesEnvoyees = nbAlertesEnvoyees;
	}
	
	public void bloquer(Membre mb) {
		mb.setBloque(true);
	}
	
	public void debloquer(Membre mb) {
		mb.setBloque(false);
	}
	
	
	public void alerter(Membre mb, String msg) {
		mb.visuNotif(msg);
		this.nbAlertesEnvoyees = this.nbAlertesEnvoyees + 1 ;
	}
	
	public boolean seConnecter(String login , String mdp) {
		if (login == this.login && mdp == this.getMdp() && this.getEtat() == DECONNECTE) {
			this.setEtat(CONNECTE);
			return true ;
		}
		else {
			return false ;
		}
	}
	
}


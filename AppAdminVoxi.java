package fr.voxi.administration;
import java.util.ArrayList;
public class AppAdminVoxi {

	public static void main(String[] args) {
		
		//1
		System.out.println("Exercice 1 :\n");
		ArrayList<Utilisateur> utilisateurs = new ArrayList<>() ;
		Utilisateur util1 = new Membre("ZAKI", "Selma", "s.zaki@gns.fr", "azerty", Utilisateur.DECONNECTE, false);
		Utilisateur util2 = new Moderateur("LEBRETON", "Jules", "j.lebreton@gmail.com", "azerty", Utilisateur.DECONNECTE, "jbreton", 33);
		Utilisateur util3 = new Moderateur("BA", "Béchir", "bechir.ba@gmail.com", "azerty", Utilisateur.CONNECTE, "bba", 103);
		Utilisateur util4 = new Membre("CAMOIT", "Alexis", "a.camoit@gns.fr", "azerty", Utilisateur.DECONNECTE, false);
		Utilisateur util5 = new Membre("Karim", "Lamia", "l.karim@gns.fr", "azerty", Utilisateur.CONNECTE, true);
		Utilisateur util6 = new Moderateur("ESSAMAMI", "Hamza", "hamza.mami@free.fr", "azerty", Utilisateur.DECONNECTE, "hessa", 8);
		
		utilisateurs.add(util1);
		utilisateurs.add(util2);
		utilisateurs.add(util3);
		utilisateurs.add(util4);
		utilisateurs.add(util5);
		utilisateurs.add(util6);
		System.out.println(utilisateurs);
		
		System.out.println("\n");
		
		//2
		System.out.println("Exercice 2 :\n");
		for (Utilisateur util : utilisateurs) {
			System.out.print(util.getNom() + " ");
			System.out.println(util.getPrenom());
		}
		
		System.out.println("\n");
		
		//3
		System.out.println("Exercice 3 :\n");
		int count = 0 ;
		for (Utilisateur util : utilisateurs) {
			if(util.getEtat() == 1) {
				count = count + 1 ;
			}
		}
		System.out.println( count + " personne(s) connecté(es)");
		
		System.out.println("\n");
		
		//4
		System.out.println("Exercice 4 :\n");
		for (Utilisateur util : utilisateurs) {
			util.seDeconnecter();
			System.out.print(util.getNom());
			System.out.println(" " + util.getEtat());
		}
		
		System.out.println("\n");
		
		//5
		System.out.println("Exercice 5 :\n");
		util2.seConnecter("jberto", "azerty");
		if (util2.getEtat() == 1 ) {
			System.out.println("L'authentification a reussie.");
		}
		else {
			System.out.println("L'authentification a échoué.");
		}
		
		System.out.println("\n");
		
		//6
		System.out.println("Exercice 6 :\n");
		util1.seConnecter("s.zaki@gns.fr", "azerty") ;
		if (util1.getEtat() == 1 ) {
			System.out.println("L'authentification a reussie.");
		}
		else {
			System.out.println("L'authentification a échoué.");
		}
		
		System.out.println("\n");
		
		//7
		System.out.println("Exercice 7 : \n");
		for ( Utilisateur util : utilisateurs) {
		if (util instanceof Moderateur) {
			util.seConnecter(((Moderateur)(util)).getLogin(), util.getMdp()) ;
				if ( util.getEtat() == 1) {
					System.out.println("L'authentification a reussie pour le modérateur " + util.getNom() + " " + util.getPrenom());
				}
				else {
					System.out.println("L'authentification a échoué pour le modérateur " + util.getNom() + " " + util.getPrenom());
				}
			}
			else {
				util.seConnecter(util.getEmail(), util.getMdp()) ;
				if ( util.getEtat() == 1) {
					System.out.println("L'authentification a reussie pour le membre " + util.getNom() + " " + util.getPrenom());
				}
				else {
					System.out.println("L'authentification a échoué pour le membre " + util.getNom() + " " + util.getPrenom());
				}
			}
		}
		
		System.out.println("\n");
		
		//8
		System.out.println("Exercice 8 :\n");
		((Moderateur)(util2)).debloquer(((Membre)(util4)));
		util4.seConnecter(util4.getEmail(), util4.getMdp());
		if ( util4.getEtat() == 1) {
			System.out.println("L'authentification a reussie pour l'utilisateur " + util4.getNom() + " " + util4.getPrenom());
		}
		else {
			System.out.println("L'authentification a échoué");
		}
		
		System.out.println("\n");
		
		//9
		System.out.println("Exercice 9 :\n");
		((Moderateur)(util6)).bloquer(((Membre)(util1)));
		util1.seConnecter(util1.getEmail(), util1.getMdp());
		if ( util1.getEtat() == 1) {
			System.out.println("L'authentification a reussie pour l'utilisateur " + util1.getNom() + " " + util1.getPrenom());
		}
		else {
			System.out.println("L'authentification a échoué");
		}
		

	}

}

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
/**
 *
 * @author bellenga
 */
public class Emprunt implements Serializable 
{
	
	private static final long serialVersionUID = 422L;
	
	// -----------------------------------------------
		//Attributs
	// -----------------------------------------------
	
		private Lecteur _lecteur;
		private Exemplaire _exemplaire;
		private GregorianCalendar _dateEmprunt;
                private GregorianCalendar _dateRetour;
  
	
	
	// -----------------------------------------------
		//Constructeur
	// -----------------------------------------------
		
		public Emprunt(Lecteur l, Exemplaire e, GregorianCalendar dateEmprunt, GregorianCalendar dateRetour)
		{
			this.setLecteur(l);
			this.setExemplaire(e);
			this.setDateEmprunt(dateEmprunt);
			this.setDateRetour(dateRetour);
		}
		
// -----------------------------------------------
	// Public
// -----------------------------------------------
                
                // -----------------------------------------------
			//Getters
		// -----------------------------------------------
	
		public Lecteur getLecteur() {
			return _lecteur;
		}

		public Exemplaire getExemplaire() {
			return _exemplaire;
		}
                
                public GregorianCalendar getDateEmprunt() {
			return _dateEmprunt;
		}

		public GregorianCalendar getDateRetour() {
			return _dateRetour;
		}
                
                // -----------------------------------------------
                
		  public void supEmprunt()
                {
                    Lecteur l = unLecteur();
                    Exemplaire e = unExemplaire();
                    this.delierExemplaire();
                    this.delierLecteur();
                    l.supEmprunt();
                }
                
                // cette méthode calcule la différence entre la date de retour et la date du jour d'un emprunt. Si le résultat est supérieur à 15, retourne retard:=true
                public boolean verifEmprunt(dateRetour)
                {
                    getDateRetour();
                    
                    
                    return
                }
                
                
		// -----------------------------------------------
			//Getters
		// -----------------------------------------------
	
		public Lecteur unLecteur() {
			return _lecteur;
		}

		public Exemplaire unExemplaire() {
			return _exemplaire;
		}

		public GregorianCalendar getDateEmprunt() {
			return _dateEmprunt;
		}
		
		public GregorianCalendar getDateRetour() {
			return _dateRetour;
		}
                
		// -----------------------------------------------
			// Methodes
		// -----------------------------------------------
		
		/*
		 * La m�thode afficherEmprunt affiche l'ensemble des informations relatives � un emprunt.
		 */
		public void afficherEmprunt()           //à renommer selon l'envie
		{
			System.out.println("Lecteur : " + this.unLecteur());               //je doute que ça marche comme ça mais à voir
			System.out.println("Exemplaire: " + this.unExemplaire());
			System.out.println("Date d'emprunt : " + this.getDateEmprunt());
			System.out.println("Date de retour : " + this.getDateRetour());
			EntreesSorties.afficherMessage("");
		}
		
                /*
                * Methode utilisée pour le use case ConsulterExemplaireOuvrage
                */
		public void infosEmpruntExemplaire()  
		{
                    System.out.println("Date d'emprunt : " + this.getDateEmprunt());
                    System.out.println("Date de retour : " + this.getDateRetour());
                    EntreesSorties.afficherMessage("");
                    l.infosReduitLecteur();
                }
	
	
// -----------------------------------------------
	// Private
// -----------------------------------------------

		// -----------------------------------------------
			//Setters
		// -----------------------------------------------

		private void setLecteur(Lecteur l) {
			this._lecteur = l;
		}

		private void setExemplaire(Exemplaire e) {
			this._exemplaire = e;
		}
		
		private void setDateEmprunt(GregorianCalendar dateEmprunt) {
            
			this._dateEmprunt = dateEmprunt;
		}

		private void setDateRetour(GregorianCalendar dateRetour) {
			this._dateRetour = dateRetour;
		}
                
                // -----------------------------------------------
			// Methodes
		// -----------------------------------------------
                
                /*
                
                */
                private void lierLecteur(Lecteur l)
                {
                    _lecteur=l;
                }
                
                private void lierExemplaire(Exemplaire e)
                {
                    _exemplaire=e;
                }
                
                private void delierExemplaire()
                {
                   _exemplaire=null; 
                }
                 
                private void delierLecteur()
                {
                    _lecteur=null;
                }
                
                
}

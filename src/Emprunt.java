import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;

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
        this.lierLecteur(l);
        this.lierExemplaire(e);
    }
		
// -----------------------------------------------
	// Public
// -----------------------------------------------
                
        // -----------------------------------------------
		//Getters
	// -----------------------------------------------
	
	public Lecteur unLecteur() 
        {
            return _lecteur;
	}

	public Exemplaire unExemplaire() 
        {
            return _exemplaire;
	}
                
        public GregorianCalendar getDateEmprunt() 
        {
            return _dateEmprunt;
	}

	public GregorianCalendar getDateRetour() 
        {
            return _dateRetour;
	}
                
        // -----------------------------------------------
		// Methodes
	// -----------------------------------------------
        
        // cette méthode permet de supprimer un emprunt de son lecteur et de son exemplaire
	public void supEmprunt()
        {
            Lecteur l = unLecteur();
            Exemplaire e = unExemplaire();
            this.delierExemplaire();
            this.delierLecteur();
            l.supEmprunt();
        }
                
        // cette méthode calcule la différence entre la date de retour et la date du jour d'un emprunt. Si le résultat est supérieur à 15, retourne retard:=true
        public boolean verifEmprunt()
        {
            GregorianCalendar dateReception = new GregorianCalendar();                    
            GregorianCalendar dateRetourEstime= new GregorianCalendar(_dateRetour.get(GregorianCalendar.YEAR), _dateRetour.get(GregorianCalendar.MONTH),_dateRetour.get(GregorianCalendar.DAY_OF_MONTH));
            Boolean test;
            Boolean retard=false;
            Integer anneeRetard= dateRetourEstime.get(GregorianCalendar.YEAR)-_dateRetour.get(GregorianCalendar.YEAR);
            Integer moisRetard = dateRetourEstime.get(GregorianCalendar.MONTH)-_dateRetour.get(GregorianCalendar.MONTH);
            Integer jourRetard = dateRetourEstime.get(GregorianCalendar.DAY_OF_MONTH)-_dateRetour.get(GregorianCalendar.DAY_OF_MONTH);
              
            if(anneeRetard>1 || moisRetard >1 || jourRetard>=15){
                return retard=true;
            }
            else{
                return retard=false;
            }
        }
               
        public void afficheRetard()
        {
            Exemplaire e = unExemplaire();
            e.infosReduitOuvrage();
            e.infosEmpruntExemplaire();
        }
		  
	//Miléna : a priori cette méthode est en double mais un autre oeil peut vérifier avant de supprimer? :)
        /*
 	 * La m�thode afficherEmprunt affiche l'ensemble des informations relatives � un emprunt.
 	 */
//	public void afficherEmprunt()
//	{
//            System.out.println("Lecteur : " + this.unLecteur());               
//            System.out.println("Exemplaire: " + this.unExemplaire());
//            System.out.println("Date d'emprunt : " + this.getDateEmprunt());
//            System.out.println("Date de retour : " + this.getDateRetour());
//            EntreesSorties.afficherMessage("");
//	}
		
        /*
         * Methode utilisée pour le use case ConsulterExemplaireOuvrage (méthode appelée par exemplaire)
         */
	public void infosEmpruntExemplaire()  
	{
            Lecteur l = unLecteur();
            l.infosReduitLecteur();
            
            GregorianCalendar dateEmprunt = this.getDateEmprunt();
            GregorianCalendar dateRetour = this.getDateRetour();
            
            System.out.println("Date d'emprunt : " + dateEmprunt.get(GregorianCalendar.DAY_OF_MONTH) + "/" + dateEmprunt.get(GregorianCalendar.MONTH) + "/" + dateEmprunt.get(GregorianCalendar.YEAR));
            System.out.println("Date de retour : " + dateRetour.get(GregorianCalendar.DAY_OF_MONTH) + "/" + dateRetour.get(GregorianCalendar.MONTH) + "/" + dateRetour.get(GregorianCalendar.YEAR));
            EntreesSorties.afficherMessage("");
        }
        
        /*
         * Methode utilisée pour le use case ConsulterLecteur (methode appelée par lecteur)
         */
        public void infosEmprunt()
        {
            Exemplaire e = unExemplaire();
            
            GregorianCalendar dateEmprunt = this.getDateEmprunt();
            GregorianCalendar dateRetour = this.getDateRetour();
            
            System.out.println("Date d'emprunt : " + dateEmprunt.get(GregorianCalendar.DAY_OF_MONTH) + "/" + dateEmprunt.get(GregorianCalendar.MONTH) + "/" + dateEmprunt.get(GregorianCalendar.YEAR));
            System.out.println("Date de retour : " + dateRetour.get(GregorianCalendar.DAY_OF_MONTH) + "/" + dateRetour.get(GregorianCalendar.MONTH) + "/" + dateRetour.get(GregorianCalendar.YEAR));
            EntreesSorties.afficherMessage("");
            e.infosEmprunt();
        }     
        
        // cette méthode permet de lier un emprunt à son lecteur et son exemplaire
        public void ajouterEmprunt(Lecteur l, Exemplaire e)
        {
            l.ajouterEmprunt(this);
            e.ajouterEmprunt(this);
        }
	
// -----------------------------------------------
	// Private
// -----------------------------------------------

	// -----------------------------------------------
		//Setters
	// -----------------------------------------------

	private void setLecteur(Lecteur l) 
        {
            this._lecteur = l;
	}

	private void setExemplaire(Exemplaire e) 
        {
            this._exemplaire = e;
	}
		
	private void setDateEmprunt(GregorianCalendar dateEmprunt) 
        {
            this._dateEmprunt = dateEmprunt;
	}

	private void setDateRetour(GregorianCalendar dateRetour) 
        {
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

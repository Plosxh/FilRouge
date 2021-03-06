import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;

// Classe de gestion des Exemplaires

public class Exemplaire implements Serializable 
{
	
    private static final long serialVersionUID = 422L;
	
// -----------------------------------------------
	//Attributs
// -----------------------------------------------
	
    private Integer _numExemplaire;
    private GregorianCalendar _dateReception;
    private Boolean _empruntable;
    private Boolean _disponibilite;
    private Ouvrage _ouvrage;
    private Emprunt _emprunt;
	
// -----------------------------------------------
        //Constructeur
// -----------------------------------------------
		
    public Exemplaire(Integer numExemplaire, GregorianCalendar dateReception, Boolean empruntable, Boolean disponibilite, Ouvrage o)
    {
	this.setNumExemplaire(numExemplaire);
	this.setDateReception(dateReception);
        this.setEmpruntable(empruntable);
        this.setDisponibilite(disponibilite);
        this.lierOuvrage(o);
    }
		
// -----------------------------------------------
	// Public
// -----------------------------------------------
                
	// -----------------------------------------------
		//Getters
	// -----------------------------------------------
	
	public Integer getNumExemplaire() 
        {
            return _numExemplaire;
	}
                
        public GregorianCalendar getDateReception() 
        {
            return _dateReception;
	}
                
        public Boolean getEmpruntable() 
        {
            return _empruntable;
	}
                
        public Boolean getDisponibilite() 
        {
            return _disponibilite;
        }
                
        public Ouvrage unOuvrage()
        {
            return _ouvrage;
        }

        public Emprunt unEmprunt() 
        {
            return _emprunt;
        }
 
	// -----------------------------------------------
		// Methodes
	// -----------------------------------------------
		
	public void infosExemplaire()
	{
            System.out.println("Numéro Exemplaire  : " + this.getNumExemplaire());
            System.out.println("Date de réception  : " + EntreesSorties.ecrireDate(getDateReception()));
            System.out.println("Empruntable        : " + this.getEmpruntable());
            System.out.println("Disponibilité      : " + this.getDisponibilite());
            EntreesSorties.afficherMessage("");
            }
                
        public void infosEmpruntExemplaire()
        {
            Emprunt em = unEmprunt();
            em.infosEmpruntExemplaire();
        }
                
        public void infosEmprunt()
        {
            Ouvrage o = unOuvrage();
            o.infosReduitOuvrage();
            System.out.println("Numéro Exemplaire  : " + this.getNumExemplaire());
            EntreesSorties.afficherMessage("");
        }
                
        public void supEmprunt()
        {
            Emprunt em = unEmprunt();
            em.supEmprunt();
            this.setDisponibilite(true);
        }
                
        public void ajouterEmprunt(Emprunt em)
        {
            lierEmprunt(em);
            this.setDisponibilite(false);
        }
              
        public void infosReduitOuvrage()
        {
            Ouvrage o = unOuvrage();
            o.infosReduitOuvrage();
        }
                
        public void editerExemplaire(boolean empruntable)
        {
            this.setEmpruntable(empruntable);
        }
       
// -----------------------------------------------
	// Private
// -----------------------------------------------

        // -----------------------------------------------
		// Methodes
	// -----------------------------------------------
        
        /*
         * La méthode lierOuvrage permet d'ajouter un ouvrage a la base de donnée de Exemplaire.
         */
        private void lierOuvrage(Ouvrage o)
        {
            _ouvrage=o;
        } 
                
        // -----------------------------------------------
                //Setters
	// -----------------------------------------------

	private void setNumExemplaire(Integer numExemplaire) 
        {
            this._numExemplaire = numExemplaire;
	}
		
        private void setDateReception(GregorianCalendar dateReception) 
        {
            this._dateReception = dateReception;
	}
                
	private void setEmpruntable(Boolean empruntable)
        {
            this._empruntable = empruntable;
	}
                
	private void setDisponibilite(Boolean disponibilite)
        {
            this._disponibilite = disponibilite;
	}
			
        private void lierEmprunt(Emprunt e)
        {
            this._emprunt = e;
	}
    }

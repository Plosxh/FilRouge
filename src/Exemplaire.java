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
	
		public Integer getNumExemplaire() {
			return _numExemplaire;
		}
                
                public GregorianCalendar getDateReception() {
			return _dateReception;
		}
                
                public Boolean getEmpruntable() {
			return _empruntable;
		}
                
                public Boolean getDisponibilite() {
                        return _disponibilite;
                }

                
		// -----------------------------------------------
			// Methodes
		// -----------------------------------------------
		
		public void infosExemplaire()
		{
			System.out.println("Numéro Exemlpaire  : " + this.getNumExemplaire());
                        System.out.println("Date de réception  : " + this.getDateReception());
                        System.out.println("Empruntable        : " + this.getEmpruntable());
                        System.out.println("Disponibilité      : " + this.getDisponibilite());
			EntreesSorties.afficherMessage("");
		}
                
                /*
                 * La méthode lierOuvrage permet d'ajouter un ouvrage a la base de donnée de Exemplaire.
                */
                private void lierOuvrage(Ouvrage o)
                {
                    _ouvrage=o;
                }
                      
                
// -----------------------------------------------
	// Private
// -----------------------------------------------

		// -----------------------------------------------
			//Setters
		// -----------------------------------------------

		private void setNumExemplaire(Integer numExemplaire) {
			this._numExemplaire = numExemplaire;
		}
		
                private void setDateReception(GregorianCalendar dateReception) {
			this._dateReception = dateReception;
		}
                
		private void setEmpruntable(Boolean empruntable){
			this._empruntable = empruntable;
		}
                
		private void setDisponibilite(Boolean disponibilite){
			this._disponibilite = disponibilite;
		}
			
}
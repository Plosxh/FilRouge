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
	
		private String _numExemplaire;
		private GregorianCalendar _dateReception;
                private Boolean _empruntable;
	
	
	
	// -----------------------------------------------
		//Constructeur
	// -----------------------------------------------
		
		public Exemplaire(String numExemplaire, GregorianCalendar dateReception, Boolean empruntable)
		{
			this.setNumExemplaire(numExemplaire);
			this.setDateReception(dateReception);
                        this.setEmpruntable(empruntable);
		}
		
// -----------------------------------------------
	// Public
// -----------------------------------------------
                
		// -----------------------------------------------
			//Getters
		// -----------------------------------------------
	
		public String getNumExemplaire() {
			return _numExemplaire;
		}
                
                public GregorianCalendar getDateReception() {
			return _dateReception;
		}
                
                public Boolean getEmpruntable() {
			return _empruntable;
		}

                
		// -----------------------------------------------
			// Methodes
		// -----------------------------------------------
		
		public void infosExemplaire()
		{
			System.out.println("Numéro Exemlpaire  : " + this.getNumExemplaire());
                        System.out.println("Date de réception  : " + this.getDateReception());
                        System.out.println("Empruntable        : " + this.getEmpruntable());
			EntreesSorties.afficherMessage("");
		}
                      
                
// -----------------------------------------------
	// Private
// -----------------------------------------------

		// -----------------------------------------------
			//Setters
		// -----------------------------------------------

		private void setNumExemplaire(String numExemplaire) {
			this._numExemplaire = numExemplaire;
		}
		
                private void setDateReception(GregorianCalendar dateReception) {
			this._dateReception = dateReception;
		}
                
		 private void setEmpruntable(Boolean empruntable){
			this._empruntable = empruntable;
		}
		
                                
			
}
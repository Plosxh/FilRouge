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
	
	
	
	// -----------------------------------------------
		//Constructeur
	// -----------------------------------------------
		
		public Exemplaire(Integer numExemplaire, GregorianCalendar dateReception)
		{
			this.setNumExemplaire(numExemplaire);
			this.setDateReception(dateReception);
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

                
		// -----------------------------------------------
			// Methodes
		// -----------------------------------------------
		
		public void infosExemplaire()
		{
			
		}
                
                /*
		 * La m�thode afficherExemplaire affiche l'ensemble des informations relatives à l'exemplaire.
		 */
		public void afficherExemplaire()
		{
			System.out.println("Numero exemplaire : " + this.getNumExemplaire());
			System.out.println("Date de réception : " + this.getDateReception());
			EntreesSorties.afficherMessage("");
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
		
                                
                // -----------------------------------------------
			// Methodes
		// -----------------------------------------------
		
		private void genererNumExemplaire()
		{
			
		}
                                
                private void lierOuvrage()
		{
			
		}
}
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bellenga
 */



// Classe de gestion de Ouvrage

public class Ouvrage 
{
    
	/*private static final long serialVersionUID = 422L;*/
	
	// -----------------------------------------------
		//Attributs
	// -----------------------------------------------
	
		private String _isbn;
                private String _titre;
                private String _nomEditeur;
                private GregorianCalendar _dateParution;
                private String _nomAuteur;
                private PublicCible _public;
                private HashSet<Exemplaire> _exemplaire;
                private Integer _numLast=(1);
	
	// -----------------------------------------------
		//Constructeur
	// -----------------------------------------------
		
		public Ouvrage(String isbn, String titre, String nomEditeur, GregorianCalendar dateParution, String nomAuteur, PublicCible publicOuvrage)
		{
                     	this.setIsbn(isbn);
			this.setTitre(titre);
			this.setNomEditeur(nomEditeur);
			this.setDateParution(dateParution);
			this.setNomAuteur(nomAuteur);
			this.setPublic(publicOuvrage);
                        _exemplaire = new HashSet<>();
		}
		
// -----------------------------------------------
	// Public
// -----------------------------------------------
		
		// -----------------------------------------------
			//Getters
		// -----------------------------------------------
	
		public String getIsbn() {
			return _isbn;
		}

		public String getTitre() {
			return _titre;
		}

		public String getNomEditeur() {
			return _nomEditeur;
		}
		
		public GregorianCalendar getDateParution() {
			return _dateParution;
		}

		public String getNomAuteur() {
			return _nomAuteur;
		}

		public PublicCible getPublic() {
			return _public;
		}
               
                
                
                
		// -----------------------------------------------
			// Methodes
		// -----------------------------------------------
		
		/*
		 * La m�thode infosOuvrage affiche l'ensemble des informations relatives � un ouvrage.
		 */
		public void infosOuvrage()
		{
                	
                        System.out.println("Isbn    : " + this.getIsbn());
			System.out.println("Titre   : " + this.getTitre());
			System.out.println("Editeur : " + this.getNomEditeur());
			System.out.println("Date de parution : " + this.getDateParution());
			System.out.println("Auteur  : " + this.getNomAuteur());
                        System.out.println("Public  : " + this.getPublic());
                        System.out.println("Nombre d'exemplaires  : ");
			EntreesSorties.afficherMessage("");
		}
		
                
                
		public void ajouterExemplaire()
		{
                    Integer numExemplaire = getNumLast();
                    setNumLast(numExemplaire+1);
                }
		
                /*
		 * La m�thode afficherInfosExemplaire affiche l'ensemble des informations relatives aux exemplaires d'un ouvrage.
		 */
		public void afficherInfosExemplaire()
		{
                    e = mesExemplaires(); 
                                      
		}
		
		/*
		 * La m�thode infosReduitOuvrage affiche quelques informations sur un ouvrage.
		 */
		public void infosReduitOuvrage()
		{
                (juste faire un print de isbn titre)	
                        
		}
		
	
	
// -----------------------------------------------
	// Private
// -----------------------------------------------

		// -----------------------------------------------
			//Setters
		// -----------------------------------------------

		private void setIsbn(String isbn) {
			this._isbn = isbn;
		}

		private void setTitre(String titre) {
			this._titre = titre;
		}
		
		private void setNomEditeur(String nomEditeur) {
			this._nomEditeur = nomEditeur;
		}

		private void setDateParution(GregorianCalendar dateParution) {
			this._dateParution = dateParution;
		}

		private void setNomAuteur(String nomAuteur) {
			this._nomAuteur = nomAuteur;
		}

		private void setPublic(PublicCible publicOuvrage) {
			this._public = publicOuvrage;
		}
                
                // -----------------------------------------------
			// Methodes
		// -----------------------------------------------
		
		/*
		 * La m�thode mesExemplaires demande d'accèder à tous les exemplaires de cet ouvrage.
		 */
		public HashSet<Exemplaire> mesExemplaires()
		{
			return _exemplaire;
		}       

    /**
     * @param _exemplaire the _exemplaire to set
     */
    public void setExemplaire(HashSet<Exemplaire> _exemplaire) {
        this._exemplaire = _exemplaire;
    }
                
                
}

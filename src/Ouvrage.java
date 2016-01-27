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
		
                 public void setExemplaire(HashSet<Exemplaire> _exemplaire)
                 {
                    this._exemplaire = _exemplaire;
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
                    /**
                * @return the _numLast
                */
               public Integer getNumLast() {
                   return _numLast;
               }
               
                
                
                
		// -----------------------------------------------
			// Methodes
		// -----------------------------------------------
		
		/*
		 * La m�thode infosOuvrage affiche l'ensemble des informations relatives � un ouvrage.
		 */
		public void infosOuvrage()
		{
                	HashSet<Exemplaire> ensE=mesExemplaires();
                        Integer nbExemplaires = ensE.size();
                        System.out.println("Isbn    : " + this.getIsbn());
			System.out.println("Titre   : " + this.getTitre());
			System.out.println("Editeur : " + this.getNomEditeur());
			System.out.println("Date de parution : " + this.getDateParution());
			System.out.println("Auteur  : " + this.getNomAuteur());
                        System.out.println("Public  : " + this.getPublic());
                        System.out.println("Nombre d'exemplaires  : " + nbExemplaires);
			EntreesSorties.afficherMessage("");
		}
		
                
                
		public void ajouterExemplaire()
		{
                
                   Integer numExemplaire = getNumLast();
                   setNumLast(numExemplaire+1);
                   
                   HashSet<Exemplaire> ensE=mesExemplaires();                   
                   Exemplaire e;
                   boolean test;
                   boolean empruntable=false;
                   boolean disponible=true;
                   Integer empr = EntreesSorties.lireEntier("Entrez l'empruntabilité : 1 pour Oui, 2 pour Non : ");
                   GregorianCalendar dateReception = EntreesSorties.lireDate("Entrez la date de reception :");
                   
                   do{
                        test = false;
                        
                        switch (empr){
                                    case 1 : {
                                            empruntable=true;
                                            break;
                                    }
                                    case 2 : {
                                            empruntable=false;
                                            break;
                                    }
                                    
                                    default : {
                                            EntreesSorties.afficherMessage("Inserez : 1 pour Oui, 2 pour Non.");
                                            test=true;
                                            break;
                                    }
                            }
                    } while (test);
                   
                  e = new Exemplaire(numExemplaire, dateReception, empruntable, disponible);
                  ensE.add(e);
                }
		
                /*
		 * La m�thode afficherInfosExemplaire affiche l'ensemble des informations relatives aux exemplaires d'un ouvrage.
		 */
		public void afficherInfosExemplaire()
		{
          
                   HashSet<Exemplaire> ensE=mesExemplaires();
                   for(Exemplaire e : ensE)
                   { 
                        e.infosExemplaire();
                   }                  
		}
		
		/*
		 * La m�thode infosReduitOuvrage affiche quelques informations sur un ouvrage.
		 */
		public void infosReduitOuvrage()
		{
                    System.out.println("Isbn    : " + this.getIsbn());
                    System.out.println("Titre   : " + this.getTitre());         
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
                /**
                 * @param _numLast the _numLast to set
                 */
                public void setNumLast(Integer _numLast) {
                    this._numLast = _numLast;
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
                
                /*
                 * La méthode lierExemplaire permet d'ajouter un exemplaire a la base de donnée de Ouvrage.
                 */
               /* private void lierExemplaire(Exemplaire e)
                {
                    _dicoOuvrage.put(e);
                }*/

    /**
     * @param _exemplaire the _exemplaire to set
     */
   
                
                
}

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

// Classe de gestion de Ouvrage

public class Ouvrage implements Serializable
{
    private static final long serialVersionUID = 422L;
	
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
		
    public Ouvrage(String isbn, String titre, String nomEditeur, GregorianCalendar dateParution, String nomAuteur, PublicCible publicOuvrage/*,*/ /*j'ai ajouté ça sinon y'a pas de visu externe, Antoine*/  /*HashSet<Exemplaire> _exemplaires*/)
    {
        this.setIsbn(isbn);
	this.setTitre(titre);
	this.setNomEditeur(nomEditeur);
	this.setDateParution(dateParution);
	this.setNomAuteur(nomAuteur);
	this.setPublic(publicOuvrage);
        this.setExemplaire(new HashSet<Exemplaire>());
    }
		
// -----------------------------------------------
	// Public
// -----------------------------------------------
		
	// -----------------------------------------------
		//Getters
	// -----------------------------------------------
	
	public String getIsbn() 
        {
            return _isbn;
	}

	public String getTitre() 
        {
            return _titre;
	}

	public String getNomEditeur() 
        {
            return _nomEditeur;
	}
		
	public GregorianCalendar getDateParution()
        {
            return _dateParution;
	}

	public String getNomAuteur() 
        {
            return _nomAuteur;
        }

	public PublicCible getPublic() 
        {
            return _public;
	}
                
        public Integer getNumLast() 
        {
            return _numLast;
        }
               
        public HashSet <Exemplaire> unExemplaire() 
        {
            return _exemplaire;                      
        }
               
              
	// -----------------------------------------------
		// Methodes
	// -----------------------------------------------
		
	/*
	 * La m�thode infosOuvrage affiche l'ensemble des informations relatives � un ouvrage.
	 */
	public void infosOuvrage()
	{
            System.out.println("Isbn                  : " + this.getIsbn());
            System.out.println("Titre                 : " + this.getTitre());
            System.out.println("Editeur               : " + this.getNomEditeur());
            System.out.println("Date de parution      : " + EntreesSorties.ecrireDate(getDateParution()));
            System.out.println("Auteur                : " + this.getNomAuteur());
            System.out.println("Public                : " + this.getPublic());
            System.out.println("Nombre d'exemplaires  : " + this._exemplaire.size());
            EntreesSorties.afficherMessage("");
	}
	
        // La méthode ajouterExemplaire permet de lier un exemplaire avec son ouvrage (dont ajouter l'explaire au set de son ouvrage)
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
                   
            do{
                test = false;
                        
                switch (empr){
                    case 1 : {
                        empruntable=true;
                        break;
                    }
                    
                    case 2 : {
                        empruntable=false;
                                              
                        HashSet<Exemplaire> ensemblE=mesExemplaires();
                        for(Exemplaire ex : ensemblE){
                            if (ex.getEmpruntable()==false){
                                EntreesSorties.afficherMessage("Il existe déjà un exemplaire non empruntable, celui-ci sera donc empruntable.");
                                empruntable=true;
                            }        
                        }
                    break;
                    }
                                    
                    default : {
                        EntreesSorties.afficherMessage("Insérez : 1 pour Oui, 2 pour Non.");
                        test=true;
                        break;
                    }
                }
            } while (test);
                   
            GregorianCalendar dateReception = EntreesSorties.lireDate("Entrez la date de récéption : ");                   
            e = new Exemplaire(numExemplaire, dateReception, empruntable, disponible, this);
            _exemplaire.add(e);
            EntreesSorties.afficherMessage("L'exemplaire a bien été ajouté à cet ouvrage.");
        }
                
        // Cette méthode permet de changer l'état d'un exemplaire donné de empruntable à en lecture sur place. Possible uniquement dans ce sens et dans la limite d'un exemplaire par ouvrage        
        public void editerExemplaire(Integer numExemplaire)
        {
            Exemplaire e =unExemplaire(numExemplaire);
            Boolean empruntable=e.getEmpruntable();
            HashSet<Exemplaire> ensemblE=mesExemplaires();
            for(Exemplaire ex : ensemblE){
                if (ex.getEmpruntable()==false){
                    EntreesSorties.afficherMessage("Il existe déjà un exemplaire non empruntable, celui-ci restera donc empruntable.");
                } 
                else{
                    empruntable = true;
                }
            }
                       
            e.editerExemplaire(empruntable);                      
        }
                
        /*
	 * La m�thode afficherInfosExemplaire affiche l'ensemble des informations relatives aux exemplaires d'un ouvrage.
	 */
	public void infosExemplaire()
	{
            HashSet<Exemplaire> ensE=mesExemplaires();
            for(Exemplaire e : ensE) { 
                e.infosExemplaire();
                if(!e.getDisponibilite()){
                    e.infosEmpruntExemplaire();                         
                }
            }                  
	}
		
	/*
	 * La m�thode infosReduitOuvrage affiche quelques informations sur un ouvrage.
	 */
	public void infosReduitOuvrage()
	{
            System.out.println("ISBN    : " + this.getIsbn());
            System.out.println("Titre   : " + this.getTitre());
            EntreesSorties.afficherMessage("");
	}
		
        /*
         * La fonction unExemplaire(numExemplaire) retourne l'exemplaire e trouvé grâce à son numExemplaire
         */
        public Exemplaire unExemplaire(int numExemplaire)
        {
            Exemplaire ex = null;
            HashSet<Exemplaire> ensE=mesExemplaires();
            for(Exemplaire e : ensE){
                if (numExemplaire==e.getNumExemplaire()){
                    ex = e;
                }
            }
            return ex;
        }              
                
        /*
         * exemplaireEmpruntable retourne true si l'exemplaire peut etre emprunté false sinon, il appelle des fonctions de ouvrage
         */
        public boolean exemplaireEmpruntable(Exemplaire e)
        {    
            if(e.getDisponibilite() && e.getEmpruntable()){
                return true;
            }
            else{
                return false;
            }
        }
                
        public void supEmprunt(Integer numExemplaire)
        {
            Exemplaire e = unExemplaire(numExemplaire);
            e.supEmprunt();
        }
                
// -----------------------------------------------
	// Private
// -----------------------------------------------

	// -----------------------------------------------
		//Setters
	// -----------------------------------------------

	private void setIsbn(String isbn) 
        {
            this._isbn = isbn;
	}

	private void setTitre(String titre) 
        {
            this._titre = titre;
	}
		
	private void setNomEditeur(String nomEditeur) 
        {
            this._nomEditeur = nomEditeur;
	}

	private void setDateParution(GregorianCalendar dateParution) 
        {
            this._dateParution = dateParution;
	}

	private void setNomAuteur(String nomAuteur) 
        {
            this._nomAuteur = nomAuteur;
	}

	private void setPublic(PublicCible publicOuvrage) 
        {
            this._public = publicOuvrage;
	}
               
        private void setNumLast(Integer _numLast) 
        {
            this._numLast = _numLast;
        }
                
        private void setExemplaire(HashSet<Exemplaire> _exemplaire)
        {
            this._exemplaire = _exemplaire;
        }
                
        // -----------------------------------------------
		// Methodes
	// -----------------------------------------------
		
	/*
	 * La m�thode mesExemplaires demande d'accèder à tous les exemplaires de cet ouvrage.
	 */
	private HashSet<Exemplaire> mesExemplaires()
	{
            return _exemplaire;
	}           
}

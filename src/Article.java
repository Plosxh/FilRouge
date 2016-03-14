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


public class Article implements Serializable
{
    private static final long serialVersionUID = 422L;
	
// -----------------------------------------------
        //Attributs
// -----------------------------------------------
	
    private Integer _numeroPage;
    private Parution _parution;
    private Titre _titre;
    private HashSet<Auteur> _collectionAuteurs;
    private HashSet<MotCle> _collectionMotsCles;
	
// -----------------------------------------------
	//Constructeur
// -----------------------------------------------
		
    /*creationArticle*/
    public Article(Integer numeroPage, Parution pa)
    {
        this.setNumeroPage(numeroPage);
	this.lierParution(pa);
    }
		
// -----------------------------------------------
	// Public
// -----------------------------------------------
		
	// -----------------------------------------------
		//Getters
	// -----------------------------------------------
	
	public Integer getNumeroPage() 
        {
            return _numeroPage;
	}

	public Parution getParution() 
        {
            return _parution;
	}
            
        public Titre getTitre()
        {
            return _titre;
        }
        
                   
	// -----------------------------------------------
		// Methodes
	// -----------------------------------------------
		
	public void ajouterAuteur(Auteur au)
	{
            au.ajouterArticle(this);
            lierAuteur(au);
        }
        
        public void ajouterMotCle(MotCle mc)
        {
            mc.ajouterArticle(this);
            lierMotCle(mc);
        }
               
        public void consulterArticle()
        {
            HashSet<Auteur> ensAu=mesAuteurs();
            for(Auteur au : ensAu) 
            { 
                au.infosAuteur();
            }
            HashSet<MotCle> ensMc=mesMotsCles();
            for(MotCle mc : ensMc) 
            { 
                mc.infosMotCle();
            }
        }
            
        public void infosArticle()
        {
            System.out.println("Titre : " + this.getTitre());
            System.out.println("Numero de page : " + this.getNumeroPage());
            EntreesSorties.afficherMessage("");
        }
        /* Elodie : A enlever dans VPP car plus réduit que titre et numPage, pas très pertient"
        public void infosReduitArticles()
	{
            
	}
        */
        
        
        
// -----------------------------------------------
	// Private
// -----------------------------------------------

	// -----------------------------------------------
		//Setters
	// -----------------------------------------------

	private void setNumeroPage(Integer numeroPage) 
        {
            this._numeroPage = numeroPage;
	}

	private void lierParution(Parution pa) 
        {
            this._parution = pa;
	}
        
        private void setAuteur(HashSet<Auteur> _collectionAuteurs)
                {
                    this._collectionAuteurs = _collectionAuteurs;
                }
        
        private void setMotCle(HashSet<MotCle> _collectionMotsCles)
                {
                    this._collectionMotsCles = _collectionMotsCles;
                }
                                
        // -----------------------------------------------
		// Methodes
	// -----------------------------------------------
       
        private void lierAuteur(Auteur au)
        {
            _collectionAuteurs.add(au);
        }
        
        private void lierMotCle(MotCle mc)
        {
            _collectionMotsCles.add(mc);
        }
        
        private HashSet <Auteur> mesAuteurs() 
        {
            return _collectionAuteurs;                      
        }
        
        private HashSet <MotCle> mesMotsCles() 
        {
            return _collectionMotsCles;                      
        }
        
        /*Antoine : ça ne peux pas être dans cette méthode, il y a une erreur sur le VPP*/
        private Article unArticle(Integer numPage)
        {
            
        }

    
}

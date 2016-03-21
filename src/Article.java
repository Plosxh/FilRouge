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
    private HashSet<MotCle> _collectionMotCles;
	
// -----------------------------------------------
	//Constructeur
// -----------------------------------------------
		

    /*creationArticle ???*/
    public Article(Titre t, Integer numPage, Parution pa)
    {
        this.setTitre(t);
        this.setNumeroPage(numPage);
	this.lierParution(pa);
        this.setAuteur(new HashSet<Auteur>());
        this.setMotCle(new HashSet<MotCle>());
        

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
            
        public String getTitre()
        {
            
            return _titre.getTitre();
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
            HashSet<MotCle> ensMc=mesMotCles();
            for(MotCle mc : ensMc) 
            { 
               mc.infosMotCle();
            }
        }
            
        public void infosArticle()
        {
            Periodique pe = _parution.getPeriodique();
    
            System.out.println("ISSN : " + pe.getIssn());
            System.out.println("Nom periodique : " + pe.getNomPeriodique());
            System.out.println("Numero parution : " + _parution.getNumParution());
            System.out.println("Date de parution : " + EntreesSorties.ecrireDate(_parution.getDateParution()));
            System.out.println("Titre : " + _titre.getTitre());
            System.out.println("Numero de page : " + this.getNumeroPage());
            EntreesSorties.afficherMessage("");
        }      
        
        public void infosReduitArticle()
        {
            System.out.println("Titre : " + _titre.getTitre());
            System.out.println("Numero de page : " + this.getNumeroPage());
            EntreesSorties.afficherMessage("");
        }
        
        
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
            this._collectionMotCles = _collectionMotsCles;
        }

        private void setTitre(Titre titre) 
        {
            this._titre = titre;
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
            _collectionMotCles.add(mc);
        }
        
        private HashSet <Auteur> mesAuteurs() 
        {
            return _collectionAuteurs;                      
        }
        
        private HashSet <MotCle> mesMotCles() 
        {
            return _collectionMotCles;                      
        }
        
        /*Antoine : ça ne peux pas être dans cette méthode, il y a une erreur sur le VPP
        private Article unArticle(Integer numPage)
        {
            
        }*/

    
}

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
public class Article implements Serializable
{
    private static final long serialVersionUID = 422L;
	
// -----------------------------------------------
        //Attributs
// -----------------------------------------------
	
    private Integer _numeroPage;
    private Parution _parution;
    private Titre _titre;
    private HashSet<Auteur> _auteur;
    private HashSet<MotCle> _motCle;
	
// -----------------------------------------------
	//Constructeur
// -----------------------------------------------
		
    /*creationArticle ???*/
    public Article(Integer numeroPage, Parution parution)
    {
        this.setNumeroPage(numeroPage);
	this.setParution(parution);
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
        
        public HashSet <Auteur> unAuteur() 
        {
            return _auteur;                      
        }
        
        public HashSet <MotCle> unMotCle() 
        {
            return _motCle;                      
        }
              
	// -----------------------------------------------
		// Methodes
	// -----------------------------------------------
		
	public void ajouterMotCle(MotCle mc)
        {
            
        }
	
	public void ajouterAuteur(Auteur au)
	{
            
        }
          
        /*passera privée*/
        public void lierAuteur(Auteur au)
        {
            
        }
        
        public void consulterArticle()
        {
            
        }
            
        public void infosArticle()
        {
            System.out.println("Numero de page        : " + this.getNumeroPage());
            //System.out.println("Date de parution      : " + this.getDateParution());
        }
        
        public void infosReduitArticles()
	{
            
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

	private void setParution(Parution parution) 
        {
            this._parution = parution;
	}
                                
        // -----------------------------------------------
		// Methodes
	// -----------------------------------------------
    
        /*ça ne peux pas être dans cette méthode, il y a une erreur sur le VPP*/
        private Article unArticle(Integer numPage)
        {
            
        }
}

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
public class Parution implements Serializable
{
       private static final long serialVersionUID = 422L;
	
// -----------------------------------------------
        //Attributs
// -----------------------------------------------
	
    private Integer _numParution;
    private GregorianCalendar _dateParution;
    private Periodique _periodique;
    private HashSet<Article> _article;
	
// -----------------------------------------------
	//Constructeur
// -----------------------------------------------
		
    /*creationParution ???*/
    public Parution(Integer numParution, GregorianCalendar dateParution, Periodique periodique)
    {
        this.setNumParution(numParution);
        this.setDateParution(dateParution);
	/*this.setPeriodique(periodique);*/
        this.lierPeriodique(periodique);
        this.setArticle(new HashSet<Article>());
        
    }
		
// -----------------------------------------------
	// Public
// -----------------------------------------------
		
	// -----------------------------------------------
		//Getters
	// -----------------------------------------------
	
	public Integer getNumParution() 
        {
            return _numParution;
	}

        public GregorianCalendar getDateParution() 
        {
            return _dateParution;
	}

        public Periodique getPeriodique() 
        {
            return _periodique;
	}    
        
        public HashSet <Article> unArticle() 
        {
            return _article;                      
        }
              
	// -----------------------------------------------
		// Methodes
	// -----------------------------------------------
        
        public void verifierArticle(Integer numPage)
	{
              /*n'existe pas*/                
	}
        
        /*appelé par infosPeriodique() depuis periodique*/
        public void infosParution()
        {
            System.out.println("Numero de parution    : " + this.getNumParution());
            System.out.println("Date de parution      : " + this.getDateParution());
            
            HashSet<Article> ensA=mesArticles();
            for(Article a : ensA) { 
                a.infosArticle();               
            }
        }
        
        public void infosParutionReduit()
        {
            System.out.println("Numero de parution    : " + this.getNumParution());
            System.out.println("Date de parution      : " + this.getDateParution());
        }
        
        public void consulterArticle(Integer numPage)
        {
            Article a = unArticle(numPage);
            if(a == null)
            {
                this.infosParutionReduit();
                a.consulterArticle();
            }
            else
            {
                EntreesSorties.afficherMessage("L'article n'existe pas");
            }
        }
        
                       
// -----------------------------------------------
	// Private
// -----------------------------------------------

	// -----------------------------------------------
		//Setters
	// -----------------------------------------------

	private void setNumParution(Integer numParution) 
        {
            this._numParution = numParution;
	}

	private void setDateParution(GregorianCalendar dateParution) 
        {
            this._dateParution = dateParution;
	}
        
        private void setPeriodique(Periodique periodique) 
        {
            this._periodique = periodique;
	}
                
        private void setArticle(HashSet<Article> _article)
        {
            this._article = _article;
        }
                
        // -----------------------------------------------
		// Methodes
	// -----------------------------------------------

        private HashSet<Article> mesArticles()
	{
            return _article;
	}
        
        private void lierPeriodique(Periodique pe)
	{
            _periodique=pe;
	}
        
        private Article unArticle(Integer numPage)
        {
            Article ar = null;
            HashSet<Article> ensA=mesArticles();
            for(Article a : ensA){
                if (numPage==a.getNumeroPage()){
                    ar = a;
                }
            }
            return ar;
        }
}

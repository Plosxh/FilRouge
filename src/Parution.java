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
	this.setPeriodique(periodique);
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
		
	public void lierPeriodique()
	{
            
	}
        
        public void verifierArticle(Integer numPage)
	{
                              
	}
	
        public Article unArticle(Integer numPage)
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
        
        public void infosParution()
        {
            
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
}

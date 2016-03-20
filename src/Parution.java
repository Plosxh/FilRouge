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
    private HashSet<Article> _collectionArticles;
	
// -----------------------------------------------
	//Constructeur
// -----------------------------------------------
		
    /*creationParution ???*/
    public Parution(Integer numParution, GregorianCalendar dateParution, Periodique pe)
    {
        this.setNumParution(numParution);
        this.setDateParution(dateParution);
	/*this.setPeriodique(periodique);*/
        this.lierPeriodique(pe);
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
        
        public HashSet <Article> mesArticles() 
        {
            return _collectionArticles;                      
        }
        

              
	// -----------------------------------------------
		// Methodes
	// -----------------------------------------------
        
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
        
        public void verifierArticle(Integer numPage)
	{
              /*n'existe pas*/                
	}
        
        /*appelé par nouvelArticle() depuis bibliotheque, pour créer un article et le lier à sa parution et son titre */
	public void ajouterArticle(Titre t, Integer numPage)
	{
            Article a = new Article(t, numPage, this);
            _collectionArticles.add(a);
	}
        
        public void infosReduitParution()
        {
            System.out.println("Numero de parution    : " + this.getNumParution());
            System.out.println("Date de parution      : " + EntreesSorties.ecrireDate(getDateParution()));  //modifié par antoine 20/03
        }
        
        /*appelé par infosPeriodique() depuis periodique*/
        public void infosParution()
        {
            System.out.println("Numero de parution    : " + this.getNumParution());
            System.out.println("Date de parution      : " + EntreesSorties.ecrireDate(getDateParution()));  //modifié par antoine 20/03
            
            HashSet<Article> ensA=mesArticles();
            for(Article a : ensA) { 
                a.infosReduitArticle();               
            }
        }
        
            
        public void consulterArticle(Integer numPage)
        {
            Article a = unArticle(numPage);
            if(a != null)
            {
                this.infosReduitParution();
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
                
        private void setArticle(HashSet<Article> _collectionArticles)
        {
            this._collectionArticles = _collectionArticles;
        }
                
        // -----------------------------------------------
		// Methodes
	// -----------------------------------------------

        
        private void lierPeriodique(Periodique pe)
	{
            _periodique=pe;
	}
        

}

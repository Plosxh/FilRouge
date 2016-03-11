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
            
              
	// -----------------------------------------------
		// Methodes
	// -----------------------------------------------
		
	public void infosReduitArticles()
	{
            
	}
	
	public void ajouterAuteur(Auteur au)
	{
            
        }
                
        public void lierAuteur(Auteur au)
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
    
}

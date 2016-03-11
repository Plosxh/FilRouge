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
 * @author bellenga le tro for
 */
public class Periodique implements Serializable
{
    private static final long serialVersionUID = 422L;
	
// -----------------------------------------------
        //Attributs
// -----------------------------------------------
	
    private String _issn;
    private String _nomPeriodique;
    private HashSet<Parution> _parution;
	
// -----------------------------------------------
	//Constructeur
// -----------------------------------------------
		
    /*creationPeriodique ???*/
    public Periodique(String issn, String nomPeriodique)
    {
        this.setIssn(issn);
	this.setNomPeriodique(nomPeriodique);
        this.setParution(new HashSet<Parution>());
    }
		
// -----------------------------------------------
	// Public
// -----------------------------------------------
		
	// -----------------------------------------------
		//Getters
	// -----------------------------------------------
	
	public String getIssn() 
        {
            return _issn;
	}

	public String getNomPeriodique() 
        {
            return _nomPeriodique;
	}

        public HashSet <Parution> uneParution() 
        {
            return _parution;                      
        }
               
              
	// -----------------------------------------------
		// Methodes
	// -----------------------------------------------
		
	public void ajouterParution()
	{
            
	}
	
	public void verifParution(Integer numParution)
	{
            
        }
                
        public Parution uneParution(Integer numParution)
        {
            
        }
        
	public void creationParution(Integer numParution, GregorianCalendar dateParution)
	{
                              
	}
	
	public void lierParution()
	{
            
	}
        
        public void consulterPeriodique()
        {
            
        }
	
        public void consulterParutionPeriodique()
        {
            
        }
                       
// -----------------------------------------------
	// Private
// -----------------------------------------------

	// -----------------------------------------------
		//Setters
	// -----------------------------------------------

	private void setIssn(String issn) 
        {
            this._issn = issn;
	}

	private void setNomPeriodique(String nomPeriodique) 
        {
            this._nomPeriodique = nomPeriodique;
	}
                
        private void setParution(HashSet<Parution> _parution)
        {
            this._parution = _parution;
        }
                
        // -----------------------------------------------
		// Methodes
	// -----------------------------------------------
		           
  
}

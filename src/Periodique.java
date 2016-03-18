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

        public HashSet <Parution> mesParutions() 
        {
            return _parution;                      
        }
        
        public Parution uneParution(Integer numParution)
        {
            Parution par = null;
            HashSet<Parution> ensPa=mesParutions();
            for(Parution pa : ensPa){
                if (numParution==pa.getNumParution()){
                    par = pa;
                }
            }
            return par;
        }               
              
	// -----------------------------------------------
		// Methodes
	// -----------------------------------------------
	
        /*appelé par nouvelleParution() depuis bibliotheque*/
	public void ajouterParution()
	{
            EntreesSorties.afficherMessage("Veuillez entrer un numero de parution : ");
	}
	
        /*appelé par nouvelleParution() depuis bibliotheque*/
	public void verifParution(Integer numParution)
	{
            Parution pa = uneParution(numParution);
            if(pa == null)
            {
                GregorianCalendar dateParution = EntreesSorties.lireDate("Veuillez entrer la date de parution :");
                creationParution(numParution, dateParution);
                EntreesSorties.afficherMessage("La parution a bien été créée.");
            }
            else
            {
                EntreesSorties.afficherMessage("La parution existe déjà.");
            }
        }
	
	public void lierParution(Parution pa)
	{
            _parution.add(pa);
	}
        
        /*appelé par consulterPeriodique() depuis bibliotheque*/
        public void infosPeriodique()
        {
            System.out.println("Issn                  : " + this.getIssn());
            System.out.println("Nom Periodique        : " + this.getNomPeriodique());
            
            HashSet<Parution> ensPa=mesParutions();
            for(Parution pa : ensPa) { 
                pa.infosReduitParution();               
            }   
        }
        
        public void infosReduitPeriodique()
        {
            System.out.println("Issn                  : " + this.getIssn());
            System.out.println("Nom Periodique        : " + this.getNomPeriodique());
        }
        
        public void consulterParutionPeriodique(Integer numParution)
        {
            this.infosReduitPeriodique();
            Parution pa = uneParution(numParution);
            if(pa != null)
            {
                pa.infosParution();
            }
        }
        
        /*appelé par consulterArticle() depuis bibliotheque*/
        public void consulterArticle(Integer numParution, Integer numPage)   /*erreur vpp, numParution à ajouter*/
        {
           Parution pa = uneParution(numParution);
           this.infosReduitPeriodique();
           pa.consulterArticle(numPage);
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
	// ----------------------------------------------
              
        private void creationParution(Integer numParution, GregorianCalendar dateParution)
	{
            EntreesSorties.afficherMessage("Création de la parution...");
            Parution pa = new Parution(numParution, dateParution, this);
            lierParution(pa);  
            EntreesSorties.afficherMessage("Création avec succès!");     
	}
	
}

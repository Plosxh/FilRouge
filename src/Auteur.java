import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;


public class Auteur extends Index implements Serializable  {
   
        private static final long serialVersionUID = 422L;
	
// -----------------------------------------------
	//Attributs
// -----------------------------------------------
	
	private String _nomAuteur;
        private HashSet<Ouvrage> _collectionOuvrages;
        private HashSet<Article> _collectionArticles;

// -----------------------------------------------
	//Constructeur
// -----------------------------------------------
		
            public Auteur(String nom)
                {
                    this.setNom(nom);
                    this.setArticle(new HashSet<Article>());
                    this.setOuvrage(new HashSet<Ouvrage>());
                }		

        
        		
// -----------------------------------------------
	// Public
// -----------------------------------------------
		
	// -----------------------------------------------
		//Getters
	// -----------------------------------------------
            public String getNom() 
                {
                    return _nomAuteur;
                }        

                        
	// -----------------------------------------------
		// Methodes
	// -----------------------------------------------
	    public void infosAuteur() 
                {
                     
                } 	
            
            public void ajouterOuvrage(Ouvrage o) 
                {
                     
                }
            
            public void ajouterArticle(Article a) 
                {
                     
                }
            
            public void lierOuvrage() 
                {
                     
                }
            
            public void lierArticle() 
                {
                     
                } 
            
        
// -----------------------------------------------
	// Private
// -----------------------------------------------

	// -----------------------------------------------
		//Setters
	// -----------------------------------------------
            private void setNom(String nom) 
               {
                   this._nomAuteur = nom;
               }
            
            private void setArticle(HashSet<Article> _collectionArticles)
                {
                    this._collectionArticles = _collectionArticles;
                }
            
            private void setOuvrage(HashSet<Ouvrage> _collectionOuvrages)
                {
                    this._collectionOuvrages = _collectionOuvrages;
                }
        
        
        
        // -----------------------------------------------
		// Methodes
	// -----------------------------------------------
           
        
        
}

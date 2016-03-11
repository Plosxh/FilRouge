import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;



public class Titre extends Index implements Serializable {

  
        private static final long serialVersionUID = 422L;
	
// -----------------------------------------------
	//Attributs
// -----------------------------------------------
	
	private String _titre;
        private HashSet<Ouvrage> _collectionOuvrages;
        private HashSet<Article> _collectionArticles;

// -----------------------------------------------
	//Constructeur
// -----------------------------------------------
		
            public Titre(String libelle)
                {
                    this.setTitre(libelle);
                    this.setArticle(new HashSet<Article>());
                    this.setOuvrage(new HashSet<Ouvrage>());
                }		

        
        		
// -----------------------------------------------
	// Public
// -----------------------------------------------
		
	// -----------------------------------------------
		//Getters
	// -----------------------------------------------
            public String getTitre() 
                {
                    return _titre;
                }        

                        
	// -----------------------------------------------
		// Methodes
	// -----------------------------------------------
	    public void infosTitre() 
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
            private void setTitre(String libelle) 
               {
                   this._titre = libelle;
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

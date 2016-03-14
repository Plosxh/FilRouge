import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;



public class MotCle extends Index implements Serializable {

  
        private static final long serialVersionUID = 422L;
	
// -----------------------------------------------
	//Attributs
// -----------------------------------------------
	
	private String _motcle;
        private HashSet<Ouvrage> _collectionOuvrages;
        private HashSet<Article> _collectionArticles;

// -----------------------------------------------
	//Constructeur
// -----------------------------------------------
		
            public MotCle(String mot)
                {
                    this.setMotCle(mot);
                    this.setArticle(new HashSet<Article>());
                    this.setOuvrage(new HashSet<Ouvrage>());
                }		

        
        		
// -----------------------------------------------
	// Public
// -----------------------------------------------
		
	// -----------------------------------------------
		//Getters
	// -----------------------------------------------
            public String getMotCle() 
                {
                    return _motcle;
                }        

                        
	// -----------------------------------------------
		// Methodes
	// -----------------------------------------------
	    public void infosMotCle() 
                {
                  System.out.println("Mot Cle                     : " + this.getMotCle());   
                  EntreesSorties.afficherMessage("");    
                } 
            
            
            
            public void ajouterOuvrage(Ouvrage o) 
                {
                  lierOuvrage(o);   
                }
            
            public void ajouterArticle(Article a) 
                {
                 lierArticle(a);    
                }
             
            
        
// -----------------------------------------------
	// Private
// -----------------------------------------------

	// -----------------------------------------------
		//Setters
	// -----------------------------------------------
            private void setMotCle(String mot) 
               {
                   this._motcle = mot;
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
            
            
            private void lierArticle(Article a)
            {
                _collectionArticles.add(a);
            }
            
            private void lierOuvrage(Ouvrage o)
            {
                _collectionOuvrages.add(o);
            }  
            







}

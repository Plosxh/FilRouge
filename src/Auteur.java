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
            public String getNomAuteur() 
                {
                    return _nomAuteur;
                }        

                        
	// -----------------------------------------------
		// Methodes
	// -----------------------------------------------
	    public void infosAuteur() 
                {
                  System.out.println("Auteur                     : " + this.getNomAuteur());   
                  EntreesSorties.afficherMessage("");
                }

            public void documentsAuteur() 
                {
                    HashSet<Ouvrage> ensO=mesOuvrages();
                    if (ensO.isEmpty())
                    {
                        EntreesSorties.afficherMessage("Pas d'ouvrages pour cette requête.");
                    }
                    else
                    {
                      for(Ouvrage o : ensO) 
                        { 
                            o.infosReduitOuvrage();
                        }  
                    }
                    
                    HashSet<Article> ensA=mesArticles();
                    if (ensA.isEmpty())
                    {
                        EntreesSorties.afficherMessage("Pas d'articles pour cette requête.");
                    }
                    else
                    {
                      for(Article a : ensA) 
                        { 
                            a.infosArticle();
                        }  
                    }
                    
                }  
            
            public void ajouterOuvrage(Ouvrage o) 
                {
                     lierOuvrage(o);
                }
            
            public void ajouterArticle(Article a) 
                {
                     lierArticle(a);
                }

            public HashSet<Article> articleAuteur()
            {
                return mesArticles();
            }
        
            public HashSet<Ouvrage> ouvrageAuteur()
            {
                return mesOuvrages();
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
           
            
            private void lierArticle(Article a)
            {
                _collectionArticles.add(a);
            }
            
            private void lierOuvrage(Ouvrage o)
            {
                _collectionOuvrages.add(o);
            } 
        
            private HashSet <Ouvrage> mesOuvrages() 
            {
                return _collectionOuvrages;                      
            }
            
            private HashSet <Article> mesArticles() 
            {
                return _collectionArticles;                      
            }
}

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;

// Classe de gestion de Lecteur

public class Lecteur implements Serializable 
{
	
	private static final long serialVersionUID = 422L;
	
	// -----------------------------------------------
		//Attributs
	// -----------------------------------------------
	
		private String _nomLecteur;
		private String _prenomLecteur;
		private Integer _numLecteur;
		private GregorianCalendar _dateNaissance;
		private String _adresseLecteur;
		private String _telephone;
                private HashSet<Emprunt> _collectionEmprunts;
	
	
	// -----------------------------------------------
		//Constructeur
	// -----------------------------------------------
		
		public Lecteur(String nom, String prenom, Integer numLecteur, GregorianCalendar dateNaiss, String adresse, String tel)
		{
			this.setNom(nom);
			this.setPrenom(prenom);
			this.setNumLecteur(numLecteur);
			this.setDateNaiss(dateNaiss);
			this.setAdresse(adresse);
			this.setTel(tel);
                        this.setEmprunt(new HashSet<Emprunt>());
                }
		
// -----------------------------------------------
	// Public
// -----------------------------------------------
		
		// -----------------------------------------------
			//Getters
		// -----------------------------------------------
	
		public String getNom() {
			return _nomLecteur;
		}

		public String getPrenom() {
			return _prenomLecteur;
		}

		public Integer getNumLecteur() {
			return _numLecteur;
		}
		
		public GregorianCalendar getDateNaiss() {
			return _dateNaissance;
		}

		public String getAdresse() {
			return _adresseLecteur;
		}

		public String getTel() {
			return _telephone;                      
        	}
                               
                public HashSet <Emprunt> unEmprunt() {
			return _collectionEmprunts;                      
        	}
                
                
		// -----------------------------------------------
			// Methodes
		// -----------------------------------------------
		
		/*
		 * La m�thode afficherLecteur affiche l'ensemble des informations relatives � un lecteur.
		 */
		public void afficherLecteur()
		{
			System.out.println("Numero lecteur : " + this.getNumLecteur());
			System.out.println("Nom et prenom du lecteur: " + this.getNom() + " " + this.getPrenom());
			System.out.println("Age : " + this.calculAge() + " ans");
			System.out.println("Adresse : " + this.getAdresse());
			System.out.println("Telephone : " + this.getTel());
                        System.out.println("Nombre d'exemplaire(s) emprunté(s) : " + this._collectionEmprunts.size());
			EntreesSorties.afficherMessage("");
		}
		
		
		/*
		 * la m�thode calculAge permet de d�terminer l'age des lecteurs grace a leur date de naissance
		 * et la date actuelle. De cette fa�on, il n'y a pas de mise a jour a faire sur l'age des lecteurs.
		 */
		public Integer calculAge() {
			Integer age;
			GregorianCalendar dateNaissComp;
			GregorianCalendar dateActuelle = new GregorianCalendar();
			dateNaissComp = new GregorianCalendar(dateActuelle.get(GregorianCalendar.YEAR), _dateNaissance.get(GregorianCalendar.MONTH), _dateNaissance.get(GregorianCalendar.DAY_OF_MONTH));
			if(dateNaissComp.before(dateActuelle)){
				age=dateActuelle.get(GregorianCalendar.YEAR)-_dateNaissance.get(GregorianCalendar.YEAR);
			}
			else{
				age=dateActuelle.get(GregorianCalendar.YEAR)-_dateNaissance.get(GregorianCalendar.YEAR)-1;
			}
			return age;
		}
                
                public void supEmprunt()
                {
                    
                    this.delierEmprunt();
                    /*if(_collectionEmprunts.isEmpty())
                    {
                        this.setEmprunt(new HashSet<Emprunt>());
                    }*/
                }
		
                public void setCollectionEmprunts(HashSet<Emprunt> collectionEmprunts)
                {
                    this._collectionEmprunts = collectionEmprunts;
                }
                
                public void infosReduitLecteur()
                {
                    System.out.println("Numero lecteur : " + this.getNumLecteur());
                    System.out.println("Nom et prenom du lecteur: " + this.getNom() + " " + this.getPrenom());
                    EntreesSorties.afficherMessage("");
                }
               
                public void afficherInfosEmprunts()
                {
                    
                    HashSet<Emprunt> ensEm=mesEmprunts();
                    if(ensEm.size()>0)
                    {
                        for(Emprunt em : ensEm)
                        { 
                             em.infosEmprunt();                         
                         }
                    }
                    else
                    {
                        EntreesSorties.afficherMessage("Ce lecteur n'a pas d'emprunt.");
                        
                    }
                }
                public void relancerLecteur()
                {
                    
                    
                    Boolean retard=false;   
                    HashSet<Emprunt> ensEm = mesEmprunts(); 
                    
                    for(Emprunt em : ensEm)
                    {
                        retard = em.verifEmprunt();
                        if(retard=true)
                        {
                           em.afficheRetard();
                        }
                    }
                }
              
	
                /*
		 * La m�thode mesEmprunts demande d'accèder à tous les emprunts de cet ouvrage.
		 */
		public HashSet<Emprunt> mesEmprunts()
		{
                   return _collectionEmprunts;
                } 
                
                public boolean etatSature()
                {
                    int nb = _collectionEmprunts.size();
                    if (nb < 5)
                    {
                        return false;
                    }
                    else
                    {
                        return true;
                    }
                }
                
                public void ajouterEmprunt(Emprunt em)
                {
                    lierEmprunt(em);
                }
	
// -----------------------------------------------
	// Private
// -----------------------------------------------

		// -----------------------------------------------
			//Setters
		// -----------------------------------------------

		private void setNom(String nom) {
			this._nomLecteur = nom;
		}

		private void setPrenom(String prenom) {
			this._prenomLecteur = prenom;
		}
		
		private void setNumLecteur(Integer numLecteur) {
			this._numLecteur = numLecteur;
		}

		private void setDateNaiss(GregorianCalendar dateNaiss) {
			this._dateNaissance = dateNaiss;
		}

		private void setAdresse(String adresse) {
			this._adresseLecteur = adresse;
		}

		private void setTel(String tel) {
			this._telephone = tel;
		}
		
                private void delierEmprunt()
                {
                    //faire avec em comme dans exemplaire
                    _collectionEmprunts=null;
                }
                
                private void lierEmprunt(Emprunt em)
                {
                    _collectionEmprunts.add(em);
                }
                
                   private void setEmprunt(HashSet<Emprunt> _collectionEmprunts)
                 {
                    this._collectionEmprunts = _collectionEmprunts;
                 }
}




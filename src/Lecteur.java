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
                private Integer _numEmprunt;
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
                        System.out.println("Nombre d'exemplaire(s) emprunté(s) : " + this.getNbEmprunt());
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
			dateNaissComp = new GregorianCalendar(dateActuelle.get(GregorianCalendar.YEAR), _dateNaissance.get(GregorianCalendar.MONTH), _dateNaissance.get(GregorianCalendar.DATE));
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
                    _nbEmprunt=_nbEmprunt-1;                    
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
                    HashSet<Emprunts> ensEm=mesEmprunts();
                   for(Emprunt em : ensEm)
                   { 
                        em.infosExmprunt();                       
                    }
                
                
                public void relancerLecteur()
                {
                    HashSet<Emprunt> em = mesEmprunts(); 
                    
                    for(em!=null)
                    {
                        em.verifEmprunt();
                        if(retard=1)
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
		
               
                
                
		//private void setNbEmprunt(Integer nbEmprunt) {
		//	this._nbEmprunt = nbEmprunt;
		//}
                
                private void delierEmprunt()
                {
                    //faire avec em comme dans exemplaire
                    _collectionEmprunts=null;
                }
}



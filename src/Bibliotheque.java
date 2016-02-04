import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;


// Classe de gestion de la Bibliotheque

public class Bibliotheque implements Serializable 
{
	
	private static final long serialVersionUID = 262L;

	// -----------------------------------------------
		//Attributs
	// -----------------------------------------------
	
		private HashMap<Integer, Lecteur> _dicoLecteur;
                private HashMap<String, Ouvrage> _dicoOuvrage;
                
            
                
                private Integer _numLast=(1);
                
		
		/*
		 * Le dictionnaire de lecteur permet à bibliotheque de 
		 * garantir l'unicité de ces derniers, et facilitent les recherches et créations.
		 */
	
	// -----------------------------------------------
		//Constructeur
	// -----------------------------------------------
	

		public Bibliotheque() {
			this.setLecteurs(new HashMap<Integer, Lecteur>());
                        this.setOuvrages(new HashMap<String, Ouvrage>());
		
		}
	
// -----------------------------------------------
	// Public
// -----------------------------------------------	
		
		// -----------------------------------------------
			// Mï¿½thodes
		// -----------------------------------------------
	
		/*
		 * La méthode nouveauLecteur permet de créé un lecteur en demandant la saisie de son numéro
		 * nom, prénom, date de naissance, adresse et numéro de téléphone.
		 * L'age doit être compris entre 3 et 110 ans
		 * Le lecteur est identifié par son numéro, si celui ci existe déjà dans le dictionnaire
		 * de bibliothèque, un message d'erreur est affiché.
		 * Une fois le nouveau lecteur créé, il est ajouté au dictionnaire de lecteur
		 * afin de garantir la cohérence des données.
		 */
	public void nouveauLecteur()
	{
		
          
            Integer numLecteur = getNumLast();
            setNumLast(numLecteur+1);
		
		Lecteur L = unLecteur(numLecteur);
		
		if (L == null) 
		{
			String nom = EntreesSorties.lireChaine("Entrez le nom :");
			String prenom = EntreesSorties.lireChaine("Entrez le prenom :");
			Integer age;
                        Integer nbEmprunt=0;
			GregorianCalendar dateNaiss, dateNaissComp;
			GregorianCalendar dateActuelle = new GregorianCalendar();
			do {
				dateNaiss = EntreesSorties.lireDate("Entrez la date de naissance du lecteur :");
				dateNaissComp = new GregorianCalendar(dateActuelle.get(GregorianCalendar.YEAR), dateNaiss.get(GregorianCalendar.MONTH), dateNaiss.get(GregorianCalendar.DATE));
				if(dateNaissComp.before(dateActuelle)){
					age=dateActuelle.get(GregorianCalendar.YEAR)-dateNaiss.get(GregorianCalendar.YEAR);
				}
				else{
					age=dateActuelle.get(GregorianCalendar.YEAR)-dateNaiss.get(GregorianCalendar.YEAR)-1;
				}
				if ((age<=3) | (age>=110)){
					EntreesSorties.afficherMessage("Age incorrecte ("+age+"), veuillez recommencer.");
				}
				else {
					EntreesSorties.afficherMessage("Age du lecteur : " + age + " ans");
				}
			} while ((age<=3) | (age>=110));
			String adresse = EntreesSorties.lireChaine("Entrez l'adresse :");
			String tel = EntreesSorties.lireChaine("Entrez le numero de telephone :");
			EntreesSorties.afficherMessage("Fin de saisie");
			
			L = new Lecteur(nom, prenom, numLecteur, dateNaiss, adresse, tel);
			lierLecteur(L, numLecteur);

                        EntreesSorties.afficherMessage("Le numéro de ce nouveau lecteur est : " + numLecteur + ".");

		}
		else {
			EntreesSorties.afficherMessage("Ce numero de lecteur existe déjà.");
		}
		
	}
	
        /*
	 * La méthode nouvelOuvrage permet de créer un ouvrage en demandant la saisie de son titre, le nom de l'éditeur,
	 * la date de parution, le(s) nom(s) de l'auteur (ou des auteurs), son ISBN et le public visé
	 */
        public void nouvelOuvrage()
        {
                Integer NB = 1;
                String isbn = EntreesSorties.lireChaine("Entrez le numero d'isbn : ");
		Ouvrage o = unOuvrage(isbn);
                if (o==null){
                this.creationOuvrage(isbn);
                }
                else{
                    EntreesSorties.afficherMessage("Cet ouvrage existe deja.");
		}
        }
        
	private Ouvrage creationOuvrage(String isbn)
        {	
                    PublicCible p=PublicCible.ADULTE;
                    boolean t;
                    String titre = EntreesSorties.lireChaine("Entrez le titre de l'ouvrage : ");
                    String nomEditeur = EntreesSorties.lireChaine("Entrez le nom d'editeur : ");
                    String nomAuteur = EntreesSorties.lireChaine("Entrez le nom d'auteur : ");
                    GregorianCalendar dateParution = EntreesSorties.lireDate("Entrez la date de parution :");
                    Integer publique = EntreesSorties.lireEntier("Entrez le type de public pour cet ouvrage, en tapant : 1 pour Enfant, 2 pour Adolescent, 3 pour Adulte : ");
                    
                    do{
                        t = false;
                        
                        switch (publique){
                                    case 1 : {
                                            p=PublicCible.ENFANT;
                                            break;
                                    }
                                    case 2 : {
                                             p=PublicCible.ADOLESCENT;
                                            break;
                                    }
                                    case 3 : {
                                             p=PublicCible.ADULTE;
                                            break;
                                    }
                                    default : {
                                             EntreesSorties.afficherMessage("Inserez : 1 pour Enfant, 2 pour Adolescent ou 3 pour Adulte.");
                                             t=true;
                                            break;
                                    }
                            }
                    } while (t);
                    
                    Ouvrage o = new Ouvrage(isbn, titre, nomEditeur, dateParution, nomAuteur, p);
                    lierOuvrage(o, isbn);
                   
                   EntreesSorties.afficherMessage("L'ouvrage a bien été créé.");     
                   return o; 
                   
		} 
        
             
        
        
        /*
	 * La méthode nouvelExemplaire permet de créer un exempalire en demandant la saisie de l'ISBN, puis 
	 * date de parution.
         * Si l'ouvrage n'existe pas, on le crée en demandant les informations correspondantes
         * A la création, on génère un numéro d'exemplaire (en fonction du nombre d'exemplaires pré-éxistant)
	 */
        public void nouvelExemplaire()
        {
            String isbn = EntreesSorties.lireChaine("Entrez le numéro ISBN de l'ouvrage : ");
            Ouvrage o = unOuvrage(isbn);

            if (o == null)
            {
               EntreesSorties.afficherMessage("Cet ouvrage n'existe pas, nous allons le créer.");
               o =this.creationOuvrage(isbn);
                
            }
                        
            o.ajouterExemplaire();
            
        }
	/*
	 * La méthode consulterLecteur permet d'afficher l'ensemble des informations relatives à
	 * un lecteur, par la saisie de son identifiant (numéro de lecteur).
	 * Si le numéro de lecteur n'est pas dans la base de données de bibliotheque un message d'erreur est
	 * renvoyé a l'utilisateur.
	 */
	public void consulterLecteur()
	{
		Integer numLecteur = EntreesSorties.lireEntier("Entrez le numero du lecteur : ");
		
		Lecteur l = unLecteur(numLecteur);
		
		if (l!=null){
			l.infosReduitLecteur();
                        l.afficherInfosEmprunts();
		}
		else {
			EntreesSorties.afficherMessage("Aucun lecteur n'est associé à ce numero.");
		}
	}
        
             
	               
	
	/*
	 * La méthode consulterOuvrage permet d'afficher l'ensemble des informations relatives à
	 * un ouvrage, par la saisie de son ISBN.
         * Si le numéro ISBN n'est pas dans la base de données de bibliotheque un message d'erreur est
         * renvoyé a l'utilisateur.
	 */
        public void consulterOuvrage()
        {
         
            String isbn = EntreesSorties.lireChaine("Entrez le numero d'isbn : ");
		
		Ouvrage o = unOuvrage(isbn);
		
		if (o!=null){
			o.infosOuvrage();
		}
		else {
			EntreesSorties.afficherMessage("Aucun Ouvrage n'est associe à ce numero.");
		}
            
        }
        
        /*
	 * La méthode consulterExemplaireOuvrage permet d'afficher l'ensemble des informations relatives à
	 * un ouvrage, ainsi que tous ses exempalires existants (avec leur numéro d'exemplaire) à partir de 
         * la saisie de son ISBN.
         * Si le numéro ISBN n'est pas dans la base de données de bibliotheque un message d'erreur est
         * renvoyé a l'utilisateur.
	 */
        public void consulterExemplaireOuvrage()
        {         
            String isbn = EntreesSorties.lireChaine("Entrez le numero d'isbn : ");
		
		Ouvrage o = unOuvrage(isbn);
		
		if (o!=null){
                    o.infosReduitOuvrage();
                    o.afficherInfosExemplaire();
                }
                else {
			EntreesSorties.afficherMessage("Aucun Ouvrage n'est associe à ce numero.");
		}
            
               
        }
        
        
        public void emprunterExemplaire()
        {
            Integer numExemplaire = EntreesSorties.lireEntier("Entrez le numero de l'exemplaire : ");
            String isbn = EntreesSorties.lireChaine("Entrez l'isbn");
            Ouvrage o = unOuvrage(isbn);
            
            if(exemplaireEmpruntable(o, numExemplaire))
            {
                Integer numLecteur = EntreesSorties.lireEntier("Entrez le numero du lecteur : ");
                Lecteur l = unLecteur(numLecteur);  //je pense qu'il faut ajouter if (l:=null) sinon on continu le programme avec un lecteur inexistant
                if(!etatSature(numLecteur)) //si c'est false on continue
                {
                    int age = age(numLecteur);
                    PublicCible publicO = o.getPublic();
                    if(agePublic(age, publicO))
                    {
                        //CREER EMPRUNT
                    }
                 
                    
                }
            }
            
        // une méthode pour passer un exemplaire de empruntable à en consultation sur place
        public void editerExemplaire()
        {
            Integer numExemplaire = EntreesSorties.lireEntier("Entrez le numero de l'exemplaire : ");
            String isbn = EntreesSorties.lireChaine("Entrez l'isbn");
            Ouvrage o = unOuvrage(isbn); 
            
            o.editerExemplaire(numExemplaire);
             EntreesSorties.afficherMessage("L'exemplaire à été modifié."); 
        }
                                    
           // lierNumLecteurNumExemplaire(numLecteur, numExemplaire);
               
        public void rendreExemplaire()
        {
           Integer numExemplaire = EntreesSorties.lireEntier("Entrez le numero de l'exemplaire : ");
           String isbn = EntreesSorties.lireChaine("Entrez l'ISBN : ");
        
            Ouvrage o = unOuvrage(isbn);
            
            o.supEmprunt(numExemplaire);
            EntreesSorties.afficherMessage("L'emprunt à été supprimé.");       
        
        }
                
                
        public void relancerLecteur()
        {
            
            HashMap<Integer, Lecteur> ensL = lesLecteurs();
                       
            for(Lecteur l : ensL.values())
            { 
                l.relancerLecteur();
            }                  
            
        }
        
        
        
// -----------------------------------------------
	// Private
// -----------------------------------------------
	
	// -----------------------------------------------
		// Setters
	// -----------------------------------------------
	
	private void setLecteurs(HashMap<Integer, Lecteur> dicoLecteur) {
		_dicoLecteur = dicoLecteur;
	}

	private void setOuvrages(HashMap<String, Ouvrage> dicoOuvrage) {
		_dicoOuvrage = dicoOuvrage;
	}
	
	// -----------------------------------------------
		// Méthodes
	// -----------------------------------------------
	
	/*
	 * La méthode unLecteur permet de rechercher dans la base de donnée de bibliotheque un objet 
	 * lecteur identifié par son numéro, et de renvoyer l'objet. (ou la donnée null s'il n'est pas trouvé)
	 */
	private Lecteur unLecteur(Integer numLecteur)
	{
		return _dicoLecteur.get(numLecteur);
	}
        
        
	
        /*
	 * La méthode unOuvrage permet de rechercher dans la base de donnée de bibliotheque un objet 
	 * ouvrage identifié par son ISBN, et de renvoyer l'objet. (ou la donnée null s'il n'est pas trouvé)
	 */
	private Ouvrage unOuvrage(String isbn)
	{
		return _dicoOuvrage.get(isbn);
	}
	
        
	/*
	 * La méthode lierLecteur permet d'ajouter un lecteur a la base de donnée de bibliotheque.
	 */
	private void lierLecteur(Lecteur L, Integer numLecteur)
	{
		_dicoLecteur.put(numLecteur, L);
	}
	
        
        private void lierOuvrage(Ouvrage o, String isbn)
	{
		_dicoOuvrage.put(isbn, o);
	}
	
	/*
	 * La méthode lesLecteurs permet de créer un iterator sur les lecteurs, dans le but de les parcourir
	 * pour eventuellement les relancer.
	 */
	private HashMap<Integer, Lecteur> lesLecteurs()
	{       
                return _dicoLecteur;
                
            
	}  
            
    /**
     * @return the _numLast
     */
    public Integer getNumLast() {
        return _numLast;
    }

    /**
     * @param _numLast the _numLast to set
     */
    public void setNumLast(Integer _numLast) {
        this._numLast = _numLast;
    }


    


    //les classes qui peuvent être utiles (fait par Antoine)
    
    private void lierNumLecteurNumExemplaire(Lecteur l, Exemplaire e)
    {
        _dicoEmprunt.remove(l, e); //interdit ça!!
    }

    private void delierNumLecteurNumExemplaire(Integer numLecteur, Integer numExemplaire)
    {
        _dicoEmprunt.remove(numLecteur, numExemplaire);
    }

    
    /*
    exemplaireEmpruntable retourne true si l'exemplaire peut etre emprunté false sinon, il appelle des fonctions de ouvrage
    */
    private boolean exemplaireEmpruntable(Ouvrage o, int numExemplaire)
    {
        Exemplaire e = o.monExemplaire(numExemplaire);
        if(e!=null)
        {
            if(o.etatEmpruntabilite(e) && o.etatDisponibilite(e))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
              
    }
    
    
    /*
    etatSature retourne true si le lecteur de numero numLecteur ne peut plus emprunter false sinon
    */
    
    private boolean etatSature(int numLecteur)
    {
        Lecteur l = unLecteur(numLecteur);
        int nb = l.getNbEmprunt();
        if (nb<5)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    /*
    age retourne l'age du lecteur de numero numLecteur
    */
    
    private int age(int numLecteur)
    {
        Lecteur l = unLecteur(numLecteur);
        return l.calculAge();        
    }
    
    /*
    agePublic retourne true si l'ouvrage correspond à la tranche d'âge correspondante false sinon
    */
    
    private boolean agePublic(int age, PublicCible publiq)
    {
        boolean retour;
        switch(publiq)
        {
            case ADOLESCENT :
            {
                if(age < 10)
                    retour = false;
                else    
                    retour = true;
            }
            case ADULTE :
            {
                if(age < 16)
                    retour = false;
                else
                    retour = true;
            }   
            default : 
            {
                retour = true;
            }
       }
        return retour;
    }
    
    private void CreerEmprunt(Lecteur l, Exemplaire e)
    {
        
    }
    
    //private Exemplaire unExemplaire(String isbn, Integer numExemplaire)
    //{
        //return _dicoOuvrage.get(xemplaire);
        
        //_exemplaire = new HashSet<Exemplaire>();
        
    //}
}

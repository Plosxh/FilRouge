import java.io.Serializable;
import java.util.Calendar;
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
	* Les dictionnaires de Lecteur et Ouvrage permettent à bibliotheque de 
	* garantir l'unicité de ces derniers, et facilitent les recherches et créations.
	*/
	
// -----------------------------------------------
        //Constructeur
// -----------------------------------------------
	
        public Bibliotheque() 
        {
            this.setLecteurs(new HashMap<Integer, Lecteur>());
            this.setOuvrages();
                        
        }
	
// -----------------------------------------------
	// Public
// -----------------------------------------------	
		
        // -----------------------------------------------
                // Getters
	// -----------------------------------------------
                
        public Integer getNumLast() 
        {
            return _numLast;
        }
                
	// -----------------------------------------------
                // Méthodes
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
		String nom = EntreesSorties.lireChaine("Entrez le nom : ");
		String prenom = EntreesSorties.lireChaine("Entrez le prénom : ");
		Integer age;
                GregorianCalendar dateNaiss, dateNaissComp;
		GregorianCalendar dateActuelle = new GregorianCalendar();
		do {
                    dateNaiss = EntreesSorties.lireDate("Entrez la date de naissance du lecteur : ");
                    dateNaissComp = new GregorianCalendar(dateActuelle.get(GregorianCalendar.YEAR), dateNaiss.get(GregorianCalendar.MONTH), dateNaiss.get(GregorianCalendar.DATE));
                    if(dateNaissComp.before(dateActuelle)) {
                        age=dateActuelle.get(GregorianCalendar.YEAR)-dateNaiss.get(GregorianCalendar.YEAR);
                    }
                    else {
			age=dateActuelle.get(GregorianCalendar.YEAR)-dateNaiss.get(GregorianCalendar.YEAR)-1;
                    }
                    if ((age<=3) | (age>=110)) {
			EntreesSorties.afficherMessage("Age incorrecte ("+age+"), veuillez recommencer.");
                    }
                    else {
			EntreesSorties.afficherMessage("Age du lecteur : " + age + " ans.");
                    }
		} while ((age<=3) | (age>=110));
                String adresse = EntreesSorties.lireChaine("Entrez l'adresse : ");
                String tel = EntreesSorties.lireChaine("Entrez le numéro de téléphone : ");
                EntreesSorties.afficherMessage("Fin de saisie.");
			 
                L = new Lecteur(nom, prenom, numLecteur, dateNaiss, adresse, tel);
		lierLecteur(L, numLecteur);

                EntreesSorties.afficherMessage("Le numéro de ce nouveau lecteur est : " + numLecteur + ".");

            }
            else {
		EntreesSorties.afficherMessage("Ce numero de lecteur existe déjà.");
            }
	}
	
        /*
	 * La méthode nouvelOuvrage permet d'initialiser la création d'un nouvel ouvrage
	 */
        public void nouvelOuvrage()
        {
            String isbn = EntreesSorties.lireChaine("Entrez le numéro ISBN : ");
            Ouvrage o = unOuvrage(isbn);
            if (o==null){
                this.creationOuvrage(isbn);
            }
            else{
                EntreesSorties.afficherMessage("Cet ouvrage existe déjà.");
            }
        }
        
        /*
	 * La méthode creationOuvrage permet de créer un ouvrage en demandant la saisie de son titre, le nom de l'éditeur,
	 * la date de parution, le(s) nom(s) de l'auteur (ou des auteurs), son ISBN et le public visé
	 */
	public Ouvrage creationOuvrage(String isbn)
        {	
            PublicCible p=PublicCible.ADULTE;
            boolean t;
            String titre = EntreesSorties.lireChaine("Entrez le titre de l'ouvrage : ");
            String nomEditeur = EntreesSorties.lireChaine("Entrez le nom de l'éditeur : ");
            String nomAuteur = EntreesSorties.lireChaine("Entrez le nom d'auteur : ");
            GregorianCalendar dateParution = EntreesSorties.lireDate("Entrez la date de parution : ");
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
                        EntreesSorties.afficherMessage("Insérez : 1 pour Enfant, 2 pour Adolescent ou 3 pour Adulte.");
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
            Integer numLecteur = EntreesSorties.lireEntier("Entrez le numéro du lecteur : ");
            Lecteur l = unLecteur(numLecteur);
		
            if (l!=null){
		l.afficherLecteur();
                l.infosEmprunts();
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
            String isbn = EntreesSorties.lireChaine("Entrez le numero ISBN : ");
            Ouvrage o = unOuvrage(isbn);
		
            if (o!=null){
		o.infosOuvrage();
            }
            else {
		EntreesSorties.afficherMessage("Aucun Ouvrage n'est associé à ce numéro.");
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
            String isbn = EntreesSorties.lireChaine("Entrez le numero ISBN : ");
            Ouvrage o = unOuvrage(isbn);
		
            if (o!=null){
                o.infosReduitOuvrage();
                o.infosExemplaire();
            }
            else {
                EntreesSorties.afficherMessage("Aucun Ouvrage n'est associé à ce numéro.");
            }              
        }
        
        // une méthode qui permet d'emprunter un exemplaire d'un ouvrage et de l'associer à un lecteur
        public void emprunterExemplaire()
        {
            String isbn = EntreesSorties.lireChaine("Entrez l'ISBN : ");
            Integer numExemplaire = EntreesSorties.lireEntier("Entrez le numero de l'exemplaire : ");
            Ouvrage o = unOuvrage(isbn);
            
            if(o!=null)
            {
                Exemplaire e = o.unExemplaire(numExemplaire);
                if(e!=null)
                {
                    if(o.exemplaireEmpruntable(e))
                    {
                        Integer numLecteur = EntreesSorties.lireEntier("Entrez le numéro du lecteur : ");
                        Lecteur l = unLecteur(numLecteur); 
                        if(l!=null)
                        {
                            if(!l.etatSature()) //si c'est false on continue
                            {
                                int age = l.calculAge();
                                PublicCible publicO = o.getPublic();
                                if(comparePublicAge(age, publicO))
                                {
                                    GregorianCalendar dateEmprunt = new GregorianCalendar();
                                    GregorianCalendar dateRetour = new GregorianCalendar();
                                    
                                    dateRetour.add((GregorianCalendar.DAY_OF_MONTH),8);
                                    Emprunt em = new Emprunt(l, e, dateEmprunt, dateRetour);
                                    em.ajouterEmprunt(l, e);
                                    EntreesSorties.afficherMessage("Vous avez saisi : " + EntreesSorties.ecrireDate(dateEmprunt));
                                    EntreesSorties.afficherMessage("Vous avez saisi : " + EntreesSorties.ecrireDate(dateRetour));
                                    EntreesSorties.afficherMessage("L'exemplaire a bien été emprunté.");
                                }
                                else{
                                    EntreesSorties.afficherMessage("Ce lecteur est trop jeune pour emprunter cet Ouvrage.");
                                }
                            }
                            else{
                                EntreesSorties.afficherMessage("Ce lecteur a déjà 5 exemplaires.");
                            }
                        }
                        else{
                            EntreesSorties.afficherMessage("Aucun lecteur n'est associé à ce numéro.");
                        }
                    }
                    else{
                        EntreesSorties.afficherMessage("Cet exemplaire ne peut pas être emprunté (déjà emprunté ou en lecture sur place). ");// un seul booleen teste les 2
                    }
                }                    
                else{
                    EntreesSorties.afficherMessage("Aucun exemplaire n'est associé à ce numéro.");// un seul booleen teste les 2
                }
            }
            else{
                EntreesSorties.afficherMessage("Aucun ouvrage n'est associé à ce numéro.");
            }
        }
                            
        // une méthode pour passer un exemplaire de empruntable à en consultation sur place (mais pas dans l'autre sens attention)
        public void editerExemplaire()
        {
            String isbn = EntreesSorties.lireChaine("Entrez l'ISBN : ");
            Integer numExemplaire = EntreesSorties.lireEntier("Entrez le numéro de l'exemplaire : ");
            Ouvrage o = unOuvrage(isbn); 
            o.editerExemplaire(numExemplaire);
            EntreesSorties.afficherMessage("L'exemplaire à été modifié."); 
        }
        
        // une méthode qui permet de délier les emprunts d'un lecteur
        public void rendreExemplaire()
        {
            String isbn = EntreesSorties.lireChaine("Entrez l'ISBN : ");
            Integer numExemplaire = EntreesSorties.lireEntier("Entrez le numéro de l'exemplaire : ");                  
            Ouvrage o = unOuvrage(isbn);            
            o.supEmprunt(numExemplaire);
            EntreesSorties.afficherMessage("L'exemplaire a bien été rendu.");       
        }
                
        // une méthode qui sert à visualiser tous les exemplaires en retard tous les lecteurs de la bibliothèques
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
		// Setter
	// -----------------------------------------------
	
	private void setLecteurs(HashMap<Integer, Lecteur> dicoLecteur) 
        {
            _dicoLecteur = dicoLecteur;
	}

	private void setOuvrages() 
        {
            HashMap   dicoOuvrage = new HashMap<String, Ouvrage>();
            _dicoOuvrage = dicoOuvrage;
	}
        
        private void setNumLast(Integer _numLast) 
        {
            this._numLast = _numLast;
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
	 * La méthode lesLecteurs permet de créer un iterator sur les lecteurs, dans le but de les parcourir
	 * pour eventuellement les relancer.
	 */
	private HashMap<Integer, Lecteur> lesLecteurs()
	{       
            return _dicoLecteur;
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
         * agePublic retourne true si l'ouvrage correspond à la tranche d'âge correspondante, false sinon
         */
        private boolean comparePublicAge (int age, PublicCible publicOuvrage)
        {
           if (publicOuvrage == PublicCible.ADULTE && age < 16) 
              return false;
           else return !(publicOuvrage == PublicCible.ADOLESCENT && age < 10);
        }
        
    }

    

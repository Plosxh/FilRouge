
public class MenuBiblio {
	private Bibliotheque _bibliotheque;
	
	public MenuBiblio (Bibliotheque bibliotheque) {
	_bibliotheque = bibliotheque;
	}
	
	/*
	 * menuPrincipal permet � l'utilisateur de selectionner un type de sous menu (Lecteur, Ouvrage ou Exemplaire) 
	 * o� il effectuera par la suite l'action d�sir�e. Si l'utilisateur a fini d'utiliuser le programme, il choisit l'option Quitter.
	*/
public void menuPrincipal() {
	Integer menu;
	do {
		EntreesSorties.afficherMessage(" ========================================================");
		EntreesSorties.afficherMessage("|                   Menu Principal                       |");
		EntreesSorties.afficherMessage("| Saisissez un numéro correspondant :                    |");
		EntreesSorties.afficherMessage("| Menu Lecteur : 1                                       |");
                EntreesSorties.afficherMessage("| Menu Periodique : 2                                    |");
                EntreesSorties.afficherMessage("| Menu Parution : 3                                      |");
                EntreesSorties.afficherMessage("| Menu Article : 4                                       |");
                EntreesSorties.afficherMessage("| Menu Ouvrage : 5                                       |");
                EntreesSorties.afficherMessage("| Menu Exemplaire : 6                                    |");
                EntreesSorties.afficherMessage("| Menu Emprunt : 7                                       |");
                EntreesSorties.afficherMessage("| Relancer Lecteurs : 8                                  |");
                EntreesSorties.afficherMessage("| Ajouter informations : 9                               |");
		EntreesSorties.afficherMessage("| Quitter : 0                                            |");
		EntreesSorties.afficherMessage(" ========================================================");
		menu = EntreesSorties.lireEntier();
			
			switch (menu){
				case 1 : {
					this.menuLecteur();
					break;
                                        }
                                
                        
                                case 2 : {
                                        this.menuPeriodique();
                                        break;
                                         }
                                
                                case 3 : {
                                        this.menuParution();
                                        break;
                                         }
                                
                                case 4 : {
                                        this.menuArticle();
                                        break;
                                         }
                             
                                case 5 : {
                                        this.menuOuvrage();
                                        break;
                                         }
                       
                                case 6 : {
                                        this.menuExemplaire();
                                        break;
                                        }
                                 
                                case 7 : {
                                        this.menuEmprunt();
                                        break;
                                        }
                                
                                case 8 : {
                                        _bibliotheque.relancerLecteur();
                                        break;
                                        }
                                
                                case 9 : {
                                        this.menuInformation();
                                        break;
                                        }
				
				default : {
					break;
				}
			}
	} while (menu != 0);	
}

	/* menuLect permet d'effectuer une s�rie d'action concernant les utilisateur (lecteurs) de la biblioth�que.
	 * Une fois une action effectu�e, l'utilisateur sera rediriger vers ce m�me menu afin de pouvoir selectionner
	 * une nouvelle fois une action concernant les lecteurs.
	 * "Retour Menu Principal" renvoi l'utilisateur au menu principal.
	*/
public void menuLecteur() {
	Integer menuLect;
	do {
		EntreesSorties.afficherMessage(" ========================================================");
		EntreesSorties.afficherMessage("| Saisissez un numéro correspondant :                    |");
		EntreesSorties.afficherMessage("| Nouveau Lecteur : 1                                    |");
		EntreesSorties.afficherMessage("| Consulter un Lecteur : 2                               |");
		EntreesSorties.afficherMessage("| Retour Menu Principal : 0                              |");
		EntreesSorties.afficherMessage(" ========================================================");
		menuLect = EntreesSorties.lireEntier();
			
			switch (menuLect){
				case 1 : {
					_bibliotheque.nouveauLecteur();
					break;
				}
				case 2 : {
					_bibliotheque.consulterLecteur();
					break;
				}
				default : {
					break;
				}
			}
	} while (menuLect != 0);	
}




public void menuPeriodique() {
	Integer menuPerio;
	do {
		EntreesSorties.afficherMessage(" ========================================================");
		EntreesSorties.afficherMessage("| Saisissez un numéro correspondant :                    |");
		EntreesSorties.afficherMessage("| Nouvel Periodique : 1                                  |");
                EntreesSorties.afficherMessage("| Consulter Periodique : 2                               |");
		EntreesSorties.afficherMessage("| Retour Menu Principal : 0                              |");
		EntreesSorties.afficherMessage(" ========================================================");
		menuPerio = EntreesSorties.lireEntier();
			
			switch (menuPerio){
				case 1 : {
					_bibliotheque.nouveauPeriodique();
					break;
				}
                                
                                case 2 : {
					_bibliotheque.consulterPeriodique();
					break;
				}

				default : {
					break;
				}
                                
        }
     
  
	} while (menuPerio != 0);	
}

public void menuParution() {
	Integer menuParu;
	do {
		EntreesSorties.afficherMessage(" ========================================================");
		EntreesSorties.afficherMessage("| Saisissez un numéro correspondant :                    |");
		EntreesSorties.afficherMessage("| Nouvelle Parution : 1                                  |");
                EntreesSorties.afficherMessage("| Consulter Parution Periodique : 2                      |");
		EntreesSorties.afficherMessage("| Retour Menu Principal : 0                              |");
		EntreesSorties.afficherMessage(" ========================================================");
		menuParu = EntreesSorties.lireEntier();
			
			switch (menuParu){
				case 1 : {
					_bibliotheque.nouvelleParution();
					break;
				}
                                
                                case 2 : {
					_bibliotheque.consulterParutionPeriodique();
					break;
				}

				default : {
					break;
				}
                                
        }
     
  
	} while (menuParu != 0);	
}

public void menuArticle() {
	Integer menuArti;
	do {
		EntreesSorties.afficherMessage(" ========================================================");
		EntreesSorties.afficherMessage("| Saisissez un numéro correspondant :                    |");
		EntreesSorties.afficherMessage("| Nouvel Article : 1                                     |");
                EntreesSorties.afficherMessage("| Consulter Article : 2                                  |");
		EntreesSorties.afficherMessage("| Retour Menu Principal : 0                              |");
		EntreesSorties.afficherMessage(" ========================================================");
		menuArti = EntreesSorties.lireEntier();
			
			switch (menuArti){
				case 1 : {
					_bibliotheque.nouvelArticle();
					break;
				}
                                
                                case 2 : {
					_bibliotheque.consulterArticle();
					break;
				}

				default : {
					break;
				}
                                
        }
     
  
	} while (menuArti != 0);	
}



public void menuOuvrage() {
	Integer menuOuvr;
	do {
		EntreesSorties.afficherMessage(" ========================================================");
		EntreesSorties.afficherMessage("| Saisissez un numéro correspondant :                    |");
		EntreesSorties.afficherMessage("| Nouvel Ouvrage : 1                                     |");
		EntreesSorties.afficherMessage("| Consulter un Ouvrage : 2                               |");
		EntreesSorties.afficherMessage("| Retour Menu Principal : 0                              |");
		EntreesSorties.afficherMessage(" ========================================================");
		menuOuvr = EntreesSorties.lireEntier();
			
			switch (menuOuvr){
				case 1 : {
					_bibliotheque.nouvelOuvrage();
					break;
				}
                                
				case 2 : {
					_bibliotheque.consulterOuvrage();
					break;
				}
                                
				default : {
					break;
				}
                                
        }
     
  
	} while (menuOuvr != 0);	
}

public void menuExemplaire() {
	Integer menuExemp;
	do {
		EntreesSorties.afficherMessage(" ========================================================");
		EntreesSorties.afficherMessage("| Saisissez un numéro correspondant :                    |");
		EntreesSorties.afficherMessage("| Nouvel Exemplaire : 1                                  |");
		EntreesSorties.afficherMessage("| Consulter les exemplaires d'un ouvrage : 2             |");
                EntreesSorties.afficherMessage("| Editer un Exemplaire (= le rendre empruntable) : 3     |");
		EntreesSorties.afficherMessage("| Retour Menu Principal : 0                              |");
		EntreesSorties.afficherMessage(" ========================================================");
		menuExemp = EntreesSorties.lireEntier();
			
			switch (menuExemp){
				case 1 : {
					_bibliotheque.nouvelExemplaire();
					break;
				}
				case 2 : {
					_bibliotheque.consulterExemplaireOuvrage();
					break;
				}
                                case 3 : {
					_bibliotheque.editerExemplaire();
					break;
				}
				default : {
					break;
				}
			}
                        
	} while (menuExemp != 0);	
}

public void menuEmprunt() {
	Integer menuEmprunt;
	do {
		EntreesSorties.afficherMessage(" ========================================================");
		EntreesSorties.afficherMessage("| Saisissez un numéro correspondant :                    |");
		EntreesSorties.afficherMessage("| Emprunter un Exemplaire : 1                            |");
		EntreesSorties.afficherMessage("| Rendre un Exemplaire : 2                               |");
		EntreesSorties.afficherMessage("| Retour Menu Principal : 0                              |");
		EntreesSorties.afficherMessage(" ========================================================");
		menuEmprunt = EntreesSorties.lireEntier();
			
			switch (menuEmprunt){
				case 1 : {
					_bibliotheque.emprunterExemplaire();
					break;
				}
				case 2 : {
					_bibliotheque.rendreExemplaire();
					break;
				}
				default : {
					break;
				}
			}
                        
	} while (menuEmprunt != 0);	
}

public void menuInformation() {
	Integer menuInfo;
	do {
		EntreesSorties.afficherMessage(" ========================================================");
		EntreesSorties.afficherMessage("| Saisissez un numéro correspondant :                    |");
		EntreesSorties.afficherMessage("| Ajouter Infos Article : 1                              |");
		EntreesSorties.afficherMessage("| Ajouter Infos Ouvrage : 2                              |");
		EntreesSorties.afficherMessage("| Retour Menu Principal : 0                              |");
		EntreesSorties.afficherMessage(" ========================================================");
		menuInfo = EntreesSorties.lireEntier();
			
			switch (menuInfo){
				case 1 : {
					_bibliotheque.ajouterInformationsArticle();
					break;
				}
                                
				case 2 : {
					_bibliotheque.ajouterInformationsOuvrage();
					break;
				}
				default : {
					break;
				}
			}
                        
	} while (menuInfo != 0);	
}

}


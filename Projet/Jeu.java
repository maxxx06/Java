
public class Jeu {

	public static int[] mode_facile={10,20,30,40}, mode_normal={10,33,33,34}, mode_difficile={10,40,30,20};  // different mode de jeu
    public static int turn = 0; 	// initialisation du nombre de tour
    public static int nb_cellules_deplacees=4; // nombre de cellule deplacable par defaut

    public static void main(String[] args) {  	// programme principal
    	while(true){
    		menu();
	    	int choix=utile.saisie_entier();
	    	switch(choix){
	    	case 0 : System.exit(0);
	    	case 1 : debut_jeu();break;
	    	case 2 : rules();break;
	    	default : System.out.println("Erreur de saisie.");break;
	    	}
    	}
    }

    public static void menu(){		// menu d'initialisation
    	System.out.println("Menu:\n"
    			+ "1. Nouvelle partie\n"
    			+ "2. Lire les regles\n"
    			+ "0. Quitter le jeu\n");
    }

    public static void debut_jeu() {
    	menu_difficulte(); 		// choix des difficulte
    	tours_de_jeu();
		message_fin();
    }

    public static void rules(){
    	System.out.println("Bienvenue dans VIRUCELL, un jeu multijoueur "
    			+ "ou un virus tente de se propager dans un organisme "
    			+ "constitue de plusieurs types de cellules :\nX (immunisees "
    			+ "au virus), Y (sensibles mais pouvant guerir en 3 tours) et Z "
    			+ "(sensibles et mourant lorsqu'elles sont infectees).\nLe joueur 1 "
    			+ "joue les virus et le joueur 2 joue les cellules. Le but du virus "
    			+ "est de se propager un maximum en evitant d'infecter des cellules immunisees,\n"
    			+ "celui des cellules est de resister.\n"
    			+ "A chaque tour de jeu, le joueur 1 peut deplacer un ou plusieurs virus, "
    			+ "et le joueur 2 peut deplacer 4 cellules. Ces deplacements se font "
    			+ "en utilisant les touches zqsd ou wasd.\n"
				+ "A chaque début de tour vous sera proposée l'option de quitter la partie. En effet, le but est de faire le score le plus élevé, donc vous pouvez quitter la partie quand vous voulez.");
    }

    public static void menu_difficulte(){
    	while(true){
	    	System.out.println("Choisissez la difficulte du jeu.");
	    	System.out.println("1. Facile\n2. Normal\n3. Difficile\n4. Personnalise\n");
	    	int choix=utile.saisie_entier();
	    		switch(choix){
	    		case 1 : Plateau.aleatoire("non personnalise",mode_facile);return;
	    		case 2 : Plateau.aleatoire("non personnalise",mode_normal);return;
	    		case 3 : Plateau.aleatoire("non personnalise",mode_difficile);return;
	    		case 4 : Plateau.aleatoire("personnalise",null);return;
	    		default : System.out.println("Erreur de saisie.");break;
    		}
    	}

    }

    public static void tours_de_jeu() {
        while (true) {
        	avancee_tour();
            Plateau.affiche_plateau();
            Plateau.gestion_infectes();
            int choix=virus_intro();
			if(choix==405){
				return;
			}
            int cpt=0;
            tour_joueur(cpt,choix,"Virus");

            int choix2=cellule_intro();
			if(choix==405){
				return;
			}
            cpt=0;
            tour_joueur(cpt,nb_cellules_deplacees,"Cell");
        }
    }

    public static int virus_intro(){   	// s'affiche quand c'est au virus de jouer
    	try{
    		System.out.println("~~~~ C'est au tour des virus ~~~~");
			if(continuer_partie()){
	        	System.out.println("Combien voulez-vous deplacer de virus ? Vous en avez "+Virus.cpt_virus);
	        	int choix=utile.saisie_entier();
	        	if(choix>Virus.cpt_virus){
	        		System.out.println("Entree d'un nombre trop grand. Merci de saisir un nombre compris entre 0 et "+Virus.cpt_virus);
	        		choix=virus_intro();
	        	}
	        	return choix;
			}
			else{
				return 405;
			}
		}
		catch(NumberFormatException e){
			System.out.println("Erreur de saisie. Merci de saisir un nombre compris entre 0 et "+Virus.cpt_virus);
			return virus_intro();
			}
    }

    public static int cellule_intro() { 		// s'affiche quand c'est au cellule de jouer
        System.out.println("~~~~ C'est au tour des cellules ~~~~");
		if(continuer_partie()){
        	System.out.println("Vous avez "+Cell.cpt_cell+" cellules. Vous pouvez deplacer un maximum de "+nb_cellules_deplacees+" cellules.");
			return 0;
		}
		else{
			return 405;
		}
	}

    public static void tour_joueur(int cpt, int choix, String entite){
        while (cpt<choix) {
            Plateau.affiche_plateau();
            Plateau.deplacement_plateau(cpt,entite);
            cpt+=1;
        }
    }

    public static void avancee_tour(){
    	turn+=1;
    	System.out.println("|||| TOUR "+turn+" ||||");
    }

	public static boolean continuer_partie(){
		while(true){
			System.out.println("Voulez-vous continuer la partie ? y/n");
			String continuer=utile.saisie_chaine();
			switch(continuer){
				case "y" :
				case "Y" :
					return true;
				case "n" :
				case "N" :
					return false;
				default : System.out.println("Erreur. Reessayez en utilisant y/n");
			}
		}
	}

	public static void message_fin(){
		if(Virus.cpt_virus>0){
			System.out.println(Virus.cpt_virus+" virus ont réussi à évoluer dans l'organisme. Mais "+Cell.cpt_cell+" cellules subsistent encore...");
		}
		else {
			System.out.println("Tous les virus sont morts.");
		}
	}


}

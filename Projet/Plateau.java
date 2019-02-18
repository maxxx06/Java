import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.regex.*;


public class Plateau {

    public static String[] directions={"q","w","s","d","a","z"};    // configuration possible à l'utilisateur pour se deplacer
    public static Individu[][] grille=generation_plateau();


    public static Individu[][] generation_plateau() {   // creation de la grille
        Individu plateau [][] = new Individu[20][20];
        for (int i = 0; i<20; i++ ) {
            for (int j = 0; j<20; j++ ) {
                Empty item=new Empty(i,j);      // remplir par des cases vides
                plateau[i][j]=item;
            }
        }
        return plateau;
    }

    public static void affiche_plateau() {      // methode d'affiche de la grille
        for (int i = 0; i<20; i++ ) {
            for (int j = 0; j<20; j++ ) {
                System.out.print("|"+grille[i][j].get_id()+"|");
            }
            System.out.println();
        }
    }

    public static void aleatoire(String mode, int[] mode_de_jeu) {      // placer aléatoirement les individus sur la grille
    	CVVector vct= new CVVector();
    	Vector<Integer> tab = new Vector<>();
        for ( int i=0;i<400;i++) {
            tab.add(i);     // ce vecteur nous serbviration pour recuperer les indices de chaque iondividu
        }

        if(mode.equals("personnalise")) {
            vct.add_idv_personnalise();
        }
        else {
        	vct.add_idv_fixe(mode_de_jeu);
        }

        for (Enumeration e = vct.elements(); e.hasMoreElements();) {       // parcours du vecteur
            Random rand = new Random();         // creation d'un objet Random
            int indice= rand.nextInt(tab.size());      // choix aleatoire d'un indice du vecteur tab
            int new_indice_line=tab.elementAt(indice)%20;       // attribution d'un coordonne x
            int new_indice_column=tab.elementAt(indice)/20;     // attribution d'une coordonnée Y
            Individu item = (Individu)e.nextElement();
            item.set_x(new_indice_line);        // definir les coordonee de l'individu
            item.set_y(new_indice_column);
            grille[new_indice_line][new_indice_column]=item;        // placer l'individu sur le plateau
            tab.remove(indice);         // retire l'indice trouve pour evide de tomber plusieurs fois sur les meme coordonnees
        }
    }


    public static void deplacement_plateau(int cpt, String type) {
    	while(true){

    		Individu item=find_plateau(choix_individu());

	        if((item instanceof Cell && type=="Virus") || (item instanceof Virus && type=="Cell")) {    // quand c'est au tour des virus mais qu'il selectionne une cellule
                                                                                                        // ou lorsqu'il joue les cellules mais qu'il a selectionne un virus
		        	System.out.println("Vous avez selectionne une entite appartenant a l'adversaire");
		        	deplacement_plateau(cpt,type);
		        	return;
	        }
	        item.affiche();
	        if(cpt==0 && !(item instanceof Y_Cell)){
	        	item.reset_move();
	        }
		    if(!(item.did_moved())) {     // si l'individu ne s'est pas encore deplacé
		    	String move_choice=choix_deplacement();
		        if (item instanceof Cell) {  // si il a selectionné une cellule
		        	Cell cellule=(Cell)item;
		            cellule.deplacement(move_choice);     // deplacement cellule
		            break;
		        }
		        else{
		        	Virus vrs=(Virus)item;
		            vrs.deplacement(move_choice);     // deplacement des virus
		            break;
		        }
		    }
		    else{
		        	System.out.println("Cet individu est infecte ou a deja ete deplace.");
		    }
	   }

   }

    public static Individu find_plateau(String id) {        // fonction de recherche d'un id sur la grille
        for (int i = 0; i<20; i++ ) {
            for (int j = 0; j<20; j++ ) {
                Individu item = grille[i][j];
                if (item.get_id().equals(id)) {
                    return item;
                }
            }
        }
        System.out.println("Objet introuvable");
        Individu item=find_plateau(choix_individu());
        return item;
    }


    public static void gestion_infectes() {        // cas des cellules infectees
        for (int i = 0; i<20; i++ ) {
            for (int j = 0; j<20; j++ ) {
                Individu item = grille[i][j];
                if(item instanceof Y_Cell) {
                	((Y_Cell) item).y_turn();      // cas pour la cellule y
                }
            }
        }
    }

    public static String choix_individu() {
    	System.out.println("Donnez l'id de l'individu que vous voulez deplacer");
    	String choix=utile.saisie_chaine();
    	return choix;
    }

    public static String choix_deplacement() {
        System.out.println("Dans quelle direction ? q/a : gauche   s : bas    d : droite    z/w : haut");
        String move_choice=utile.saisie_chaine();
        if(utile.includes(directions, move_choice)){
        	return move_choice;
        }
        System.out.println("Erreur de saisie. Reessayez en utilisant les touches zqsd ou wasd.");
        String second_move_choice=choix_deplacement();
        return second_move_choice;

    }


}

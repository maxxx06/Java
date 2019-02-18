import java.io.*;
import java.util.*;

public class CVVector extends Vector {

    public void add_idv_personnalise() {    // Permet à l'utilisateur de créer soi même le nombre d'individu qu'il souhaite
        int reponse=1;
        while(reponse!=0) {
            System.out.println("\n1. Virus\n2. Cellule X\n3. Cellule Y\n4. Cellule Z\n0. Fin\n5. Pour quitter");
            reponse = utile.saisie_entier();    // Recupere la methode saisie_chaine dans la classe Utile
            if(reponse==0){return;}
            System.out.println("Combien voulez-vous en ajouter ?");
            int valeur=utile.saisie_entier();   // Recupere la methode saisie_entier dans la classe Utile
            for (int i=0;i<valeur;i++) {
                Individu item=null;     // Creation d'un nouvel individu item
                switch (reponse) {
                    case 0 : return;
                    case 1 : item = new Virus();break;      // item est un nouveau virus
                    case 2 : item = new X_Cell();break;     // item est une nouvelle cellule X
                    case 3 : item = new Y_Cell();break;     // item est une nouvelle cellule Y
                    case 4 : item = new Z_Cell();break;     // item est une nouvelle cellule Z
                    case 5 : System.exit(1);
                    default: System.out.println("Mauvais numero");break;
                }
                if(item!=null) {
                    addElement(item);      // ajoute les individus
                }
            }
        }
    }

    public void add_idv_fixe(int[] mode_de_jeu) {       // Selon la difficulte choisie, modes de jeu visibles dans la classe Jeu
    	for (int i=0; i<mode_de_jeu.length; i++) {     // liste de forme (virus,x_cell,y_cell,z_cell), permet d'ajouter les bons individus dans le switch
    	  int cpt=mode_de_jeu[i];         // la proportion de chaque individu est mis dans cpt
    	  for(int j=0;j<cpt;j++){      // ajout de "cpt" individus
    		  Individu item=null;
    		  switch(i){
    	  		case 0 : item = new Virus();break;
    	  		case 1 : item = new X_Cell();break;
    	  		case 2 : item = new Y_Cell();break;
    	  		case 3 : item = new Z_Cell();break;
    		  }
    		  addElement(item);       // ajoute ces elements
    	  }
    	}
    }
}

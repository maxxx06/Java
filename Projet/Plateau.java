import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.regex.*;


public class Plateau {

    public static void main(String[] args) {
        CVVector vct=new CVVector();
        String[][] grille=game();
        while (true) {
            System.out.println("\nMenu\n Tapez 0 pour quitter l'application\n Taper 1 pour creer des individus\n Taper 2 pour se deplacer");
            int choix = utile.saisie_entier();
            switch (choix) {
                case 0: System.exit(0);
                case 1: aleatoire(grille,vct);break;
                case 2: deplacement_plateau(vct,grille);break;
            }

        }
    }





    public static void oneIndividu(Vector vector_virus, Vector vector_x, Vector vector_y, Vector vector_z){
        Individu item;
        if (Virus.cpt_virus != vector_virus.size()) {
            item = new Virus();
            vector_virus.addElement(item);
            // System.out.println(vector_virus);
        }
        // on compare le compteur avec la longueur vecteur pour voir s'ils correspondent, si c'est pas le cas on ajoute un idv
    }

    // public static void affiche_individus(Vector vector_virus, Vector vector_cell) {
    //     System.out.println("\n1. Virus\n2. Cellule");
    //     int rep = utile.saisie_entier();
    //     // switch(rep){
    //     //     case 1 : Vector tableau=vector_virus;
    //     //     case 2 : Vector tableau=vector_cell;
    //     // }
    //     for (Enumeration e = vector_virus.elements(); e.hasMoreElements();) {
    //     Virus item = (Virus)e.nextElement();
    //     item.affiche();
    //   }
    // }

    public static String[][] game() {
        String plateau [][] = new String [20][20];
        for (int i = 0; i<20; i++ ) {
            for (int j = 0; j<20; j++ ) {
                plateau[i][j]="|___|";
                // System.out.print(plateau[i][j]);
            }
            // System.out.println();
        }
        return plateau;
    }
    public static void affiche_grille(String[][] grille){
        for (int i = 0; i<20; i++ ) {
            for (int j = 0; j<20; j++ ) {
                System.out.print(grille[i][j]);
            }
            System.out.println();

    }
}

    public static void aleatoire(String[][] grille,CVVector vct) {
        vct.add_idv();
        Vector tab = new Vector();
        for ( int i=0;i<400;i++) {
            tab.add(i);
        }
        for (Enumeration e = vct.elements(); e.hasMoreElements();) {
            Random rand = new Random();
            int indice= rand.nextInt(tab.size());
            System.out.println(indice);
            int new_indice_line=indice%20;
            int new_indice_column=indice/20;
            Individu item = (Individu)e.nextElement();
            item.set_x(new_indice_line);
            item.set_y(new_indice_column);
            grille[new_indice_line][new_indice_column]="|"+item.get_id()+"|";
            tab.remove(tab.indexOf(indice));
            System.out.println(tab);
            item.affiche();
        }
        affiche_grille(grille);

}


   //  public static boolean includes (int[] liste, int sujet) {
   //     for(int i=0;i<liste.length;i++) {
   //         for (int j=0;j<liste.length;j++) {
   //             if(liste[i] == sujet) {
   //                 return true;
   //             }
   //
   //         }
   //     }
   //     return false;
   // }

   public static void effet_virus_cell(CVVector vct, Individu vrs, String[][] grille, int x, int y){
       if(Pattern.matches("X*",grille[y][x])){
           vrs.perte_vie();
       }
       else if(Pattern.matches("z*",grille[y][x])) {
           vrs.gain_vie();
           Individu item=vct.find_id(grille[y][x]);
           item.die();
           System.out.println(item.get_cpt());
           vct.remove(item);

       }
       else if(Pattern.matches("y*",grille[y][x])) {
           Individu item=vct.find_id(grille[y][x]);
           if(!(item.get_infection())) {
               vrs.gain_vie();
               System.out.println(vrs.get_cpt());
               item.infected();
           }
           else {
               vrs.perte_vie();
               System.out.println(vrs.get_cpt());
       }

       }

   }


////////////////////////////// GERER EXCEPTION OUT OF BOUNDS ////////////////////


    public static void deplacement_plateau(CVVector vct,String[][] grille) {
        int cpt=0;
        Vector check_virus=new Vector();
        while(cpt<10){
            affiche_grille(grille);
            System.out.println("Donnez l'id du virus que vous voulez déplacer");
            String choix=utile.saisie_chaine();
            Individu item=vct.find_id(choix);
            int old_x=item.get_x();
            int old_y=item.get_y();
            item.deplacement();
            if(!(check_virus.contains(item))) {
                if (item.get_x()<0 || item.get_x() >= grille.length || item.get_y()<0 || item.get_y() >= grille.length) {
                    System.out.println("Déplacement impossible, indiquez une nouvelle direction.");
                    item.set_x(old_x);
                    item.set_y(old_y);
                    item.deplacement();
                }
                else if (!(grille[item.get_x()][item.get_y()].equals("|___|"))) {
                    effet_virus_cell(vct,item,grille,item.get_x(),item.get_y());
                    item.set_y(old_y);
                    item.set_x(old_x);
                }

                else{
                cpt=cpt+1;
                System.out.println(cpt);
                grille[item.get_x()][item.get_y()]="|"+item.get_id()+"|";
                grille[old_x][old_y]="|___|";

                }
            check_virus.addElement(item);
            }
            else {
                System.out.println("Ce virus a déjà été déplacé");
                item.set_x(old_x);
                item.set_y(old_y);
            }
                }
            }

    }

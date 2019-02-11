import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.regex.*;


public class Plateau {

    public static void main(String[] args) {
        CVVector vct=new CVVector();
        String[][] grille=game();
        while (true) {
            System.out.println("\nMenu\n Tapez 0 pour quitter l'application\n Tapez 1 pour voir plateau de jeu\n Taper 2 pour creer des individus\n Taper 4 pour placer aleatoirement les individus\n Taper 5 pour se deplacer");
            int choix = utile.saisie_entier();
            switch (choix) {
                case 0: System.exit(0);
                case 1: System.out.println(grille);break;
                case 2: aleatoire(grille,vct);break;
                case 5 : deplacement_plateau(vct,grille);break;
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
                System.out.print(plateau[i][j]);
            }
            System.out.println();
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
            int new_indice_line=indice%20;
            int new_indice_column=indice/20;
            Individu item = (Individu)e.nextElement();
            item.set_x(new_indice_line);
            item.set_y(new_indice_column);
            grille[new_indice_line][new_indice_column]="|"+item.get_id()+"|";
            tab.remove(indice);
            item.affiche();
        }
        // for (Enumeration e = vector_y.elements(); e.hasMoreElements();) {
        //     Random rand = new Random();
        //     int indice= rand.nextInt(tab.size());
        //     int new_indice_line=indice%20;
        //     int new_indice_column=indice/20;
        //     Y_Cell item = (Y_Cell)e.nextElement();
        //     item.set_x(new_indice_line);
        //     item.set_y(new_indice_column);
        //     grille[new_indice_line][new_indice_column]="|"+item.get_id()+"|";
        //     tab.remove(indice);
        //     item.affiche();
        // }
        //
        // for (Enumeration e = vector_z.elements(); e.hasMoreElements();) {
        //     Random rand = new Random();
        //     int indice= rand.nextInt(tab.size());
        //     int new_indice_line=indice%20;
        //     int new_indice_column=indice/20;
        //     Z_Cell item = (Z_Cell)e.nextElement();
        //     item.set_x(new_indice_line);
        //     item.set_y(new_indice_column);
        //     grille[new_indice_line][new_indice_column]="|"+item.get_id()+"|";
        //     tab.remove(indice);
        //     item.affiche();
        // }
        //
        // for (Enumeration e = vector_virus.elements(); e.hasMoreElements();) {
        //     Random rand = new Random();
        //     int indice= rand.nextInt(tab.size());
        //     int new_indice_line=indice%20;
        //     int new_indice_column=indice/20;
        //     Virus item = (Virus)e.nextElement();
        //     item.set_x(new_indice_line);
        //     item.set_y(new_indice_column);
        //     grille[new_indice_column][new_indice_line]="|"+item.get_id()+"|";
        //     tab.remove(indice);
        //     item.affiche();

        // }
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

   // public static void effet(Virus vrs, String[][] grille, int x, int y){
   //     if(Pattern.matches("x*",grille[y][x])){
   //         vrs.perte_vie();
   //         X_Cell item = find_x(String grille[y][x], Vector vector_x);
   //
   //     }
   //     // else if(){
   //     //     vrs.gain_vie();
   //     // }
   //     // else if{
   //     //
   //     // }
   //
   // }


////////////////////////////// GERER EXCEPTION OUT OF BOUNDS ////////////////////


    public static void deplacement_plateau(CVVector vct,String[][] grille) {
        int cpt=0;
        Vector check_virus=new Vector();
        while(cpt<10){
            affiche_grille(grille);
            Individu item=vct.find_id();
            int old_x=item.get_x();
            int old_y=item.get_y();
            item.deplacement();
            // if(vct.contains(item)){
            //     System.out.println("blabla");
            // }
            if (!(grille[item.get_y()][item.get_x()].equals("|___|"))) {
                System.out.println("pas possible case pas vide, recommencer");
                item.set_y(old_y);
                item.set_x(old_x);
                item.deplacement();
                }
            else if (item.get_x()<0 || item.get_x() >= grille.length || item.get_y()<0 || item.get_y() >= grille.length){
                System.out.println("Déplacement impossible, indiquez une nouvelle direction.");
                item.set_x(old_x);
                item.set_y(old_y);
                item.deplacement();
                }
            cpt=cpt+1;
            grille[item.get_x()][item.get_y()]="|"+item.get_id()+"|";
            grille[old_x][old_y]="|___|";
            check_virus.addElement(item);
            // break;
                }
            }

    }

import java.io.*;
import java.util.*;
import java.lang.*;



public class Plateau {
    public static void main(String[] args) {
        Vector vector_virus=new Vector();
        Vector vector_x=new Vector();
        Vector vector_y=new Vector();
        Vector vector_z=new Vector();
        String[][] grille=game();
        while (true) {
            System.out.println("\nMenu\n Tapez 0 pour quitter l'application\n Tapez 1 pour voir plateau de jeu");
            int choix = utile.saisie_entier();
            switch (choix) {
                case 0: System.exit(0);
                case 1: System.out.println(grille);break;
                case 2: creation_individus(vector_virus,vector_x,vector_y,vector_z);break;
                // case 3: affiche_individus(vector_virus,vector_cell);break;
                case 4 : aleatoire(grille, vector_virus,vector_x,vector_y,vector_z);break;
                case 5 : deplacement_plateau(vector_virus,grille);break;
            }

        }
    }



    public static void creation_individus(Vector vector_virus, Vector vector_x, Vector vector_y, Vector vector_z) {
        while(true){
        System.out.println("Combien voulez-vous ajouter d'individus ?");
        int valeur=utile.saisie_entier();
        System.out.println("\n1. Virus\n2. Cellule X\n3. Cellule Y\n4. Cellule Z\n0. Fin");
        int rep = utile.saisie_entier();

        for (int i=0;i<valeur;i++) {

            Individu item = null;
            switch (rep) {
                case 0 : return;
                case 1 :
                item = new Virus();
                vector_virus.addElement(item);
                break;
                case 2 :
                item = new X_Cell();
                vector_x.addElement(item);break;
                case 3 :
                item = new Y_Cell();
                vector_y.addElement(item);break;
                case 4 :
                item = new Z_Cell();
                vector_z.addElement(item);break;
                default: System.out.println("Mauvais numero");
            }
        }
    }
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

    public static void aleatoire(String[][] grille,Vector vector_virus, Vector vector_x, Vector vector_y, Vector vector_z) {
        Vector tab = new Vector();
        for ( int i=0;i<400;i++) {
            tab.add(i);
        }
        // X_Cell X = new X_Cell();
        // Y_Cell Y = new Y_Cell();
        // Z_Cell Z = new Z_Cell();
        // Virus V = new Virus();
        for (Enumeration e = vector_x.elements(); e.hasMoreElements();) {
            Random rand = new Random();
            int indice= rand.nextInt(tab.size());
            int new_indice_line=indice%20;
            int new_indice_column=indice/20;
            X_Cell item = (X_Cell)e.nextElement();
            item.set_x(new_indice_line);
            item.set_y(new_indice_column);
            grille[new_indice_line][new_indice_column]="|"+item.get_id()+"|";
            // Cell_z.add("\n line = "+new_indice_line+" column = "+new_indice_column);
            tab.remove(indice);
            item.affiche();
        }
        for (Enumeration e = vector_y.elements(); e.hasMoreElements();) {
            Random rand = new Random();
            int indice= rand.nextInt(tab.size());
            int new_indice_line=indice%20;
            int new_indice_column=indice/20;
            Y_Cell item = (Y_Cell)e.nextElement();
            item.set_x(new_indice_line);
            item.set_y(new_indice_column);
            grille[new_indice_line][new_indice_column]="|"+item.get_id()+"|";
            tab.remove(indice);
                        item.affiche();
        }

        for (Enumeration e = vector_z.elements(); e.hasMoreElements();) {
            Random rand = new Random();
            int indice= rand.nextInt(tab.size());
            int new_indice_line=indice%20;
            int new_indice_column=indice/20;
            Z_Cell item = (Z_Cell)e.nextElement();
            item.set_x(new_indice_line);
            item.set_y(new_indice_column);
            grille[new_indice_line][new_indice_column]="|"+item.get_id()+"|";
            tab.remove(indice);
                        item.affiche();
        }

        for (Enumeration e = vector_virus.elements(); e.hasMoreElements();) {
            Random rand = new Random();
            int indice= rand.nextInt(tab.size());
            int new_indice_line=indice%20;
            int new_indice_column=indice/20;
            Virus item = (Virus)e.nextElement();
            item.set_x(new_indice_line);
            item.set_y(new_indice_column);
            grille[new_indice_column][new_indice_line]="|"+item.get_id()+"|";
            tab.remove(indice);
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

   public static void remplissage_grille(){

   }


    public static void deplacement_plateau(Vector vector_virus,String[][] grille) {
        int cpt=0;
        while(cpt<vector_virus.size()){
            affiche_grille(grille);
            System.out.println("Quelle entité voulez-vous déplacer ?");
            String choix=utile.saisie_chaine();
            for (Enumeration e=vector_virus.elements();e.hasMoreElements();) {
                Virus item=(Virus)e.nextElement();
                String id = item.get_id();
                if (id.equals(choix)) {
                    int old_x=item.get_x();
                    int old_y=item.get_y();
                    item.deplacement();
                    cpt=cpt+1;
                    grille[item.get_y()][item.get_x()]="|"+id+"|";
                    grille[old_y][old_x]="|___|";
                    // break;
                }
            }

        }
    }


}

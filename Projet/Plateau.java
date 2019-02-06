import java.io.*;
import java.util.*;
import java.lang.*;



public class Plateau {
    public static void main(String[] args) {
        Vector vector_virus=new Vector();
        Vector vector_cell=new Vector();
        String[][] grille=game();
        while (true) {
            System.out.println("\nMenu\n Tapez 0 pour quitter l'application\n Tapez 1 pour voir plateau de jeu");
            int choix = saisie_entier();
            switch (choix) {
                case 0: System.exit(0);
                case 1: System.out.println(grille);break;
                case 2: creation_individus(vector_virus,vector_cell);break;
                case 3: affiche_individus(vector_virus,vector_cell);break;
            }

        }
    }

    public static void affiche_grille(String[][] grille) {
        System.out.println(grille);
    }

    public static void creation_individus(Vector vector_virus, Vector vector_cell) {
        System.out.println("Combien voulez-vous ajouter d'individus ?");
        int valeur=saisie_entier();
        System.out.println("\n1. Virus\n2. Cellule");
        int rep = saisie_entier();

        for (int i=0;i<valeur;i++) {

            Individu item = null;
            switch (rep) {
              case 1 :
              item = new Virus();
              vector_virus.addElement(item);break;
              case 2 :
              item = new Cell();
              vector_cell.addElement(item);break;
              default: System.out.println("Mauvais numero");
            }
        }
    }

    public static void affiche_individus(Vector vector_virus, Vector vector_cell) {
        System.out.println("\n1. Virus\n2. Cellule");
        int rep = saisie_entier();
        // switch(rep){
        //     case 1 : Vector tableau=vector_virus;
        //     case 2 : Vector tableau=vector_cell;
        // }
        for (Enumeration e = vector_virus.elements(); e.hasMoreElements();) {
        Virus item = (Virus)e.nextElement();
        item.affiche();
      }
    }

    public static String[][] game() {
        String plateau [][] = new String [20][20];
        for (int i = 0; i<20; i++ ) {
            for (int j = 0; j<20; j++ ) {
                plateau[i][j]="|____|";
                System.out.print(plateau[i][j]);
            }
            System.out.println();
        }
        return plateau;
    }

    public static void aleatoire() {
        Vector tab = new Vector();
        for ( int i=0;i<400;i++) {
            tab.add(i);
        }
        Random rand = new Random();
        int indice= rand.nextInt(tab.size());
        int new_indice_line=indice%20;
        int new_indice_column=indice/20;
        System.out.println("ligne = "+new_indice_line);
        System.out.println("colonne = "+new_indice_column);
        for (int i = 0; i<33; i++ ) {
            // ajouter une celluleX en position line et column dans grille
            // ajouter une celluleY en position line et column dans grille
            // ajouter une celluleZ en position line et column dans grille
            // tab.remove(i)
        }
        for (int i =0;i<10;i++) {
            //ajouter un virus en position ligne et colum dans grille
            //tab.remove(i)
        }
    }

    public static boolean includes (int[] liste, int sujet) {
       for(int i=0;i<liste.length;i++) {
           for (int j=0;j<liste.length;j++) {
               if(liste[i] == sujet) {
                   return true;
               }

           }
       }
       return false;
   }

    public static void deplacement_plateau(Vector vector_virus,String[][] grille) {
        int cpt=0;
        while(cpt<vector_virus.size()){
            affiche_grille(grille);
            System.out.println("Quelle entité voulez-vous déplacer ?");
            String choix=saisie_chaine();
            for (Enumeration e=vector_virus.elements();e.hasMoreElements();) {
                Virus item=(Virus)e.nextElement();
                String id = item.get_id();
                if (id.equals(choix)) {
                    item.deplacement();
                    cpt=cpt+1;
                    break;
                }
            }

        }
    }

    public static String saisie_chaine() {
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String chaine = buff.readLine();
            return chaine;
        } catch (IOException e) {
            System.out.println("impossible de travailler " + e);
            return null;
        }
    }

    public static int saisie_entier() {
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String chaine = buff.readLine();
            int num = Integer.parseInt(chaine);
            return num;
        } catch (IOException e) {
            return 0;
        }
    }
}

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
<<<<<<< HEAD
                case 1: game();break;
                case 2: aleatoire();break;
=======
                case 1: System.out.println(grille);break;
                case 2: creation_individus(vector_virus,vector_cell);break;
                case 3: affiche_individus(vector_virus,vector_cell);break;
>>>>>>> 614be87b6d27dc4805548bbb095db6d81a2a602a
            }

        }
    }

<<<<<<< HEAD
=======
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

>>>>>>> 614be87b6d27dc4805548bbb095db6d81a2a602a
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

<<<<<<< HEAD
    public static void aleatoire() {
        int tab [] = {1,2,3,4,5,6,7,8,9,10};
        int tab2 [];
        Random rand = new Random();
        for (int i = 0; i<tab.length; i++ ) {
            tab[i]=rand.nextInt(tab.length);
            System.out.print(tab[i]);
            if (includes(tab,i)) {
                tab2 = tab[i];
            }
        }
        System.out.println();


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


=======

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

>>>>>>> 614be87b6d27dc4805548bbb095db6d81a2a602a

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

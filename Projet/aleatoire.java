import java.io.*;
import java.util.*;
import java.lang.*;



public class Plateau {
    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenu\n Tapez 0 pour quitter l'application\n Tapez 1 pour voir plateau de jeu");
            int choix = saisie_entier();
            switch (choix) {
                case 0: System.exit(0);
                case 1: game();break;
                case 2: aleatoire();break;
            }

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

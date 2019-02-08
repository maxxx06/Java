import java.io.*;
import java.util.*;
import java.lang.*;



public class Aleatoire {
    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenu\n Tapez 0 pour quitter l'application\n Tapez 1 pour voir plateau de jeu");
            int choix = saisie_entier();
            switch (choix) {
                case 0: System.exit(0);
                // case 1: game();break;
                case 2: aleatoire();break;
            }

        }
    }

    public static void aleatoire() {
        Vector tab = new Vector();
        for ( int i=0;i<400;i++) {
            tab.add(i);
        }
        Vector Cell_x = new Vector();
        Vector Cell_y = new Vector();
        Vector Cell_z = new Vector();
        Vector Virus = new Vector();
        for (int i = 0; i<33; i++ ) { 
            Random rand = new Random();
            int indice= rand.nextInt(tab.size());
            int new_indice_line=indice%20;
            int new_indice_column=indice/20;
            Cell_x.add("\n line = "+new_indice_line+" column = "+new_indice_column);
            // Cell_z.add("\n line = "+new_indice_line+" column = "+new_indice_column);
            tab.remove(i);
        }
        for (int i = 0; i<33; i++ ) {
            Random rand = new Random();
            int indice= rand.nextInt(tab.size());
            int new_indice_line=indice%20;
            int new_indice_column=indice/20;
            Cell_y.add("\n line = "+new_indice_line+" column = "+new_indice_column);
            tab.remove(i);
        }

        for (int i = 0; i<33; i++ ) {
            Random rand = new Random();
            int indice= rand.nextInt(tab.size());
            int new_indice_line=indice%20;
            int new_indice_column=indice/20;
            Cell_z.add("\n line = "+new_indice_line+" column = "+new_indice_column);
            tab.remove(i);
        }

        for (int i =0;i<10;i++) {
            Random rand = new Random();
            int indice= rand.nextInt(tab.size());
            int new_indice_line=indice%20;
            int new_indice_column=indice/20;
            Virus.add("\n line = "+new_indice_line+" column = "+new_indice_column);
            tab.remove(i);
        }

        System.out.println("\nCelle_x = "+Cell_x);
        System.out.println("\nCell_y = "+Cell_y);
        System.out.println("\nCell_z = "+Cell_z);
        System.out.println("\nVirus = "+Virus);
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

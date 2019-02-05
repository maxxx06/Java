import java.io.*;
import java.util.*;

public class Plateau {
    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenu\n Tapez 0 pour quitter l'application\n Tapez 1 pour voir plateau de jeu");
            int choix = saisie_entier();
            switch (choix) {
                case 0: System.exit(0);
                case 1: game();break;
            }

        }
    }

    public static void game() {
        String plateau [][] = new String [20][20];
        for (int i = 0; i<20; i++ ) {
            for (int j = 0; j<20; j++ ) {
                plateau[i][j]="|_|";
                System.out.print(plateau[i][j]);
            }
            System.out.println();
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

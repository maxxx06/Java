import java.io.*;
import java.util.*;

public class GestionAnimalerie {
    public static void main(String[] args) {
        Vector animaux = new Vector();
        while (true) {
            System.out.println("\nmenu\n Tapez 0 pour quitter l'application\n Tapez 1 pour creer une animalerie\n tapez 2 pour afficher toutes les animaleries\n tapez 3 pour gerer votre animalerie\n taper 4 pour tansferer un animal" );
            int choix = saisie_entier();
            switch (choix) {
                case 0: System.exit(0);
                case 1: createAnimalerie(animaux);break;
                case 2: afficherAnimalerie(animaux);break;
                case 3: gererAnimalerie(animaux);break;
                case 4: transfererAnimaux(animaux);break;
            }
        }
    }

    public static void createAnimalerie(Vector animaux) {
        System.out.println("donnez un nom a l'animalerie ");
        String chaine = saisie_chaine();
        Animalerie item= new Animalerie(chaine);
        animaux.add(item);
        System.out.println("Vous avez cree l'animalerie "+chaine);
        System.out.println("voulez vous en creer une autre ? o pour oui, n pour non");
        String rep = saisie_chaine();
        if (rep.equals("o")) {
            createAnimalerie(animaux);
        }
    }

    public static void afficherAnimalerie(Vector animaux) {
        for (Enumeration e = animaux.elements(); e.hasMoreElements();) {
            Animalerie item = (Animalerie)e.nextElement();
            item.affiche();
        }
    }

    public static void gererAnimalerie(Vector animaux) {
        System.out.println("Quelle animalerie voulez-vous ?");
        afficherAnimalerie(animaux);
        String chaine = saisie_chaine();
        for (Enumeration e = animaux.elements(); e.hasMoreElements();) {
            Animalerie item = (Animalerie)e.nextElement();
            String nom = item.get_nom_animalerie();
            if(nom.equals(chaine)) {
                item.menu();
            }
        }
    }

    public static void transfererAnimaux(Vector animaux) {
        System.out.println("Quelle animalerie voulez-vous partir ?");
        afficherAnimalerie(animaux);
        String chaine = saisie_chaine();
        System.out.println("Quelle animal ?");
        for (Enumeration e = animaux.elements(); e.hasMoreElements();) {
            Animalerie item = (Animalerie)e.nextElement();
            item.affiche();
        }
        System.out.println("Dans quelle animalerie voulez vous le transferer");
        afficherAnimalerie(animaux);
        String future = saisie_chaine();
        String nom = item.get_nom_animalerie();
        String animals = saisie_chaine();
        if (nom.equals(future)) {
            // ajouter future dans nouvelle animalerie
            future.add(animals);
        }
        // for (Enumeration e = animaux.elements(); e.hasMoreElements();) {
        //     Animalerie item = (Animalerie)e.nextElement();
        //     String nom = item.get_nom_animalerie();
        //     if(nom.equals(chaine)) {
        //         item.menu();
        //     }
        // }
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

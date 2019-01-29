import java.io.*;
import java.util.*;

public class GestionAnimalerie {
    public static void main(String[] args) {
        Vector animaux = new Vector();
        while (true) {
            System.out.println("\nmenu\n Tapez 0 pour quitter l'application\n Tapez 1 pour creer une animalerie\n tapez 2 pour afficher toutes les animaleries\n tapez 3 pour gerer votre animalerie");
            int choix = saisie_entier();
            switch (choix) {
                case 0: System.exit(0);
                case 1: createAnimalerie(animaux);break;
                case 2: afficherAnimalerie(animaux);break;
                case 3: gererAnimalerie(animaux);break;
            }
        }
    }

    public static void createAnimalerie(Vector animaux) {
        System.out.println("donnez un nom a l'animalerie ");
        String chaine = saisie_chaine();
        Animalerie item= new Animalerie(chaine);
        animaux.add(item);
        System.out.println("Vous avez cree l'animalerie "+chaine);
    }

    public static void afficherAnimalerie(Vector animaux) {
        for (Enumeration e = animaux.elements(); e.hasMoreElements();) {
            Animalerie item = (Animalerie)e.nextElement();
            item.affiche();
        }
    }

    public static void gererAnimalerie(Vector animaux) {
        System.out.println("Quelle animalerie voulez-vous ?");
        String chaine = saisie_chaine();
        for (Enumeration e = animaux.elements(); e.hasMoreElements();) {
            Animalerie item = (Animalerie)e.nextElement();
            String nom = item.get_nom_animalerie();
            if(nom.equals(chaine)) {
                item.menu();
            }
        }
        // System.out.println("Erreur, animalerie non trouvé");
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

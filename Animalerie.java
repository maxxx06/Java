import java.io.*;
import java.util.*;

public class Animalerie {
    private String nom_animalerie;
    private Vector animaux;

    public String get_nom_animalerie() {
      return nom_animalerie;
    }


    public void affiche() {
        System.out.println("-"+nom_animalerie+"\n");
        afficher_animaux(animaux);
    }

    public Animalerie() {
        nom_animalerie="unknown";
        animaux = new Vector();
    }

    public Animalerie(String name) {
        nom_animalerie = name;
        animaux = new Vector();
    }

    public void menu() {
        while (true) {
            System.out.println("\nwelcome to "+nom_animalerie+" !");
            System.out.println("\nmenu\n Tapez 0 pour quitter l'application\n Tapez 1 pour creer un animal\n tapez 2 pour afficher tous les animaux\n tapez 3 pour afficher un animal dont on donne le nom\n tapez 4 pour afficher la moyenne des ages\n tapez 5 pour faire vieillir tous les animaux\n tapez 6 pour faire mourir un animal dont on donne le nom");
            int choix = saisie_entier();
            switch (choix) {
            case 0:
             return;
            case 1:
              create_animal();
              break;
            case 2:
              afficher_animaux(animaux);
              break;
            case 3:
              afficher_un_animal(animaux);
              break;
            case 4:
              moyenneAge(animaux);
              break;
            case 5:
              vieillir(animaux);
              break;
            case 6:
              mourir(animaux);
              break;
            }
        }
    }


    public void create_animal() {
      while (true) {
        System.out.println("Donnez un nom");
        String chaine = saisie_chaine();
        System.out.println("Donnez un age");
        Integer valeur = saisie_entier();
        Animal item=null;
        System.out.println("\nTapez 1 pour Chat\nTapez 2 pour Souris\nTapez 3 pour Canari");
        int rep=saisie_entier();
        switch(rep){
          case 1: item = new Chat(chaine,valeur);break;
          case 2: item = new Souris(chaine,valeur); break;
          case 3: item = new Canari(chaine,valeur); break;
          default: System.out.println("Erreur: type non connu");
        }
        animaux.add(item);
        System.out.println("Un autre? o pour Oui n pour Non");
        String reponse = saisie_chaine();
        System.out.println("Vous avez cree l'animal "+chaine);
        if (!(reponse.equals("o"))) {
          System.out.println("Fin de saisie");
          return;
        }
      }
    }

    public void afficher_animaux(Vector animaux) {
        for (Enumeration e = animaux.elements(); e.hasMoreElements();)
        {
            Animal item=(Animal)e.nextElement();
            item.affiche();
        }
    }

    public static void afficher_un_animal(Vector animaux) {
      Animal item=chercher(animaux);
      item.affiche();
    }

    public static void moyenneAge(Vector animaux) {
      int somme = 0;
      int ageAnimal;
      for (Enumeration e = animaux.elements(); e.hasMoreElements();) {
          Animal item = (Animal)e.nextElement();
          somme = somme + item.get_age();
      }
      ageAnimal = somme / animaux.size();
      System.out.println("La moyenne des ages est de " + ageAnimal + " ans");
    }

    public static void vieillir(Vector animaux) {
      for (Enumeration e = animaux.elements(); e.hasMoreElements();)
      {Animal item=(Animal)e.nextElement(); // on dit specifiquement que le retour est un animal.
        item.vieillir();
      }
    }

    public static void mourir(Vector animaux) {
      Animal item=chercher(animaux);
      item.tuer();
      System.out.println("Un Animal est mort");
    }

    public static Animal chercher(Vector animaux) {
      System.out.println("Quel animal?");
      String nom = saisie_chaine();
      for (Enumeration e= animaux.elements(); e.hasMoreElements();) {
          Animal id = (Animal)e.nextElement();
          String name = id.get_nom();
          if (name.equals(nom)) {
              return id;
          }
      }
      System.out.println("Erreur, animal non trouvé");
      return null;
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

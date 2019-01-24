import java.io.*;
import java.util.*;

public class Gestion {
  public static void main(String[] args) {
    final int NBA = 10;
    Vector leclub= new Vector();
    while (true) {
      String chaine = "menu\n Tapez 0 pour quitter l'application\n Tapez 1 pour creer un animal\n tapez 2 pour afficher tous les animaux\n tapez 3 pour afficher un animal dont on donne le nom\n tapez 4 pour afficher la moyenne des ages\n tapez 5 pour faire vieillir tous les animaux\n tapez 6 pour faire mourir un animal dont on donne le nom";
      System.out.println(chaine);
      int choix = saisie_entier();
      switch (choix) {
      case 0:
        System.exit(1);
      case 1:
        create_animal(leclub);
        break;
      case 2:
        afficher_animaux(leclub);
        break;
      case 3:
        afficher_un_animal(leclub);
        break;
      case 4:
        moyenneAge(leclub);
        break;
      case 5:
        vieillir(leclub);
        break;
      case 6:
        mourir(leclub);
        break;
      }
    }
  }

  public static void create_animal(Vector leclub) {
    while (true) {
      System.out.println("Donnez un nom");
      String chaine = saisie_chaine();
      System.out.println("Donnez un age");
      Integer valeur = saisie_entier();
      Animal item=null;
      System.out.println("Tapez 1 pour Chat\n Tapez 2 pour Souris\n Tapez 3 pour Canari");
      int rep=saisie_entier();
      switch(rep){
        case 1: item = new Chat(chaine,valeur);break;
        case 2: item = new Souris(chaine,valeur); break;
        case 3: item = new Canari(chaine,valeur); break;
        default: System.out.println("Erreur: type non connu");
      }
      // leclub[Animal.cpt-1] = item;
      leclub.add(item);
      System.out.println("Un autre? O pour Oui");
      String reponse = saisie_chaine();
      if (!(reponse.equals("O"))) {
        System.out.println("Fin de saisie");
        return;
      }
    }
    System.out.println("Vous avez créé les animaux");
  }

  public static void afficher_animaux(Vector leclub) {
  for (Enumeration e = leclub.elements(); e.hasMoreElements();)
    {
    Animal item=(Animal)e.nextElement();
    item.affiche();
    }
  }

  public static void afficher_un_animal(Vector leclub) {
    Animal item=chercher(leclub);
    item.affiche();
  }

  public static void moyenneAge(Vector leclub) {
    int somme = 0;
    for (int i = 0; i < Animal.cpt; i++) {
      // Animal item = leclub[i];
      leclub.add(i);
      // int ageAnimal = leclub[i].get_age();
      int ageAnimal = leclub.elementAt(i).get_age();
      somme = somme + ageAnimal;
    }
    int resultat = somme / Animal.cpt;
    System.out.println("La moyenne d'âge est de: " + resultat);
  }

  public static void vieillir(Vector leclub) {
    for (Enumeration e = leclub.elements(); e.hasMoreElements();)
    {Animal item=(Animal)e.nextElement();
      item.vieillir();
    }
  }

  public static void mourir(Vector leclub) {
    Animal item=chercher(leclub);
    item.tuer();
    System.out.println("Un Animal est mort");
  }

  public static Animal chercher(Vector leclub) {
    System.out.println("Quel animal?");
    String nom = saisie_chaine();
    for (int i = 0; i < Animal.cpt; i++) {
      String id = leclub[i].get_nom();
      if (id.equals(nom)) {
        return leclub.elementAt(i);
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

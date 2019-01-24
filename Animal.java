public abstract class Animal {

  private String nom;
  private int age;
  private boolean vivant;
  private int num;
  public static int cpt=0;
  public void affiche() {
    System.out.println("Je suis "+nom);
    System.out.println("J'ai "+age);
    if (vivant) {
      System.out.println("vivant");
    }
    else {
      System.out.println("mort");
    }
    System.out.println("mon numero est "+num);
  }
  public void set_age (int valeur) {
    age=valeur;
  }
  public int get_age() {
    return age;
  }

  public String get_nom() {
    return nom;
  }

  public void vieillir(){
    age++;
  }
  public void tuer(){
    vivant= false;
  }

  public Animal() {
    nom="Absent";
    age=0;
    vivant=true;
  }
  public Animal (String chaine) {
    nom=chaine;
    age=0;
    vivant=true;
    cpt++;
    num=cpt;
  }
  public Animal (String chaine, int valeur) {
    nom=chaine;
    age=valeur;
    vivant=true;
    cpt++;
    num=cpt;
  }

  public abstract void crier();
}


// mot cle "final" est equivalent à const

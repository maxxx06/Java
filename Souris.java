class Souris extends Animal {

  public Souris (String nom, int val) {
    super(nom,val);
  }

  public void affiche() {
    System.out.println("\nJe suis une souris");
    super.affiche();
    crier();
  }

  public void crier() {
      System.out.println("hihihihiihihih\n");
  }

}

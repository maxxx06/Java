class Canari extends Animal {

  public Canari (String nom, int val) {
    super(nom,val);
  }

  public void affiche() {
    System.out.println("\nje suis un canari");
    super.affiche();
    crier();
  }

  public void crier() {
      System.out.println("baaaaaaaah\n");
  }

}

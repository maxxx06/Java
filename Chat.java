class Chat extends Animal {

  public Chat (String nom, int val) {
    super(nom,val);
  }

  public void affiche() {
    System.out.println("miaou je suis un chat");
    super.affiche();
    crier();
  }
  public void crier() {
      System.out.println("miiioooooou");
  }

}

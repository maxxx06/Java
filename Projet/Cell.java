public class Cell {
    private String type;
    private int id;
    private boolean vivant;
    public static int cpt_cell = 0;

    public Cell(){
      vivant=true;
      cpt_cell++;
      id=cpt_cell;
    }

    public void affiche() {
        System.out.println("je suis une cellule du type "+type);
        if(vivant)
          System.out.println("je suis vivante");
        else
          System.out.println("je suis morte");
    }

    public void set_type(String nom) {
        type = nom;
    }

    public String get_type() {
        return type;
    }

    public int get_vie() {
        return vie;
    }

    public String get_effet() {
        return effet;
    }

    public void die (String type) {
        vie=0;
        cpt_cell=1;

    }
}

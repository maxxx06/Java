public class Cellule {
    private String type;
    private String effet;
    private int vie;
    public static int compteur_cellule = 100;

    public void affiche() {
        System.out.println("je suis une cellule du type "+type);
        System.out.println("je suis donc "+effet);
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
        compteur_cellule-=1;

    }
}

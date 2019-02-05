public class Vitus {
    private String effet;
    private int life;
    public static int cpt_virus = 10;

    public void affiche() {
        System.out.println("i am a virus");
    }

    public String get_effet() {
        return effet;
    }

    public int get_life() {
        return life;
    }

    public void die() {
        life=0;
        cpt_virus-=1;
    }

    public void proliferation() {
        cpt_virus=+1;
    }
}

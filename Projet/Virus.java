public class Virus {
    
    private int life;
    private int id;
    public static int cpt_virus = 0;

    public void affiche() {
        System.out.println("i am a virus");
    }

    public Virus() {
        id=cpt_virus;
    }

    public int get_life() {
        return life;
    }

    public int get_id() {
        return id;
    }

    public void die() {
        life=0;
        cpt_virus-=1;
    }

    public void proliferation() {
        cpt_virus=+1;
    }
}

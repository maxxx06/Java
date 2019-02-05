<<<<<<< HEAD
public class Virus {
    
    private int life;
    private int id;
    public static int cpt_virus = 0;
=======
import java.io.*;
import java.util.*;


public class Virus extends Individu {
    private int vie;
    private String id;
    public static int cpt_virus = 0;

    public Virus(){
        super();
        vie=5;
        cpt_virus++;
        id="v"+cpt_virus;
    }
>>>>>>> 614be87b6d27dc4805548bbb095db6d81a2a602a

    public void affiche() {
        System.out.println("Je suis le virus numéro "+id);
        System.out.println("Il me reste "+vie+" tours de vie");
        super.affiche();
    }

    public String get_id(){
        return id;
    }

<<<<<<< HEAD
    public Virus() {
        id=cpt_virus;
=======
    public int get_vie() {
        return vie;
>>>>>>> 614be87b6d27dc4805548bbb095db6d81a2a602a
    }

    public void set_vie(int _vie) {
        vie=_vie;
    }

    public int get_id() {
        return id;
    }

    public void die() {
        vie=0;
        cpt_virus-=1;
    }

    public void proliferation() {
        cpt_virus=+1;
    }
}

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

    public void affiche() {
        System.out.println("Je suis le virus numéro "+id);
        System.out.println("Il me reste "+vie+" tours de vie");
        super.affiche();
    }

    public String get_id(){
        return id;
    }

    public int get_vie() {
        return vie;
    }

    public void set_vie(int _vie) {
        vie=_vie;
    }

    public void die() {
        vie=0;
        cpt_virus-=1;
    }

    public void proliferation() {
        cpt_virus=+1;
    }
}

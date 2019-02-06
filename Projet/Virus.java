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

    public void set_vie(int _vie) {
        vie=_vie;
    }

    public String get_id() {
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

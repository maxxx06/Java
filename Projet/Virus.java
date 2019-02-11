import java.io.*;
import java.util.*;


public class Virus extends Individu {
    private int vie;
    public static int cpt_virus = 0;

    public Virus(){
        super();
        vie=5;
        cpt_virus++;
        id="v"+cpt_virus;
    }

    // public void set_vie(int _vie) {
    //     vie=_vie;
    // }

    public void perte_vie() {
        vie=vie-1;
    }

    public void gain_vie() {
        vie=vie+1;
    }





    public void die() {
        vie=0;
        cpt_virus-=1;
        super.mourir();
    }

    public void proliferation() {
        cpt_virus=+1;
        Virus item = new Virus();
    }

    public void set_id(String _id){
        id=_id;
    }
}

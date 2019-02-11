import java.io.*;
import java.util.*;

abstract public class Individu {

    private boolean vivant;
    private int x,y;
    protected String id;


    public Individu() {
        vivant=true;
    }

    public void affiche() {
        System.out.println("Mes coordonnées sont : ("+x+", "+y+")");
        if(vivant)
          System.out.println("je suis vivante");
        else
          System.out.println("je suis morte");
    }

    public void deplacement() {
        String choix=utile.saisie_chaine();

        switch(choix) {
            case "W" :
            case "Z" :
                set_x(x-1);break;
            case "Q" :
            case "A" :
                set_y(y-1);break;
            case "S" : set_x(x+1);break;
            case "D" : set_y(y+1);break;
        }

    }

    public void set_x(int _x) {
        x = _x;
    }

    public int get_x() {
        return x;
    }


    public void set_y(int _y) {
        y = _y;
    }

    public int get_y() {
        return y;
    }

    public void set_xy(int _x,int _y){
        x=_x;
        y=_y;
    }

    public void die() {
        vivant=false;
    }

    public String get_id() {
        return id;
    }

    public boolean get_vivant() {
        return vivant;
    }


}

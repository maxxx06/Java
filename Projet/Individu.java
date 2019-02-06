import java.io.*;
import java.util.*;

public class Individu {

    private boolean vivant;
    private int x,y;

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
        String choix=saisie_chaine();
        switch(choix) {
            case "W" :
            case "Z" :
                set_y(y-1);break;
            case "Q" :
            case "A" :
                set_x(x-1);break;
            case "S" : set_y(y+1);break;
            case "D" : set_x(x+1);break;
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

    public void mourir() {
        vivant=false;
    }

    public static String saisie_chaine() {
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String chaine = buff.readLine();
            return chaine;
        } catch (IOException e) {
            System.out.println("impossible de travailler " + e);
            return null;
        }
    }

    public static int saisie_entier() {
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String chaine = buff.readLine();
            int num = Integer.parseInt(chaine);
            return num;
        } catch (IOException e) {
            return 0;
        }
    }

}
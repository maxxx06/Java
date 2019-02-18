import java.io.*;
import java.util.*;

public class X_Cell extends Cell {

    public X_Cell() {
        super();
        id=String.format("x%03d",num);
        immunite=3;
    }

    public X_Cell(int _x,int _y) {
        super();
        id=String.format("x%03d",num); // methode de represenation d'un X_cell sur la grille
        immunite=3;
        x=_x;
        y=_y;
    }


    public void affiche() {
        System.out.println(id+" est immunisée.");
    }

    public void infected() {
        affiche();
    }

    public void effet(String choix, Virus vrs) { // effet d'une cellule x
        infected();
        vrs.perte_vie();    // consequence sur le virus
    }

}

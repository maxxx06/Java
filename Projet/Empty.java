import java.io.*;
import java.util.*;

public class Empty extends Individu {   // verifie si un element de la case est vide

    public Empty() {    // Constructeur vide
        super();
        id="____";
        immunite=-1;
    }

    public Empty(int _x,int _y) {   // constructeur qui prend 2 int
        super();
        id="____";
        x=_x;
        y=_y;
    }

}

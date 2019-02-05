import java.io.*;
import java.util.*;

public class Y_Cell extends Cell {

    private String type;
    private String id;

    public Y_Cell() {
        super();
        type="Y";
        id="y"+num;
    }

    public void affiche() {
        System.out.println("je suis une cellule du type "+type);
        super.affiche();
    }


    public void infection() {

    }

}

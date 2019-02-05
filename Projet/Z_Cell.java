import java.io.*;
import java.util.*;

public class Z_Cell extends Cell {

    private String type;
    private String id;

    public Z_Cell() {
        super();
        type="Z";
        id="z"+num;
    }

    public void affiche() {
        System.out.println("je suis une cellule du type "+type);
        super.affiche();
    }


}

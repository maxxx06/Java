import java.io.*;
import java.util.*;

public class Z_Cell extends Cell {


    public Z_Cell() {
        super();
        id="z"+num;
    }

    public void affiche() {
        System.out.println("id : "+id);
        super.affiche();
    }

}

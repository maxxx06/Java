import java.io.*;
import java.util.*;

public class Z_Cell extends Cell {


    public Z_Cell() {
        super();
        id=String.format("z%02d",num);
    }

    public void affiche() {
        System.out.println("id : "+id);
        super.affiche();
    }

}

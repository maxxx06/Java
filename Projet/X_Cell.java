import java.io.*;
import java.util.*;

public class X_Cell extends Cell{

    public X_Cell() {
        super();
        id="x"+num;
    }

    public void affiche() {
        System.out.println("id : "+id);
        super.affiche();
    }

}

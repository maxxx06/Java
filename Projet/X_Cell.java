import java.io.*;
import java.util.*;

public class X_Cell extends Cell{

    public X_Cell() {
        super();
        id=String.format("x%02d",num);
    }

    public void affiche() {
        System.out.println("id : "+id);
        super.affiche();
    }

}

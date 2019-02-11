import java.io.*;
import java.util.*;

public class Y_Cell extends Cell {

    private boolean infection;

    public Y_Cell() {
        super();
        infection=false;
        id=String.format("y%02d",num);
    }

    public void affiche() {
        System.out.println("id : "+id);
        super.affiche();
    }


    public void infected() {
        infection=true;
    }

    public boolean get_infection() {
        return infection;
    }


}

import java.io.*;
import java.util.*;

public class X_Cell extends Cell{

    private String type;
    private String id;

    public X_Cell() {
        super();
        type="X";
        id="x"+num; //super.num ?????
    }

    public void affiche() {
        System.out.println("je suis une cellule du type "+type);
        super.affiche();
    }

    public void set_num(int value) {
        num=value;
    }

    public int get_num(){
        return num;
    }

}

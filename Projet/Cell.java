import java.io.*;
import java.util.*;


public class Cell extends Individu {

    protected int num;
    public static int cpt_cell = 0;

    public Cell(){
      super();
      cpt_cell++;
      num=cpt_cell;
    }

    public void affiche() {
        System.out.println("je suis la cellule numéro "+num);
        super.affiche();
    }

    public int get_cpt(){
        return cpt_cell;
    }


}

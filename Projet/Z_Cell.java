import java.io.*;
import java.util.*;

public class Z_Cell extends Cell {

    public Z_Cell() {
        super();
        id=String.format("z%03d",num);      // methode d'affichage de la cellule Z sur la grille
        immunite=1;
    }

    public void affiche() {
    	if(vivant){
    		System.out.println(id+" est sensible aux virus.");
    	}
    	else{
    		System.out.println(id+" est morte.");
    	}
    }

    public void die(){
        super.die();
        cpt_cell-=1;
    }

    public void infected() {       // si infecté
    	die();                     // meurt
        affiche();
    }




    public void effet(String choix, Virus vrs) {
        vrs.simple_deplacement(choix);
        vrs.gain_vie();
        infected();
        }
    }

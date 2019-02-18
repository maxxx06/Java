import java.io.*;
import java.util.*;


public abstract class Cell extends Individu {

    protected int num;                                      // Attribut protege
    public static int cpt_cell = 0;                         // Attribut statique
    public abstract void effet(String choix,Virus vrs);     // Methode abstract

    public Cell() {     // Constructeur vide
      super();          // La cellule prendra les paramètres de Individu
      cpt_cell++;
      num=cpt_cell;
    }

    public void fusion(Individu item, String move_choice) {     // methode de fusion de 2 cellules
        Individu source=(Individu)this;     // Cellule qui deplace est la source
        if(this.immunite>item.immunite) {   // Si immunite de source est superieur à la cellule qui subit
        	Plateau.grille[source.get_x()][source.get_y()]= new Empty();   // Remplace au coordonnée de source par une case vide
        }
        else { // sinon
        	simple_deplacement(move_choice); // verifie si c'est un virus
        }
        System.out.println(this.id+" et "+item.id+" ont fusionne.");
    }

    public int get_cpt() {  //recupere l'attribut cpt_cell
        return cpt_cell;
    }

    public void deplacement(String move_choice) {   // methode de deplacement propre au cellule
    	try{
	        Individu next_case=case_suivante(move_choice);     // Analyse l'inidividu à la case suivante
	        if(next_case.immunite>0) {     // si cet individu est une cellule
	            fusion(next_case,move_choice);     // la fusion est possible
	        }
	        else {
	            simple_deplacement(move_choice); // verifie si la la case suivante est un virus
	        }
    	}
    	catch(ArrayIndexOutOfBoundsException e){   // gestion de l'erreur ArrayIndexOutOfBoundsException
    		System.out.println("Ce deplacement sort du plateau. Essayez une nouvelle direction");
    		deplacement(Plateau.choix_deplacement());     // Se deplacer ailleurs
    	}
    }


}

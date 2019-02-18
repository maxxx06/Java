import java.io.*;
import java.util.*;

public class Individu {

	protected boolean vivant;  		// attribut indiquant si un individu est vivant ou non
    protected boolean already_moved=false; 		// attribut indiquant si il a deja bouge
    protected int x,y;
    protected String id;
    protected int immunite;

    public Individu() {		// construteur vide
    	vivant=true; 		// un individu est vivant de base
    }

    public void affiche() {
        System.out.println("|"+id+"|");
    }

    public void moved() { 	// Si individu bouge
        already_moved=true; // dire qu'il a bougé
    }

    public void reset_move() { 	// reset a chaque tour
        already_moved=false;
    }

    public boolean did_moved() { // retourne la valeur de already_moved
        return already_moved;
    }

    public Individu case_suivante(String choix) { 	// methode qui analyse l'individu à la case suivante
    	Individu item;
        switch (choix) {
            case "w" :
            case "z" :
            	item = Plateau.grille[x-1][y];break;
            case "q" :
            case "a" :
            	item = Plateau.grille[x][y-1];break;
            case "s" :
            	item = Plateau.grille[x+1][y];break;
            case "d" :
            	item = Plateau.grille[x][y+1];break;
            default : item=null;
        }
        return item; 	// recupere l'individu
    }

    public void simple_deplacement(String choix) { 	// methode de deplacement apres verification si la case suivante n'est pas un virus
    	try{
	        Individu next_case=case_suivante(choix);
	        	if (!(next_case.getClass().getSimpleName().equals("Virus"))){
		            switch (choix) {
		                case "w" :
		                case "z" :
		                    set_x(x-1);
		                    Plateau.grille[x][y]=this;
		                    Plateau.grille[x+1][y]=new Empty(x,y);break;
		                case "q" :
		                case "a" :
		                    set_y(y-1);
		                    Plateau.grille[x][y]=this;
		                    Plateau.grille[x][y+1]=new Empty(x,y);break;
		                case "s" :
		                    set_x(x+1);
		                    Plateau.grille[x][y]=this;
		                    Plateau.grille[x-1][y]=new Empty(x,y);break;

		                case "d" :
		                    set_y(y+1);
		                    Plateau.grille[x][y]=this;
		                    Plateau.grille[x][y-1]=new Empty(x,y);break;
		            }
		            moved();
	            }
	            else{
	            	System.out.println("Un virus vous empeche d'acceder a cette case. Choisissez une nouvelle direction.");
	            	simple_deplacement(Plateau.choix_deplacement());

	            }
    	}
    	catch(ArrayIndexOutOfBoundsException e){
    		System.out.println("Ce deplacement sort du plateau. Essayez une nouvelle direction");
    		simple_deplacement(Plateau.choix_deplacement());
    	}
    }


    public void set_x(int _x) {
        x = _x;
    }

    public int get_x() {
        return x;
    }


    public void set_y(int _y) {
        y = _y;
    }

    public int get_y() {
        return y;
    }

    public String get_id() {
        return id;
    }

    public void die(){
    	vivant=false;
    }
}

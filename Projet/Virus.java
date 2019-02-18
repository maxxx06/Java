import java.io.*;
import java.util.*;


public class Virus extends Individu {

    protected int vie;
    public static int cpt_virus = 0;

    public Virus() {
        super();
        cpt_virus++;
        vie=5;
        immunite=0;
        id=String.format("v%03d", cpt_virus);  // methode de representation d'un virus sur la grille
    }

    public Virus(int _x, int _y) {
        super();
        cpt_virus++;
        vie=5;
        immunite=0;
        id=String.format("v%03d", cpt_virus); // methode de representation d'un virus sur la grille
        x=_x;
        y=_y;
    }


    public void affiche() {
    	if(vivant){
    		System.out.println(id+" a encore "+vie+" vies.");
    	}
    	else{
    		System.out.println(id+" est mort.");
    	}
    }

    public void set_vie(int nb) {
        vie=nb;
    }

    public void perte_vie() {
        vie=vie-1;
        System.out.println("Il reste "+vie+" vies à "+id);
    }

    public void gain_vie() {
        vie=vie+1;
        System.out.println("Il reste "+vie+" vies à "+id);
    }

    public int get_cpt() {
        return cpt_virus;
    }

    public void die() {
    	super.die();
        cpt_virus-=1;
        Plateau.grille[x][y]=new Empty(x,y);
        affiche();
    }

    public void proliferation() {       // consequence de l'effet du virus
        for (int i = 0; i < Plateau.directions.length; ++i) {
            String s = Plateau.directions[i];
            Individu rep=case_suivante(s);
            if (rep.getClass().getSimpleName().equals("Empty")) {
                if (!(rep.get_x()==0 || rep.get_x() >= Plateau.grille.length-1 || rep.get_y()==0 || rep.get_y()>= Plateau.grille.length-1)) {
                    Virus vrs=new Virus(rep.get_x(),rep.get_y());
                    vrs.set_vie(4);
                    System.out.println("Le nouveau virus a "+vrs.vie);
                    Plateau.grille[rep.get_x()][rep.get_y()]=vrs;
                    break;
                }
            }
        }
    }

    public void set_id(String _id) {
        id=_id;
    }

    public void effet() {       // effet du virus
        if (vie==10) {
            System.out.println("le virus "+id+" prolifere.");
            proliferation(); // application de l'effet du virus
            set_vie(4);     // application de l'effet du virus
            System.out.println("L'ancien virus se retrouve avec "+vie);
        }
        else if (vie==0) {
            die();
        }
    }

    public void deplacement(String move_choice) {   // deplacement propres au virus
    	try{
	        Individu next_case=case_suivante(move_choice);
	        if(next_case.immunite>0) {
	            Cell cellule=(Cell)next_case;
	            cellule.effet(move_choice,this);
	        }
	        else {
	            simple_deplacement(move_choice);
	        }
	        effet();
    	}
    	catch(ArrayIndexOutOfBoundsException e){
    		System.out.println("Ce deplacement sort du plateau. Essayez une nouvelle direction (virus)");
    		deplacement(Plateau.choix_deplacement());
    	}

    }

}

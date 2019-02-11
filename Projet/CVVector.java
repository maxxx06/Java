import java.io.*;
import java.util.*;

public class CVVector extends Vector{

    String nom;

    public CVVector(){
        nom="default";
    }

    public Individu find_id(){
        if(isEmpty()){
            System.out.println("Nobody");
            return null;
        }
        System.out.println("Give id");
        String id=utile.saisie_chaine();
        for(Enumeration e=elements();e.hasMoreElements();){
            Individu courant=(Individu)e.nextElement();
            if(courant.get_id().equals(id))
                return courant;
        }
        System.out.println("Id does not exist");
        return null;
    }

    public void delete_idv(){
        if(isEmpty()){
            System.out.println("Nobody");
        }
        for(Enumeration e=elements();e.hasMoreElements();){
            Individu courant=(Individu)e.nextElement();
            if(!(courant.get_vivant()))
                remove(courant);
        }
    }

    public void kill(){
        Individu item=find_id();
        if(item!=null)
            item.die();
    }

    public void add_idv(){
        int reponse=1;
        while(reponse!=0){
            System.out.println("\n1. Virus\n2. Cellule X\n3. Cellule Y\n4. Cellule Z\n0. Fin\n5. Pour quitter");
            reponse = utile.saisie_entier();
            System.out.println("Combien voulez-vous en ajouter ?");
            int valeur=utile.saisie_entier();
            for (int i=0;i<valeur;i++) {

                Individu item = null;
                switch (reponse) {
                    case 0 : return;
                    case 1 :
                    item = new Virus();break;
                    case 2 :
                    item = new X_Cell();break;
                    case 3 :
                    item = new Y_Cell();break;
                    case 4 :
                    item = new Z_Cell();break;
                    case 5 :
                    System.exit(0);
                    default: System.out.println("Mauvais numero");
                }
                if(item!=null)
                    addElement(item);
            }
        }
    }





}

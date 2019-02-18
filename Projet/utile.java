import java.io.*;
import java.util.*;

public class utile{


public static String saisie_chaine() {         // permet à l'utilisateur d'entrez une chaine de caractere
    try {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String chaine = buff.readLine();
        return chaine;
    }
    catch (IOException e) {
        System.out.println("impossible de travailler " + e);
        return null;
    }


}

public static int saisie_entier() {     // permet à l'utilisateur de rentrer un entier
    try {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String chaine = buff.readLine();
        int num = Integer.parseInt(chaine);
        return num;
    }
    catch (IOException e) {
        return 0;
    }
    catch(NumberFormatException e){
    	System.out.println("Merci de saisir seulement des caracteres numeriques.");
    	return saisie_entier();
    }
}

public static boolean includes(String[] s_array, String chaine){        // permet de verifier si un string est contenu dans un tableau de string
	List<String> list = Arrays.asList(s_array);
    if(list.contains(chaine)){
        return true;
    }
    return false;
}

}

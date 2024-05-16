package sources.fichiers;

import sources.classes.Utilisateur;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LireInscription {

    public LireInscription() {

        String nomFichier = "inscription.txt";
//        String mot_clef = "Ashley-23";
        String mot_clef = "Q";


        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier)) ){
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(mot_clef)) {
                    System.out.println(line);

                    String[] infos = line.split(" &&& ");

                    Utilisateur user = new Utilisateur();
                    user.login = infos[0];
                    user.email = infos[1];
                    user.rib = infos[2];
                    user.mot_de_passe = infos[3];

                    String dateNaissanceString = infos[4];
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date dateNaissance = dateFormat.parse(dateNaissanceString);
                    user.dateNaiss = new java.sql.Date(dateNaissance.getTime());



                    System.out.println(" " + user.login + " " + user.email + " " + user.rib + " " + user.mot_de_passe + " " + user.dateNaiss);
                }
//                System.out.println(line);
            }
        }catch (FileNotFoundException e){
            System.out.println(" Erreur lors de l'ouverture du fichier " + e.getMessage());
        }catch (IOException e){
            System.out.println(" Erreur lors de l'ouverture du fichier " + e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        LireInscription lire = new LireInscription();
    }

}

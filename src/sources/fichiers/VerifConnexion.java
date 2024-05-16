package sources.fichiers;

import sources.classes.Utilisateur;
import sources.fonctions.Dashboard;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VerifConnexion {

    public  VerifConnexion( String login, String mdp) {
        String nomFichier = "inscription.txt";
        boolean utilisateurTrouve = false;


        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier)) ){
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(login)) {

                    utilisateurTrouve = true;

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


                    if(user.mot_de_passe.equals(mdp)) {

                        Dashboard dashboard = new Dashboard(user);
                    }else{
                        JOptionPane.showMessageDialog(null,"Le mot de passe ne correspond pas");
                    }


//                    System.out.println(" " + user.login + " " + user.email + " " + user.rib + " " + user.mot_de_passe + " " + user.dateNaiss);
                }
            }

            if (!utilisateurTrouve) {
//                System.out.println("Aucun utilisateur trouvé avec le login spécifié.");
                JOptionPane.showMessageDialog(null,"Aucun utilisateur avec ce login n'est trouvé");
            }


        }catch (FileNotFoundException e){
            System.out.println(" Erreur lors de l'ouverture du fichier " + e.getMessage());
        }catch (IOException e){
            System.out.println(" Erreur lors de l'ouverture du fichier " + e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
//        return 0;
    }


    public static void main(String[] args) {
       VerifConnexion verifConnexion = new VerifConnexion("TEST","test");
    }


}



























//package sources.fichiers;
//
//import sources.classes.Utilisateur;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class LireInscription {
//
//    public LireInscription() {
//
//    }
//
//}

package sources.fichiers;

import sources.classes.Utilisateur;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ValiderInscription {

    public ValiderInscription(Utilisateur user) {

    // File file = new File("inscription.txt");

        // Chemin du fichier
        String cheminFichier = "inscription.txt";

        // Création d'un objet File
        File fichier = new File(cheminFichier);

        try {
            if (!fichier.exists()) {
                fichier.createNewFile();
                System.out.println("Le fichier a été créé.");
                try(BufferedWriter br = new BufferedWriter(new FileWriter(fichier, true))) {
                    br.write(user.getLogin()+ " &&& " +
                            user.getEmail() + " &&& " +
                            user.getRib() + " &&& " +
                            user.getMot_de_passe() + " &&& " +
                            user.getDateNaiss() );

                    br.newLine();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                //Le fichier existe déjà.
                try(BufferedWriter br = new BufferedWriter(new FileWriter(fichier, true))) {
                    br.write(user.getLogin()+ " &&& " +
                            user.getEmail() + " &&& " +
                            user.getRib() + " &&& " +
                            user.getMot_de_passe() + " &&& " +
                            user.getDateNaiss() );

                    br.newLine();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("Une erreur est survenue lors de la création du fichier : " + e.getMessage());
        }

    }

    public static void main(String[] args) {

    }
}

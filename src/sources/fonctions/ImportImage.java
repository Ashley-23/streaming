package sources.fonctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;

public class ImportImage {

    private JFrame frame;
    private ImageIcon monimage;
    private JLabel monlabel;
    private JButton commencer;

    public ImportImage() {
        int longueur = 600;
        int largeur = 800;

        URL imageURL = getClass().getResource("/ressources/accueil.jpg");
        assert imageURL != null;
        Image image = new ImageIcon(imageURL).getImage();

        Image resizedImage = image.getScaledInstance(largeur, longueur, Image.SCALE_SMOOTH);


        monimage = new ImageIcon(resizedImage);
        monlabel = new JLabel(monimage);


//        commencer = new JButton("Commencer");
//        commencer.setBounds(400, 400, 100, 50);
//        monlabel.add(commencer);



        // Augmenter la taille de la police du bouton
        commencer = new JButton("Commencer");
        commencer.setFont(new Font("Arial", Font.BOLD, 24));
        commencer.setBounds(largeur / 2 - 100, longueur - 100, 200, 50);

        monlabel.add(commencer);



        frame = new JFrame("Import Image");
        frame.add(monlabel);

        frame.setSize(largeur, longueur);


        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ImportImage();
    }
}

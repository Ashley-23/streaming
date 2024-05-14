package sources.fonctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Accueil {

    private JFrame frame;
    private ImageIcon monimage;
    private JLabel monlabel;
    private JButton commencer;


    public  Accueil() {

        int longueur = 600;
        int largeur = 800;

        URL imageURL = getClass().getResource("/ressources/accueil.jpg");
        assert imageURL != null;
        Image image = new ImageIcon(imageURL).getImage();

        Image resizedImage = image.getScaledInstance(largeur, longueur, Image.SCALE_SMOOTH);


        monimage = new ImageIcon(resizedImage);
        monlabel = new JLabel(monimage);


        commencer = new JButton("Commencer");
        commencer.setFont(new Font("Arial", Font.BOLD, 24));
        commencer.setBounds(largeur / 2 - 100, longueur - 100, 200, 50);


        commencer.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


//                  JOptionPane.showMessageDialog(null, "Vous avez cliqué sur le bouton");
                frame.dispose();
//                ImportImage i = new ImportImage();

                Login login = new Login();
            }
        });


        monlabel.add(commencer);

        frame = new JFrame("Streaming Accueil");
        frame.add(monlabel);

        frame.setSize(largeur, longueur);


        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Accueil();
    }

}

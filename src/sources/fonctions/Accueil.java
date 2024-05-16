package sources.fonctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Array;

public class Accueil {

    private JFrame frame;
    private ImageIcon monimage;
    private JLabel monlabel;
    private JButton commencer;



    public  Accueil(String[] profils) {

        int longueur = 600;
        int largeur = 800;

        frame = new JFrame("Streaming Accueil");

        int nb_profils = profils.length;

        URL imageURL = getClass().getResource("/ressources/Background_accueil.jpeg");
//        URL imageURL = getClass().getResource("/ressources/accueil2.png");
        assert imageURL != null;
        Image image = new ImageIcon(imageURL).getImage();
        Image resizedImage = image.getScaledInstance(largeur, longueur, Image.SCALE_SMOOTH);
        monimage = new ImageIcon(resizedImage);
        monlabel = new JLabel(monimage);


        int longueur_image = 150;
        int largeur_image = 150;

        URL imageURL2 = getClass().getResource("/ressources/profil4.png");
        assert imageURL2 != null;
        Image image2 = new ImageIcon(imageURL2).getImage();
        Image resizedImage2 = image2.getScaledInstance(largeur_image, longueur_image, Image.SCALE_SMOOTH);
        ImageIcon monimage2 = new ImageIcon(resizedImage2);

        JLabel[] monlabel2 = new JLabel[nb_profils];
        for (int i = 0; i < nb_profils; i++) {
            monlabel2[i] = new JLabel(monimage2);

            if (i == 0) {
                monlabel2[i].setBounds(150, 30, largeur_image, longueur_image);
            } else if (i == 1) {
                monlabel2[i].setBounds(450, 30, largeur_image, longueur_image);
            } else if (i == 2) {
                monlabel2[i].setBounds(150, 300, largeur_image, longueur_image);
            } else if (i == 3) {
                monlabel2[i].setBounds(450, 300, largeur_image, longueur_image);
            }
        }


        System.out.println(" Nombre de profils " + nb_profils);

        String[] boutonProfil = new String[nb_profils];
        JButton[] boutons = new JButton[nb_profils];
        for (int i = 0; i < nb_profils; i++) {
            boutonProfil[i] = "Commencer" + i;
            System.out.println(" bouton_profil " + boutonProfil[i]);
            boutons[i] = new JButton(profils[i]);



            if (i == 0) {
                boutons[i].setBounds(150-30, 30+150, 200, 50);
                frame.add(monlabel2[i]);
                frame.add(boutons[i]);
            } else if (i == 1) {
                boutons[i].setBounds(450-30, 30+150, 200, 50);
                frame.add(monlabel2[i]);
                frame.add(boutons[i]);
            } else if (i == 2) {
                boutons[i].setBounds(150-30, 300+150, 200, 50);
                frame.add(monlabel2[i]);
                frame.add(boutons[i]);
            } else if (i == 3) {
                boutons[i].setBounds(450-30, 300+150, 200, 50);
                frame.add(monlabel2[i]);
                frame.add(boutons[i]);
            }




            commencer = new JButton("Commencer");
            commencer.setFont(new Font("Arial", Font.BOLD, 24));
            commencer.setBounds(largeur / 2 - 100, longueur - 100, 200, 50);

            commencer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                  JOptionPane.showMessageDialog(null, "Vous avez cliqué sur le bouton");
                    frame.dispose();
//                ImportImage i = new ImportImage();
                    Login login = new Login();
                }
            });


            // monlabel.add(commencer);




//            for (i = 0; i < nb_profils; i++) {
//                frame.add(monlabel2[i]);
//                frame.add(boutons[i]);
//            }

            frame.add(monlabel);

            frame.setSize(largeur, longueur);

            frame.setLocationRelativeTo(null);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setVisible(true);

        }

    }
        public static void main (String[]args){
            String[] p = new String[4];
            p[0] = "Yasmine";
            p[1] = "Ashley";
            new Accueil(p);
        }

    }

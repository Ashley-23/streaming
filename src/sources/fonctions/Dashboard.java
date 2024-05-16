package sources.fonctions;

import sources.classes.Utilisateur;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Dashboard {


    private JFrame frame;
    private ImageIcon icon;
    private JLabel label;


    public Dashboard( Utilisateur user){

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int largeur = (int) screenSize.getWidth();
        int longueur = (int) screenSize.getHeight();

        URL imageURL = getClass().getResource("/ressources/login.png");
        assert imageURL != null;
        Image image = new ImageIcon(imageURL).getImage();
        Image resizedImage = image.getScaledInstance(largeur, longueur, Image.SCALE_SMOOTH);
        icon = new ImageIcon(resizedImage);
        label = new JLabel(icon);
        label.setBounds(0, 0, largeur, longueur);


        System.out.println(" loginD : " + user.login);
        System.out.println(" Email : " + user.email);
        System.out.println(" RIB : " + user.rib);
        System.out.println(" Date de Naissance : "+ user.dateNaiss);
        System.out.println(" Mot de passe 1 : " + user.mot_de_passe);



        frame = new JFrame();


        frame.setTitle("Tableau de bord");
        frame.add(label);

        frame.setLayout(null);
        frame.setSize(largeur, longueur);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


    public static void main(String[] args) {
        Utilisateur user = new Utilisateur();
        new Dashboard(user);
    }
}

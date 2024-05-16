package sources.classes;

import com.toedter.calendar.JDateChooser;
import sources.fichiers.ValiderInscription;
import sources.fonctions.Login;
import sources.fonctions.Fichiers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;

public class Inscription {

    private JFrame frame;
    private ImageIcon icon;
    private JLabel label;

    private JLabel loginLabel;
    private JLabel emailLabel;
    private JLabel mdp1Label;
    private JLabel mdp2Label;
    private JLabel dateNaissLabel;
    private JLabel ribLabel;
    private JLabel connexionLabel;

    private JTextField loginField;
    private JTextField emailField;
    private JTextField ribField;

    private JPasswordField mdp1Field;
    private JPasswordField mdp2Field;


    private JPanel calendrierPanel;
    private JDateChooser dateChooser;
    Calendar cld = Calendar.getInstance();
    JDateChooser choixdate = new JDateChooser(cld.getTime());


    private JButton valider;
    private JButton annuler;
    private JButton connexion;

    public Inscription() {

        int longeur = 800;
        int largeur = 1000;


        URL imageURL = getClass().getResource("/ressources/login.png");
        assert imageURL != null;
        Image image = new ImageIcon(imageURL).getImage();
        Image resizedImage = image.getScaledInstance(largeur, longeur, Image.SCALE_SMOOTH);
        icon = new ImageIcon(resizedImage);
        label = new JLabel(icon);
        label.setBounds(0, 0, largeur, longeur);


        loginLabel = new JLabel("Login");
        loginLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        loginLabel.setForeground(Color.WHITE);
        loginLabel.setBounds(200, 200, 80, 25);

        loginField = new JTextField();
        loginField.setBounds(500, 200, 150, 25);


        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setBounds(200, 260, 80, 25);

        emailField = new JTextField();
        emailField.setBounds(500, 260, 150, 25);


        ribLabel = new JLabel("RIB");
        ribLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        ribLabel.setForeground(Color.WHITE);
        ribLabel.setBounds(200, 310, 80, 25);

        ribField = new JTextField();
        ribField.setBounds(500, 310, 150, 25);

        dateNaissLabel = new JLabel("Date de naissance");
        dateNaissLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        dateNaissLabel.setForeground(Color.WHITE);
        dateNaissLabel.setBounds(200, 360, 300, 25);

        calendrierPanel = new JPanel();
        calendrierPanel.setBackground(Color.WHITE);
        calendrierPanel.setBounds(500, 360, 100, 25);


        choixdate.setDateFormatString("dd/MM/yyyy");
        calendrierPanel.add(choixdate);

        mdp1Label = new JLabel("Mot de passe");
        mdp1Label.setFont(new Font("Arial", Font.PLAIN, 24));
        mdp1Label.setForeground(Color.WHITE);
        mdp1Label.setBounds(200, 410, 300, 25);

        mdp1Field = new JPasswordField();
        mdp1Field.setBounds(500, 410, 150, 25);


        mdp2Label = new JLabel("Confirmez le mot de passe");
        mdp2Label.setFont(new Font("Arial", Font.PLAIN, 24));
        mdp2Label.setForeground(Color.WHITE);
        mdp2Label.setBounds(200, 460, 300, 25);

        mdp2Field = new JPasswordField();
        mdp2Field.setBounds(500, 460, 150, 25);


        connexionLabel = new JLabel("Vous avez déjà un compte ? ");
        connexionLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        connexionLabel.setForeground(Color.GRAY);
        connexionLabel.setBounds(320, 600, 310, 25);


        valider = new JButton("Valider");
        valider.setFont(new Font("Arial", Font.BOLD, 20));
        valider.setBounds(300, 510, 120, 25);
        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (loginField.getText().isEmpty() ||
                        emailField.getText().isEmpty() ||
                        ribField.getText().isEmpty() ||
                        mdp2Field.getText().isEmpty() ||
                        mdp2Field.getText().isEmpty()
                ) {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
                } else {
                    if (mdp1Field.getText().equals(mdp2Field.getText())) {
                        Utilisateur user = new Utilisateur();
                        user.login = loginField.getText();
                        user.email = emailField.getText();
                        user.rib = ribField.getText();
                        user.mot_de_passe = mdp1Field.getText();
//                        user.dateNaiss = choixdate.getDate();

                        user.dateNaiss = new java.sql.Date(choixdate.getDate().getTime());

                        ValiderInscription v = new ValiderInscription(user);

                        frame.dispose();
                        Login login = new Login();

                    } else {
                        JOptionPane.showMessageDialog(null, "Les deux mots de passes ne sont pas égaux");
                        mdp1Field.setText("");
                        mdp2Field.setText("");
                    }
                }
            }
        });

        annuler = new JButton("Annuler");
        annuler.setFont(new Font("Arial", Font.BOLD, 20));
        annuler.setBounds(450, 510, 120, 25);
        annuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginField.setText("");
                emailField.setText("");
                ribField.setText("");
                mdp1Field.setText("");
                mdp2Field.setText("");
            }
        });

        connexion = new JButton("Connectez-vous");
        connexion.setFont(new Font("Arial", Font.BOLD, 20));
        connexion.setBounds(650, 600, 200, 25);
        connexion.setForeground(Color.BLUE);
        connexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Login login = new Login();
            }
        });


        frame = new JFrame("Inscription");
        frame.setLayout(null);

        frame.add(calendrierPanel);

        frame.add(loginLabel);
        frame.add(loginField);

        frame.add(emailLabel);
        frame.add(emailField);

        frame.add(ribLabel);
        frame.add(ribField);

        frame.add(dateNaissLabel);
//        frame.add(dateNaissField);

        frame.add(mdp1Label);
        frame.add(mdp1Field);

        frame.add(mdp2Label);
        frame.add(mdp2Field);

        frame.add(valider);
        frame.add(annuler);

        frame.add(connexionLabel);
        frame.add(connexion);

        frame.add(label);

        frame.setSize(largeur, longeur);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }



    public static void main(String[] args) {
        new Inscription();
    }
}


package sources.fonctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Login {

    private JFrame frame;
    private ImageIcon icon;
    private JLabel label;
    private JLabel nomLabel;
    private JLabel mdpLabel;
    private JTextField nomField;
    private JPasswordField mdpField;
    private JButton valider;
    private JButton annuler;

    public Login() {
        int longueur = 600;
        int largeur = 800;

        URL imageURL = getClass().getResource("/ressources/login.png");
        assert imageURL != null;
        Image image = new ImageIcon(imageURL).getImage();

        Image resizedImage = image.getScaledInstance(largeur, longueur, Image.SCALE_SMOOTH);

        icon = new ImageIcon(resizedImage);

        label = new JLabel(icon);
        nomLabel = new JLabel("Nom ");
        nomLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        nomLabel.setForeground(Color.WHITE);

        mdpLabel = new JLabel("Mot de passe ");
        mdpLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        mdpLabel.setForeground(Color.WHITE);


        nomField = new JTextField();
        mdpField = new JPasswordField();
        valider = new JButton("Valider");
        annuler = new JButton("Annuler");

        frame = new JFrame("Connexion");
        frame.setLayout(null);

        label.setBounds(0, 0, largeur, longueur);


        nomLabel.setBounds(200, 200, 80, 25);
        nomField.setBounds(400, 200, 150, 25);
        mdpLabel.setBounds(200, 300, 200, 25);
        mdpField.setBounds(400, 300, 150, 25);


        valider.setFont(new Font("Arial", Font.BOLD, 20));
        valider.setBounds(300, 370, 120, 25);
        valider.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(nomField.getText().equals("MOI") || mdpField.getText().equals("MOI")) {
                    JOptionPane.showMessageDialog(null, "Valider");
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez reprendre");
                }


            }
        });

        annuler.setFont(new Font("Arial", Font.BOLD, 20));
        annuler.setBounds(450, 370, 120, 25);
        annuler.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nomField.setText("");
                mdpField.setText("");
            }
        });





        frame.add(nomLabel);
        frame.add(nomField);
        frame.add(mdpLabel);
        frame.add(mdpField);
        frame.add(valider);
        frame.add(annuler);
        frame.add(label);

        frame.setSize(largeur, longueur);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}

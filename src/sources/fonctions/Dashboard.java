package sources.fonctions;

import sources.classes.Utilisateur;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Dashboard {


    private JFrame frame;
    private ImageIcon icon;
    private JLabel label;

    private ImageIcon icon2;
    private JButton btParametre;

    private ImageIcon icon_sidebar;
    private JLabel label_sidebar;

    private ImageIcon icon_img_serie;
    private JButton bt_serie;

    private ImageIcon icon_img_film;
    private JButton bt_film;

    private ImageIcon icon_img_documentaire;
    private JButton bt_documentaire;

    private JLabel login_label;
    private JLabel login_label2;

    public Dashboard( Utilisateur user){

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int largeur = (int) screenSize.getWidth();
        int longueur = (int) screenSize.getHeight();


        URL imageURL = getClass().getResource("/ressources/dashboard.jpg");
        assert imageURL != null;
        Image image = new ImageIcon(imageURL).getImage();
        Image resizedImage = image.getScaledInstance(largeur, longueur, Image.SCALE_SMOOTH);
        icon = new ImageIcon(resizedImage);
        label = new JLabel(icon);
        label.setBounds(0, 0, largeur, longueur);



        JPanel rectanglePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
//                g.setColor(Color.BLUE);
                g.fillRect(0, 0, getWidth(), getHeight());
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(135, 70);
            }
        };


        login_label = new JLabel("OUPS                  tEST");
        login_label.setFont(new Font("Arial", Font.BOLD, 20));
        login_label.setForeground(Color.RED);

        login_label2 = new JLabel("OUPS    OUPS ");
        login_label2.setFont(new Font("Arial", Font.BOLD, 20));
        login_label2.setForeground(Color.RED);

        rectanglePanel.add(login_label);
        rectanglePanel.add(login_label2);
        rectanglePanel.setBounds(largeur-1350, 26, 135, 70);


        int longueur_btfilm = 70;
        int largeur_btfilm = 70;
        bt_film = new JButton();
        URL imageURL_film = getClass().getResource("/ressources/films.png");
        assert imageURL_film != null;
        Image image_film = new ImageIcon(imageURL_film).getImage();
        Image resizedImage_film = image_film.getScaledInstance(largeur_btfilm, longueur_btfilm, Image.SCALE_SMOOTH);
        icon_img_film = new ImageIcon(resizedImage_film);
        bt_film.setForeground(Color.WHITE);
        bt_film.setIcon(icon_img_film);
        bt_film.setBounds(largeur-1065, 26, largeur_btfilm+35, longueur_btfilm);



        int longueur_btserie = 70;
        int largeur_btserie = 70;
        bt_serie = new JButton();
        URL imageURL_serie = getClass().getResource("/ressources/series.png");
        assert imageURL_serie != null;
        Image image_serie = new ImageIcon(imageURL_serie).getImage();
        Image resizedImage_serie = image_serie.getScaledInstance(largeur_btserie, longueur_btserie, Image.SCALE_SMOOTH);
        icon_img_serie = new ImageIcon(resizedImage_serie);
        bt_serie.setForeground(Color.WHITE);
        bt_serie.setIcon(icon_img_serie);
        bt_serie.setBounds(largeur-820, 26, largeur_btserie+35, longueur_btserie);


        int longueur_btdocumentaire = 70;
        int largeur_btdocumentaire = 150;
        bt_documentaire = new JButton();
        URL imageURL_documentaire = getClass().getResource("/ressources/documentaires.jpeg");
        assert imageURL_documentaire != null;
        Image image_documentaire = new ImageIcon(imageURL_documentaire).getImage();
        Image resizedImage_documentaire = image_documentaire.getScaledInstance(largeur_btdocumentaire, longueur_btdocumentaire, Image.SCALE_SMOOTH);
        icon_img_documentaire = new ImageIcon(resizedImage_documentaire);
        bt_documentaire.setForeground(Color.WHITE);
        bt_documentaire.setIcon(icon_img_documentaire);
        bt_documentaire.setBounds(largeur-620 ,26, largeur_btdocumentaire + 35, longueur_btdocumentaire);



        int longueur_btnparametre = 70;
        int largeur_btnparametre = 70;
        btParametre = new JButton();
        URL imageURL2 = getClass().getResource("/ressources/parametres.png");
        assert imageURL2 != null;
        Image image2 = new ImageIcon(imageURL2).getImage();
        Image resizedImage2 = image2.getScaledInstance(largeur_btnparametre, longueur_btnparametre, Image.SCALE_SMOOTH);
        icon2 = new ImageIcon(resizedImage2);
        btParametre.setForeground(Color.WHITE);
        btParametre.setIcon(icon2);
        btParametre.setBounds(largeur-320, 28, largeur_btnparametre+35, longueur_btnparametre);


        int longueur_sidebar = 100;
        int largeur_sidebar = largeur - 300;
        URL imageURL_sidebar = getClass().getResource("/ressources/sidebar.png");
        assert imageURL_sidebar != null;
        Image image_sidebar = new ImageIcon(imageURL_sidebar).getImage();
        Image resizedImage_sidebar = image_sidebar.getScaledInstance(largeur_sidebar, longueur_sidebar , Image.SCALE_SMOOTH);
        icon_sidebar = new ImageIcon(resizedImage_sidebar);
        label_sidebar = new JLabel(icon_sidebar);
        label_sidebar.setBounds( ((largeur - largeur_sidebar)/2), 10, largeur_sidebar, longueur_sidebar);


        System.out.println(" loginD : " + user.login);
        System.out.println(" Email : " + user.email);
        System.out.println(" RIB : " + user.rib);
        System.out.println(" Date de Naissance : "+ user.dateNaiss);
        System.out.println(" Mot de passe 1 : " + user.mot_de_passe);






        frame = new JFrame();
        frame.setTitle("Tableau de bord");


        frame.add(rectanglePanel);

        frame.add(bt_film);
        frame.add(bt_serie);
        frame.add(btParametre);
        frame.add(bt_documentaire);
        frame.add(label_sidebar);
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

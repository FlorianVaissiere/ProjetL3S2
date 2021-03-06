package vue;
import controleur.ControlFenetreOptions;
import controleur.ControlTouche;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

public class FenetreOptions extends JPanel {

    Jeu jeu;
    ControlTouche controlTouche;
    public Button retour;
    public JButton[] controlButton;

    private Image imageFenetreOption;
    private Font f, fControlTouche;

    public FenetreOptions(Jeu jeu, ControlTouche controlTouche) {
        this.controlTouche = controlTouche;
        this.jeu = jeu;

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        imageFenetreOption = getToolkit().getImage("images/menuPrincipale.jpg");
        f = new Font("Arial", Font.BOLD, Fenetre.adapterResolutionEnX(20));
        fControlTouche = new Font("Arial", Font.BOLD, Fenetre.adapterResolutionEnX(35));

        retour = new Button("Retour");
        retour.setActionCommand("Retour");

        controlButton = new JButton[controlTouche.getNbActions() - 1];
        String[] repAction = new String[]{"Droite", "Gauche", "Sauter"};

        for (int i = 0; i < controlButton.length; i++) {
            controlButton[i] = new JButton(controlTouche.getNomTouche(i + 1));
            controlButton[i].setActionCommand(repAction[i]);
        }

        this.add(retour);

        for (JButton b : controlButton)
            this.add(b);
    }

    public void setControl(ControlFenetreOptions controlFenetreOptions) {
        retour.addActionListener(controlFenetreOptions);

        for (JButton b : controlButton) {
            b.addActionListener(controlFenetreOptions);
            b.addKeyListener(controlFenetreOptions);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imageFenetreOption, 0, 0, getWidth(), getHeight(), this);

        retour.setBounds(Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(980), Fenetre.adapterResolutionEnX(228), Fenetre.adapterResolutionEnX(40));

        int x1 = 600, y1 = 390;
        int x2 = 1300, y2 = 323;

        for (int i = 0; i < controlButton.length; i++) {
            if (i <= 4) {
                controlButton[i].setBounds(Fenetre.adapterResolutionEnX(x1), Fenetre.adapterResolutionEnY(y1), Fenetre.adapterResolutionEnX(270), Fenetre.adapterResolutionEnY(55));
                controlButton[i].setBackground(new Color(0, 0, 0, 0));
                controlButton[i].setForeground(Color.WHITE);
                controlButton[i].setFont(fControlTouche);
                controlButton[i].setBorder(null);
                y1 += 75;
            }
            /*if (i >= 5) {
                controlButton[i].setBounds(Fenetre.adapterResolutionEnX(x2), Fenetre.adapterResolutionEnY(y2), Fenetre.adapterResolutionEnX(270), Fenetre.adapterResolutionEnY(50));
                controlButton[i].setBackground(new Color(0, 0, 0, 0));
                controlButton[i].setForeground(Color.WHITE);
                controlButton[i].setFont(fControlTouche);
                controlButton[i].setBorder(null);
                y2 += 58;
            }*/
        }
    }
}
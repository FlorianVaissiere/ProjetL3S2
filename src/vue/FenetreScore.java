package vue;

import controleur.ControlFenetreScores;
import model.BDD;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.*;

public class FenetreScore extends JPanel {

    private Jeu jeu;

    private Image imageFenetreScore;

    public JButton retour;


    public FenetreScore() {

        this.jeu = jeu;

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        imageFenetreScore = getToolkit().getImage("images/menuPrincipale.jpg");

        retour = new Bouton("Retour");
        retour.setActionCommand("Retour");
        this.add(retour);
    }

    public void setControl(ControlFenetreScores controlFenetreScores) {
        retour.addActionListener(controlFenetreScores);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageFenetreScore, 0, 0, getWidth(), getHeight(), this);

        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("TimesRoman",Font.PLAIN, 30));
        g2.setColor(Color.white);
        g2.drawString(jeu.score[0],150,100);

        retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
    }
}
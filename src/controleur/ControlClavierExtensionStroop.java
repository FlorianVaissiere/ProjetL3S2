package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlClavierExtensionStroop extends Control implements KeyListener{
    private ControlTouche controlTouche;
    String conteneurUneLettre = "";
    String resultat = "";

    public ControlClavierExtensionStroop(Jeu jeu, Fenetre fenetre){
        super(jeu, fenetre);
        fenetre.setControlClavierExtension(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        char lettre = e.getKeyChar();

        conteneurUneLettre = conteneurUneLettre + lettre;

        if(conteneurUneLettre.matches("[a-z]")){
            resultat = resultat + conteneurUneLettre;
        }
        if (key == KeyEvent.VK_ENTER) {
            switch (resultat) {
                case "jaune":
                    if (fenetre.panelFenetreExtensionStroop.getMotTab()[0]) {
                        fenetre.deplacementClavierExtension(true);
                        fenetre.panelFenetreExtensionStroop.setScore(fenetre.panelFenetreExtensionStroop.getScore()+1);
                        fenetre.changerMotExtension();
                    }
                    else{
                        fenetre.deplacementClavierExtension(false);
                        fenetre.changerMotExtension();
                    }
                    resultat = "";
                    break;
                case "vert":
                    if (fenetre.panelFenetreExtensionStroop.getMotTab()[1]) {
                        fenetre.deplacementClavierExtension(true);
                        fenetre.panelFenetreExtensionStroop.setScore(fenetre.panelFenetreExtensionStroop.getScore()+1);
                        fenetre.changerMotExtension();
                    }
                    else{
                        fenetre.deplacementClavierExtension(false);
                        fenetre.changerMotExtension();
                    }
                    resultat = "";
                    break;
                case "rouge":
                    if (fenetre.panelFenetreExtensionStroop.getMotTab()[2]) {
                        fenetre.deplacementClavierExtension(true);
                        fenetre.panelFenetreExtensionStroop.setScore(fenetre.panelFenetreExtensionStroop.getScore()+1);
                        fenetre.changerMotExtension();
                    }
                    else{
                        fenetre.deplacementClavierExtension(false);
                        fenetre.changerMotExtension();
                    }
                    resultat = "";
                    break;
                case "bleu":
                    if (fenetre.panelFenetreExtensionStroop.getMotTab()[3]) {
                        fenetre.deplacementClavierExtension(true);
                        fenetre.panelFenetreExtensionStroop.setScore(fenetre.panelFenetreExtensionStroop.getScore()+1);
                        fenetre.changerMotExtension();
                    }
                    else{
                        fenetre.deplacementClavierExtension(false);
                        fenetre.changerMotExtension();
                    }

                    resultat = "";
                    break;

                    default:
                        fenetre.deplacementClavierExtension(false);
                        fenetre.changerMotExtension();
                        resultat = "";
            }
        }

        if(key == KeyEvent.VK_BACK_SPACE){ // pour effacer
            resultat = "";
        }
        conteneurUneLettre = "";


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
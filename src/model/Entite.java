package model;

import vue.Fenetre;

import java.awt.*;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.random;

public class Entite {

    protected String nom, texture, couleur;

    protected int positionX, positionY;
    protected int vecteurDeplacementEnX, vecteurDeplacementEnY, vitesseDeDeplacementEnX, vitesseDeDeplacementEnY, vitesseDeSaut;
    protected Direction directionOrientation;

    protected boolean collision, deplacement;
    protected String color[] = {"ROUGE","BLEU","VERT","JAUNE","BLANC"};

    public Entite(String nom, String texture, String couleur) {

        this.nom = nom;
        this.texture = texture;
        this.couleur = couleur;

        vitesseDeDeplacementEnY = 0;
        vitesseDeDeplacementEnX = 0;
        vecteurDeplacementEnX = 0;
        vecteurDeplacementEnY = 0;
        directionOrientation = new Direction(Direction.DROITE);
        vitesseDeSaut = 0;

        collision = false;
        deplacement = false;
    }

    public boolean collisionEntite(Entite enti1, Entite enti2, boolean etoile){
        if (etoile == false) {
            if ((enti1.positionY == enti2.positionY || enti1.positionX == enti2.positionX) && enti1.couleur != enti2.couleur) {
                enti1.collision = true;
                enti2.collision = true;
                return true;
            } else {
                return false;
            }
        } else {
            if (enti1.positionY == enti2.positionY && enti1.positionX == enti2.positionX) {
                enti1.collision = true;
                enti2.collision = true;
                return true;
            } else {
                return false;
            }
        }
    }

    public void changementCouleurBille(Entite bille, Entite etoile){
        if(collisionEntite(bille,etoile,true)){
            Random rand = new Random();
            int val = rand.nextInt(5);
            bille.couleur = color[val];
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightoff_roux_version_console;

/**
 *
 * @author hugor
 */
import java.util.Random;

public class GrilleDeCellules {

    private CelluleLumineuse[][] grille;
    private int nbLignes;
    private int nbColonnes;

        public void eteindreToutesLesCellules() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                grille[i][j].eteindreCellule();
            }
        }
    }
    public GrilleDeCellules(int nbLignes, int nbColonnes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        grille = new CelluleLumineuse[nbLignes][nbColonnes];

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                grille[i][j] = new CelluleLumineuse();
            }
        }
    }

    public CelluleLumineuse getCellule(int ligne, int colonne) {
        if (ligne < 0 || ligne >= nbLignes || colonne < 0 || colonne >= nbColonnes) {
            throw new IndexOutOfBoundsException("Position en dehors de la grille.");
        }
        return grille[ligne][colonne];
    }

    public void activerLigneDeCellules(int idLigne) {
        for (int j = 0; j < nbColonnes; j++) {
            grille[idLigne][j].activerCellule();
        }
    }

    public void activerColonneDeCellules(int idColonne) {
        for (int i = 0; i < nbLignes; i++) {
            grille[i][idColonne].activerCellule();
        }
    }

    public void activerDiagonaleDescendante() {
        for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
            grille[i][i].activerCellule();
        }
    }

    public void activerDiagonaleMontante() {
        for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
            grille[nbLignes - 1 - i][i].activerCellule();
        }
    }


    public void MelangeAleatoire(int nbTours) {
        eteindreToutesLesCellules();
        Random rand = new Random();
        for (int i = 0; i < nbTours; i++) {
        int choix = rand.nextInt(4); // 0: ligne, 1: colonne, 2: diagonale descendante, 3: diagonale montante
        switch (choix) {
            case 0:
                activerLigneDeCellules(rand.nextInt(nbLignes));
                break;
            case 1:
                activerColonneDeCellules(rand.nextInt(nbColonnes));
                break;
            case 2:
                activerDiagonaleDescendante();
                break;
            case 3:
                activerDiagonaleMontante();
                break;
        }
    }
    }

    public int getNbLignes() {
        return nbLignes;
    }

    public int getNbColonnes() {
        return nbColonnes;
    }

    @Override
    public String toString() {
        StringBuilder affichage = new StringBuilder();

        for (int i = 0; i < nbLignes; i++) {    
            for (int j = 0; j < nbColonnes; j++) {
                if (grille[i][j].estEteint()) {
                    affichage.append("X");
                } else {
                    affichage.append("0");
                }
            }
            affichage.append("\n");
        }

        return affichage.toString();
    }
}

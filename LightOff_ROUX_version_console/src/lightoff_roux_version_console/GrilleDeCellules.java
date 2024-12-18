/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightoff_roux_version_console;

import java.util.Random;

/**
 * Classe représentant une grille de cellules lumineuses.
 * Cette grille permet de gérer l'état des cellules lumineuses et d'effectuer des actions sur celles-ci
 * telles que l'activation de lignes, colonnes ou diagonales entières.
 * Elle permet également de mélanger aléatoirement l'état des cellules.
 * 
 * @author hugor
 */
public class GrilleDeCellules {

    // Tableau 2D représentant la grille de cellules lumineuses
    public CelluleLumineuse[][] grille;
    
    // Nombre de lignes de la grille
    private int nbLignes;
    
    // Nombre de colonnes de la grille
    private int nbColonnes;

    /**
     * Éteint toutes les cellules de la grille.
     * Parcourt toute la grille et éteint chaque cellule.
     */
    public void eteindreToutesLesCellules() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                grille[i][j].eteindreCellule();
            }
        }
    }

    /**
     * Vérifie si toutes les cellules de la grille sont éteintes.
     * 
     * @return true si toutes les cellules sont éteintes, false sinon.
     */
    public boolean cellulesToutesEteintes() {
        // Parcours de chaque cellule de la grille
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                // Si une cellule est allumée, retourne false
                if (!grille[i][j].estEteint()) {
                    return false;
                }
            }
        }
        // Si aucune cellule n'est allumée, retourne true
        return true;
    }

    /**
     * Constructeur de la grille de cellules lumineuses.
     * Initialise une grille vide avec le nombre de lignes et de colonnes spécifié.
     * Chaque cellule est initialisée à "éteinte".
     * 
     * @param nbLignes le nombre de lignes de la grille.
     * @param nbColonnes le nombre de colonnes de la grille.
     */
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

    /**
     * Récupère la cellule située à la position spécifiée (ligne, colonne).
     * 
     * @param ligne l'indice de la ligne.
     * @param colonne l'indice de la colonne.
     * @return la cellule lumineuse à la position spécifiée.
     * @throws IndexOutOfBoundsException si les indices sont en dehors des limites de la grille.
     */
    public CelluleLumineuse getCellule(int ligne, int colonne) {
        if (ligne < 0 || ligne >= nbLignes || colonne < 0 || colonne >= nbColonnes) {
            throw new IndexOutOfBoundsException("Position en dehors de la grille.");
        }
        return grille[ligne][colonne];
    }

    /**
     * Active toutes les cellules d'une ligne spécifiée.
     * Inverse l'état de toutes les cellules de la ligne donnée.
     * 
     * @param idLigne l'indice de la ligne à activer.
     */
    public void activerLigneDeCellules(int idLigne) {
        for (int j = 0; j < nbColonnes; j++) {
            grille[idLigne][j].activerCellule();
        }
    }

    /**
     * Active toutes les cellules d'une colonne spécifiée.
     * Inverse l'état de toutes les cellules de la colonne donnée.
     * 
     * @param idColonne l'indice de la colonne à activer.
     */
    public void activerColonneDeCellules(int idColonne) {
        for (int i = 0; i < nbLignes; i++) {
            grille[i][idColonne].activerCellule();
        }
    }

    /**
     * Active les cellules de la diagonale descendante.
     * Inverse l'état des cellules de la diagonale allant de l'angle supérieur gauche
     * à l'angle inférieur droit de la grille.
     */
    public void activerDiagonaleDescendante() {
        for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
            grille[i][i].activerCellule();
        }
    }

    /**
     * Active les cellules de la diagonale montante.
     * Inverse l'état des cellules de la diagonale allant de l'angle inférieur gauche
     * à l'angle supérieur droit de la grille.
     */
    public void activerDiagonaleMontante() {
        for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
            grille[nbLignes - 1 - i][i].activerCellule();
        }
    }

    /**
     * Mélange aléatoirement l'état des cellules de la grille.
     * Un certain nombre de tours est effectué pour activer aléatoirement des lignes,
     * colonnes ou diagonales.
     * 
     * @param nbTours le nombre de tours pendant lesquels l'état des cellules sera modifié.
     */
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

    /**
     * Récupère le nombre de lignes de la grille.
     * 
     * @return le nombre de lignes de la grille.
     */
    public int getNbLignes() {
        return nbLignes;
    }

    /**
     * Récupère le nombre de colonnes de la grille.
     * 
     * @return le nombre de colonnes de la grille.
     */
    public int getNbColonnes() {
        return nbColonnes;
    }

    /**
     * Redéfinition de la méthode {@link Object#toString()} pour afficher la grille sous forme textuelle.
     * Les cellules allumées sont représentées par "X" et les cellules éteintes par "O".
     * 
     * @return une représentation textuelle de la grille.
     */
    @Override
    public String toString() {
        StringBuilder affichage = new StringBuilder();
        // Affichage des indices de colonnes
        affichage.append("   ");
        for (int j = 0; j < nbColonnes; j++) {
            affichage.append("| ").append(j).append(" ");
        }
        affichage.append("|\n").append("   ").append("-".repeat(nbColonnes * 4)).append("\n");
        // Affichage des cellules avec les indices de lignes
        for (int i = 0; i < nbLignes; i++) {
            affichage.append(i).append(" | "); // Indice de ligne
            for (int j = 0; j < nbColonnes; j++) {
                affichage.append(grille[i][j].toString()).append(" | ");
            }
            affichage.append("\n").append("   ").append("-".repeat(nbColonnes * 4)).append("\n");
        }
        return affichage.toString();
    }
}

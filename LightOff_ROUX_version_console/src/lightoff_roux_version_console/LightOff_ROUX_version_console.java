/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lightoff_roux_version_console;

/**
 *
 * @author hugor
 */
public class LightOff_ROUX_version_console {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Créer une grille 5x5
        GrilleDeCellules grille = new GrilleDeCellules(5, 5);

        // Affichage initial (toutes les cellules sont éteintes)
        System.out.println("Grille initiale :");
        System.out.println(grille);

        // Activer une ligne
        grille.activerLigneDeCellules(1);
        System.out.println("Après activation de la ligne 1 :");
        System.out.println(grille);

        // Activer une colonne
        grille.activerColonneDeCellules(2);
        System.out.println("Après activation de la colonne 2 :");
        System.out.println(grille);

        // Activer la diagonale descendante
        grille.activerDiagonaleDescendante();
        System.out.println("Après activation de la diagonale descendante :");
        System.out.println(grille);

        // Activer la diagonale montante
        grille.activerDiagonaleMontante();
        System.out.println("Après activation de la diagonale montante :");
        System.out.println(grille);

        // Mélanger la grille aléatoirement 5 fois
        grille.melangerMatriceAleatoirement(5);
        System.out.println("Après mélange aléatoire (5 tours) :");
        System.out.println(grille);
    }
}

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
import java.util.Scanner;

public class Partie {

    private GrilleDeCellules grille;
    private Scanner scanner;

    public Partie(int nbLignes, int nbColonnes) {
        this.grille = new GrilleDeCellules(nbLignes, nbColonnes);
        this.scanner = new Scanner(System.in);
    }

   public void initialiserPartie() {
        Random rand = new Random();
        int nbMélanges = rand.nextInt(10) + 5; // Par exemple, entre 5 et 15 actions aléatoires

        // Mélanger la grille avec des actions aléatoires
        for (int i = 0; i < nbMélanges; i++) {
            // Choisir une action aléatoire parmi ligne, colonne ou diagonale
            grille.activerLigneColonneOuDiagonaleAleatoire(); 
        }

        // Afficher la grille après mélange
        System.out.println("Grille initiale mélangée : ");
        System.out.println(grille.toString());
    }

    // Lancer la partie avec des actions de l'utilisateur

    public void lancerPartie() { 
        Random ran = new Random();
         int nbTours = ran.nextInt(16) + 5; // Cela donne un nombre aléatoire entre 5 et 20
                System.out.println("Nombre de tours de mélange : " + nbTours);
                grille.melangerMatriceAleatoirement(nbTours);
        boolean continuer = true;
       

        while (continuer) {
            System.out.println("Entrez votre coup :");
            System.out.println("1. Activer une ligne");
            System.out.println("2. Activer une colonne");
            System.out.println("3. Activer une diagonale descendante");
            System.out.println("4. Activer une diagonale montante");
            System.out.println("0. Quitter");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("Entrez le numéro de la ligne (0-" + (grille.getNbLignes() - 1) + ") : ");
                    int ligne = scanner.nextInt();
                    grille.activerLigneDeCellules(ligne);
                    break;
                case 2:
                    System.out.print("Entrez le numéro de la colonne (0-" + (grille.getNbColonnes() - 1) + ") : ");
                    int colonne = scanner.nextInt();
                    grille.activerColonneDeCellules(colonne);
                    break;
                case 3:
                    grille.activerDiagonaleDescendante();
                    break;
                case 4:
                    grille.activerDiagonaleMontante();
                    break;
                    
                case 0:
                    continuer = false;
                    System.out.println("Merci d'avoir joué !");
                    break;
                default:
                    System.out.println("Choix invalide. Réessayez.");
            }

            if (continuer) {
                System.out.println("État actuel de la grille :");
                System.out.println(grille);
            }
        }
    }
}

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
 private int nbCoups;
 
    public Partie(int nbLignes, int nbColonnes) {
        this.grille = new GrilleDeCellules(nbLignes, nbColonnes);
        this.scanner = new Scanner(System.in);
        nbCoups = 0;
    }

   public void initialiserPartie() {
        Random rand = new Random();
        int nbMélanges = rand.nextInt(10) + 5; // Par exemple, entre 5 et 15 actions aléatoires

        // Mélanger la grille avec des actions aléatoires
        
            grille.MelangeAleatoire(nbMélanges); 

        // Afficher la grille après mélange
        System.out.println("Grille initiale mélangée : "+ nbMélanges);
        System.out.println(grille.toString());
    }

    // Lancer la partie avec des actions de l'utilisateur

    public void lancerPartie() { 
        boolean continuer = true;
       

        while (continuer) {
            System.out.println("nombre de coup = " +nbCoups);
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
                    nbCoups++;
                    break;
                case 2:
                    System.out.print("Entrez le numéro de la colonne (0-" + (grille.getNbColonnes() - 1) + ") : ");
                    int colonne = scanner.nextInt();
                    grille.activerColonneDeCellules(colonne);
                    nbCoups++;
                    break;
                case 3:
                    grille.activerDiagonaleDescendante();
                    nbCoups++;
                    break;
                case 4:
                    grille.activerDiagonaleMontante();
                    nbCoups++;
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightoff_roux_version_console;

import java.util.Random;
import java.util.Scanner;

/**
 * Classe représentant une partie du jeu "Light Off".
 * Elle gère la création de la grille, le mélange initial des cellules, 
 * ainsi que les actions effectuées par le joueur pendant la partie.
 * 
 * @author hugor
 */
public class Partie {

    // Attributs représentant la grille de jeu et le scanner pour la saisie de l'utilisateur
    private GrilleDeCellules grille;
    private Scanner scanner;
    private int nbCoups;

    /**
     * Constructeur de la classe Partie.
     * Initialise la grille de jeu avec le nombre de lignes et de colonnes spécifiés
     * et prépare le scanner pour la saisie des actions du joueur.
     * 
     * @param nbLignes Le nombre de lignes de la grille de jeu
     * @param nbColonnes Le nombre de colonnes de la grille de jeu
     */
    public Partie(int nbLignes, int nbColonnes) {
        this.grille = new GrilleDeCellules(nbLignes, nbColonnes);
        this.scanner = new Scanner(System.in);
        nbCoups = 0;
    }

    /**
     * Méthode pour initialiser la partie avec un mélange aléatoire des cellules.
     * Le nombre d'actions aléatoires est compris entre 5 et 15.
     */
    public void initialiserPartie() {
        Random rand = new Random();
        int nbMélanges = rand.nextInt(10) + 5; // Par exemple, entre 5 et 15 actions aléatoires

        // Mélange la grille avec des actions aléatoires
        grille.MelangeAleatoire(nbMélanges); 

        // Affiche la grille après mélange
        System.out.println("Grille initiale mélangée : "+ nbMélanges);
        System.out.println(grille.toString());
    }

    /**
     * Méthode principale qui lance la partie.
     * Elle permet à l'utilisateur de choisir des actions pour modifier l'état de la grille.
     * La partie continue jusqu'à ce que l'utilisateur choisisse de quitter.
     */
    public void lancerPartie() { 
        boolean continuer = true;

        while (continuer) {
            // Affichage du nombre de coups et des options du joueur
            System.out.println("nombre de coup = " + nbCoups);
            System.out.println("Entrez votre coup :");
            System.out.println("1. Activer une ligne");
            System.out.println("2. Activer une colonne");
            System.out.println("3. Activer une diagonale descendante");
            System.out.println("4. Activer une diagonale montante");
            System.out.println("0. Quitter");

            // Lecture du choix de l'utilisateur
            int choix = scanner.nextInt();

            // Traitement du choix
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

            // Affiche l'état de la grille après chaque action, sauf si l'utilisateur a quitté
            if (continuer) {
                System.out.println("État actuel de la grille :");
                System.out.println(grille);
            }
        }
    }
}

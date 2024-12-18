/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lightoff_roux_version_console;

/**
 * Classe principale représentant le jeu "LightOff" en version console.
 * Cette classe contient le point d'entrée du programme, où la partie est initialisée et lancée.
 * 
 * @author hugor
 */
public class LightOff_ROUX_version_console {

    /**
     * Méthode principale pour démarrer le jeu "LightOff".
     * Elle crée une instance de la classe Partie avec une grille de 5x5, initialise la partie et lance le jeu.
     * 
     * @param args les arguments de la ligne de commande (non utilisés dans cette version).
     */
    public static void main(String[] args) {
        // Création d'une partie avec une grille de 5x5
        Partie partie = new Partie(5, 5); 
        
        // Initialisation de la partie (affichage de la grille initiale)
        partie.initialiserPartie(); 
        
        // Lancement de la partie (demande à l'utilisateur de faire des choix)
        partie.lancerPartie(); 
    }
}

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
        // Création d'une partie avec une grille de 5x5
        Partie partie = new Partie(5, 5); 
        
        // Initialisation de la partie (affichage de la grille initiale)
        partie.initialiserPartie(); 
        
        // Lancement de la partie (demande à l'utilisateur de faire des choix)
        partie.lancerPartie(); 
    }
}

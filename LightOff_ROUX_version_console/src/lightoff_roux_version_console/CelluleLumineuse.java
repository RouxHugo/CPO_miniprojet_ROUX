/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightoff_roux_version_console;

/**
 * Classe représentant une cellule lumineuse.
 * Une cellule lumineuse peut avoir un état allumé (true) ou éteint (false).
 * Elle permet de gérer l'activation et la désactivation de la cellule.
 * 
 * @author hugor
 */
public class CelluleLumineuse {

    // Attribut : état de la cellule (true = allumée, false = éteinte)
    public boolean etat;

    /**
     * Constructeur par défaut de la cellule lumineuse.
     * Initialisation de l'état de la cellule à "éteinte".
     */
    public CelluleLumineuse() {
        this.etat = false;
    }

    /**
     * Méthode pour activer la cellule, c'est-à-dire inverser son état.
     * Si la cellule est éteinte, elle devient allumée, et vice versa.
     */
    public void activerCellule() {
        this.etat = !this.etat;
    }

    /**
     * Méthode pour éteindre la cellule.
     * L'état de la cellule est fixé à "éteinte" (false).
     */
    public void eteindreCellule() {
        this.etat = false;
    }

    /**
     * Méthode pour vérifier si la cellule est éteinte.
     * 
     * @return true si la cellule est éteinte, sinon false.
     */
    public boolean estEteint() {
        return !this.etat;
    }

    /**
     * Méthode pour obtenir l'état actuel de la cellule.
     * 
     * @return true si la cellule est allumée, false si elle est éteinte.
     */
    public boolean getEtat() {
        return this.etat;
    }

    /**
     * Redéfinition de la méthode {@link Object#toString()} pour retourner une représentation textuelle
     * de l'état de la cellule. "X" pour une cellule allumée et "O" pour une cellule éteinte.
     * 
     * @return "X" si la cellule est allumée, "O" si elle est éteinte.
     */
    @Override
    public String toString() {
        return etat ? "X" : "O"; // "X" pour allumée, "O" pour éteinte
    }
}

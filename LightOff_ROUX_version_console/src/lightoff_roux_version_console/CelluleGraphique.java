/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightoff_roux_version_console;

import javax.swing.*;
import java.awt.*;

/**
 * Représente un bouton graphique associé à une cellule lumineuse.
 * Cette classe hérite de {@link JButton} et permet de gérer l'affichage
 * graphique d'une cellule, en changeant sa couleur en fonction de son état (allumée ou éteinte).
 * 
 * @author hugor
 */
public class CelluleGraphique extends JButton {

    // Attributs
    private CelluleLumineuse celluleLumineuseAssociee;
    private int largeur;
    private int longueur;

    /**
     * Constructeur de la classe CelluleGraphique.
     * 
     * @param celluleLumineuseAssociee La cellule lumineuse associée à ce bouton graphique.
     * @param largeur La largeur du bouton graphique.
     * @param longueur La longueur du bouton graphique.
     */
    public CelluleGraphique(CelluleLumineuse celluleLumineuseAssociee, int largeur, int longueur) {
        this.celluleLumineuseAssociee = celluleLumineuseAssociee;
        this.largeur = largeur;
        this.longueur = longueur;
    }

    /**
     * Méthode qui gère le dessin de la cellule graphique. 
     * Elle change la couleur de fond du bouton en fonction de l'état de la cellule lumineuse associée.
     * Si la cellule est allumée, le fond est jaune, sinon il est noir.
     * 
     * @param g L'objet {@link Graphics} utilisé pour dessiner la cellule.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Changement de couleur selon l'état de la cellule
        if (celluleLumineuseAssociee.etat) { // Allumée
            this.setBackground(Color.YELLOW); // Jaune pour "allumé"
            this.setForeground(Color.BLACK);  // Texte noir pour contraste
        } else { // Éteinte
            this.setBackground(Color.BLACK); // Noir pour "éteint"
            this.setForeground(Color.WHITE); // Texte blanc pour contraste
        }
        
        this.setText(""); // Retire le texte
        this.setOpaque(true); // Assure que la couleur de fond est visible
        this.setBorderPainted(false); // Supprime la bordure
    }
}
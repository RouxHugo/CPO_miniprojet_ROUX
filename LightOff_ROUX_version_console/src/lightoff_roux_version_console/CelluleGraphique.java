/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightoff_roux_version_console;

/**
 *
 * @author hugor
 */
import javax.swing.*;
import java.awt.*;

public class CelluleGraphique extends JButton {

    // Attributs
    private CelluleLumineuse celluleLumineuseAssociee;
    private int largeur;
    private int longueur;

    // Constructeur
    public CelluleGraphique(CelluleLumineuse celluleLumineuseAssociee, int largeur, int longueur) {
        this.celluleLumineuseAssociee = celluleLumineuseAssociee;
        this.largeur = largeur;
        this.longueur = longueur;
        
    }
    // Methode gérant le dessin de la cellule  
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
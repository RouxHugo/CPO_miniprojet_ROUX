/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightoff_roux_version_console;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe représentant le menu principal du jeu "Light Off".
 * Cette classe crée une interface graphique avec plusieurs écrans permettant à l'utilisateur de 
 * naviguer entre les options du menu principal, la sélection de difficulté et l'affichage des règles du jeu.
 * 
 * @author hugor
 */
public class MenuPrincipal extends JFrame {
    
    // Attributs pour la gestion de l'interface graphique
    private CardLayout cardLayout;
    private JPanel mainPanel;

    /**
     * Constructeur de la classe MenuPrincipal.
     * Initialise le menu principal avec les boutons pour démarrer le jeu, voir les règles et quitter.
     * Configure également l'écran de sélection de la difficulté avec les boutons correspondants.
     */
    public MenuPrincipal() {
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        // Initialiser le CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Écran principal (menu)
        JPanel menuPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        JButton jouerButton = new JButton("Jouer");
        JButton reglesButton = new JButton("Règles du Jeu");
        JButton quitterButton = new JButton("Quitter");

        // Actions pour le menu principal
        jouerButton.addActionListener(e -> cardLayout.show(mainPanel, "selectionDifficulte"));
        reglesButton.addActionListener(e -> JOptionPane.showMessageDialog(null, 
            "Le but du jeu est d'éteindre toutes les lumières.\n"
            + "Cliquez sur les boutons pour activer des lignes, colonnes ou diagonales.",
            "Règles du Jeu",
            JOptionPane.INFORMATION_MESSAGE));
        quitterButton.addActionListener(e -> System.exit(0));

        // Ajouter les boutons au menu principal
        menuPanel.add(jouerButton);
        menuPanel.add(reglesButton);
        menuPanel.add(quitterButton);

        // Écran de sélection de difficulté
        JPanel difficultePanel = new JPanel(new GridLayout(6, 1, 10, 10));
        JButton facileButton = new JButton("Facile (3x3, coups illimités)");
        JButton moyenButton = new JButton("Moyen (5x5, 30 coups)");
        JButton difficileButton = new JButton("Difficile (7x7, 20 coups)");
        JButton expertButton = new JButton("Expert (10x10, 15 coups)");
        JButton maitreButton = new JButton("Maître (20x20, 10 coups)");
        JButton retourButton = new JButton("Revenir au menu principal");

        // Actions pour les boutons de difficulté
        facileButton.addActionListener(e -> lancerJeu(3, -1));
        moyenButton.addActionListener(e -> lancerJeu(5, 30));
        difficileButton.addActionListener(e -> lancerJeu(7, 20));
        expertButton.addActionListener(e -> lancerJeu(10, 15));
        maitreButton.addActionListener(e -> lancerJeu(20, 10));
        retourButton.addActionListener(e -> cardLayout.show(mainPanel, "menu"));

        // Ajouter les boutons au panneau de sélection de difficulté
        difficultePanel.add(facileButton);
        difficultePanel.add(moyenButton);
        difficultePanel.add(difficileButton);
        difficultePanel.add(expertButton);
        difficultePanel.add(maitreButton);
        difficultePanel.add(retourButton);

        // Ajouter les deux panneaux au CardLayout
        mainPanel.add(menuPanel, "menu");
        mainPanel.add(difficultePanel, "selectionDifficulte");

        // Ajouter le panneau principal au JFrame
        add(mainPanel);

        // Afficher le menu principal par défaut
        cardLayout.show(mainPanel, "menu");
    }

    /**
     * Lance le jeu avec la taille de grille spécifiée et le nombre maximal de coups.
     * Ferme la fenêtre actuelle et ouvre la fenêtre de l'interface du jeu avec les paramètres donnés.
     * 
     * @param taille Taille de la grille de jeu (nombre de lignes et de colonnes)
     * @param coupsMax Nombre maximal de coups autorisés dans le jeu
     */
    private void lancerJeu(int taille, int coupsMax) {
        // Ferme la fenêtre actuelle et lance l'interface principale du jeu
        dispose();
        new interfaceprincipale(taille, coupsMax).setVisible(true);
    }

    /**
     * Méthode principale qui lance l'application graphique.
     * 
     * @param args Arguments de la ligne de commande (non utilisés dans cette version)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }
}

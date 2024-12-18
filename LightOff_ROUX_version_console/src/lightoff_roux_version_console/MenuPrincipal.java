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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Création des boutons
        JButton jouerButton = new JButton("Jouer");
        JButton jouerButton2 = new JButton("Jouer moyen");
       
         JButton jouerButton3 = new JButton("Jouer difficile");
       JButton reglesButton = new JButton("Règles du Jeu");
        JButton quitterButton = new JButton("Quitter");

        // Ajout des actions pour les boutons
        jouerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ouvrir l'interface de jeu
                dispose(); // Ferme le menu principal
                new interfaceprincipale(8).setVisible(true); // Ouvre l'interface de jeu
            }
        });

        jouerButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ouvrir l'interface de jeu
                dispose(); // Ferme le menu principal
                new interfaceprincipale(10).setVisible(true); // Ouvre l'interface de jeu
            }
        });
        jouerButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ouvrir l'interface de jeu
                dispose(); // Ferme le menu principal
                new interfaceprincipale(15).setVisible(true); // Ouvre l'interface de jeu
            }
        });
        reglesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Afficher les règles du jeu
                JOptionPane.showMessageDialog(null, 
                    "Le but du jeu est d'éteindre toutes les lumières.\n"
                    + "Cliquez sur les boutons pour activer des lignes, colonnes ou diagonales.",
                    "Règles du Jeu",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });

        quitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Quitter l'application
                System.exit(0);
            }
        });

        // Mise en page des boutons
        setLayout(new GridLayout(3, 1, 10, 10));
        add(jouerButton);
        add(jouerButton2);
        add(jouerButton3);
        add(reglesButton);
        add(quitterButton);
    }

    public static void main(String[] args) {
        // Afficher le menu principal
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }
}
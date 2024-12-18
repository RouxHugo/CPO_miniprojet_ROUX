/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lightoff_roux_version_console;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 * Cette classe représente l'interface principale du jeu "Light Off" avec une grille de cellules.
 * Elle gère l'affichage du jeu, les actions des joueurs et les conditions de victoire/défaite.
 * La classe hérite de JFrame pour permettre l'affichage dans une fenêtre graphique.
 * 
 * @author hugor
 */
public class interfaceprincipale extends javax.swing.JFrame {
    GrilleDeCellules grille;
    int Nbcoups = 0;
int Nbligne ;
  int coup;
  

    /**
     * Constructeur de l'interface principale.
     * Initialiser la grille de jeu et l'affichage initial.
     * 
     * @param nb Le nombre de lignes et de colonnes de la grille de jeu.
     * @param NbCoupsMax Le nombre maximal de coups autorisés.
     */
    public interfaceprincipale(int nb, int NbCoupsMax) {
        Nbligne = nb;
        coup = NbCoupsMax;
        initComponents();
        
        
        int Nbcolonne = Nbligne;
        this.grille = new GrilleDeCellules(Nbligne,Nbcolonne);
        initialiserPartie();
        
        jLabel1.setText("Nombre de coups : "+Nbcoups);
        repaint();
        
        for (int i = 0; i < Nbligne; i++) {
            JButton button = new JButton("");
            jPanel1.add(button);

            final int colonne = i; // capture de la ligne ou colonne correspondante
            button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    // Lorsque l'on clique sur un bouton, on active la colonne correspondante
                    grille.activerColonneDeCellules(colonne);
                    Nbcoups ++ ;
                    jLabel1.setText("Nombre de coups : "+Nbcoups);
                                        repaint(); // Re-dessine la grille pour refléter les changements
        
                    victoire();
                    coupatteint();
                }
            });
        }

        for (int j = 0; j < Nbcolonne; j++) {
            JButton button = new JButton("");
            jPanel5.add(button);

            final int ligne = j; // capture de la colonne correspondante
                        button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    // Lorsque l'on clique sur un bouton, on active la ligne correspondante
                    grille.activerLigneDeCellules(ligne);
                    Nbcoups ++ ;
                    jLabel1.setText("Nombre de coups : "+Nbcoups);
                    repaint();
                    victoire();
                    coupatteint();
                     // Re-dessine la grille pour refléter les changements
                }
            });
            
        }

        for (int i = 0; i < Nbligne; i++) {
            for (int j = 0; j < Nbcolonne; j++) {
                CelluleGraphique bouton_cellule = new CelluleGraphique( grille.grille[i][j], 36,36);
                jPanel6.add(bouton_cellule);

    }
}
  
    }
    /**
     * Cette méthode est appelée lorsque le nombre maximal de coups est atteint.
     * Elle affiche une fenêtre de dialogue pour permettre au joueur de relancer ou quitter le jeu.
     */
    public void coupatteint() {
    if (Nbcoups == coup) { // Vérifie si le nombre de coups dépasse ou atteint la limite
        // Affiche un message à l'utilisateur
        int choix = JOptionPane.showOptionDialog(
            this,
            "Vous avez atteint le nombre maximum de " + coup + " coups.\nVous avez perdu !",
            "Défaite",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.ERROR_MESSAGE,
            null,
            new Object[]{"Relancer", "Quitter"},
            "Relancer"
        );

        // Traite le choix de l'utilisateur
        if (choix == JOptionPane.YES_OPTION) {
            // Relance le jeu
            initialiserPartie();
            repaint(); 
        } else {
            // Quitte l'application
            dispose();
            new MenuPrincipal().setVisible(true);
        }
    }
}


    /**
     * Initialiser une nouvelle partie avec une grille mélangée et le compteur de coups réinitialisé.
     */
    public void initialiserPartie() { 
grille.eteindreToutesLesCellules(); 
grille.MelangeAleatoire(10); 
Nbcoups = 0;
jLabel1.setText("Nombre de coups : "+Nbcoups);
} 

    /**
     * Vérifie si le joueur a gagné la partie.
     * Si toutes les cellules sont éteintes, un message de victoire est affiché.
     */

    public void victoire(){
        if (grille.cellulesToutesEteintes()== true) {
            // Crée un tableau pour les boutons
        Object[] options = {"Relancer", "Quitter"};

        // Affiche une boîte de dialogue avec deux boutons
        int choix = JOptionPane.showOptionDialog(
            null, // Fenêtre parente (null = centré sur l'écran)
            "Félicitations ! Vous avez gagné en "+ Nbcoups + " coups ! \nQue voulez-vous faire ?", // Message
            "Victoire !", // Titre de la fenêtre
            JOptionPane.YES_NO_OPTION, // Type de boutons
            JOptionPane.INFORMATION_MESSAGE, // Icône (info)
            null, // Icône personnalisée (null pour l'icône par défaut)
            options, // Texte des boutons
            options[0] // Valeur par défaut (Relancer)
        );

        // Traite le choix de l'utilisateur
        if (choix == JOptionPane.YES_OPTION) {
            // Action pour relancer le jeu
            System.out.println("Le jeu est relancé !");
            initialiserPartie();
             repaint(); 
        } else if (choix == JOptionPane.NO_OPTION) {
            // Action pour quitter le jeu
            System.out.println("Le jeu est terminé. Au revoir !");
            System.exit(0); // Ferme l'application
        } else {
            // Si l'utilisateur ferme la fenêtre
            System.out.println("Aucune action sélectionnée. Quitter par défaut.");
            System.exit(0);
        }
    }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setPreferredSize(new java.awt.Dimension(400, 400));

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel5.setLayout(new java.awt.GridLayout(0, 1));

        jPanel6.setLayout(new java.awt.GridLayout(Nbligne, Nbligne));

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jButton2.setText("diagonale montante ↗");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        jPanel4.setLayout(new java.awt.GridLayout(2, 1));

        jLabel1.setText("jLabel1");
        jPanel4.add(jLabel1);

        jButton3.setText("retour au Menu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);

        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setText("diagonale descendante ↘");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Méthode appelée lorsque le bouton "diagonale descendante" est cliqué.
     * Elle active la diagonale descendante dans la grille.
     * 
     * @param evt L'événement de clic sur le bouton.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        grille.activerDiagonaleDescendante();
        Nbcoups ++ ;
                    jLabel1.setText("Nombre de coups : "+Nbcoups);
                    victoire();
                    coupatteint();
                    repaint();
    }//GEN-LAST:event_jButton1ActionPerformed
     /**
     * Méthode appelée lorsque le bouton "diagonale montante" est cliqué.
     * Elle active la diagonale montante dans la grille.
     * 
     * @param evt L'événement de clic sur le bouton.
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        grille.activerDiagonaleMontante();
        Nbcoups ++ ;
                    jLabel1.setText("Nombre de coups : "+Nbcoups);
                    victoire();
                    coupatteint();
                    repaint();
    }//GEN-LAST:event_jButton2ActionPerformed
       /**
     * Méthode appelée lorsque le bouton "retour au Menu" est cliqué.
     * Elle ferme l'interface actuelle et retourne au menu principal.
     * 
     * @param evt L'événement de clic sur le bouton.
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Ferme l'interface de jeu et retourne au menu principal
        dispose(); // Ferme la fenêtre actuelle
        new MenuPrincipal().setVisible(true); // Ouvre le menu principal
            // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * Le point d'entrée principal de l'application.
     * Lance l'interface principale avec des paramètres de jeu par défaut.
     * 
     * @param args Les arguments de la ligne de commande.
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interfaceprincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaceprincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaceprincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaceprincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaceprincipale(7,7).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}

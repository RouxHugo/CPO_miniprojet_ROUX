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
        CelluleLumineuse cellule = new CelluleLumineuse();

        System.out.println(cellule); // Affiche : CelluleLumineuse [estAllumee=false]

        cellule.allumer();
        System.out.println(cellule); // Affiche : CelluleLumineuse [estAllumee=true]

        cellule.eteindre();
        System.out.println(cellule); // Affiche : CelluleLumineuse [estAllumee=false]
    }
}

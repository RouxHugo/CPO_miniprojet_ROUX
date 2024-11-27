/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightoff_roux_version_console;

/**
 *
 * @author hugor
 */
/**
 * Classe représentant une cellule lumineuse.
 * Une cellule lumineuse a un état qui peut être allumé ou éteint.
 */
/**
 * Classe représentant une cellule lumineuse.
 */
public class CelluleLumineuse {

    private boolean estAllumee;

    public CelluleLumineuse() {
        this.estAllumee = false;
    }

    public void allumer() {
        this.estAllumee = true;
    }

    public void eteindre() {
        this.estAllumee = false;
    }

    public boolean estAllumee() {
        return estAllumee;
    }

    @Override
    public String toString() {
        return estAllumee ? "O" : ".";
    }
}

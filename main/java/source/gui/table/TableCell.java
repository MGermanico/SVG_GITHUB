/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.gui.table;

import javax.swing.JButton;

/**
 *
 * @author migue
 */
public class TableCell {
    int nGame;
    int value;
    
    public TableCell(int nGame, int value){
        this.nGame = nGame;
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " ";
    }

    public int getValue() {
        return value;
    }

    public int getnGame() {
        return nGame;
    }
    
    
}

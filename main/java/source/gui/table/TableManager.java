/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.gui.table;

import java.util.ArrayList;
import java.util.Map;
import source.bbdd.dao.pojo.Jugador;
import source.gui.DutchWindow;

/**
 *
 * @author migue
 */
public class TableManager {

    protected DutchWindow parent;
    TablePanel tp;

    public TableManager(int nGames, DutchWindow parent) {
        this.parent = parent;
        this.tp = new TablePanel(nGames, this);
    }

    public TablePanel getTP() {
        return tp;
    }

    public int getMaxPoints() {
        int sumaAct;
        int ret = 1;
        Map<Jugador, ArrayList<TableCell>> gameTable = this.tp.gameTable;
        for (Jugador jugador : gameTable.keySet()) {
            sumaAct = 1;
            for (TableCell tableCell : gameTable.get(jugador)) {
                if (tableCell.getValue() != -66) {
                    sumaAct += tableCell.getValue();
                    if (ret < sumaAct) {
                        ret = sumaAct;
                    }
//                    System.out.println(sumaAct);
                }
            }
        }
//        System.out.println("ret : " + ret);
        return ret;

    }
    
    public int getMinPoints() {
        int sumaAct;
        int ret = 0;
        Map<Jugador, ArrayList<TableCell>> gameTable = this.tp.gameTable;
        for (Jugador jugador : gameTable.keySet()) {
            sumaAct = 0;
            for (TableCell tableCell : gameTable.get(jugador)) {
                if (tableCell.getValue() != -66) {
                    sumaAct += tableCell.getValue();
                    if (ret > sumaAct) {
                        ret = sumaAct;
                    }
//                    System.out.println(sumaAct);
                }
            }
        }
//        System.out.println("ret : " + ret);
        return ret;

    }

    public int getActualRound() {
        return this.tp.grid.getnActualGames();
    }

    public TablePanel getTp() {
        return tp;
    }
    
    
}

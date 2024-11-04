/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.gui.table;

import source.gui.DutchWindow;

/**
 *
 * @author migue
 */
public class TableManager{
    protected DutchWindow parent;
    TablePanel tp;
    
    public TableManager(int nGames, DutchWindow parent){
        this.parent = parent;
        this.tp = new TablePanel(nGames, this);
    }
    
    public TablePanel getTP(){
        return tp;
    }
}

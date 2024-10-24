/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.gui.table;

import source.bbdd.dao.pojo.Jugador;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import source.gui.DutchWindow;
import source.utils.Config;
import source.utils.Utils;

/**
 *
 * @author migue
 */
public class TableManager{
    DutchWindow parent;
    TablePanel tp;
    
    public TableManager(int nGames, DutchWindow parent){
        this.parent = parent;
        this.tp = new TablePanel(nGames, this);
    }
    
    public TablePanel getTP(){
        return tp;
    }
}

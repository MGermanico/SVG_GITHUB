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
import java.util.Scanner;
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
public class TablePanel extends JPanel{
    TableManager parent;
    
    JScrollPane scrollPane;
    Box tableBox = Box.createHorizontalBox();
    Map<Jugador, ArrayList<TableCell>> gameTable;
    
    public TablePanel(int nGames, TableManager parent){
        this.setSize(400, 400);
        this.parent = parent;
        this.setBorder(BorderFactory.createLineBorder(Color.RED));
        gameTable = new HashMap<Jugador, ArrayList<TableCell>>();
        initPanel();
    }

    private void initPanel() {
        tableBox.add(new JLabel("aaa"));
        this.add(tableBox);
    }
}

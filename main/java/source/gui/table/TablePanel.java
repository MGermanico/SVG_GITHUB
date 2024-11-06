/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.gui.table;

import source.bbdd.dao.pojo.Jugador;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author migue
 */
public class TablePanel extends JPanel {

    TableManager parent;

    Box tableBox = Box.createHorizontalBox();

    ButtonGrid grid;//TODO - MOVER TODO EL GRID A LA CLASE BUTTONGRID
    JPanel namesGrid;
    Map<Jugador, ArrayList<TableCell>> gameTable;
    JButton addButton;
    int nGames;

    public TablePanel(int nGames, TableManager parent) {
//        this.setSize(parent.parent.dutchManager.getWidth(), 100);
        this.nGames = nGames;
        this.parent = parent;
        this.setBorder(BorderFactory.createLineBorder(Color.RED));
        initGameTable();
        grid = new ButtonGrid(this);
        
        initAddButton();
        initPanel();
        
        this.setPreferredSize(new Dimension(parent.parent.dutchManager.getWidth() + 150, 50*this.gameTable.size()+30));
        
        grid.addColumn();
    }

    private void initGameTable() {
        gameTable = new HashMap<Jugador, ArrayList<TableCell>>();
        ArrayList<TableCell> actualIndivGame;
        for (Jugador player : parent.parent.players) {
            actualIndivGame = new ArrayList<>();
            for (int i = 1; i <= nGames; i++) {
                actualIndivGame.add(new TableCell(i, -66));
            }
            gameTable.put(player, actualIndivGame);
        }
    }

    private void initPanel() {
        namesGrid = new JPanel(new GridLayout(gameTable.size(), 1));
        initGrids();
        tableBox.add(namesGrid);
        tableBox.add(grid);
        addButton.setPreferredSize(new Dimension(30, 50*parent.parent.players.size()));
        JPanel p = new JPanel();
        p.add(addButton);
        tableBox.add(p);
        this.add(tableBox);
    }

    private void initGrids() {
        for (Jugador jugador : gameTable.keySet()) {
            namesGrid.add(new JLabel(jugador.getName()));
            grid.initGrid(jugador);

        }
    }

    private void updateGrid() {
        grid.updateGrid();
    }

    private void initAddButton() {
        addButton = new JButton();
        addButton.setBackground(Color.GREEN);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Dimension d = new Dimension(300, 50*gameTable.size());
//                grid.setSize(d);
//                grid.setMaximumSize(d);
//                grid.setMinimumSize(d);
//                grid.setPreferredSize(d);
                grid.addColumn();
                parent.parent.updateGP();
                
//                parent.parent.getOwner().repaint();
//                parent.parent.getOwner().revalidate();
//                parent.parent.getOwner().pack();
            }
        });
    }

    public int getnGames() {
        return nGames;
    }

    public Map<Jugador, ArrayList<TableCell>> getGameTable() {
        return gameTable;
    }
    
    
}

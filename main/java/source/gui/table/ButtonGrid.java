/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.gui.table;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import source.bbdd.dao.pojo.Jugador;
import source.utils.StringUtils;

/**
 *
 * @author migue
 */
public class ButtonGrid extends JPanel {

    JPanel grid;
    int nActualGames = 0;
    JScrollPane scrollPane;
    
    TablePanel owner;

    public ButtonGrid(TablePanel owner) {
        this.owner = owner;
        init();
    }

    private void init() {
        grid = new JPanel(new GridLayout(owner.gameTable.size(), owner.nGames));
        grid.setPreferredSize(new Dimension(owner.parent.parent.dutchManager.getWidth(), 100));
        scrollPane = new JScrollPane(grid, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(grid.getPreferredSize().width - 2, 50*this.owner.gameTable.size()));
        this.add(scrollPane);
    }

    public void initGrid(Jugador jugador) {
        JButton actualButton;
        for (TableCell tableCell : owner.gameTable.get(jugador)) {
            if (tableCell.nGame > nActualGames) {
                break;
            }
            actualButton = new JButton("+");
            grid.add(actualButton);
        }
    }

    public void updateGrid() {
        grid.removeAll();
        JButton actualButton;
        grid.setLayout(new GridLayout(owner.gameTable.size(), this.nActualGames));
        ButtonAction action;
        String buttonText;
        for (Jugador jugador : owner.gameTable.keySet()) {
            for (TableCell tableCell : owner.gameTable.get(jugador)) {
                if (tableCell.nGame > nActualGames) {
                    break;
                }
                if (tableCell.value == -66) {
                    buttonText = "+";
                }else{
                    buttonText = tableCell.value + "";
                }
                actualButton = new JButton(buttonText);
                actualButton.setBackground(Color.WHITE);
                action = new ButtonAction(tableCell, actualButton);
                actualButton.addActionListener(action);
                grid.add(actualButton);
            }
        }
        owner.parent.parent.getOwner().update();
    }

    public void addColumn() {
        incrementNActualGames();
        Dimension d = new Dimension(50*this.nActualGames, 50*this.owner.gameTable.size());
        this.grid.setPreferredSize(d);
        this.setPreferredSize(new Dimension(400, grid.getPreferredSize().height - 2));
        updateGrid();
    }

    public void incrementNActualGames() {
        if (this.nActualGames < owner.getnGames()) {
            nActualGames++;
        }
    }
    
    
}


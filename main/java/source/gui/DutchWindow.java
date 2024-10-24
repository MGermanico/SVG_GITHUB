/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import source.bbdd.dao.pojo.Jugador;
import source.dutch.DutchManager;
import source.gui.table.TableManager;
import source.gui.table.TablePanel;

/**
 *
 * @author migue
 */
public class DutchWindow extends JPanel{

    private PrincipalFrame owner;
    public ArrayList<Jugador> players;
    JPanel back;
    Box leftSide;
    Box rightSide;
    public DutchManager dutchManager;
    public TableManager tableManager;
            
    public DutchWindow(PrincipalFrame owner, ArrayList<Jugador> players) {
        this.owner = owner;
        
        this.players = players;
        
        initComponents();
        
        initBack();
        
        this.setVisible(true);
    }

    private void initComponents() {
        back = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        leftSide = Box.createVerticalBox();
        rightSide = Box.createVerticalBox();
        
        dutchManager = new DutchManager(players, 15);
        tableManager = new TableManager(15, this);
    }

    private void initBack() {
        leftSide.add(new JLabel("PARTIDA"));
        leftSide.add(dutchManager.getGp());
        leftSide.add(tableManager.getTP());
        back.add(leftSide);
        rightSide.add(new JLabel("aaaaa"));
        back.add(rightSide);
        this.add(back);
    }
    
    public void updateComponents(){
        System.out.println("actualizar");
    }
}

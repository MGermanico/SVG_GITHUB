/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.gui;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import source.bbdd.dao.pojo.Jugador;
import source.dutch.DutchManager;

/**
 *
 * @author migue
 */
public class DutchWindow extends JPanel{

    private PrincipalFrame owner;
    ArrayList<Jugador> players;
    JPanel back;
    JPanel leftSide;
    DutchManager dutchManager;
    
    public DutchWindow(PrincipalFrame owner, ArrayList<Jugador> players) {
        this.owner = owner;
        
        this.players = players;
        
        initComponents();
        
        initBack();
        
        this.setVisible(true);
    }

    private void initComponents() {
        back = new JPanel(new GridLayout(1, 2));
        leftSide = new JPanel(new );
        
        dutchManager = new DutchManager(players, 15);
    }

    private void initBack() {
        leftSide.add(new JLabel("PARTIDA"));
        leftSide.add(dutchManager.getGp());
        back.add(leftSide);
        this.add(back);
    }
    
}

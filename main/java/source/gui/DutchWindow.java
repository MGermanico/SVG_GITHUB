/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.gui;

import java.util.ArrayList;
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
    DutchManager dutchManager;
    
    public DutchWindow(PrincipalFrame owner, ArrayList<Jugador> players) {
        this.owner = owner;
        this.players = players;
        
        initComponents();
        
        initBack();
        
        this.setVisible(true);
    }

    private void initComponents() {
        back = new JPanel();
        
        dutchManager = new DutchManager(players, 15);
        
//        dutchManager.putPoints(players.get(0), 1, 5);
    }

    private void initBack() {
        back.add(dutchManager.getGp());
        this.add(back);
    }
    
}

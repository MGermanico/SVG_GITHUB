/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.gui.optionsWindow;

import exceptions.InvalidFormatException;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import source.bbdd.dao.pojo.Jugador;
import source.bbdd.dao.variables.Nickname;

/**
 *
 * @author migue
 */
public class AddPlayersPanel extends JPanel{

    GetPlayers owner;
    
    private ArrayList<Jugador> players;
    
    JPanel back;
    
    public AddPlayersPanel(GetPlayers owner) {
        this.owner = owner;
        players = new ArrayList<>();
        back = new JPanel();
        
        setUp();
        this.add(back);
    }

    private void setUp() {
        back.removeAll();
        int n = 0;
        for (Jugador player : players) {
            try {
                player.setName(player.getName() + "_" + n);
                back.add(new JLabel(player.getName()));
                n++;
            } catch (InvalidFormatException ex) {
                Logger.getLogger(AddPlayersPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JButton addButton = new JButton("Añadir");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPlayerAction();
            }
        });
        back.add(addButton);
        
        back.setLayout(new GridLayout(back.getComponentCount(), 1));
    }
    private void addPlayerAction(){
        try {
            players.add(new Jugador(new Nickname("aaa"), Color.yellow));
        } catch (InvalidFormatException ex) {
            Logger.getLogger(AddPlayersPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        setUp();
        owner.getOwner().setVisible(true);
        owner.getOwner().repaint();
    }

    public ArrayList<Jugador> getPlayers() {
        return players;
    }
    
}

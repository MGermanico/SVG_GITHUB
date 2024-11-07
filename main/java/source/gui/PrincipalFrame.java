/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.gui;

import exceptions.InvalidFormatException;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import source.bbdd.dao.pojo.Jugador;
import source.bbdd.dao.variables.Nickname;
import source.dutch.DutchManager;
import source.gui.optionsWindow.GetPlayers;

/**
 *
 * @author migue
 */
public class PrincipalFrame extends JFrame implements Runnable{

    public static void main(String[] args) {
        (new PrincipalFrame()).run();
    }
    
    @Override
    public void run() {
        this.add(back);
        initComponents();
    }
    
    JPanel back = new JPanel();
    public static int MENU_SETUP = 0;
    public static int GETPLAYERS_SETUP = 1;
    public static int STARTGAME_SETUP = 2;
    
    private DutchManager dutchManager;
    
    private void initComponents() {
        this.setSize(600, 600);
        setUp(MENU_SETUP);
        
        ArrayList<Jugador> players = new ArrayList<>();
        try {
            players.add(new Jugador(new Nickname("ElPetaCulos1"), Color.BLUE));
            players.add(new Jugador(new Nickname("ElPetaCulos2"), Color.RED));
            players.add(new Jugador(new Nickname("ElPetaCulos3"), Color.YELLOW));
//            players.add(new Jugador(new Nickname("ElPetaCulos"), Color.YELLOW));
//            players.add(new Jugador(new Nickname("ElPetaCulos"), Color.YELLOW));
//            players.add(new Jugador(new Nickname("ElPetaCulos"), Color.YELLOW));
//            players.add(new Jugador(new Nickname("ElPetaCulos"), Color.YELLOW));
//            players.add(new Jugador(new Nickname("ElPetaCulos"), Color.YELLOW));
//            players.add(new Jugador(new Nickname("ElPetaCulos"), Color.YELLOW));
        } catch (InvalidFormatException ex) {
            Logger.getLogger(PrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        setUp(STARTGAME_SETUP, players);
    }

    public void setUp(int setupType, ArrayList<Jugador> players) {
        back.removeAll();
        if (setupType == MENU_SETUP) {
            Menu menu = new Menu(this);
            back.add(menu);
        }else if (setupType == GETPLAYERS_SETUP) {
            GetPlayers getPlayers = new GetPlayers(this);
            back.add(getPlayers);
        }else if (setupType == STARTGAME_SETUP && players != null) {
            DutchWindow dutchWindow = new DutchWindow(this, players);
            for (Jugador player : players) {
                System.out.println(player.getName());
            }
            back.add(dutchWindow);
        }
        this.setVisible(true);
        this.repaint();
    }
    public void setUp(ArrayList<Jugador> players) {
        setUp(STARTGAME_SETUP, players);
    }
    public void setUp(int setupType) {
        setUp(setupType, null);
    }
    public void update(){
        int width = this.getWidth();
        int height = this.getHeight();
        this.pack();
        this.setSize(width, height);
        this.setPreferredSize(new Dimension(width, height));
    }
}

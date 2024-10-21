/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.gui;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import source.bbdd.dao.pojo.Jugador;
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
    
}

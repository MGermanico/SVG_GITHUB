/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.dutch;

import java.util.ArrayList;
import java.util.HashMap;
import source.bbdd.dao.pojo.Jugador;

/**
 *
 * @author migue
 */
public class DutchManager {
    GraphicPanel gp;
    Dutch dutch;
    
    public DutchManager(ArrayList<Jugador> jugadores, int nGames) {
        this.gp = new GraphicPanel(400, 400);
        this.dutch = new Dutch(gp, jugadores, nGames);
    }
    
    public void putPoints(Jugador jugador, int n, int points){
        dutch.putPoints(points, jugador, n);
        gp.addPoints(dutch.getPoints(jugador, n - 1), dutch.getPoints(jugador, n), jugador, n);
        gp.refreshJugadorLines(jugador, n);
    }

    public GraphicPanel getGp() {
        return gp;
    }
    
}

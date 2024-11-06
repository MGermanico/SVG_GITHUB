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
    PointsGraphicPanel pgp;
    Dutch dutch;
    
    public DutchManager(ArrayList<Jugador> jugadores, int nGames) {
        this.gp = new GraphicPanel(400, 400);
        this.dutch = new Dutch(gp, jugadores, nGames);
        this.pgp = new PointsGraphicPanel(this);
    }
    
    public int getMagOrder(){
        return this.gp.getMagOrder();
    }
    
    public void putPoints(Jugador jugador, int n, int points){
        dutch.putPoints(points, jugador, n);
        
        gp.addPoints(dutch.getPoints(jugador, n - 1), dutch.getPoints(jugador, n), jugador, n);
        
        gp.refreshJugadorLines(jugador, n);
    }
    
    public HashMap<Integer, Integer> getPointsByName(String nickname){
        return gp.getPointsByName(nickname);
    }
    
    public void setXY(double x, double y){
        gp.setXY(x, y);
        pgp.update();
    }
    
    public void setSize(int width, int height) {
        gp.setSizeGP(width, height);
        pgp.update();
    }

    public GraphicPanel getGP() {
        return gp;
    }

    public PointsGraphicPanel getPGP() {
        return pgp;
    }
    
    public double getY(){
        return gp.gm.getY();
    }
    
    public double getX() {
        return gp.gm.getX();
    }
    
    public double getYOffset(){
        return gp.gm.getyOffSet();
    }
    
    public int getWidth(){
        return this.gp.gm.getSvgManager().getWidth();
    }
    public int getHeight(){
        return this.gp.gm.getSvgManager().getHeight();
    }

    

    
    
}

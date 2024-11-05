/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

import source.bbdd.dao.pojo.Jugador;
import source.bbdd.dao.variables.Nickname;
import exceptions.InvalidFormatException;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import source.dutch.Dutch;
import source.dutch.DutchManager;
import source.dutch.GraphicPanel;
import source.graphic.GraphicManager;
import source.svg.SVGManager;
import source.svg.complexstatements.Grid;
import source.svg.dao.implementations.SVGImplementation;
import source.svg.dao.pojo.SVGObject;
import source.svg.dao.pojo.statements.Line;
import source.svg.dao.pojo.statements.Rect;
import source.svg.dao.pojo.statements.SVGStatement;
import source.svg.data.config.SVGConfiguration;

/**
 *
 * @author migue
 */
public class ExecTest extends JFrame implements Runnable{
    public static void main(String[] args) {
        (new ExecTest()).run();
//        GraphicManager gm = new GraphicManager(10, 10, 400, 400);
//        gm.setxOffSet(-2);
//        gm.setyOffSet(-1);
//        gm.addLane(new Line(0, 0, 3, 3, Color.RED, 1));
//        gm.setXY(5, 5);
//        ShowSVGImage mi = new ShowSVGImage(gm.getImageIcon());
    }

    @Override
    public void run() {// Jugador jugador, int n, int points
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Jugador j = null;
        
        try {
            j = new Jugador(new Nickname("aaa"));
            jugadores.add(new Jugador(new Nickname("aaa")));
            jugadores.add(new Jugador(new Nickname("bbb")));
            jugadores.add(new Jugador(new Nickname("ccc")));
            jugadores.add(new Jugador(new Nickname("ddd")));
        } catch (InvalidFormatException ex) {
            Logger.getLogger(ExecTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DutchManager dm = new DutchManager(jugadores, 15);
        
        this.add(dm.getGP());
        
        
        dm.putPoints(j, 1, 3);
        
        dm.putPoints(j, 2, 2);
        
        dm.putPoints(j, 3, 5);
        
        this.setVisible(true);
        this.setSize(500, 500);
    }
}
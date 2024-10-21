/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.dutch;

import source.bbdd.dao.pojo.Jugador;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JPanel;
import source.bbdd.dao.pojo.PartidaIndividual;
import source.graphic.GraphicManager;
import source.svg.dao.pojo.statements.Line;
import source.svg.dao.pojo.statements.SVGStatement;

/**
 *
 * @author migue
 */
public class GraphicPanel extends JPanel{

    GraphicManager gm;
    HashMap<String, HashMap<Integer, Line>> lines;
    
    public GraphicPanel(int width, int height) {
        lines = new HashMap<>();
        gm = new GraphicManager(10, 10, width, height);
        gm.setXY(8,8);
        update();
    }
    
    
    
    public void addPoints(int beforePoints, int points, Jugador jugador, int n){
//        gm.addLane(new Line(n-1, beforePoints, n, points, jugador.getColor(), 1));
        Line line = new Line(n-1, beforePoints, n, points, Color.red, 1);
        HashMap<Integer, Line> jugadorLines = lines.get(jugador.getName());
        if (jugadorLines == null) {
            jugadorLines = new HashMap<>();
        }
        jugadorLines.put(n, line);
        lines.put(jugador.getName(), jugadorLines);
        update();
    }
    
    public void refreshJugadorLines(Jugador jugador, int n){
        Line actualLine;
        String name = jugador.getName();
        HashMap<Integer, Line> partidas = lines.get(name);
//        System.out.println(lines);
//        System.out.println(name);
        System.out.println("---REFRESH---");
        double difference;
        for (int i = n+1; i <= partidas.size(); i++) {
            actualLine = partidas.get(i);
            if (actualLine != null) {
//                System.out.println(actualLine);
                difference = partidas.get(i-1).getY2() - actualLine.getY1();
                actualLine = new Line(
                        actualLine.getX1(),
                        actualLine.getY1() + difference,
                        actualLine.getX2(),
                        actualLine.getY2() + difference,
                        new Color(3, 3, 3),
                        1
                );
                System.out.println(actualLine);
                gm.addLane(lines.get(name).get(i));
                partidas.put(i, actualLine);
            }
        }
        lines.put(name, partidas);
        System.out.println("--/REFRESH---");
        update();
    }
    
    public void update(){
        gm.clear();
        System.out.println("---UPDATE---");
        for (String string : lines.keySet()) {
            for (int i : lines.get(string).keySet()) {
                System.out.println(lines.get(string).get(i));
                gm.addLane(lines.get(string).get(i));
            }
        }
        System.out.println("--/UPDATE---");
        this.removeAll();
        this.add(new JLabel(gm.getImageIcon()));
    }
    
}

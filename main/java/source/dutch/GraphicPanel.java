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
    
    public void setXY(double x, double y){
        gm.setXY(x, y);
        update();
    }
    
    void setSizeGP(int width, int height) {
        gm.setSize(width, height);
        update();
    }
    
    public void addPoints(int beforePoints, int points, Jugador jugador, int n){
//        gm.addLane(new Line(n-1, beforePoints, n, points, jugador.getColor(), 1));
        Line line = new Line(n-1, beforePoints, n, points, jugador.getColor(), 2);
        HashMap<Integer, Line> jugadorLines = lines.get(jugador.getName());
        if (jugadorLines == null) {
            jugadorLines = new HashMap<>();
        }
        jugadorLines.put(n, line);
        lines.put(jugador.getName(), jugadorLines);
//        System.out.println("atascao");
        checklineIsCompleted();
//        System.out.println("no");
        update();
    }
    
    public void refreshJugadorLines(Jugador jugador, int n){
        Line actualLine;
        String name = jugador.getName();
        HashMap<Integer, Line> partidas = lines.get(name);
//        System.out.println(lines);
//        System.out.println(name);
//        System.out.println("---REFRESH---");
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
                        jugador.getColor(),
                        2
                );
//                System.out.println(actualLine);
                gm.addLane(lines.get(name).get(i));
                partidas.put(i, actualLine);
            }
        }
        lines.put(name, partidas);
//        System.out.println("--/REFRESH---");
        update();
    }
    
    public void checklineIsCompleted(){
        int realN;
        boolean changed = false;
        Line beforeLine = null;
        double ptsFill;
        Color colorFill;
//        System.out.println("ENTRADO");
        for (String name : lines.keySet()) {
            realN = 1;
            for (int n : lines.get(name).keySet()) {
//                System.out.println(n + " ?= " + realN);
                if (n != realN) {
                    beforeLine = lines.get(name).get(realN-1);
                    if (beforeLine == null) {
                        ptsFill = 0;
                        colorFill = lines.get(name).get(n).getColor();
                    }else{
                        ptsFill = beforeLine.getY2();
                        colorFill = beforeLine.getColor();
                    }
                    Line line = new Line(realN-1, ptsFill, realN, ptsFill, colorFill, 2);
                    lines.get(name).put(realN, line);
                    changed = true;
                    realN = n;
                }
                realN++;
            }
        }
        if (changed) {
            checklineIsCompleted();
        }
    }
    
    public void update(){
        gm.clear();
//        System.out.println("---UPDATE---");
        for (String string : lines.keySet()) {
            for (int i : lines.get(string).keySet()) {
//                System.out.println(lines.get(string).get(i));
                gm.addLane(lines.get(string).get(i));
            }
        }
//        System.out.println("--/UPDATE---");
        this.removeAll();
        this.add(new JLabel(gm.getImageIcon()));
    }

    public HashMap<Integer, Integer> getPointsByName(String nickName){
        
        HashMap<Integer, Integer> list = new HashMap<>();
//        System.out.println("ENTRADA NOMBRE : " + nickName);
//        for (String string : lines.keySet()) {
//            System.out.println("NOMBRE : " + string);
//        }
//        System.out.println("----/NOMBRES---");
        HashMap<Integer, Line> actualList = lines.get(nickName);
        if (actualList != null) {
            Line actualLine;
            for (Integer nRounds : actualList.keySet()) {
                actualLine = actualList.get(nRounds);
                list.put(nRounds, (int)(actualLine.getY2() - actualLine.getY1()));
            }
            return list;
        }else{
            return null;
        }
    }
    
    public GraphicManager getGm() {
        return gm;
    }

    public int getMagOrder() {
        return gm.getMagOrderGrid();
    }

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.dutch;

import javax.swing.JLabel;
import javax.swing.JPanel;
import source.graphic.GraphicManager;
import source.svg.dao.pojo.statements.Line;

/**
 *
 * @author tarde
 */
public class PointsGraphicPanel extends JPanel{

    GraphicManager gm;
    DutchManager manager;
    
    public PointsGraphicPanel(int height, DutchManager manager) {
        this.manager = manager;
        gm = new GraphicManager(2, 2, 50, height);
        gm.setGraphicGrid(false);
        update();
        /*
        TODO - 
        quiero que el panel muestre las puntuaciones al lado del grafico:
        50 - 
        40 - 
        30 -      /\
        20 -   __/  \
        10 -  /      \_
        0  - /
        */
    }
    
    public void update(){
        gm.clear();
        gm.addLane(new Line(0, 0, 2, 2));
//        System.out.println("---UPDATE---");
//        for (String string : lines.keySet()) {
//            for (int i : lines.get(string).keySet()) {
////                System.out.println(lines.get(string).get(i));
//                gm.addLane(lines.get(string).get(i));
//            }
//        }
//        System.out.println("--/UPDATE---");
        this.removeAll();
        this.add(new JLabel(gm.getImageIcon()));
    }
}

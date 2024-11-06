/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.dutch;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import source.graphic.GraphicManager;
import source.svg.complexstatements.Grid;
import source.svg.dao.pojo.statements.Line;
import source.svg.dao.pojo.statements.Text;

/**
 *
 * @author tarde
 */
public class PointsGraphicPanel extends JPanel{

    GraphicManager gm;
    DutchManager manager;
    
    public PointsGraphicPanel(DutchManager manager) {
        this.manager = manager;
        gm = new GraphicManager(2, manager.getY(), 50, this.manager.getHeight());
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
    
    public void setXY(double x, double y){
        gm.setXY(x, y);
        gm.update();
    }
    
    public void update(){
        setXY(2, manager.getY());
        gm.setyOffSet(manager.getYOffset());
        gm.setSize(50, this.manager.getHeight());
        gm.clear();
//        gm.addLane(new Line(0, 0, 2, 2));
//        System.out.println("---UPDATE---");
//        for (String string : lines.keySet()) {
//            for (int i : lines.get(string).keySet()) {
////                System.out.println(lines.get(string).get(i));
//                gm.addLane(lines.get(string).get(i));
//            }
//        }
//        System.out.println("--/UPDATE---");
        int start = Math.ceilDiv((int)manager.getYOffset() , manager.getMagOrder());
        start *= manager.getMagOrder();
        int y = (int) manager.gp.gm.getY();
        double startAdd;
        if ((y > 0 && y < 9.5) || (y > 25 && y < 50)) {
            if (y > 0 && y < 9.5) {
                startAdd = 0.5;
            }else{
                startAdd = 2.5;
            }
            for (double i = start+startAdd; i < gm.getY(); i += manager.getMagOrder()) {
                gm.addText(new Text(
                    1,
                    i*1.015,
                    i + "",
                    Text.ALIGN_MID,
                    Text.ALIGN_MID,
                    8,
                    Color.LIGHT_GRAY
                ));
            }
        }

        for (int i = start; i < gm.getY(); i += manager.getMagOrder()) {
            gm.addText(new Text(
                1,
                i*1.015,
                i + "",
                Text.ALIGN_MID,
                Text.ALIGN_MID,
                15,
                Color.BLACK
            ));
        }

        this.removeAll();
        this.add(new JLabel(gm.getImageIcon()));
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.graphic;

import java.awt.Color;
import javax.swing.ImageIcon;
import source.svg.SVGManager;
import source.svg.complexstatements.Grid;
import source.svg.dao.pojo.statements.Line;

/**
 *
 * @author migue
 */
public class GraphicManager {
    SVGManager svgManager;

    private Grid xyGrid;
    
    private double x;
    private double y;
    
    private double xOffSet = -1;
    private double yOffSet = -3;
    
    public GraphicManager(double x, double y, int width, int height) {
        svgManager = new SVGManager(true);
        setXY(x, y);
        svgManager.setSize(width, height);
    }
    
    public void setXY(double x, double y){
        this.x = x;
        this.y = y;
        
        xyGrid = new Grid(0,0, 1000, 1000, (int)this.x, (int)this.y, Color.GRAY, 1);
        addLane(xOffSet, 0, x+xOffSet, 0, Color.BLACK);
        addLane(0, yOffSet, 0, y+yOffSet, Color.BLACK);
        svgManager.addGrid(xyGrid);
    }
    
    private double convertX(double x){
        System.out.println("x :" + x);
        double ret =  x*(1000/this.x)-xOffSet*(1000/this.x);
        System.out.println("2x:" + ret);
        return ret;
    }
    private double convertY(double y){
        System.out.println("y: " + y);
        double ret = y*(1000/this.y)-yOffSet*(1000/this.y);
        System.out.println("2y:" + ret);
        return ret;
    }
    
    public void addLane(double x1, double y1, double x2, double y2, Color color){
        svgManager.addLine(new Line(
                convertX(x1), 
                convertY(y1), 
                convertX(x2), 
                convertY(y2), 
                color, 2)
        );
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getxOffSet() {
        return xOffSet;
    }

    public double getyOffSet() {
        return yOffSet;
    }

    public void setxOffSet(double xOffSet) {
        this.xOffSet = xOffSet;
    }

    public void setyOffSet(double yOffSet) {
        this.yOffSet = yOffSet;
    }
    
    public ImageIcon getImageIcon(){
        return svgManager.getImageIcon();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.graphic;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import source.svg.SVGManager;
import source.svg.complexstatements.Grid;
import source.svg.dao.pojo.statements.Line;
import source.svg.dao.pojo.statements.SVGStatement;

/**
 *
 * @author migue
 */
public class GraphicManager {
    SVGManager svgManager;
    
    ArrayList<SVGStatement> statements;

    private Grid xyGrid;
    
    private double x;
    private double y;
    
    private double xOffSet = 0;
    private double yOffSet = 0;
    
    public GraphicManager(double x, double y, int width, int height) {
        svgManager = new SVGManager(true);
        statements = new ArrayList<>();
        
        setXY(x, y);
        
        setSize(width, height);
    }
    
    public void clear(){
        this.statements.clear();
        update();
    }
    
    public void setSize(double width, double height){
        svgManager.setSize(width, height);
    }
    
    public void setXY(double x, double y){
        this.x = x;
        this.y = y;
        
        update();
    }
    
    public void update(){
        svgManager.clear();
        
        for (SVGStatement statement : statements) {
            if (statement.getType().equalsIgnoreCase("line")) {
                printLane((Line)statement);
            }
        }
        
        addLane(new Line(xOffSet, 0, x+xOffSet, 0, Color.BLACK, 2));
        addLane(new Line(0, yOffSet, 0, y+yOffSet, Color.BLACK, 2));
        
        xyGrid = new Grid(0,0, svgManager.getWidth(), svgManager.getHeight(), (int)this.x, (int)this.y, Color.GRAY, 1);
        svgManager.addGrid(xyGrid);
    }
    
    private double convertX(double x){
//        System.out.println("x :" + x);
        double ret =  x*(this.svgManager.getWidth()/this.x)-xOffSet*(this.svgManager.getWidth()/this.x);
//        System.out.println("2x:" + ret);
        return ret;
    }
    private double convertY(double y){
//        System.out.println("y: " + y);
        double ret = y*(svgManager.getHeight()/this.y)-yOffSet*(svgManager.getHeight()/this.y);
//        System.out.println("2y:" + ret);
        return ret;
    }
    
    public void addLane(Line line){
        statements.add(line);
        printLane(line);
    }
    
    private void printLane(Line line){
        svgManager.addLine(new Line(
                convertX(line.getX1()), 
                convertY(line.getY1()), 
                convertX(line.getX2()), 
                convertY(line.getY2()), 
                line.getColor(), line.getStrokeWidth())
        );
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setXYOffSet(double xOffSet, double yOffSet){
        this.xOffSet = xOffSet;
        this.yOffSet = yOffSet;
        update();
    }
    
    public double getxOffSet() {
        return xOffSet;
    }

    public double getyOffSet() {
        return yOffSet;
    }

    public void setxOffSet(double xOffSet) {
        this.xOffSet = xOffSet;
        update();
    }

    public void setyOffSet(double yOffSet) {
        this.yOffSet = yOffSet;
        update();
    }
    
    public ImageIcon getImageIcon(){
        return svgManager.getImageIcon();
    }
    
}

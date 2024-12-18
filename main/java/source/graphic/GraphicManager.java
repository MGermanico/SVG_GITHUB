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
import source.svg.dao.pojo.statements.Text;

/**
 *
 * @author migue
 */
public class GraphicManager {
    SVGManager svgManager;
    
    ArrayList<SVGStatement> statements;

    private Grid xyGrid;
    private Grid xySecondartGrid;
    
    private boolean graphicGrid = true;
    
    private double x;
    private double y;
    
    private double xOffSet = 0;
    private double yOffSet = 0;
    
    int magOrderGrid = 1;
    
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
        magOrderGrid = 1;
        if (this.y > 25) {
            magOrderGrid = 5;
        }
        if (this.y > 150) {
            magOrderGrid = 10;
        }
        svgManager.clear();
        
        for (SVGStatement statement : statements) {
            if (statement.getType().equalsIgnoreCase("line")) {
                printLane((Line)statement);
            }
            if (statement.getType().equalsIgnoreCase("text")) {
                printText((Text)statement);
            }
        }
        
        if (graphicGrid) {
            addLane(new Line(xOffSet, 0, x+xOffSet, 0, Color.BLACK, 2));
            addLane(new Line(0, yOffSet, 0, y+yOffSet, Color.BLACK, 2));
            
            if ((this.y > 0 && this.y < 12.5) || (this.y > 25 && this.y < 80)) {
                xySecondartGrid = new Grid(0,0, svgManager.getWidth(), svgManager.getHeight(), ((int)this.x)*2, ((int)(this.y/magOrderGrid))*2, Color.LIGHT_GRAY, 1);
                svgManager.addGrid(xySecondartGrid);
            }
            
            xyGrid = new Grid(0,0, svgManager.getWidth(), svgManager.getHeight(), (int)this.x, (int)(this.y/magOrderGrid), Color.GRAY, 1);
            svgManager.addGrid(xyGrid);
            
        }
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
    
    public void addText(Text text){
        statements.add(text);
        printText(text);
    }
    
    private void printText(Text text){
        svgManager.addText(new Text(
                convertX(text.getX()),
                convertY(text.getY()),
                text.getContent(),
                text.getxAlign(),
                text.getyAlign(),
                text.getFontSize(),
                text.getColor()
            )
        );
//        svgManager.addLine(new Line(
//                convertX(line.getX1()), 
//                convertY(line.getY1()), 
//                convertX(line.getX2()), 
//                convertY(line.getY2()), 
//                line.getColor(), line.getStrokeWidth())
//        );
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

    public SVGManager getSvgManager() {
        return svgManager;
    }

    public void setGraphicGrid(boolean graphicGrid) {
        this.graphicGrid = graphicGrid;
    }

    public int getMagOrderGrid() {
        return magOrderGrid;
    }
}

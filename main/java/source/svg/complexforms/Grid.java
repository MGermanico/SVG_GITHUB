/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.svg.complexforms;

import java.awt.Color;
import java.util.ArrayList;
import source.svg.dao.pojo.forms.Line;
import source.svg.dao.pojo.forms.SVGStatement;

/**
 *
 * @author migue
 */
public class Grid {

    Color color;
    int strokeWidth;
    
    double x;
    double y;
    double xLenght;
    double yLenght;
    int numberXSeparations;
    int numberYSeparations;

    ArrayList<SVGStatement> lines;
    
    public Grid(double x, double y, double xLenght, double yLenght, int numberXSeparations, int numberYSeparations, Color color, int strokeWidth) {
        if (this.numberXSeparations == 0) {
            this.numberXSeparations = 1;
        }
        if (this.numberYSeparations == 0) {
            this.numberYSeparations = 1;
        }
        this.x = x;
        this.y = y;
        this.xLenght = xLenght;
        this.yLenght = yLenght;
        this.numberXSeparations = numberXSeparations;
        this.numberYSeparations = numberYSeparations;
        this.color = color;
        this.strokeWidth = strokeWidth;
        
        lines = new ArrayList<>();
        
        setLines();
    }
    
    public Grid(double x, double y, double xLenght, double yLenght, int numberXSeparations, int numberYSeparations) {
        this(x, y, xLenght, yLenght, numberXSeparations, numberYSeparations, Color.black, 2);
    }
    
    public ArrayList<SVGStatement> getLines(){
        System.out.println("si: " + lines);
        return this.lines;
    }
    
    private void setLines() {
        lines.clear();
        
        Line bottomLine = new Line(getCloserX(), getCloserY(), getFarX(), getCloserY(), Color.yellow, strokeWidth);
        Line topLine = new Line(getCloserX(), getFarY(), getFarX(), getFarY(), Color.RED, strokeWidth);
        Line leftLine = new Line(getCloserX(), getCloserY(), getCloserX(), getFarY(), Color.GREEN, strokeWidth);
        Line rightLine = new Line(getFarX(), getCloserY(), getFarX(), getFarY(), Color.BLUE, strokeWidth);
        
        Line actualLine;
        for (int actualYLine = 1; actualYLine < numberYSeparations; actualYLine++) {
            actualLine = new Line(
                    sout
                    bottomLine.getX1(), bottomLine.getY1()+((actualYLine/numberYSeparations)*yLenght),
                    bottomLine.getX2(), bottomLine.getY2()+((actualYLine/numberYSeparations)*yLenght)
            );
            System.out.println("-- linea - " + actualLine);
            lines.add(actualLine);
        }
        
        lines.add(bottomLine);
        lines.add(topLine);
        lines.add(leftLine);
        lines.add(rightLine);
    }
    
    private double getCloserX(){
        return x;
    }
    private double getFarX(){
        return x+xLenght;
    }
    private double getCloserY(){
        return y;
    }
    private double getFarY(){
        return y+yLenght;
    }
    
}

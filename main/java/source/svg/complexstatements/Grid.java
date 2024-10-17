/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.svg.complexstatements;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
import source.svg.dao.pojo.statements.Comment;
import source.svg.dao.pojo.statements.Line;
import source.svg.dao.pojo.statements.SVGStatement;
import source.svg.utils.SVGUtils;

/**
 *
 * @author migue
 */
public class Grid extends SVGComplexStatement{

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
        super("grid");
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
    private void setLines() {
        lines.clear();
        
        Comment startOfGrid = new Comment("startOfGrid=\"x:" + this.x + ";y:" + this.y + ""
                + ";xLenght:" + this.xLenght + ";yLenght:" + this.yLenght + ""
                + ";numberXSeparations:" + this.numberXSeparations + ""
                + ";numberYSeparations:" + this.numberYSeparations + ""
                + ";color:" + SVGUtils.javaColorToSVGRGB(this.color) + ";strokeWidth:" + this.strokeWidth + "\"");
        lines.add(startOfGrid);
        
        Line bottomLine = new Line(getCloserX(), getCloserY(), getFarX(), getCloserY(), this.color, strokeWidth);
        Line topLine = new Line(getCloserX(), getFarY(), getFarX(), getFarY(), this.color, strokeWidth);
        Line leftLine = new Line(getCloserX(), getCloserY(), getCloserX(), getFarY(), this.color, strokeWidth);
        Line rightLine = new Line(getFarX(), getCloserY(), getFarX(), getFarY(), this.color, strokeWidth);
        
        Line actualLine;
        for (int actualYLine = 1; actualYLine < numberYSeparations; actualYLine++) {
            actualLine = new Line(
                    bottomLine.getX1(), bottomLine.getY1()+((actualYLine*1.0/numberYSeparations)*yLenght),
                    bottomLine.getX2(), bottomLine.getY2()+((actualYLine*1.0/numberYSeparations)*yLenght),
                    this.color, this.strokeWidth
            );
            lines.add(actualLine);
        }
        for (int actualXLine = 1; actualXLine < numberXSeparations; actualXLine++) {
            actualLine = new Line(
                    leftLine.getX1()+((actualXLine*1.0/numberXSeparations)*xLenght), leftLine.getY1(),
                    leftLine.getX2()+((actualXLine*1.0/numberXSeparations)*xLenght), leftLine.getY2(),
                    this.color, this.strokeWidth
            );
//            System.out.println("-- linea - " + actualLine);
            lines.add(actualLine);
        }
        
        lines.add(bottomLine);
        lines.add(topLine);
        lines.add(leftLine);
        lines.add(rightLine);
        
        Comment endOfGrid = new Comment("endOfGrid");
        lines.add(endOfGrid);
    }
    
    @Override
    public String getStatement(){
        String ret = "";
        for (SVGStatement statement : lines) {
            ret += statement.getStatement() + "\n";
        }
        return ret;
    }
    
    public static SVGComplexStatement textToComplexStatement(String lane, Scanner sc){
        Color color = null;
        int strokeWidth = 0;
        double x = 0;
        double y = 0;
        double xLenght = 0;
        double yLenght = 0;
        int numberXSeparations = 0;
        int numberYSeparations = 0;
        
        lane = lane.substring(lane.indexOf("=") + 2, lane.length() - 4);
        String parts[] = lane.split(";");
        String partsOfEqual[];
        String var, val;
        for (String part : parts) {
            partsOfEqual = part.split(":");
            var = partsOfEqual[0];
            val = partsOfEqual[1];
            if (var.equals("x")) {
                x = Double.parseDouble(val);
            }
            if (var.equals("y")) {
                y = Double.parseDouble(val);
            }
            if (var.equals("xLenght")) {
                xLenght = Double.parseDouble(val);
            }
            if (var.equals("yLenght")) {
                yLenght = Double.parseDouble(val);
            }
            if (var.equals("numberXSeparations")) {
                numberXSeparations = Integer.parseInt(val);
            }
            if (var.equals("numberYSeparations")) {
                numberYSeparations = Integer.parseInt(val);
            }
            if (var.equals("strokeWidth")) {
                strokeWidth = Integer.parseInt(val);
            }
            if (var.equals("color")) {
                color = SVGUtils.svgRGBToJavaColor(val);
            }
        }
        
        Grid grid = new Grid(x, y, xLenght, yLenght, numberXSeparations, numberYSeparations, color, strokeWidth);
        while (!lane.equals("<!--endOfGrid-->")){
            lane = sc.nextLine();
        };
        return grid;
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

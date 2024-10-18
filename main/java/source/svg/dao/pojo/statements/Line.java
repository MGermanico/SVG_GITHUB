/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.svg.dao.pojo.statements;

import java.awt.Color;
import source.svg.utils.SVGUtils;

/**
 *
 * @author migue
 */
public class Line extends SVGStatement{
    
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    
    Color color;
    double strokeWidth;
    
    public Line(double x1, double y1, double x2, double y2, Color color, double strokeWidth) {
        super("line");
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.strokeWidth = strokeWidth;
    }
    public Line(double x1, double y1, double x2, double y2) {
        this(x1, y1, x2, y2, Color.black, 2);
    }
    
    public void setColor(Color color){
        this.color = color;
    }
    
    public void setStrokeWidth(double strokeWidth){
        this.strokeWidth = strokeWidth;
    }
    
    @Override
    public String getStatement(){
        String ret =  "<line x1=\"" + this.x1 + "\" "
                + "y1=\"" + this.y1 + "\" "
                + "x2=\"" + this.x2 + "\" "
                + "y2=\"" + this.y2 + "\" ";
        ret += " style=\""
                + "stroke:" + SVGUtils.javaColorToSVGRGB(this.color) + ";"
                + "stroke-width:" + this.strokeWidth + "\""
                + " />";
        return ret;
    }

    public static SVGStatement textToStatement(String text) {
        Line r = null;
        text = text.replaceAll("<line ", "");
        text = text.replaceAll(" />", "");
        text = text.replaceAll(" +", " ");
        
        String parts[] = text.split(" ");
        String partsOfEqual[];
        String var;
        String val;
        
        String styleParts[];
        
        if (parts.length >= 2) {
            r = new Line(0,0,0,0);
//            System.out.println("-->" + text);
            for (String part : parts) {
                part = part.replaceAll("\"", "");
                partsOfEqual = part.split("=");
                var = partsOfEqual[0];
                val = partsOfEqual[1];
//                System.out.println("var: " + var);
//                System.out.println("val: " + val);
                if (var.equals("x1")) {
                    r.x1 = Double.parseDouble(val);
                }
                if (var.equals("y1")) {
                    r.y1 = Double.parseDouble(val);
                }
                if (var.equals("x2")) {
                    r.x2 = Double.parseDouble(val);
                }
                if (var.equals("y2")) {
                    r.y2 = Double.parseDouble(val);
                }
                if (var.equals("style")) {
                    styleParts = val.split(";");
                    for (String stylePart : styleParts) {
                        partsOfEqual = stylePart.split(":");
                        var = partsOfEqual[0];
                        val = partsOfEqual[1];
                        if (var.equals("stroke")) {
                            r.color = SVGUtils.svgRGBToJavaColor(val);
                        }
                        if (var.equals("stroke-width")) {
                            r.setStrokeWidth(Double.parseDouble(val));
                        }
                    }
                }
            }
        }
        return r;
    }

    @Override
    public String toString() {
        return this.getStatement();
    }
    
    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public Color getColor() {
        return color;
    }

    public double getStrokeWidth() {
        return strokeWidth;
    }
    
}

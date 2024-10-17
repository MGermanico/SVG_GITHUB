/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.svg.dao.pojo.forms;

import java.awt.Color;
import source.svg.utils.SVGUtils;

/**
 *
 * @author migue
 */
public class Rect extends SVGStatement{
    double width;//	Required. The width of the rectangle
    double height;//	Required. The height of the rectangle
    double x;//	The x-position for the top-left corner of the rectangle
    double y;//	The y-position for the top-left corner of the rectangle
    double rx;//	The x radius of the corners of the rectangle (used to round the corners). Default is 0
    double ry;//	The y radius of the corners of the rectangle (used to round the corners). Default is 0
    Color color = null;//     fill color
    
    public Rect(double width, double height, double x, double y, double rx, double ry) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.rx = rx;
        this.ry = ry;
    }
    
    public Rect(double width, double height, double x, double y) {
        this(width, height, x, y, 0, 0);
    }
    public void fill(Color color){
        this.color = color;
    }
    @Override
    public String getStatement(){
        String ret =  "<rect width=\"" + this.width + "\" "
                + "height=\"" + this.height + "\" "
                + "x=\"" + this.x + "\" "
                + "y=\"" + this.y + "\" "
                + "rx=\"" + this.rx + "\" "
                + "ry=\"" + this.ry + "\" ";
        if (this.color != null) {
            ret += "fill=\"" + SVGUtils.javaColorToSVGRGB(this.color) + "\" ";
        }
        ret += "/>";
        return ret;
    }

    public static SVGStatement textToStatement(String text) {
        Rect r = null;
        
        text = text.replaceAll("<rect ", "");
        text = text.replaceAll(" />", "");
        
        String parts[] = text.split(" ");
        String partsOfEqual[];
        String var;
        String val;
        
        if (parts.length >= 2) {
            r = new Rect(0, 0, 0, 0);
            for (String part : parts) {
                part = part.replaceAll("\"", "");
                partsOfEqual = part.split("=");
                var = partsOfEqual[0];
                val = partsOfEqual[1];
                if (var.equals("width")) {
                    r.width = Double.parseDouble(val);
                }
                if (var.equals("height")) {
                    r.height = Double.parseDouble(val);
                }
                if (var.equals("x")) {
                    r.x = Double.parseDouble(val);
                }
                if (var.equals("y")) {
                    r.y = Double.parseDouble(val);
                }
                if (var.equals("rx")) {
                    r.rx = Double.parseDouble(val);
                }
                if (var.equals("ry")) {
                    r.ry = Double.parseDouble(val);
                }
                if (var.equals("fill")) {
                    r.color = SVGUtils.svgRGBToJavaColor(val);
                }
            }
        }
        return r;
    }
    
}

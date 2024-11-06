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
public class Text extends SVGStatement{

    public static final int ALIGN_MID = 0;
    public static final int Y_ALIGN_TOP = 1;
    public static final int Y_ALIGN_BOT = 2;
    public static final int X_ALIGN_LEFT = 1;
    public static final int X_ALIGN_RIGHT = 2;
    
    private int xAlign = X_ALIGN_RIGHT;
    private int yAlign = Y_ALIGN_TOP;
    
    private double x;
    private double y;
    
    private String content;
    
    private int fontSize = 0;
    
    private Color color = Color.BLACK;
    
    public Text(double x, double y, String content, int xAlign, int yAlign, int fontSize, Color color) {
        super("text");
        this.x = x;
        this.y = y;
        this.content = content;
        this.xAlign = xAlign;
        this.yAlign = yAlign;
        this.fontSize = fontSize;
        this.color = color;
    }

    @Override
    public String getStatement() {
        //<text x="5" y="30" fill="none" stroke="red" font-size="35">I love SVG!</text>
        String textAnchor;
        String baseLine;
        if (xAlign == X_ALIGN_LEFT) {
            textAnchor = "start";
        }else if (xAlign == X_ALIGN_RIGHT) {
            textAnchor = "end";
        }else{
            textAnchor = "middle";
        }
        
        if (xAlign == Y_ALIGN_TOP) {
            baseLine = "text-after-edge";
        }else if (xAlign == Y_ALIGN_BOT) {
            baseLine = "text-before-edge";
        }else{
            baseLine = "middle";
        }
        
        return "<text text-anchor=\"" + textAnchor + "\" "
                + "dominant-baseline=\"" + baseLine + "\" "
                + "x=\"" + this.x + "\" "
                + "y=\"" + -this.y + "\" "
                + "fill=\"" + SVGUtils.javaColorToSVGRGB(this.color) + "\" "
                + "stroke=\"" + SVGUtils.javaColorToSVGRGB(this.color) + "\" "
                + "font-size=\"" + this.fontSize + "\" "
                + "transform=\"scale(1, -1)\" >"
                + this.content 
                + "</text>";
    }
    
    public static SVGStatement textToStatement(String text) {
        Line r = null;
        System.out.println("A VER: " + text);
        text = text.replaceAll("<text ", "");
        text = text.replaceAll("", "");
        text = text.replaceAll(" />", "");
        text = text.replaceAll(" +", " ");
        
        String parts[] = text.split(" ");
        String partsOfEqual[];
        String var;
        String val;
        
        String styleParts[];
        
//        if (parts.length >= 2) {
//            r = new Line(0,0,0,0);
////            System.out.println("-->" + text);
//            for (String part : parts) {
//                part = part.replaceAll("\"", "");
//                partsOfEqual = part.split("=");
//                var = partsOfEqual[0];
//                val = partsOfEqual[1];
////                System.out.println("var: " + var);
////                System.out.println("val: " + val);
//                if (var.equals("x1")) {
//                    r.x1 = Double.parseDouble(val);
//                }
//                if (var.equals("y1")) {
//                    r.y1 = Double.parseDouble(val);
//                }
//                if (var.equals("x2")) {
//                    r.x2 = Double.parseDouble(val);
//                }
//                if (var.equals("y2")) {
//                    r.y2 = Double.parseDouble(val);
//                }
//                if (var.equals("style")) {
//                    styleParts = val.split(";");
//                    for (String stylePart : styleParts) {
//                        partsOfEqual = stylePart.split(":");
//                        var = partsOfEqual[0];
//                        val = partsOfEqual[1];
//                        if (var.equals("stroke")) {
//                            r.color = SVGUtils.svgRGBToJavaColor(val);
//                        }
//                        if (var.equals("stroke-width")) {
//                            r.setStrokeWidth(Double.parseDouble(val));
//                        }
//                    }
//                }
//            }
//        }
        return r;
    }

    @Override
    public String toString() {
        return this.getStatement();
    }
    
    public void setXYAlign(int xAlign, int yAlign){
        this.xAlign = xAlign;
        this.yAlign = yAlign;
    }
    
    public void setxAlign(int xAlign) {
        this.xAlign = xAlign;
    }

    public void setyAlign(int yAlign) {
        this.yAlign = yAlign;
    }

    public String getContent() {
        return content;
    }

    public int getFontSize() {
        return fontSize;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getxAlign() {
        return xAlign;
    }

    public int getyAlign() {
        return yAlign;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}

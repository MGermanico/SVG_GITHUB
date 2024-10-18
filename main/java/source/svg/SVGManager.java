/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.svg;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import source.svg.complexstatements.Grid;
import source.svg.complexstatements.SVGComplexStatement;
import source.svg.dao.implementations.SVGImplementation;
import source.svg.dao.pojo.SVGObject;
import source.svg.dao.pojo.statements.Line;
import source.svg.dao.pojo.statements.Rect;
import source.svg.dao.pojo.statements.SVGStatement;
import source.svg.data.config.SVGConfiguration;
import source.svg.utils.SVGUtils;

/**
 *
 * @author migue
 */
public class SVGManager {
    private int width = 1000;
    private int height = 1000;
    
    private static SVGImplementation svgImpl = new SVGImplementation();
    private SVGObject svg;
    
    public SVGManager(boolean rewrite) {
        if (!rewrite) {
            svg = svgImpl.getSVGFile();
        }else{
            svg = new SVGObject();
        }
    }
    
    public ImageIcon getImageIcon(){
        ImageIcon ii = SVGUtils.convertSVGToImageIcon(SVGConfiguration.SVG_PATH, width, height);
        Image image = ii.getImage();
        AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
        tx.translate(0, -image.getHeight(null));
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        image = op.filter(SVGUtils.ImageToBufferedImage(image), null);
        ii = new ImageIcon(image);
        return ii;
    }
    public void setSize(double width, double height){
        setScale(width/this.width,height/this.height);
        this.width = (int) width;
        this.height = (int) height;
    }
    public void setScale(double xScale, double yScale){
        svg.setXScale(xScale);
        svg.setYScale(yScale);
        svgImpl.setSVGFile(svg);
    }
    public void setXScale(double xScale){
        svg.setXScale(xScale);
        svgImpl.setSVGFile(svg);
    }
    public void setYScale(double yScale){
        svg.setYScale(yScale);
        svgImpl.setSVGFile(svg);
    }
    
    public void clear(){
        svg = new SVGObject();
        svgImpl.setSVGFile(svg);
    }
    
    public void addLine(Line line){
        svg.addStatement(line);
        svgImpl.setSVGFile(svg);
    }
    
    public void addRect(Rect rect){
        svg.addStatement(rect);
        svgImpl.setSVGFile(svg);
    }
    
    public void addStatements(List<SVGStatement> statements){
        for (SVGStatement statement : statements) {
            svg.addStatement(statement);
        }
        svgImpl.setSVGFile(svg);
    }
    
    public void addGrid(Grid grid){
        svg.addStatement(grid);
        svgImpl.setSVGFile(svg);
    }
    
    public void printStatements(){
        System.out.println("\t--\tNORMAL STATEMENTS:");
        ArrayList<SVGStatement> statements = svg.getStatements();
        for (SVGStatement statement : statements) {
            System.out.println(statement.getStatement());
        }
        
        System.out.println("\t--\tCOMPLEX STATEMENTS:");
        ArrayList<SVGComplexStatement> complexStatements = svg.getComplexStatements();
        for (SVGComplexStatement complexStatement : complexStatements) {
            System.out.println(complexStatement.getType());
        }
        
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    
    
}

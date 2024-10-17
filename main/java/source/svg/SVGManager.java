/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.svg;

import java.util.ArrayList;
import java.util.List;
import source.svg.complexstatements.Grid;
import source.svg.complexstatements.SVGComplexStatement;
import source.svg.dao.implementations.SVGImplementation;
import source.svg.dao.pojo.SVGObject;
import source.svg.dao.pojo.statements.Line;
import source.svg.dao.pojo.statements.Rect;
import source.svg.dao.pojo.statements.SVGStatement;

/**
 *
 * @author migue
 */
public class SVGManager {
    
    private static SVGImplementation svgImpl = new SVGImplementation();
    private SVGObject svg;
    
    public SVGManager(boolean rewrite) {
        if (!rewrite) {
            svg = svgImpl.getSVGFile();
        }else{
            svg = new SVGObject();
        }
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
}

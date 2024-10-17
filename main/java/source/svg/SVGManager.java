/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.svg;

import java.util.List;
import source.svg.complexforms.Grid;
import source.svg.dao.implementations.SVGImplementation;
import source.svg.dao.pojo.SVGObject;
import source.svg.dao.pojo.forms.Line;
import source.svg.dao.pojo.forms.Rect;
import source.svg.dao.pojo.forms.SVGStatement;

/**
 *
 * @author migue
 */
public class SVGManager {
    
    private static SVGImplementation svgImpl = new SVGImplementation();
    private SVGObject svg;
    
    public SVGManager() {
        svg = svgImpl.getSVGFile();
    }

    public void clear(){
        svg.getStatements().clear();
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
        System.out.println("si");
        svg.addStatements(grid.getLines());
        svgImpl.setSVGFile(svg);
    }
}

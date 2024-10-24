/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.svg.dao.implementations;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import source.svg.complexstatements.Grid;
import source.svg.complexstatements.SVGComplexStatement;
import source.svg.dao.interfaces.SVGInterface;
import source.svg.dao.pojo.SVGObject;
import source.svg.dao.pojo.statements.Line;
import source.svg.dao.pojo.statements.Rect;
import source.svg.dao.pojo.statements.SVGStatement;
import source.svg.data.config.SVGConfiguration;

/**
 *
 * @author migue
 */
public class SVGImplementation implements SVGInterface{

    @Override
    public SVGObject getSVGFile() {
        SVGObject svg = null;
        File f = new File(SVGConfiguration.SVG_PATH);
        try(Scanner sc = new Scanner(f)){
            String lane = sc.nextLine();
            if (lane.equals("<svg xmlns=\"http://www.w3.org/2000/svg\">")) {
                svg = new SVGObject();
                do{
                    lane = sc.nextLine();
                    if (!lane.equals("</svg>")) {
                        if (lane.contains("<!--")) {
                            addComplexStatement(sc, svg, lane);
                        }else{
                            addStatement(svg, lane);
                        }
                    }
                }while(!lane.equals("</svg>"));
            };
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SVGImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return svg;
    }
    
    private void addStatement(SVGObject svg, String lane){
        SVGStatement statement = null;
        if (lane.contains("<rect")) {
            statement = Rect.textToStatement(lane);
        }
        if (lane.contains("<line")) {
            statement = Line.textToStatement(lane);
        }
        svg.addStatement(statement);
    }
    
    @Override
    public boolean setSVGFile(SVGObject svg) {
        File f = new File(SVGConfiguration.SVG_PATH);
        try(FileWriter fw = new FileWriter(f,false)){
            fw.write(svg.toSVG());
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    private void addComplexStatement(Scanner sc, SVGObject svg, String lane) {
        SVGComplexStatement cmplxStatement = null;
        if (lane.contains("<!--startOfGrid")) {
            cmplxStatement = Grid.textToComplexStatement(lane, sc);
        }
        svg.addStatement(cmplxStatement);
    }
    
}

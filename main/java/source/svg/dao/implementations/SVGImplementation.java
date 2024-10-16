/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.svg.dao.implementations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import source.svg.dao.interfaces.SVGInterface;
import source.svg.dao.pojo.SVGFile;
import source.svg.dao.pojo.dependencies.Rect;
import source.svg.dao.pojo.dependencies.SVGStatement;
import source.svg.data.config.SVGConfiguration;

/**
 *
 * @author migue
 */
public class SVGImplementation implements SVGInterface{

    @Override
    public SVGFile getSVGFile() {
        SVGFile svg = null;
        File f = new File(SVGConfiguration.SVG_PATH);
        try(Scanner sc = new Scanner(f)){
            String lane = sc.nextLine();
            if (lane.equals("<svg xmlns=\"http://www.w3.org/2000/svg\">")) {
                svg = new SVGFile();
                do{
                    lane = sc.nextLine();
                    if (!lane.equals("</svg>")) {
                        addStatement(svg, lane);
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
    
    private void addStatement(SVGFile svg, String lane){
        SVGStatement statement = null;
        if (lane.contains("<rect")) {
            statement = Rect.textToStatement(lane);
        }
        svg.addStatement(statement);
    }

    @Override
    public boolean setSVGFile(SVGFile svgFile) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

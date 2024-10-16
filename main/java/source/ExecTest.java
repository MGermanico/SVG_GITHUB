/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

import source.svg.dao.implementations.SVGImplementation;
import source.svg.dao.pojo.SVGFile;
import source.svg.dao.pojo.dependencies.Rect;
import source.svg.data.config.SVGConfiguration;

/**
 *
 * @author migue
 */
public class ExecTest {
    public static void main(String[] args) {
        SVGFile svg;
//        svg = new SVGFile();
//        Rect r = new Rect(200, 200, 1, 1);
//        r.fill("black");
//        svg.addStatement(r);
        
        SVGImplementation svgImpl = new SVGImplementation();
        svg = svgImpl.getSVGFile();
        System.out.println(svg.toSVG());
        ShowSVGImage mi = new ShowSVGImage(SVGConfiguration.SVG_PATH, 400,400);
    }
}

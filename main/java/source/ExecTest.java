/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

import java.awt.Color;
import java.util.ArrayList;
import source.svg.SVGManager;
import source.svg.complexstatements.Grid;
import source.svg.dao.implementations.SVGImplementation;
import source.svg.dao.pojo.SVGObject;
import source.svg.dao.pojo.statements.Line;
import source.svg.dao.pojo.statements.Rect;
import source.svg.dao.pojo.statements.SVGStatement;
import source.svg.data.config.SVGConfiguration;

/**
 *
 * @author migue
 */
public class ExecTest {
    public static void main(String[] args) {
        SVGManager manager = new SVGManager(true);
//        manager.clear();
        Grid grid = new Grid(0, 0, 400, 400, 100, 100, Color.BLUE, 1);
        Grid grid2 = new Grid(0, 0, 400, 400, 10, 10, Color.RED, 1);
        manager.addGrid(grid);
        manager.addGrid(grid2);
        manager.printStatements();
        ShowSVGImage mi = new ShowSVGImage(SVGConfiguration.SVG_PATH, 400,400);
    }
}

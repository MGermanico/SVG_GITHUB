/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

import java.awt.Color;
import java.util.ArrayList;
import source.svg.SVGManager;
import source.svg.complexforms.Grid;
import source.svg.dao.implementations.SVGImplementation;
import source.svg.dao.pojo.SVGObject;
import source.svg.dao.pojo.forms.Line;
import source.svg.dao.pojo.forms.Rect;
import source.svg.dao.pojo.forms.SVGStatement;
import source.svg.data.config.SVGConfiguration;

/**
 *
 * @author migue
 */
public class ExecTest {
    public static void main(String[] args) {
        SVGManager manager = new SVGManager();
        Grid grid = new Grid(10, 20, 100, 200, 3, 3);
        manager.addGrid(grid);
        ShowSVGImage mi = new ShowSVGImage(SVGConfiguration.SVG_PATH, 400,400);
    }
}

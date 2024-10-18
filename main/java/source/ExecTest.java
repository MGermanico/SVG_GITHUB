/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

import java.awt.Color;
import java.util.ArrayList;
import source.graphic.GraphicManager;
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
        GraphicManager gm = new GraphicManager(10, 10, 900, 500);
        gm.addLane(0, 0, 2, 2, Color.RED);
        ShowSVGImage mi = new ShowSVGImage(gm.getImageIcon());
    }
}
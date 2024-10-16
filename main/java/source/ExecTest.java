/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

import java.awt.Color;
import java.util.ArrayList;
import source.svg.SVGManager;
import source.svg.dao.implementations.SVGImplementation;
import source.svg.dao.pojo.SVGObject;
import source.svg.dao.pojo.dependencies.Line;
import source.svg.dao.pojo.dependencies.Rect;
import source.svg.dao.pojo.dependencies.SVGStatement;
import source.svg.data.config.SVGConfiguration;

/**
 *
 * @author migue
 */
public class ExecTest {
    public static void main(String[] args) {
        SVGManager manager = new SVGManager();
        ShowSVGImage mi = new ShowSVGImage(SVGConfiguration.SVG_PATH, 400,400);
    }
}

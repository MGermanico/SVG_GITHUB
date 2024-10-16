/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.svg.dao.interfaces;

import source.svg.dao.pojo.SVGObject;

/**
 *
 * @author migue
 */
public interface SVGInterface {
    public SVGObject getSVGFile();
    
    public boolean setSVGFile(SVGObject svgFile);
}

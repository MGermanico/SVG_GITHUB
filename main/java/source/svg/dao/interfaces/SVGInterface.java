/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.svg.dao.interfaces;

import source.svg.dao.pojo.SVGFile;

/**
 *
 * @author migue
 */
public interface SVGInterface {
    public SVGFile getSVGFile();
    
    public boolean setSVGFile(SVGFile svgFile);
}

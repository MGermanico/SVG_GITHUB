/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import source.svg.utils.SVGUtils;

/**
 *
 * @author migue
 */
public class ShowSVGImage extends JFrame{
    public ShowSVGImage(ImageIcon ii) {
        this.setVisible(true);
        JLabel img = new JLabel(ii);
        this.add(img);
        this.pack();
    }
}

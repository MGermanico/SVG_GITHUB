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
    public ShowSVGImage(String path, int width, int height) {
        this.setVisible(true);
        ImageIcon ii = SVGUtils.convertSVGToImageIcon(path, width, height);
        Image image = ii.getImage();
        AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
        tx.translate(0, -image.getHeight(null));
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        image = op.filter(SVGUtils.ImageToBufferedImage(image), null);
        ii = new ImageIcon(image);
        JLabel img = new JLabel(ii);
        this.add(img);
        this.pack();
    }
}

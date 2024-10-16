/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

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
        JLabel img = new JLabel(ii);
        this.add(img);
        this.pack();
    }
}

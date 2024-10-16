/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.svg.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.image.ImageTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;

/**
 *
 * @author migue
 */
public class SVGUtils {
    public static ImageIcon convertSVGToImageIcon(String svgFilePath, int width, int height) {
        try {
            // Cargar el archivo SVG usando InputStream
            InputStream inputStream = new FileInputStream(svgFilePath);
            TranscoderInput input = new TranscoderInput(inputStream);

            // Usar el BufferedImageTranscoder para convertir el SVG a imagen
            BufferedImageTranscoder transcoder = new BufferedImageTranscoder();
            transcoder.addTranscodingHint(ImageTranscoder.KEY_WIDTH, (float) width);
            transcoder.addTranscodingHint(ImageTranscoder.KEY_HEIGHT, (float) height);

            // Transcodificar sin especificar un TranscoderOutput (ya que no escribimos en un archivo)
            transcoder.transcode(input, null);

            // Obtener el BufferedImage resultante
            BufferedImage image = transcoder.getBufferedImage();

            // Convertir el BufferedImage a ImageIcon
            return new ImageIcon(image);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

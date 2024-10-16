/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.svg.data.config;

import java.io.File;
import java.util.Scanner;

/**
 *
 *  Contains the necessary data to do the Connection
 * 
 */
public abstract class SVGConfiguration {
    static{
        String state = "";
        
        File connectionFile = new File("SVGConfiguration.txt");
        if (!connectionFile.exists()) {
            state = "'SVGConfiguration.txt' missing";
        }else{
            try(Scanner sc = new Scanner(connectionFile)){
                if (!sc.hasNextLine()) {
                    state = "'SVGConfiguration.txt' is empty";
                }else{
                    SVG_PATH = sc.nextLine();
                }
            }catch(Exception ex){
                ex.printStackTrace();
                state = "exception: " + ex.getMessage();
            }
        }
        if (!state.isEmpty()) {
            SVG_PATH = null;
            (new Exception(state)).printStackTrace();
        }
    }
    public static String SVG_PATH;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.utils;

/**
 *
 * @author migue
 */
public abstract class MathUtils {
    public static int distance(int a, int b){
        return (int)Math.abs(a - b);
    }
    
    public static double distance(double a, double b){
        return Math.abs(a - b);
    }
}

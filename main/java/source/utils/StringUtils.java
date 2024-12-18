/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.utils;

/**
 *
 * @author tarde
 */
public abstract class StringUtils {
    public static String setLong(String str, int nLetters, boolean priorizeWrite){
        if (str == null) {
            return setLong("null", nLetters, priorizeWrite);
        }
        int resto = nLetters - str.length();
        if (resto < 0) {
            str = str.substring(0, nLetters);
            if (priorizeWrite) {
                for (int i = 0; i < 3; i++) {
                    try{
                        str = changeChar(str, '.', nLetters - i);
                    }catch(IndexOutOfBoundsException ex){
                    }
                }
            }else{
                str = changeChar(str, '+', nLetters);
            }
        }else if(resto != 0){
            for (int i = 0; i < resto; i++) {
                str += " ";
            }
        }
        return str;
    }
    public static String changeChar(String str, char c, int pos){
        if (pos > str.length()) {
            return str;
        }
        String part1 = str.substring(0, pos - 1);
        String part2 = str.substring(pos);
        return part1 + c + part2;
    }
    
    public static boolean onlyNumbers(String str){
        if (str.isEmpty()) {
            return false;
        }
        str.replaceAll(" ", "");
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                if (str.charAt(i) != '-') {
                    return false;
                }else{
                    if(i >= str.length() - 1) return false;
                }
            }
        }
        return true;
    }
}

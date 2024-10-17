/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.svg.dao.pojo;

import java.util.ArrayList;
import source.svg.dao.pojo.forms.SVGStatement;

/**
 *
 * @author migue
 */
public class SVGFile {
    private static final String SVG_XMLNS_TAG = "<svg xmlns=\"http://www.w3.org/2000/svg\">";

    private ArrayList<SVGStatement> statements;
    
    public SVGFile() {  
        statements = new ArrayList<>();
    }
    
    

    public ArrayList<SVGStatement> getStatements() {
        return statements;
    }
    public void addStatement(SVGStatement statement){
        if (statement != null) {
            statements.add(statement);
        }
    }
    public void setStatements(ArrayList<SVGStatement> statements) {
        this.statements = statements;
    }
    
    public String toSVG(){
        String svgString;
        svgString = SVGFile.SVG_XMLNS_TAG + "\n";
        for (SVGStatement statement : statements) {
            svgString += statement.getStatement() + "\n";
        }
        svgString += "</svg>";
        return svgString;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.svg.dao.pojo;

import java.util.ArrayList;
import source.svg.complexstatements.SVGComplexStatement;
import source.svg.dao.pojo.statements.SVGStatement;

/**
 *
 * @author migue
 */
public class SVGObject {
    private static final String SVG_XMLNS_TAG = "<svg xmlns=\"http://www.w3.org/2000/svg\">";

    private ArrayList<SVGStatement> statements;
    private ArrayList<SVGComplexStatement> complexStatements;
    
    public SVGObject() {  
        statements = new ArrayList<>();
        complexStatements = new ArrayList<>();
    }
    
    
    public ArrayList<SVGComplexStatement> getComplexStatements(){
        return complexStatements;
    }
    public void addStatement(SVGComplexStatement complexStatement){
        if (complexStatements != null) {
            this.complexStatements.add(complexStatement);
        }
    }
    public void setComplexStatements(ArrayList<SVGComplexStatement> complexStatements){
        this.complexStatements = complexStatements;
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
    public void addStatements(ArrayList<SVGStatement> statements){
        for (SVGStatement statement : statements) {
            addStatement(statement);
        }
    }
    public String toSVG(){
        String svgString;
        svgString = SVGObject.SVG_XMLNS_TAG + "\n";
        for (SVGComplexStatement complexStatement : complexStatements) {
            svgString += complexStatement.getStatement();
        }
        for (SVGStatement statement : statements) {
            svgString += statement.getStatement() + "\n";
        }
        svgString += "</svg>";
        return svgString;
    }
}

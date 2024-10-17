/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.svg.dao.pojo.statements;

/**
 *
 * @author migue
 */
public class SVGStatement {
    String type;

    public SVGStatement(String type) {
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public String getStatement(){
        throw new UnsupportedOperationException();
    }
}

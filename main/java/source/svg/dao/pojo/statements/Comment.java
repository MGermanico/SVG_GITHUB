/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.svg.dao.pojo.statements;

import source.svg.utils.SVGUtils;

/**
 *
 * @author tarde
 */
public class Comment extends SVGStatement{
    String text;

    public Comment(String text) {
        super("comment");
        this.text = text;
    }
    
    @Override
    public String getStatement(){
        String ret = "<!--"
                + this.text
                + "-->";
        return ret;
    }
}

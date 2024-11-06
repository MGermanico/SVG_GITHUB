/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.dutch;

import source.gui.DutchWindow;

/**
 *
 * @author tarde
 */
public class ControlPanelManager {

    DutchWindow parent;
    ControlPanel cp;
    
    public ControlPanelManager(DutchWindow parent) {
        this.parent = parent;
        cp = new ControlPanel(this);
        
    }

    public ControlPanel getCp() {
        return cp;
    }

    public void setGraphicSize(int widht, int height){
        parent.dutchManager.setSize(widht,height);
    }
    
    public int getGraphicWidth(){
        return parent.dutchManager.getWidth();
    }
    
    public int getGraphicHeight(){
        return parent.dutchManager.getHeight();
    }
    
    public void setGraphicXYSize(int x, int y){
        parent.dutchManager.setXY(x, y);
    }
    
    public double getGraphicX(){
        return parent.dutchManager.getX();
    }
    
    public double getGraphicY(){
        return parent.dutchManager.getY();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.dutch;

import java.awt.Dimension;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

/**
 *
 * @author tarde
 */
public class ControlPanel extends JPanel{

    ControlPanelManager manager;
    
    Box listOfOptions;
    JPanel back;
    
    JPanel graphicSizeChanger;
    JSpinner graphicWSizeSpinner;
    JSpinner graphicHSizeSpinner;
    
    JButton confirmButton;
    
    public ControlPanel(ControlPanelManager manager) {
        this.manager = manager;
        initPanel();
        setUp();
    }

    private void initPanel() {
        back = new JPanel();
        listOfOptions = Box.createVerticalBox();
        graphicSizeChanger = new JPanel();
        graphicWSizeSpinner = new JSpinner();
        graphicHSizeSpinner = new JSpinner();
        confirmButton = new JButton();
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmChanges();
            }
        });
        this.add(back);
    }
    
    private void setUp(){
        back.removeAll();
        listOfOptions.add(new JLabel("--- Tamaños ---"));
        setGraphicSizeChanger();
        listOfOptions.add(graphicSizeChanger);
        listOfOptions.add(confirmButton);
        back.add(listOfOptions);
    }

    private void setGraphicSizeChanger() {
        graphicSizeChanger.removeAll();
        Box tBox1 = Box.createVerticalBox();
        Box tBox11 = Box.createHorizontalBox();
        Box tBox12 = Box.createHorizontalBox();
        graphicSizeChanger.add(new JLabel("Gráfica: "));
        graphicWSizeSpinner.setSize(new Dimension(50, 20));
        graphicWSizeSpinner.setPreferredSize(new Dimension(50, 20));
        graphicHSizeSpinner.setSize(new Dimension(50, 20));
        graphicHSizeSpinner.setPreferredSize(new Dimension(50, 20));
        graphicWSizeSpinner.setValue(1);
        graphicHSizeSpinner.setValue(2);
        tBox11.add(new JLabel("Ancho:  "));
        tBox11.add(graphicWSizeSpinner);
        tBox12.add(new JLabel("Alto:     "));
        tBox12.add(graphicHSizeSpinner);
        tBox1.add(tBox11);
        tBox1.add(tBox12);
        graphicSizeChanger.add(tBox1);
    }
    
    public void confirmChanges(){
        --//TODO -- Aplicar buton
        manager.setGraphicSize(this.graphicWSizeSpinner, graphicHSizeSpinner);
    }
}

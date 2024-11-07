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
    
    JPanel gridSizeChanger;
    JSpinner gridHSizeSpinner;
    
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
        
        gridSizeChanger = new JPanel();
        gridHSizeSpinner = new JSpinner();
        
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
        setGridSizeChanger();
        listOfOptions.add(gridSizeChanger);
        listOfOptions.add(confirmButton);
        back.add(listOfOptions);
    }
    
    private void setGridSizeChanger(){
        gridSizeChanger.removeAll();
        Box tBox1 = Box.createVerticalBox();
        Box tBox11 = Box.createHorizontalBox();
        gridSizeChanger.add(new JLabel("Tabla: "));
        
        gridHSizeSpinner.setSize(new Dimension(50, 20));
        gridHSizeSpinner.setPreferredSize(new Dimension(50, 20));
        gridHSizeSpinner.setValue(manager.parent.tableManager.getHeightTP());
        
        tBox11.add(new JLabel("Ancho:  "));
        tBox11.add(gridHSizeSpinner);
        JButton add50buttonW = new JButton("+50");
        add50buttonW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gridHSizeSpinner.setValue((int)gridHSizeSpinner.getValue() + 50);
                confirmChanges();
            }
        });
        tBox11.add(add50buttonW);
        JButton minus50buttonW = new JButton("-50");
        minus50buttonW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gridHSizeSpinner.setValue((int)gridHSizeSpinner.getValue() - 50);
                confirmChanges();
            }
        });
        tBox11.add(minus50buttonW);
        tBox1.add(tBox11);
        gridSizeChanger.add(tBox1);
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
        graphicWSizeSpinner.setValue(manager.getGraphicWidth());
        graphicHSizeSpinner.setValue(manager.getGraphicHeight());
        tBox11.add(new JLabel("Ancho:  "));
        tBox11.add(graphicWSizeSpinner);
        JButton add50buttonW = new JButton("+50");
        add50buttonW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphicWSizeSpinner.setValue((int)graphicWSizeSpinner.getValue() + 50);
                confirmChanges();
            }
        });
        tBox11.add(add50buttonW);
        JButton minus50buttonW = new JButton("-50");
        minus50buttonW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphicWSizeSpinner.setValue((int)graphicWSizeSpinner.getValue() - 50);
                confirmChanges();
            }
        });
        tBox11.add(minus50buttonW);
        tBox12.add(new JLabel("Alto:     "));
        tBox12.add(graphicHSizeSpinner);
        JButton add50buttonH = new JButton("+50");
        add50buttonH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphicHSizeSpinner.setValue((int)graphicHSizeSpinner.getValue() + 50);
                confirmChanges();
            }
        });
        tBox12.add(add50buttonH);
        JButton minus50buttonH = new JButton("-50");
        minus50buttonH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphicHSizeSpinner.setValue((int)graphicHSizeSpinner.getValue() - 50);
                confirmChanges();
            }
        });
        tBox12.add(minus50buttonH);
        tBox1.add(tBox11);
        tBox1.add(tBox12);
        graphicSizeChanger.add(tBox1);
    }
    
    public void confirmChanges(){
        //TODO -- Aplicar buton
        manager.setGraphicSize((int)graphicWSizeSpinner.getValue(), (int)graphicHSizeSpinner.getValue());
        manager.parent.tableManager.setHeightTP((int)gridHSizeSpinner.getValue());
        manager.update();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.gui.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import source.utils.StringUtils;

/**
 *
 * @author migue
 */
public class ButtonAction implements ActionListener {

    JButton actualButton;
    TableCell tableCell;
    
    public ButtonAction(TableCell tableCell, JButton actualButton) {
        this.actualButton = actualButton;
        this.tableCell = tableCell;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String res = JOptionPane.showInputDialog("Puntos:");
        if (StringUtils.onlyNumbers(res)) {
            actualButton.setText(res);
            tableCell.value = Integer.parseInt(res);
        }
    }

}

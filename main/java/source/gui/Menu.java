/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author migue
 */
public class Menu extends JPanel{

    JPanel verticalBox = new JPanel(new GridLayout(3, 1, 15, 15));
    PrincipalFrame owner;
    JButton newGameButton;
    
    public Menu(PrincipalFrame owner) {
        this.owner = owner;
        this.setLayout(new GridBagLayout());
        initStartButton();
        this.add(verticalBox);
    }

    private void initStartButton() {
        newGameButton = new JButton("Nueva Partida");
        newGameButton.setBackground(Color.WHITE);
        newGameButton.setPreferredSize(new Dimension(300, 100));
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGameAction();
            }
        });
        verticalBox.add(newGameButton);
    }
    
    public void newGameAction(){
        owner.setUp(PrincipalFrame.GETPLAYERS_SETUP);
    }
}

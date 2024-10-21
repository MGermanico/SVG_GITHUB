/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.gui.optionsWindow;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import source.gui.PrincipalFrame;

/**
 *
 * @author migue
 */
public class GetPlayers extends JPanel{

    private PrincipalFrame owner;
    private JPanel back = new JPanel(new GridLayout(1, 2));
    private JPanel leftSide = new JPanel(new GridLayout(3, 1));
    private AddPlayersPanel addPlayersPanel;
    
    public GetPlayers(PrincipalFrame owner) {
        this.owner = owner;
        setUp();
    }
    
    private void setUp() {
        initLeftSide();
        initLayout();
        this.setVisible(true);
    }
    
    private void initLayout() {
        back.add(leftSide);
        this.add(back);
    }

    private void initLeftSide() {
        JLabel addPlayersLabel = new JLabel("Añadir Jugadores");
        leftSide.add(addPlayersLabel);
        addPlayersPanel = new AddPlayersPanel(this);
        leftSide.add(addPlayersPanel);
        initOkButton();
    }

    public PrincipalFrame getOwner() {
        return owner;
    }

    private void initOkButton() {
        JButton okButton = new JButton("Aceptar");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acceptAction();
            }
        });
        leftSide.add(okButton);
    }
    
    private void acceptAction(){
        owner.setUp(addPlayersPanel.getPlayers());
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import source.bbdd.dao.pojo.Jugador;
import source.dutch.ControlPanel;
import source.dutch.ControlPanelManager;
import source.dutch.DutchManager;
import source.gui.table.TableCell;
import source.gui.table.TableManager;
import source.gui.table.TablePanel;
import source.utils.MathUtils;

/**
 *
 * @author migue
 */
public class DutchWindow extends JPanel {

    private PrincipalFrame owner;
    public ArrayList<Jugador> players;
    JPanel back;
    Box leftSide;
    Box graphicsSide;
    Box rightSide;
    public DutchManager dutchManager;
    public TableManager tableManager;
    public ControlPanelManager controlPanelManager;

    public DutchWindow(PrincipalFrame owner, ArrayList<Jugador> players) {
        this.owner = owner;

        this.players = players;

        initComponents();

        initBack();

        this.setVisible(true);
        
        this.updateGP();
    }

    private void initComponents() {
        back = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        leftSide = Box.createVerticalBox();
        rightSide = Box.createVerticalBox();
        graphicsSide = Box.createHorizontalBox();

        dutchManager = new DutchManager(players, 15);
        tableManager = new TableManager(15, this);
        controlPanelManager = new ControlPanelManager(this);
    }

    private void initBack() {
        leftSide.add(new JLabel("PARTIDA"));
        graphicsSide.add(Box.createHorizontalGlue());
        graphicsSide.add(dutchManager.getPGP());
        graphicsSide.add(dutchManager.getGP());
        graphicsSide.add(Box.createHorizontalGlue());
        leftSide.add(graphicsSide);
        
        TablePanel tp = tableManager.getTP();
        JScrollPane scrollPane = new JScrollPane(tp, 
                                                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(tp.getPreferredSize().width, tableManager.getHeightTP()));
        leftSide.add(scrollPane);
        
        back.add(leftSide);
        rightSide.add(controlPanelManager.getCp());
        
        back.add(Box.createHorizontalGlue());
        
        back.add(rightSide);
        this.add(back);
    }

    public void updateGP() {
        //        System.out.println("actualizarGP");
        Map<Jugador, ArrayList<TableCell>> gameTable = tableManager.getTP().getGameTable();
        HashMap<Integer, Integer> realActualValues;
        Integer realActualValue;
        for (Jugador jugador : gameTable.keySet()) {
            realActualValues = dutchManager.getPointsByName(jugador.getName());
            for (TableCell tableCell : gameTable.get(jugador)) {
                if (realActualValues != null) {
                    realActualValue = realActualValues.get(tableCell.getnGame());
//                    System.out.println("RAV: " + realActualValue + "    || tablecell: " + tableCell.getValue());
                    if ((realActualValue == null) || (realActualValue != tableCell.getValue())) {
                        if (tableCell.getValue() != -66) {
//                            System.out.println("--cambiar (" + jugador.getName() + ":" + tableCell.getnGame() + ")");
                            dutchManager.putPoints(jugador, tableCell.getnGame(), tableCell.getValue());
                        }
                    }
                }else if (tableCell.getValue() != -66) {
                    dutchManager.putPoints(jugador, tableCell.getnGame(), tableCell.getValue());
                }
            }
        }
//        System.out.println("max: " + this.tableManager.getMaxPoints());
//        System.out.println("min: " + this.tableManager.getMinPoints());

        dutchManager.getGP().getGm().setyOffSet(tableManager.getMinPoints() - 1);
        dutchManager.setXY(tableManager.getActualRound(), 1 + MathUtils.distance(tableManager.getMaxPoints(), tableManager.getMinPoints()));

        updateComponents();
    }

    public void updateComponents() {
//        System.out.println("actualizarComps");
        back.removeAll();
        leftSide.removeAll();
        graphicsSide.removeAll();
        rightSide.removeAll();
        leftSide.add(new JLabel("PARTIDA"));
        graphicsSide.add(dutchManager.getPGP());
        graphicsSide.add(dutchManager.getGP());
        leftSide.add(graphicsSide);
        
        TablePanel tp = tableManager.getTP();
        JScrollPane scrollPane = new JScrollPane(tp, 
                                                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(tp.getPreferredSize().width, tableManager.getHeightTP()));
        leftSide.add(scrollPane);
        
        back.add(leftSide);
        rightSide.add(controlPanelManager.getCp());
        back.add(rightSide);
        this.revalidate();
        this.repaint();
    }

    public PrincipalFrame getOwner() {
        return owner;
    }
    
}

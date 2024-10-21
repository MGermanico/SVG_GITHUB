/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.bbdd.biz;

import source.bbdd.dao.implementation.JugadorDAOImpl;
import source.bbdd.dao.pojo.Jugador;
import source.bbdd.dao.variables.Nickname;
import exceptions.InvalidFormatException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migue
 */
public class DataBaseManager {
    public ArrayList<Jugador> getJugadoresToList() throws SQLException, Exception{
        JugadorDAOImpl jdi = new JugadorDAOImpl();
        ArrayList<Jugador> jugadores = jdi.getJugadores();
        return jugadores;
    }
    public Jugador getJugadorByName(String str) throws SQLException, Exception{
        System.out.println("si");
        JugadorDAOImpl jdi = new JugadorDAOImpl();
        Jugador jugador = null;
        try {
            jugador = jdi.getJugadorByWId(new Nickname(str));
        } catch (InvalidFormatException ex) {
            ex.printStackTrace();
        }
        return jugador;
    }
}

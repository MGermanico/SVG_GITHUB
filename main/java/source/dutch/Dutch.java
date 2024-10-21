/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.dutch;

import java.util.ArrayList;
import java.util.HashMap;
import source.bbdd.dao.pojo.Jugador;
import source.bbdd.dao.pojo.PartidaIndividual;
import source.bbdd.dao.pojo.Partida;
import source.graphic.GraphicManager;

/**
 *
 * @author migue
 */
public class Dutch {
    HashMap<String, HashMap<Integer, PartidaIndividual>> jugadores;
    GraphicPanel gp;
    int nGames;

    public Dutch(GraphicPanel gp, ArrayList<Jugador> jugadores, int nGames) {
        this.gp = gp;
        this.nGames = nGames;
        this.jugadores = new HashMap<>();
        initDutch(jugadores);
    }

    private void initDutch(ArrayList<Jugador> jugadores) {
        PartidaIndividual partidaActual;
        HashMap<Integer, PartidaIndividual> partidas;
        for (Jugador jugador : jugadores) {
            partidas = new HashMap<>();
            this.jugadores.put(jugador.getName(), partidas);
        }
    }
    public int getPoints(Jugador jugador, int n){
        HashMap<Integer, PartidaIndividual> partidas = jugadores.get(jugador.getName());
        PartidaIndividual partidaAct;
        int points = 0;
        for (Integer i : partidas.keySet()) {
            if (i > n) {
                break;
            }
            partidaAct = partidas.get(i);
            if (partidaAct != null) {
                points += partidaAct.getPoints();
            }
        }
        return points;
    }
    public void addPoints(int points, Jugador jugador){
        HashMap<Integer, PartidaIndividual> mapIndiv = jugadores.get(jugador.getName());
        if (mapIndiv == null) {
            mapIndiv = new HashMap<>();
        }
        PartidaIndividual partidaActual = new PartidaIndividual(jugadores.size(), jugador.getNickname());
        partidaActual.setPoints(points);
        int actualN = mapIndiv.size()+1;
        mapIndiv.put(actualN, partidaActual);
    }
    public void putPoints(int points, Jugador jugador, int nGame){
        HashMap<Integer, PartidaIndividual> mapIndiv = jugadores.get(jugador.getName());
        if (mapIndiv == null) {
            mapIndiv = new HashMap<>();
        }
        PartidaIndividual partidaActual = new PartidaIndividual(jugadores.size(), jugador.getNickname());
        partidaActual.setPoints(points);
        mapIndiv.put(nGame, partidaActual);
    }
}

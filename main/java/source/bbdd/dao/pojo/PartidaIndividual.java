/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.bbdd.dao.pojo;

import source.bbdd.dao.variables.Nickname;
import exceptions.InvalidFormatException;
import source.utils.StringUtils;

/**
 *
 * @author tarde
 */
public class PartidaIndividual {
    private int IdPartida;
    private int points;
    private Nickname nickname;

    public PartidaIndividual(int IdPartida, Nickname nickname) {
        this.IdPartida = IdPartida;
        this.nickname = nickname;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
    
    public int getIdPartida() {
        return IdPartida;
    }

    public void setIdPartida(int IdPartida) {
        this.IdPartida = IdPartida;
    }

    public Nickname getNickname() {
        return nickname;
    }

    public void setNickname(Nickname nickname)  {
        this.nickname = nickname;
    }
    
    @Override
    public String toString(){
        return ":PartidaIndiv: " + 
                StringUtils.setLong(this.IdPartida+"", 4, true) + " , " + 
                StringUtils.setLong(this.nickname.toString(), 4, true);
    }
}

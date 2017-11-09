package model;

import java.util.ArrayList;
import java.util.UUID;

import nof.airsoft.RegistroEquipeActivity;

/**
 * Created by Dalmiro Junior on 05/10/2017.
 */

public class Equipe{
    private String equipeId;
    private String equipeNome;
    private String equipeLiderId;
    public static ArrayList<Usuario> jogadores;

    public Equipe(String equipeId, String equipeNome, String equipeLiderId) {
        super();
        this.equipeId = equipeId;
        this.equipeNome = equipeNome;
        this.equipeLiderId = equipeLiderId;
    }

    public String getEquipeId() {
        return equipeId;
    }

    public void setEquipeId(String equipeId) {
        this.equipeId = equipeId;
    }

    public String getEquipeNome() {
        return equipeNome;
    }

    public void setEquipeNome(String equipeNome) {
        this.equipeNome = equipeNome;
    }

    public String getEquipeLiderId() {
        return equipeLiderId;
    }

    public void setEquipeLiderId(String equipeLiderId) {
        this.equipeLiderId = equipeLiderId;
    }

    public void adicionaJogador(Usuario usuario){
        this.jogadores.add(usuario);
    }

    public void removerJogador(Usuario usuario){
        this.jogadores.remove(usuario);
    }


}
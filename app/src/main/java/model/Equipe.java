package model;

import java.util.UUID;

import nof.airsoft.RegistroEquipeActivity;

/**
 * Created by Dalmiro Junior on 05/10/2017.
 */

public class Equipe {
    private String nome;
    private String id;
    private String idDoLider;

    public Equipe(String nome) {
        this.nome = nome;
        this.id = UUID.randomUUID().toString();
        this.idDoLider = Usuario.class.getName();
    }

    public String getNome(String nome) {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
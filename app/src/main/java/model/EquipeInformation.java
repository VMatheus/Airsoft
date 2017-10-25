package model;

import com.google.firebase.database.DatabaseReference;

import java.util.UUID;

import nof.airsoft.RegistroEquipeActivity;

/**
 * Created by Dalmiro Junior on 05/10/2017. lixo
 */

public class EquipeInformation {
    private String nome;
    private String id;
   // private String idDoLider;

    public EquipeInformation(String nome) {
        this.nome = nome;
        this.id = UUID.randomUUID().toString();
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

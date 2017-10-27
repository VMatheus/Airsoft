package model;

import java.util.UUID;

/**
 * Created by Dalmiro Junior on 28/09/2017.
 */

public class Usuario{
    private String id;
    private String nome;
    private String contato;
    private String idDaEquipe;
    private String endereco;


    public Usuario(String nome, String contato, String endereco) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.contato = contato;
        this.endereco = endereco;

    }

    public Usuario() {

    }
    public String getId() {
        return id;
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getIdDaEquipe() {
        return idDaEquipe;
   }

    public void setIdDaEquipe(String idDaEquipe) {
        this.idDaEquipe = idDaEquipe;
    }

}


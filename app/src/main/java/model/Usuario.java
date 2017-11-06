package model;

import java.util.UUID;

/**
 * Created by Dalmiro Junior on 28/09/2017.
 */

public class Usuario{
    public static String usuarioId;
    private String usuarioNome;
    private String usuarioContato;
    private String usuarioEndereco;


    public Usuario(String nome, String contato, String endereco) {
        this.usuarioId = UUID.randomUUID().toString();
        this.usuarioNome = nome;
        this.usuarioContato = contato;
        this.usuarioEndereco = endereco;

    }

    public Usuario() {

    }

    public static String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getUsuarioContato() {
        return usuarioContato;
    }

    public void setUsuarioContato(String usuarioContato) {
        this.usuarioContato = usuarioContato;
    }

    public String getUsuarioEndereco() {
        return usuarioEndereco;
    }

    public void setUsuarioEndereco(String usuarioEndereco) {
        this.usuarioEndereco = usuarioEndereco;
    }
}


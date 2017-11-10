package model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Stream;

import static model.Equipe.jogadores;

/**
 * Created by Dalmiro Junior on 28/09/2017.
 */

public class Usuario implements Serializable {
    public String usuarioNome;
    private String usuarioContato;
    private String usuarioEndereco;


    public Usuario(String nome, String contato, String endereco) {
        this.usuarioNome = nome;
        this.usuarioContato = contato;
        this.usuarioEndereco = endereco;

    }

    public Usuario() {

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

//
//    @Override
//    public Stream<Usuario> stream() {
//        return null;
//    }
}
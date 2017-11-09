package model;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Stream;

import static model.Equipe.jogadores;

/**
 * Created by Dalmiro Junior on 28/09/2017.
 */

public class Usuario extends ArrayList<Usuario> {
    public static String usuarioId;
    public static String usuarioNome;
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

    public static boolean verificaJogador(Usuario u) {
        for (int i = 0; i < jogadores.size(); i++) {
            if (jogadores.get(i).getUsuarioNome().equals(u.getUsuarioNome())) {
                return true;
            } else {
                return false;
            }
        }


        return false;
    }

    @Override
    public Stream<Usuario> stream() {
        return null;
    }
}
package nof.airsoft;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import com.google.firebase.auth.FirebaseUser;

import java.io.StringReader;
import java.util.Map;
import java.util.Set;

import model.Usuario;



public class SharedPreferencesUser {

    //ATRIBUTOS
    private Context contexto;
    private SharedPreferences preferencias;
    private final String NOME_ARQUIVO = "STUDYNG.PREFERENCES";
    private final int MODE = 0;
    private SharedPreferences.Editor editor;

    private final String CHAVE_IDENTIFICADOR = "id";
    private final String CHAVE_NOME = "nome";
    private final String CHAVE_NOMEJOG = "nomeJog";
    private final String CHAVE_CONTATO = "contato";
    private final String CHAVE_ENDERECO = "endereco";

    public SharedPreferencesUser(Context contextoParametro) {
        contexto = contextoParametro;
        preferencias = contexto.getSharedPreferences(NOME_ARQUIVO, MODE);
        editor = preferencias.edit();
    }

    //SALVANDO USUARIOS
    public void salvarUsuarioPreferences(String ident, String nome, String contato, String endereco) {
        editor.putString(CHAVE_IDENTIFICADOR, ident);
        editor.putString(CHAVE_NOME, nome);
        editor.putString(CHAVE_CONTATO, contato);
        editor.putString(CHAVE_ENDERECO, endereco);
        editor.apply();
    }

    //RECUPERANDO
    public String getIdentificador() {
        return preferencias.getString(CHAVE_IDENTIFICADOR, "");
    }
    public String getUsuarioNome() {
        return preferencias.getString(CHAVE_NOME, "");
    }
    public String getUsuarioNomeJog() {
        return preferencias.getString(CHAVE_NOMEJOG, "");
    }
    public String getUsuarioContato() {
        return preferencias.getString(CHAVE_CONTATO, "");
    }
    public String getUsuarioEndereco() {
        return preferencias.getString(CHAVE_ENDERECO, "");
    }

    public boolean possuiEquipe() {
        return getUsuarioNomeJog().contains(getUsuarioNome());
    }
}
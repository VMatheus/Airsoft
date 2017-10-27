package nof.airsoft;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by rickc on 27/10/2017.
 */

public class SharedPreferencesUser {

    //ATRIBUTOS
    private Context contexto;
    private SharedPreferences preferencias;
    private final String NOME_ARQUIVO = "STUDYNG.PREFERENCES";
    private final int MODE = 0;
    private SharedPreferences.Editor editor;

    private final String CHAVE_IDENTIFICADOR = "id";
    private final String CHAVE_NOME = "nome";

    public SharedPreferencesUser(Context contextoParametro) {
        contexto = contextoParametro;
        preferencias = contexto.getSharedPreferences(NOME_ARQUIVO, MODE);
        editor = preferencias.edit();
    }

    //SALVANDO E RECUPERANDO USUARIOS
    public void salvarUsuarioPreferences(String ident, String nome) {
        editor.putString(CHAVE_IDENTIFICADOR, ident);
        editor.putString(CHAVE_NOME, nome);
        editor.commit();
    }

    //RECUPERANDO
    public String getIdentificador() {
        return preferencias.getString(CHAVE_IDENTIFICADOR, null);
    }

    public String getUsuarioNome() {
        return preferencias.getString(CHAVE_NOME, null);
    }

}
package nof.airsoft;

import com.google.firebase.database.DatabaseReference;

/**
 * Created by Dalmiro Junior on 05/10/2017.
 */

public class EquipeInformation extends RegistroEquipeActivity {
    private String nome;
    private String id;

    public EquipeInformation(String nome, String id) {
        this.nome = nome;
        this.id = id;
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

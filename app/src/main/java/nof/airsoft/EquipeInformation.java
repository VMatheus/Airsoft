package nof.airsoft;

/**
 * Created by Dalmiro Junior on 05/10/2017.
 */

public class EquipeInformation {
    String nome;
    String endereco;
    String contato;

    public EquipeInformation(String nome, String endereco, String contato) {
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
    }

    public EquipeInformation(String nome) {
        this.nome = nome;

    }

    public String getNome(String nome) {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco(EquipeInformation endereco) {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}

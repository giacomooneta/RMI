package shared;

import java.io.Serializable;

public class Contatto implements Serializable {
    String nome, numt;

    public Contatto(String nome, String numt) {
        this.nome = nome;
        this.numt = numt;
    }

    public String getNome() {
        return nome;
    }

    public String getNum() {
        return numt;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNum(String numt) {
        this.numt = numt;
    }
}

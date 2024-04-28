package Entidades;

public class Loja {

    private final String nomeLoja;
    private final Conta cLoja;

    public Loja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
        this.cLoja = new Conta(nomeLoja, 0);
    }

    public Conta getContaLoja() {
        return cLoja;
    }

    public String getNome() {
        return nomeLoja;
    }
}

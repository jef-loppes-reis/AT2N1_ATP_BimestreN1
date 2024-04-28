package Entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListaNomesClie {
    private List<String> nomes;
    private Random random;

    public ListaNomesClie() {
        this.nomes = new ArrayList<>();
        this.random = new Random();
    }

    public void adicionarNomeCli(String nome) {
        nomes.add(nome);
    }

    public List<String> getNomes() {
        return nomes;
    }

    public String getNomeAleatorioCli() {
        if (nomes.isEmpty()) {
            return null;
        }
        int indiceAleatorio = random.nextInt(nomes.size());
        return nomes.get(indiceAleatorio);
    }
}

package Entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListaNomesFunc {
    private List<String> nomes;
    private Random random;

    public ListaNomesFunc() {
        this.nomes = new ArrayList<>();
        this.random = new Random();
    }

    public void adicionarNomeFunc(String nome) {
        nomes.add(nome);
    }

    public List<String> getNomes() {
        return nomes;
    }

    public String getNomeAleatorioFunc() {
        if (nomes.isEmpty()) {
            return null;
        }
        int indiceAleatorio = random.nextInt(nomes.size());
        return nomes.get(indiceAleatorio);
    }
}


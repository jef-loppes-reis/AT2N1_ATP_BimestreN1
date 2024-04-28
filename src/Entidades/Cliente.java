package Entidades;

import java.util.Random;

public class Cliente extends Thread {

    private String nome;
    private Conta contaCliente;
    private Loja[] lojas;
    private Loja ultimaLojaEscolhida;
    private Banco banco;

    public Cliente(String nome, Loja[] lojas, Banco banco) {
        this.nome = nome;
        this.contaCliente = new Conta(nome, 1000);
        this.lojas = lojas;
        this.banco = banco;
    }

    public void run() {

        Random random = new Random();

        while (contaCliente.getSaldo() > 0) {

            double valorCompra = random.nextDouble() < 0.5 ? 100.0 : 200.0;
            Loja primeiraLojaEscolhida;

            do {
                int indiceLoja = random.nextInt(lojas.length);
                primeiraLojaEscolhida = lojas[indiceLoja];
            } while (primeiraLojaEscolhida == ultimaLojaEscolhida);
            ultimaLojaEscolhida = primeiraLojaEscolhida;

            synchronized (this) {
                banco.transferir(contaCliente, ultimaLojaEscolhida.getContaLoja(), valorCompra);
                // Print para representar as Threads
                System.out.println(getThreadName() + " - " + contaCliente.getNome() + " efetuou uma compra de R$ "
                        + valorCompra + " na loja " + ultimaLojaEscolhida.getNome() + "\nSaldo atual do(a) " + nome + "e de R$ "
                        + getContaCliente().getSaldo() + "\n");
            }
        }
    }

    public Conta getContaCliente() {
        return contaCliente;
    }

    private static String getThreadName() {
        return Thread.currentThread().getName();
    }

    public String getNome() {
        return nome;
    }
}

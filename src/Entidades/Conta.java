package Entidades;

public class Conta {

    private final String nome;
    private double saldo;

    public Conta(String nome, double saldoInicial) {

        this.nome = nome;
        this.saldo = saldoInicial;

    }

    public double getSaldo() {
        return saldo;
    }

    public synchronized void debitar(double valor) {
        saldo -= valor;
    }

    public synchronized void creditar(double valor) {
        saldo += valor;
    }

    public String getNome() {
        return nome;
    }
}

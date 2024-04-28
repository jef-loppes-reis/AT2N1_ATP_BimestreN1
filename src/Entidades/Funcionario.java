package Entidades;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Funcionario extends Thread {

    private String nomeFuncionario;
    private Loja loja;
    private Conta contaSalario;
    private Conta contaInvestimento;
    private Banco banco;
    private final Lock lock = new ReentrantLock();

    public Funcionario(String nomeFuncionario, Loja loja, Banco banco) {

        this.nomeFuncionario = nomeFuncionario;
        this.loja = loja;
        this.contaSalario = new Conta(nomeFuncionario + " - Salário", 0);
        this.contaInvestimento = new Conta(nomeFuncionario + " - Investimento", 0);
        this.banco = banco;

    }

    @Override
    public void run() {

        receberSalario();
        contaSalContaInv();

    }

    private void receberSalario() {

        double salario = 1400.0;
        lock.lock();

        try {
            synchronized (loja) { 
                if (loja.getContaLoja().getSaldo() >= salario) {
                    banco.transferir(loja.getContaLoja(), getContaSalario(), salario);
                    System.out.println("A loja " + loja.getNome() + " pagou o(a) funcionario(a) " + nomeFuncionario
                        + "\nSaldo da conta de(a) " + nomeFuncionario + " antes do ivestimento era de " + getContaSalario().getSaldo());
                } else {
                    System.out.println("\nA loja" + loja.getNome() + " não teve o saldo suficiente para pagar o(a) " + getNome()
                        + "\nO saldo atual da loja " + loja.getNome() + " e de R$ " + loja.getContaLoja().getSaldo() + "\n");
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void contaSalContaInv() {
        lock.lock();
        try {
            double valorInvestimento = getContaSalario().getSaldo() * 0.2; 
            if (valorInvestimento == 0) {
                System.out.println("O(a) funcionario(a) " + nomeFuncionario + " nao conseguiu investir.");
            } else {
                banco.transferir(contaSalario, contaInvestimento, valorInvestimento);
                System.out.println("\nO(a) funcionario(a) " + nomeFuncionario + " investiu R$ " + valorInvestimento
                        + "\nSaldo atualizado do funcionario(a) " + nomeFuncionario
                        + "\n    -> Conta de investimento, valor de R$ " + getContaInvestimento().getSaldo()
                        + "\n    -> Conta do salario, valor de R$ " + getContaSalario().getSaldo());
            }
        } finally {
            lock.unlock();
        }
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public Conta getContaInvestimento() {
        return contaInvestimento;
    }

    public String getNome() {
        return nomeFuncionario;
    }
}
import Entidades.*;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

        System.out.println("\n******************************************");
        System.out.println("**             Sistema Bancario           **");
        System.out.println("********************************************\n");
        Banco banco = new Banco();

        Loja loja1 = new Loja("[RENNER-BR]");
        Loja loja2 = new Loja("[PUMA-BR]");

        // lojas disponiveis
        Loja[] lojasDisponiveis = { loja1, loja2 };

        //*********** Funcionarios */
        // Lista de nomes aleatorios, para funcionarios.
        ListaNomesFunc listaNomeFuncionarios = new ListaNomesFunc();
        listaNomeFuncionarios.adicionarNomeFunc("Ana Silva");
        listaNomeFuncionarios.adicionarNomeFunc("Pedro Santos");
        listaNomeFuncionarios.adicionarNomeFunc("Juliana Costa");
        listaNomeFuncionarios.adicionarNomeFunc("Gabriel Oliveira");
        listaNomeFuncionarios.adicionarNomeFunc("Laura Pereira");
        listaNomeFuncionarios.adicionarNomeFunc("Rafaela Martins");
        listaNomeFuncionarios.adicionarNomeFunc("João Carvalho");
        listaNomeFuncionarios.adicionarNomeFunc("Beatriz Ferreira");
        listaNomeFuncionarios.adicionarNomeFunc("Thiago Almeida");
        listaNomeFuncionarios.adicionarNomeFunc("Mariana Rocha");

        // Atribuicoes dos funcionarios, pegando um nome aleatorio da lista de nomes.
        Funcionario func1 = new Funcionario(listaNomeFuncionarios.getNomeAleatorioFunc(), loja1, banco);
        Funcionario func2 = new Funcionario(listaNomeFuncionarios.getNomeAleatorioFunc(), loja1, banco);
        Funcionario func3 = new Funcionario(listaNomeFuncionarios.getNomeAleatorioFunc(), loja2, banco);
        Funcionario func4 = new Funcionario(listaNomeFuncionarios.getNomeAleatorioFunc(), loja2, banco);

        // lista de funcionarios da loja1
        List<Funcionario> listaFuncLoja1 = new ArrayList<>();
        listaFuncLoja1.add(func1);
        listaFuncLoja1.add(func2);

        // lista de funcionarios da loja2
        List<Funcionario> listaFuncLoja2 = new ArrayList<>();
        listaFuncLoja2.add(func3);
        listaFuncLoja2.add(func4);

        //*********** Clientes */
        ListaNomesClie listaNomeClientes = new ListaNomesClie();
        listaNomeClientes.adicionarNomeCli("Sofia Martinez");
        listaNomeClientes.adicionarNomeCli("Lucas Johnson");
        listaNomeClientes.adicionarNomeCli("Isabella Thompson");
        listaNomeClientes.adicionarNomeCli("Mateo Rodrigues");
        listaNomeClientes.adicionarNomeCli("Emily Chen");
        listaNomeClientes.adicionarNomeCli("Daniel Khan");
        listaNomeClientes.adicionarNomeCli("Olivia Wright");
        listaNomeClientes.adicionarNomeCli("Ethan Nguyen");
        listaNomeClientes.adicionarNomeCli("Mia Garcia");
        listaNomeClientes.adicionarNomeCli("Alexander Smith");

        // instânciando os clientes e dando start nas threads
        Cliente cliente1 = new Cliente(listaNomeClientes.getNomeAleatorioCli(), lojasDisponiveis, banco);
        Cliente cliente2 = new Cliente(listaNomeClientes.getNomeAleatorioCli(), lojasDisponiveis, banco);
        Cliente cliente3 = new Cliente(listaNomeClientes.getNomeAleatorioCli(), lojasDisponiveis, banco);
        Cliente cliente4 = new Cliente(listaNomeClientes.getNomeAleatorioCli(), lojasDisponiveis, banco);
        Cliente cliente5 = new Cliente(listaNomeClientes.getNomeAleatorioCli(), lojasDisponiveis, banco);
        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();

        try {
            cliente1.join();
            cliente2.join();
            cliente3.join();
            cliente4.join();
            cliente5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n******************************************" +
            "Relatorio de pagamentos das lojas aos funcionario / e os investimentos." + 
            "  ******************************************\n");

        func1.start();
        func2.start();
        func3.start();
        func4.start();

        try {
            func1.join();
            func2.join();
            func3.join();
            func4.join();
        } catch (InterruptedException error) {
            error.printStackTrace();
        }

        System.out.println("\n****************************************** " + 
            "Relatorio de saldo finais de cada conta." +
            " ******************************************\n");

        System.out.println("Conta dos clientes:");
        System.out.println("-> " + cliente1.getNome() + ": " + cliente1.getContaCliente().getSaldo());
        System.out.println("-> " + cliente2.getNome() + ": " + cliente2.getContaCliente().getSaldo());
        System.out.println("-> " + cliente3.getNome() + ": " + cliente3.getContaCliente().getSaldo());
        System.out.println("-> " + cliente4.getNome() + ": " + cliente4.getContaCliente().getSaldo());
        System.out.println("-> " + cliente5.getNome() + ": " + cliente5.getContaCliente().getSaldo());
        System.out.println();

        System.out.println("Conta das Lojas:");
        System.out.println("-> " + loja1.getNome() + ": R$" + loja1.getContaLoja().getSaldo());
        System.out.println("-> " + loja2.getNome() + ": R$" + loja2.getContaLoja().getSaldo());

        System.out.println("\nConta dos Funcionários que trabalham na loja " + loja1);

        // Saldos dos funcionarios por loja.
        for (Funcionario funcionario : listaFuncLoja1) {
            System.out.println("\nFuncionario(a) " + funcionario.getNome() + ":");
            System.out.println("    -> Conta salário, saldo R$ " + funcionario.getContaSalario().getSaldo());
            System.out.println("    -> Conta investimento, saldo R$ " + funcionario.getContaInvestimento().getSaldo());
        }

        System.out.println("\nConta dos Funcionários que trabalham na loja " + loja2);
    
        for (Funcionario funcionario : listaFuncLoja2) {
            System.out.println("\nFuncionario(a) " + funcionario.getNome() + ":");
            System.out.println("    -> Conta salário, saldo R$ " + funcionario.getContaSalario().getSaldo());
            System.out.println("    -> Conta investimento, saldo R$ " + funcionario.getContaInvestimento().getSaldo());
        }

    }
}

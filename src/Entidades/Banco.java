package Entidades;

public class Banco {

    public synchronized void transferir(Conta origem, Conta destino, double valor) {
        // Validacao saldo conta bancaria.
        if (origem.getSaldo() >= valor) {
            origem.debitar(valor);
            destino.creditar(valor);
        } else {
            System.out.println("Tentativa de transferencia no valor de " + valor + "invalida.\n"
                + "Saldo insuficiente na conta " + origem.getNome());
        }

        // Metodo sleep de 0.5 sec, para executar a proxima thread.
        try {
            Thread.sleep(50);
        } catch (InterruptedException error) {
            error.printStackTrace();
        }
    }
}

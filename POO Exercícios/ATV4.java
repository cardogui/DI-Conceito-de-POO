import java.util.HashMap;
import java.util.Map;

class Cliente {
    String nome;
    String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
}

class ContaBancaria {
    String numeroConta;
    Cliente cliente;
    double saldo;

    public ContaBancaria(String numeroConta, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.saldo = 0;
    }

    public void depositar(double valor) {
        if (valor > 0) saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(ContaBancaria destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }
}

class Banco {
    Map<String, Cliente> clientes = new HashMap<>();
    Map<String, ContaBancaria> contas = new HashMap<>();

    public void cadastrarCliente(String nome, String cpf) {
        clientes.put(cpf, new Cliente(nome, cpf));
    }

    public void abrirConta(String numeroConta, String cpf) {
        Cliente cliente = clientes.get(cpf);
        if (cliente != null) {
            contas.put(numeroConta, new ContaBancaria(numeroConta, cliente));
        }
    }

    public void depositar(String numeroConta, double valor) {
        ContaBancaria conta = contas.get(numeroConta);
        if (conta != null) conta.depositar(valor);
    }

    public boolean sacar(String numeroConta, double valor) {
        ContaBancaria conta = contas.get(numeroConta);
        return conta != null && conta.sacar(valor);
    }

    public boolean transferir(String numeroContaOrigem, String numeroContaDestino, double valor) {
        ContaBancaria origem = contas.get(numeroContaOrigem);
        ContaBancaria destino = contas.get(numeroContaDestino);
        return origem != null && destino != null && origem.transferir(destino, valor);
    }
}

public class ATV4 { 
    public static void main(String[] args) {
        Banco banco = new Banco();

        banco.cadastrarCliente("João Silva", "123.456.789-00");
        banco.abrirConta("001", "123.456.789-00");
        banco.abrirConta("002", "123.456.789-00"); 

        banco.depositar("001", 1000);
        banco.sacar("001", 200);
        banco.transferir("001", "002", 300);

      
        ContaBancaria conta001 = banco.contas.get("001");
        ContaBancaria conta002 = banco.contas.get("002");
        if (conta001 != null) {
            System.out.println("Saldo da conta 001: " + conta001.saldo);
        }
        if (conta002 != null) {
            System.out.println("Saldo da conta 002: " + conta002.saldo);
        }
    }
}

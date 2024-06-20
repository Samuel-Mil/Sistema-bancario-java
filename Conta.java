import java.util.ArrayList;

public class Conta {
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;
    private double saldo;
    private ArrayList<Transacao> transacoes;

    // Construtor
    public Conta(String cpf, String nome, String endereco, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.saldo = 0.0;
        this.transacoes = new ArrayList<>();
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getSaldo() {
        return saldo;
    }

    // Métodos para operações bancárias
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            transacoes.add(new Transacao("Depósito", valor));
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Valor de depósito inválido!");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            transacoes.add(new Transacao("Saque", valor));
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente!");
        }
    }

    public void transferir(Conta destino, double valor) {
        if (valor > 0 && valor <= saldo) {
            this.saldo -= valor;
            destino.depositar(valor);
            transacoes.add(new Transacao("Transferência para " + destino.getCpf(), valor));
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Valor de transferência inválido ou saldo insuficiente!");
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }

    public void encerrarConta() {
        if (saldo == 0) {
            System.out.println("Conta encerrada com sucesso!");
            // Aqui poderíamos remover a conta do sistema se tivéssemos um banco de dados ou uma lista de contas.
        } else {
            System.out.println("A conta não pode ser encerrada. Saldo deve ser zero.");
        }
    }

    public void exibirExtrato() {
        System.out.println("Extrato da conta de " + nome);
        for (Transacao transacao : transacoes) {
            System.out.println(transacao);
        }
    }
}

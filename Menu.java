import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<Conta> contas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.exibirMenu();
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\nSistema Bancário");
            System.out.println("1. Criar Conta");
            System.out.println("2. Saque");
            System.out.println("3. Depósito");
            System.out.println("4. Transferência");
            System.out.println("5. Consultar Saldo");
            System.out.println("6. Exibir Extrato");
            System.out.println("7. Encerrar Conta");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    realizarSaque();
                    break;
                case 3:
                    realizarDeposito();
                    break;
                case 4:
                    realizarTransferencia();
                    break;
                case 5:
                    consultarSaldo();
                    break;
                case 6:
                    exibirExtrato();
                    break;
                case 7:
                    encerrarConta();
                    break;
                case 8:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 8);
        
    }

    private void criarConta() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        
        Conta conta = new Conta(cpf, nome, endereco, telefone);
        contas.add(conta);
        
        System.out.println("Conta criada com sucesso!");
    }

    private Conta buscarConta(String cpf) {
        for (Conta conta : contas) {
            if (conta.getCpf().equals(cpf)) {
                return conta;
            }
        }
        return null;
    }

    private void realizarSaque() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        Conta conta = buscarConta(cpf);
        if (conta != null) {
            System.out.print("Valor do saque: ");
            double valor = scanner.nextDouble();
            conta.sacar(valor);
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    private void realizarDeposito() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        Conta conta = buscarConta(cpf);
        if (conta != null) {
            System.out.print("Valor do depósito: ");
            double valor = scanner.nextDouble();
            conta.depositar(valor);
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    private void realizarTransferencia() {
        System.out.print("CPF da conta origem: ");
        String cpfOrigem = scanner.nextLine();
        Conta contaOrigem = buscarConta(cpfOrigem);
        if (contaOrigem != null) {
            System.out.print("CPF da conta destino: ");
            String cpfDestino = scanner.nextLine();
            Conta contaDestino = buscarConta(cpfDestino);
            if (contaDestino != null) {
                System.out.print("Valor da transferência: ");
                double valor = scanner.nextDouble();
                contaOrigem.transferir(contaDestino, valor);
            } else {
                System.out.println("Conta destino não encontrada!");
            }
        } else {
            System.out.println("Conta origem não encontrada!");
        }
    }

    private void consultarSaldo() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        Conta conta = buscarConta(cpf);
        if (conta != null) {
            conta.consultarSaldo();
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    private void exibirExtrato() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        Conta conta = buscarConta(cpf);
        if (conta != null) {
            conta.exibirExtrato();
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    private void encerrarConta() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        Conta conta = buscarConta(cpf);
        if (conta != null) {
            conta.encerrarConta();
            if (conta.getSaldo() == 0) {
                contas.remove(conta);
            }
        } else {
            System.out.println("Conta não encontrada!");
        }
    }
}

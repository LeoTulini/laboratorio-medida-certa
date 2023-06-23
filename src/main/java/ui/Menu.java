package ui;

import main.Sistema;
import negocio.Pessoa;
import serviços.CalculadoraIMC;
import serviços.CalculadoraPesoIdeal;
import serviços.CalculadoraTaxaGordura;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);
    private static Sistema sistema = new Sistema();
    private static int codigoPessoa;
    private static Pessoa pessoa;

    public static void main(String[] args) throws InterruptedException {
        sistema.carregarDadosDoArquivo("dados.txt");

        boolean sair = false;

        while(!sair) {
            try {
                int opcao = exibirMenu(scanner);

                switch (opcao) {
                    case 1:
                        inserirPessoa();
                        break;
                    case 2:
                        editarPessoa();
                        break;
                    case 3:
                        calcularImc();
                        break;
                    case 4:
                        calcularPesoIdeal();
                        break;
                    case 5:
                        calcularTaxaDeGorduraCorporal();
                        break;
                    case 6:
                        sistema.listarPessoas();
                        Thread.sleep(1000);
                        break;
                    case 7:
                        sistema.salvarDadosEmArquivo("dados.txt");
                        System.out.println("Saindo do sistema...");
                        sair = true;
                        break;
                    default:
                        System.out.println("Opção inválida. Digite um número de 1 a 7.");
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
    }

    private static int exibirMenu(Scanner scanner) {
        System.out.println("Sistema de Cálculo de IMC");
        System.out.println("1. Inserir pessoa");
        System.out.println("2. Editar pessoa");
        System.out.println("3. Calcular IMC");
        System.out.println("4. Calcular Peso Ideal");
        System.out.println("5. Calcular Taxa de Gordura Corporal");
        System.out.println("6. Listar todas as pessoas com resultados dos cálculos");
        System.out.println("7. Sair");
        System.out.print("Digite a opção desejada: ");

        return scanner.nextInt();
    }

    public static void inserirPessoa() throws InterruptedException {
        scanner.nextLine();

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o sexo (M/F): ");
        String sexo = scanner.nextLine();
        System.out.print("Digite a idade: ");
        int idade = scanner.nextInt();
        System.out.print("Digite o peso (Kg): ");
        double peso = scanner.nextDouble();
        System.out.print("Digite a altura (Metro): ");
        double altura = scanner.nextDouble();
        scanner.nextLine();

        Pessoa pessoa = new Pessoa(nome, sexo, idade, peso, altura);
        sistema.adicionarPessoa(pessoa);
        System.out.println(nome + " adicionado com sucesso!");
        Thread.sleep(1000);
    }

    public static void editarPessoa() throws InterruptedException {
        System.out.print("Digite o código da pessoa: ");
        int codigoPessoa = scanner.nextInt();
        scanner.nextLine();

        Pessoa pessoaEditar = sistema.encontrarPessoa(codigoPessoa);
        if (pessoaEditar != null) {
            System.out.println("Pessoa encontrada: " + pessoaEditar.getNome());
            System.out.println("Digite o número correspondente ao dado que deseja editar:");
            System.out.println("1. Nome");
            System.out.println("2. Sexo");
            System.out.println("3. Idade");
            System.out.println("4. Peso");
            System.out.println("5. Altura");
            System.out.print("Opção: ");
            int opcaoEditar = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoEditar) {
                case 1:
                    System.out.print("Digite o novo nome: ");
                    String novoNome = scanner.nextLine();
                    pessoaEditar.setNome(novoNome);
                    System.out.println("Nome atualizado com sucesso.");
                    break;
                case 2:
                    System.out.print("Digite o novo sexo (M/F): ");
                    String novoSexo = scanner.nextLine();
                    pessoaEditar.setSexo(novoSexo);
                    System.out.println("Sexo atualizado com sucesso.");
                    break;
                case 3:
                    System.out.print("Digite a nova idade: ");
                    int novaIdade = scanner.nextInt();
                    pessoaEditar.setIdade(novaIdade);
                    System.out.println("Idade atualizada com sucesso.");
                    break;
                case 4:
                    System.out.print("Digite o novo peso: ");
                    double novoPeso = scanner.nextDouble();
                    pessoaEditar.setPeso(novoPeso);
                    System.out.println("Peso atualizado com sucesso.");
                    break;
                case 5:
                    System.out.print("Digite a nova altura: ");
                    double novaAltura = scanner.nextDouble();
                    pessoaEditar.setAltura(novaAltura);
                    System.out.println("Altura atualizada com sucesso.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } else {
            System.out.println("Pessoa não encontrada.");
        }
        Thread.sleep(1000);
    }

    public static void calcularImc() throws InterruptedException {
        System.out.print("Digite o código da pessoa: ");
        codigoPessoa = scanner.nextInt();
        pessoa = sistema.encontrarPessoa(codigoPessoa);

        if (pessoa == null) {
            System.out.println();
        }

        double imc = CalculadoraIMC.calcularIMC(pessoa.getPeso(), pessoa.getAltura());
        System.out.println("IMC: " + imc);
        System.out.println("Interpretação do IMC: " +
                CalculadoraIMC.interpretarIMC(imc, pessoa.getSexo()));
        Thread.sleep(1000);
    }

    public static void calcularPesoIdeal() throws InterruptedException {
        System.out.print("Digite o código da pessoa: ");
        pessoa = sistema.encontrarPessoa(scanner.nextInt());

        double pesoIdeal = CalculadoraPesoIdeal.calcularPesoIdeal(pessoa.getAltura(), pessoa.getSexo());
        System.out.println("Peso Ideal: " + pesoIdeal);
        Thread.sleep(1000);
    }

    public static void calcularTaxaDeGorduraCorporal() throws InterruptedException {
        System.out.print("Digite o código da pessoa: ");
        pessoa = sistema.encontrarPessoa(scanner.nextInt());

        double taxaGordura = CalculadoraTaxaGordura.calcularTaxaGordura(
                CalculadoraIMC.calcularIMC(pessoa.getPeso(), pessoa.getAltura()),
                pessoa.getSexo(), pessoa.getIdade());
        System.out.println("Taxa de Gordura Corporal: " + taxaGordura);
        Thread.sleep(1000);
    }
}
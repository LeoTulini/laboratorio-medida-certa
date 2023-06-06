package ui;

import main.Sistema;
import negocio.Pessoa;
import serviços.CalculadoraIMC;
import serviços.CalculadoraPesoIdeal;
import serviços.CalculadoraTaxaGordura;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();

        sistema.carregarDadosDoArquivo("dados.txt");

        int opcao = 0;
        Pessoa pessoa = null;

        do {
            System.out.println("Sistema de Cálculo de IMC");
            System.out.println("[1] Inserir pessoa");
            System.out.println("[2] Calcular IMC");
            System.out.println("[3] Calcular Peso Ideal");
            System.out.println("[4] Calcular Taxa de Gordura Corporal");
            System.out.println("[5] Listar todas as pessoas com resultados dos cálculos");
            System.out.println("[6] Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    pessoa = lerDadosPessoa(scanner);
                    if (pessoa != null) {
                        sistema.adicionarPessoa(pessoa);
                    }

                    Thread.sleep(1000);
                    break;
                case 2:
                    try {
                        System.out.print("Digite o código da pessoa: ");
                        int codigoPessoa = scanner.nextInt();

                        pessoa = sistema.encontrarPesssoa(codigoPessoa);

                        double imc = CalculadoraIMC.calcularIMC(pessoa.getPeso(), pessoa.getAltura());
                        System.out.printf("IMC: %.2f %n", imc);
                        System.out.println("Interpretação do IMC: " +
                                CalculadoraIMC.interpretarIMC(imc, pessoa.getSexo()));

                    } catch (NullPointerException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }

                    Thread.sleep(1000);
                    break;
                case 3:
                    try {
                        System.out.print("Digite o código da pessoa: ");
                        int codigoPessoa = scanner.nextInt();

                        pessoa = sistema.encontrarPesssoa(codigoPessoa);

                        double pesoIdeal = CalculadoraPesoIdeal.calcularPesoIdeal(pessoa.getAltura(), pessoa.getSexo());
                        System.out.println("Peso Ideal: " + pesoIdeal);
                    } catch (NullPointerException e) {
                        System.out.println("Erro: " + e.getMessage());}

                    Thread.sleep(1000);
                    break;
                case 4:
                    try {
                        System.out.print("Digite o código da pessoa: ");
                        int codigoPessoa = scanner.nextInt();

                        pessoa = sistema.encontrarPesssoa(codigoPessoa);

                        double taxaGordura = CalculadoraTaxaGordura.calcularTaxaGordura(
                                CalculadoraIMC.calcularIMC(pessoa.getPeso(), pessoa.getAltura()),
                                pessoa.getSexo(), pessoa.getIdade());
                        System.out.printf("Taxa de Gordura Corporal: %.2f %n", taxaGordura);
                    } catch (NullPointerException e) {
                        System.out.println("Erro: " + e.getMessage());
                    };

                    Thread.sleep(1000);
                    break;
                case 5:
                    sistema.listarPessoas();

                    Thread.sleep(1000);
                    break;
                case 6:
                    sistema.salvarDadosEmArquivo("dados.txt");
                    System.out.println("Saindo do sistema...");

                    Thread.sleep(1000);
                    break;
                default:
                    System.out.println("Opção inválida. Digite um número de 1 a 6.");
            }
        } while (opcao != 6);
    }

    private static Pessoa lerDadosPessoa(Scanner scanner) {
        try {
            System.out.print("Digite o código: ");
            int codigo = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();
            System.out.print("Digite o sexo (M/F): ");
            String sexo = scanner.nextLine();
            System.out.print("Digite a idade: ");
            int idade = scanner.nextInt();
            System.out.print("Digite o peso: ");
            double peso = scanner.nextDouble();
            System.out.print("Digite a altura: ");
            double altura = scanner.nextDouble();

            return new Pessoa(codigo, nome, sexo, idade, peso, altura);
        } catch (IllegalArgumentException | InputMismatchException e) {
            scanner.nextLine(); // Limpar o buffer do scanner
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
}
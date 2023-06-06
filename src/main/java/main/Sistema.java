package main;

import negocio.Pessoa;
import serviços.CalculadoraIMC;
import serviços.CalculadoraPesoIdeal;
import serviços.CalculadoraTaxaGordura;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Sistema {
    private List<Pessoa> pessoas;

    public Sistema() {
        this.pessoas = new ArrayList<>();
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public Pessoa encontrarPesssoa(int codigo) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCodigo() == codigo) {
                return pessoa;
            }
        }
        return null;
    }

    public void listarPessoas() {
        System.out.println("Listagem de Pessoas:");
        for (Pessoa pessoa : pessoas) {
            System.out.println("Código: " + pessoa.getCodigo());
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Sexo: " + pessoa.getSexo().toUpperCase());
            System.out.println("Idade: " + pessoa.getIdade());
            System.out.println("Peso: " + pessoa.getPeso());
            System.out.println("Altura: " + pessoa.getAltura());
            System.out.printf("IMC: %.2f %n", CalculadoraIMC.calcularIMC(pessoa.getPeso(), pessoa.getAltura()));
            System.out.println("Interpretação do IMC: " +
                    CalculadoraIMC.interpretarIMC(CalculadoraIMC.calcularIMC(pessoa.getPeso(), pessoa.getAltura()), pessoa.getSexo()));
            System.out.println("Peso Ideal: " +
                            CalculadoraPesoIdeal.calcularPesoIdeal(pessoa.getAltura(), pessoa.getSexo()));
            System.out.printf("Taxa de Gordura Corporal: %.2f %n",
                    CalculadoraTaxaGordura.calcularTaxaGordura(CalculadoraIMC.calcularIMC(pessoa.getPeso(), pessoa.getAltura()),
                            pessoa.getSexo(), pessoa.getIdade()));
            System.out.println("------------------------------------");
        }
    }

    public void salvarDadosEmArquivo(String arquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo))) {
            for (Pessoa pessoa : pessoas) {
                writer.println(pessoa.getCodigo() + ";" + pessoa.getNome() + ";" + pessoa.getSexo() + ";" +
                        pessoa.getIdade() + ";" + pessoa.getPeso() + ";" + pessoa.getAltura());
            }
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public void carregarDadosDoArquivo(String arquivo) {
        try (Scanner scanner = new Scanner(new File(arquivo))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dados = linha.split(";");
                int codigo = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String sexo = dados[2];
                int idade = Integer.parseInt(dados[3]);
                double peso = Double.parseDouble(dados[4]);
                double altura = Double.parseDouble(dados[5]);
                Pessoa pessoa = new Pessoa(codigo, nome, sexo, idade, peso, altura);
                pessoas.add(pessoa);
            }
            System.out.println("Dados carregados com sucesso!");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}

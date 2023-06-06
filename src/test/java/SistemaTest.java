import main.Sistema;
import negocio.Pessoa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import serviços.CalculadoraIMC;
import serviços.CalculadoraPesoIdeal;
import serviços.CalculadoraTaxaGordura;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class SistemaTest {
    private Sistema sistema = new Sistema();
    private ByteArrayOutputStream outputStream;

    @Test
    public void deveAdicionarPessoaCorretamente() {
        Pessoa pessoa = new Pessoa(1, "João", "M", 30, 80.0, 1.75);
        sistema.adicionarPessoa(pessoa);
        List<Pessoa> pessoas = sistema.getPessoas();
        Assert.assertEquals(1, pessoas.size());
        Assert.assertEquals(pessoa, pessoas.get(0));
    }

    @Test
    public void deveEncontrarPessoaExistente() {
        Pessoa pessoa1 = new Pessoa(1, "João", "M", 30, 80.0, 1.75);
        Pessoa pessoa2 = new Pessoa(2, "Maria", "F", 25, 60.0, 1.65);
        sistema.adicionarPessoa(pessoa1);
        sistema.adicionarPessoa(pessoa2);
        Pessoa encontrada = sistema.encontrarPesssoa(2);
        Assert.assertEquals(pessoa2, encontrada);
    }

    @Test
    public void deveEncontrarPessoaInexistente() {
        Pessoa pessoa1 = new Pessoa(1, "João", "M", 30, 80.0, 1.75);
        sistema.adicionarPessoa(pessoa1);
        Pessoa encontrada = sistema.encontrarPesssoa(2);
        Assert.assertNull(encontrada);
    }

    @Test
    public void deveSalvarDadosEmArquivo() {
        Pessoa pessoa1 = new Pessoa(1, "João", "M", 30, 80.0, 1.75);
        Pessoa pessoa2 = new Pessoa(2, "Maria", "F", 25, 60.0, 1.65);
        sistema.adicionarPessoa(pessoa1);
        sistema.adicionarPessoa(pessoa2);

        sistema.salvarDadosEmArquivo("dados.txt");

        // Verificar se o arquivo foi criado e contém os dados
        // Faça asserções adicionais conforme necessário
    }

    @Test
    public void deveCarregarDadosDoArquivo() {
        // Crie um arquivo com dados de exemplo
        // Chame o método carregarDadosDoArquivo para carregar os dados

        // Verificar se os dados foram carregados corretamente
        // Faça asserções adicionais conforme necessário
    }
}
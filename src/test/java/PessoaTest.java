import negocio.Genero;
import negocio.Pessoa;
import org.junit.Assert;
import org.junit.Test;

public class PessoaTest {

    @Test
    public void criarPessoa_Valida() {
        String nome = "João";
        Genero genero = Genero.MASCULINO;
        int idade = 30;
        double peso = 80.5;
        double altura = 1.75;

        Pessoa pessoa = new Pessoa(nome, genero, idade, peso, altura);

        Assert.assertEquals(nome, pessoa.getNome());
        Assert.assertEquals(Genero.MASCULINO, pessoa.getGenero());
        Assert.assertEquals(idade, pessoa.getIdade());
        Assert.assertEquals(peso, pessoa.getPeso(), 0.001);
        Assert.assertEquals(altura, pessoa.getAltura(), 0.001);
    }

    @Test
    public void criarPessoa_NomeInvalido() {
        String nome = "";

        try {
            new Pessoa(nome, Genero.MASCULINO, 30, 80.5, 1.75);
            Assert.fail("Deveria lançar uma exceção IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Não é permitido criar uma pessoa sem nome.", e.getMessage());
        }
    }

    @Test
    public void criarPessoa_SexoInvalido() {
        Genero genero = null;

        try {
            new Pessoa("João", genero, 30, 80.5, 1.75);
            Assert.fail("Deveria lançar uma exceção IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Gênero inválido. O gênero deve ser 'MASCULINO' ou 'FEMININO'.", e.getMessage());
        }
    }

    @Test
    public void criarPessoa_IdadeInvalida() {
        int idade = -10;

        try {
            new Pessoa("João", Genero.MASCULINO, idade, 80.5, 1.75);
            Assert.fail("Deveria lançar uma exceção IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Idade inválida. A idade deve ser um valor positivo.", e.getMessage());
        }
    }

    @Test
    public void criarPessoa_PesoInvalido() {
        double peso = 0;

        try {
            new Pessoa("João", Genero.MASCULINO, 30, peso, 1.75);
            Assert.fail("Deveria lançar uma exceção IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Peso inválido. O peso deve ser um valor positivo.", e.getMessage());
        }
    }

    @Test
    public void criarPessoa_AlturaInvalida() {
        double altura = -1.5;

        try {
            new Pessoa("João", Genero.MASCULINO, 30, 80.5, altura);
            Assert.fail("Deveria lançar uma exceção IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Altura inválida. A altura deve ser um valor positivo.", e.getMessage());
        }
    }
}

import main.Sistema;
import negocio.Genero;
import negocio.Pessoa;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SistemaTest {

    private Sistema sistema;

    @Before
    public void setUp() {
        sistema = new Sistema();
    }

    @Test
    public void adicionarPessoa() {
        Pessoa pessoa = new Pessoa("João", Genero.MASCULINO, 30, 80.5, 1.75);
        sistema.adicionarPessoa(pessoa);
        Assert.assertTrue(sistema.getPessoas().contains(pessoa));
    }

    @Test
    public void encontrarPessoa() {
        Pessoa pessoa1 = new Pessoa("João", Genero.MASCULINO, 30, 80.5, 1.75);
        Pessoa pessoa2 = new Pessoa("Maria", Genero.FEMININO, 25, 65.2, 1.60);
        sistema.adicionarPessoa(pessoa1);
        sistema.adicionarPessoa(pessoa2);
        Pessoa pessoaEncontrada = sistema.encontrarPessoa(pessoa2.getCodigo());
        Assert.assertEquals(pessoa2, pessoaEncontrada);
    }
}

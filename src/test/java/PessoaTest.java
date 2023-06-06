import negocio.Pessoa;
import org.junit.Assert;
import org.junit.Test;

public class PessoaTest {
    @Test
    public void setCodigoValido() {
        Pessoa pessoa = new Pessoa(1, "João", "M", 30, 80.0, 1.75);
        Assert.assertEquals(1, pessoa.getCodigo());
    }

    @Test
    public void setCodigoInvalido() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            new Pessoa(0, "Maria", "F", 25, 60.0, 1.65);
        });
    }

    @Test
    public void setNomeValido() {
        Pessoa pessoa = new Pessoa(1, "Ana", "F", 35, 65.0, 1.60);
        Assert.assertEquals("Ana", pessoa.getNome());
    }

    @Test
    public void setNomeInvalido() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            new Pessoa(2, "", "M", 40, 70.0, 1.80);
        });
    }

    @Test
    public void setSexoValido() {
        Pessoa pessoa = new Pessoa(3, "Carlos", "M", 45, 75.0, 1.70);
        Assert.assertEquals("M", pessoa.getSexo());
    }

    @Test
    public void setSexoInvalido() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            new Pessoa(4, "Lúcia", "Feminino", 50, 80.0, 1.75);
        });
    }

    @Test
    public void setIdadeValida() {
        Pessoa pessoa = new Pessoa(5, "Pedro", "M", 55, 85.0, 1.80);
        Assert.assertEquals(55, pessoa.getIdade());
    }

    @Test
    public void setIdadeInvalida() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            new Pessoa(6, "Camila", "F", -30, 60.0, 1.65);
        });
    }

    @Test
    public void setPesoValido() {
        Pessoa pessoa = new Pessoa(7, "Paula", "F", 28, 55.0, 1.62);
        Assert.assertEquals(55.0, pessoa.getPeso(), 0.001);
    }

    @Test
    public void setPesoInvalido() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            new Pessoa(8, "Lucas", "M", 33, -70.0, 1.75);
        });
    }

    @Test
    public void setAlturaValida() {
        Pessoa pessoa = new Pessoa(9, "Mariana", "F", 40, 60.0, 1.70);
        Assert.assertEquals(1.70, pessoa.getAltura(), 0.001);
    }

    @Test
    public void setAlturaInvalida() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            new Pessoa(10, "André", "M", 45, 80.0, -1.80);
        });
    }
}
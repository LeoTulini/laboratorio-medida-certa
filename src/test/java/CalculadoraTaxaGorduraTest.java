import org.junit.Assert;
import org.junit.Test;
import serviços.CalculadoraTaxaGordura;

public class CalculadoraTaxaGorduraTest {

    @Test
    public void deveCalcularCorretamenteATaxaDeGorduraFeminino() {

        Assert.assertEquals(CalculadoraTaxaGordura.calcularTaxaGordura(27.1, "f", 20), 31.72, .01);
    }

    @Test
    public void deveCalcularCorretamenteATaxaDeGorduraMasculino() {

        Assert.assertEquals(CalculadoraTaxaGordura.calcularTaxaGordura(27.1, "m", 20), 20.92, .01);
    }
}

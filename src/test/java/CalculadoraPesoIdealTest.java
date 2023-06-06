import org.junit.Assert;
import org.junit.Test;
import serviços.CalculadoraPesoIdeal;

public class CalculadoraPesoIdealTest {

    @Test
    public void deveCalcularCorretamenteOPesoIdealFeminino() {

        Assert.assertEquals(CalculadoraPesoIdeal.calcularPesoIdeal(175, "f"), 62.5, .01);
    }

    @Test
    public void deveCalcularCorretamenteOPesoIdealMasculino() {

        Assert.assertEquals(CalculadoraPesoIdeal.calcularPesoIdeal(175, "m"), 68.75, .01);
    }
}

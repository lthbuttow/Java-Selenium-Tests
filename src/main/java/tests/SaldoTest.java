package tests;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;

public class SaldoTest extends BaseTest {
    HomePage page = new HomePage();

    @Test
    public void testSaldoConta() {
        Assert.assertEquals("2500.00", page.obterSaldoConta("Conta do Teste alterada"));
    }
}

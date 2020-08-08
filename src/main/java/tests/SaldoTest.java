package tests;

import core.BaseTest;
import core.Propriedades;
import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.MenuPage;

public class SaldoTest extends BaseTest {
    HomePage page = new HomePage();
    MenuPage menu = new MenuPage();

    @Test
    public void testSaldoConta() {
        menu.acessarTelaPrincipal();
        Assert.assertEquals("534.00", page.obterSaldoConta("Conta para saldo"));
    }
}

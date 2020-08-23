package suites;

import core.DriverFactory;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pages.LoginPage;
import tests.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContaTest.class,
        MovimentacaoTest.class,
        RemoverMovimentacaoContaTest.class,
        SaldoTest.class,
        ResumoTest.class
})
public class SuiteGeral {
    private static LoginPage page = new LoginPage();

    @BeforeClass
    public static void reset(){
        page.acessarTelaInicial();

        page.setEmail("lucas_buttow@outlook.com");
        page.setSenha("6478");
        page.entrar();

        page.resetar();

        DriverFactory.killDriver();
    }

}

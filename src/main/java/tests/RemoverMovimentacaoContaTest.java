package tests;

import core.BaseTest;
import core.Propriedades;
import org.junit.Assert;
import org.junit.Test;
import pages.ContasPage;
import pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest {
    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void ExcluirContaComMovimentacao(){

        menuPage.acessarTelaListarConta();

        contasPage.clicarExcluirConta(Propriedades.NOME_CONTA_ALTERADA);

        Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
    }
}

package tests;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.MenuPage;
import pages.ResumoPage;

public class ResumoTest extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private ResumoPage resumoPage = new ResumoPage();

    @Test
    public void testExcluirMovimentacao(){
        menuPage.acessarTelaResumo();

        resumoPage.excluirMovimentacao();

        Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());

    }

}

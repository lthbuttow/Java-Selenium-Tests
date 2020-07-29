package tests;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MenuPage;
import pages.MovimentacaoPage;

import java.util.Arrays;
import java.util.List;

public class MovimentacaoTest extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private MovimentacaoPage movPage = new MovimentacaoPage();

    @Test
    public void testInserirMovimentacao(){
        menuPage.acessarTelaInserirMovimentacao();

        movPage.setDataMovimentacao("01/09/2017");
        movPage.setDataPagamento("02/09/2017");
        movPage.setDescricao("Movimentação do Teste");
        movPage.setInteressado("Interessado Qualquer");
        movPage.setValor("500");
        movPage.setConta("Conta do Teste alterada");
        movPage.setStatusPago();
        movPage.salvar();

        Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
    }

    @Test
    public void testCamposObrigatorios(){
        menuPage.acessarTelaInserirMovimentacao();

        movPage.salvar();
        List<String> erros = movPage.obterErros();
//		Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0));
//		Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório"));
        Assert.assertTrue(erros.containsAll(Arrays.asList(
                "Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",
                "Descrição é obrigatório", "Interessado é obrigatório",
                "Valor é obrigatório", "Valor deve ser um número")));
        Assert.assertEquals(6, erros.size());
    }
}

package tests;

import core.BaseTest;
import core.Propriedades;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MenuPage;
import pages.MovimentacaoPage;
import utils.DataUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static utils.DataUtils.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private MovimentacaoPage movPage = new MovimentacaoPage();

    @Test
    public void test1InserirMovimentacao(){
        menuPage.acessarTelaInserirMovimentacao();

        movPage.setDataMovimentacao(obterDataFormatada(new Date()));
        movPage.setDataPagamento(obterDataFormatada(new Date()));
        movPage.setDescricao("Movimentação do Teste");
        movPage.setInteressado("Interessado Qualquer");
        movPage.setValor("500");
        movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
        movPage.setStatusPago();
        movPage.salvar();

        Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
    }

    @Test
    public void test2CamposObrigatorios(){
        menuPage.acessarTelaInserirMovimentacao();

        movPage.salvar();
        List<String> erros = movPage.obterErros();
        Assert.assertTrue(erros.containsAll(Arrays.asList(
                "Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",
                "Descrição é obrigatório", "Interessado é obrigatório",
                "Valor é obrigatório", "Valor deve ser um número")));
        Assert.assertEquals(6, erros.size());
    }

    @Test
    public void test3InserirMovimentacaoFutura(){
        menuPage.acessarTelaInserirMovimentacao();

        Date dataFutura = obterDataComDiferencaDias(5);

        movPage.setDataMovimentacao(obterDataFormatada(dataFutura));
        movPage.setDataPagamento(obterDataFormatada(dataFutura));
        movPage.setDescricao("Movimentação do Teste");
        movPage.setInteressado("Interessado Qualquer");
        movPage.setValor("500");
        movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
        movPage.setStatusPago();
        movPage.salvar();

        List<String> erros = movPage.obterErros();
        Assert.assertTrue(
                erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
        Assert.assertEquals(1, erros.size());

    }

}

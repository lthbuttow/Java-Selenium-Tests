package pages;

import core.BasePage;
import org.openqa.selenium.By;

public class ContasPage extends BasePage {

    public void setNome(String nome) {
        escrever("nome", nome);
    }

    public void salvar() {
       clicarBotao(By.xpath("//button[.='Salvar']"));
    }

    public String obterMensagemSucesso() {
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public void clicarAlterarConta(String string) {
        obterCelula("Conta", string , "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
    }
}

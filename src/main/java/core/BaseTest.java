package core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

public class BaseTest {
	private LoginPage page = new LoginPage();

	@Rule
	public TestName testName = new TestName();

	@Before
	public void inicializa(){
		page.acessarTelaInicial();

		page.setEmail("lucas_buttow@test.com");
		page.setSenha("6478");
		page.entrar();
	}
	
	@After
	public void finaliza() throws IOException{
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" +
				File.separator + testName.getMethodName() + ".jpg"));
		
		if(Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}

}

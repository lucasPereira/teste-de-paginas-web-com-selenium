package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TesteCalculadora {

	@Test
	void abrir() throws Exception {
		WebDriver selenium = new Utilitarios().criarChromeDriverHeadlessLinux();
		selenium.get("https://duckduckgo.com");
		WebElement campoDeBusca = selenium.findElement(By.cssSelector("#search_form_input_homepage"));
		campoDeBusca.sendKeys("calculator");
		new Utilitarios().capturarTela(selenium);
		WebElement botaoDeBusca = selenium.findElement(By.cssSelector("#search_button_homepage"));
		botaoDeBusca.click();
		WebElement textoResultado = selenium.findElement(By.cssSelector("#display"));
		WebElement historico = selenium.findElement(By.cssSelector("#zci-calculator > div > div > div > div > div > div.tile__tabs > ul"));
		assertEquals("0", textoResultado.getText());
		assertEquals(0, historico.findElements(By.tagName("li")).size());
		selenium.close();
	}

}

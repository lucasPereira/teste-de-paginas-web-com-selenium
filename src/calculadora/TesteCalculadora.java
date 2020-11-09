package calculadora;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCalculadora {

	@Test
	void abrir() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver selenium = new ChromeDriver();
		selenium.navigate().to("https://duckduckgo.com/");
		WebElement pesquisa = selenium.findElement(By.cssSelector("#search_form_input_homepage"));
		pesquisa.sendKeys("calculator");
		WebElement botao = selenium.findElement(By.cssSelector("#search_button_homepage"));
		botao.click();
		selenium.close();
	}

}

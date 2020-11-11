package calculadora;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.google.common.io.Files;

public class Utilitarios {

	public void capturarTela(WebDriver selenium) {
		TakesScreenshot screenshot = (TakesScreenshot) selenium;
		File arquivoNaPastaTemporaria = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			Files.move(arquivoNaPastaTemporaria, new File("teste.png"));
		} catch (IOException excecao) {
			excecao.printStackTrace();
		}
	}

	public WebDriver construirWebDriver() {
		Boolean windows = System.getProperty("os.name").contains("Windows");
		Boolean linux = System.getProperty("os.name").equals("Linux");
		Boolean arquitetura64 = System.getProperty("os.arch").equals("amd64");
		if (linux && arquitetura64) {
			return criarChromeDriverLinux();
		} else if (windows && arquitetura64) {
			return criarChromeDriverWindows();
		}
		throw new RuntimeException("Sistema operacional não suportado nesse projeto");
	}

	public ChromeDriver criarChromeDriverLinux() {
		System.setProperty("webdriver.chrome.driver", "drivers/chrome-driver-linux-64-versao-86");
		return new ChromeDriver();
	}

	public ChromeDriver criarChromeDriverWindows() {
		System.setProperty("webdriver.chrome.driver", "drivers/chrome-driver-windows-32-versao-86.exe");
		return new ChromeDriver();
	}

	public ChromeDriver criarChromeDriverHeadlessLinux() {
		System.setProperty("webdriver.chrome.driver", "drivers/chrome-driver-linux-64-versao-86");
		ChromeOptions opcoes = new ChromeOptions();
		opcoes.addArguments("--headless");
		opcoes.addArguments("--disable-gpu");
		opcoes.addArguments("--window-size=1920,1200");
		opcoes.addArguments("--ignore-certificate-errors");
		return new ChromeDriver(opcoes);
	}
	
	public HtmlUnitDriver criarHtmlUnitDriver() {
		return new HtmlUnitDriver();
	}

}

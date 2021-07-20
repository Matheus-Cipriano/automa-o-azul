package pages;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SelecionarPoltrona {
	WebDriver navegador;
	
	//Construct
	public SelecionarPoltrona(WebDriver navegador) {
	this.navegador = navegador;	
	}
	public void poltrona() throws InterruptedException {
		Random aleatorio = new Random();
        int poltrona = aleatorio.nextInt(60);
        navegador.findElement(By.xpath("(//a[contains(@class,'seat -available') and @unit_value_pax_0='R$ 0,00'])[" + poltrona + "]")).click();
        Thread.sleep(6000);
        navegador.findElement(By.id("btnProsseguir")).click();
        Thread.sleep(3000);
        ((RemoteWebDriver) navegador).executeScript("scrollBy(0,550)", "");
        navegador.findElement(By.id("btnContinue")).click();
}
}
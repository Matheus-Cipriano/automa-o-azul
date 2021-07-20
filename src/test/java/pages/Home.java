package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class Home {
	WebDriver navegador;
	
	//Construct
	public Home(WebDriver navegador) {
		this.navegador = navegador;
	}
	public void dadosPassagem() throws InterruptedException {
		navegador.findElement(By.xpath("//*[@id=\"nav-shopping\"]/a")).click();
		navegador.findElement(By.xpath("//*[@id=\"TCSS__tabbox-shopping\"]/div[1]/div/fieldset[2]/input")).click();
		navegador.findElement(By.xpath("//*[@id=\"field-5-origin1\"]"))
				.sendKeys("São Paulo - Todos os Aeroportos (SAO)");
		navegador.findElement(By.xpath("//*[@id=\"field-5-origin1\"]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		navegador.findElement(By.xpath("//*[@id=\"field-6-destination1\"]"))
				.sendKeys("Rio de Janeiro - Todos os Aeroportos (RIO)");
		navegador.findElement(By.xpath("//*[@id=\"field-6-destination1\"]")).sendKeys(Keys.ENTER);
		
	}
	
	public void informacaoData() {
		navegador.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);navegador.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		navegador.findElement(By.xpath("//*[@id=\"tab-one-way\"]/div[2]/div[1]/div/button")).click();
		Random aleatorio = new Random();
        int dia = aleatorio.nextInt(120);
        LocalDate dataDePartida = LocalDate.now().plusDays(dia);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        navegador.findElement(By.xpath("//input[@id='field-7-departure1']")).sendKeys((dataDePartida.format(formato)).toString());

        navegador.findElement(By.id("searchTicketsButton")).click();
	}
}


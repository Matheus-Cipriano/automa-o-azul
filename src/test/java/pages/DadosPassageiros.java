package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DadosPassageiros {
	WebDriver navegador;
	
	//Construct
	public DadosPassageiros(WebDriver navegador) {
	this.navegador = navegador;	
	}
	public void dados() throws InterruptedException {
	Thread.sleep(5000);
	
	navegador.findElement(By.xpath("//*[@id=\"PassengerControlPassengerView_TextBoxFirstName_0\"]")).sendKeys("Matheus");
	navegador.findElement(By.xpath("//*[@id=\"PassengerControlPassengerView_TextBoxLastName_0\"]")).sendKeys("TesteUltimo");
	navegador.findElement(By.xpath("//*[@id=\"countryDiv\"]/div/button/span[1]")).click();
	navegador.findElement(By.xpath("//*[@id=\"countryDiv\"]/div/div/ul/li[2]/a")).click();
	navegador.findElement(By.xpath("//*[@id=\"PassengerControlPassengerView_TextBoxNationalId_0\"]")).sendKeys("331.076.338-28");
	navegador.findElement(By.xpath("//*[@id=\"PassengerControlPassengerView_TextBoxMiddleName_0\"]")).sendKeys("TesteMeio");
	Thread.sleep(2000);
	navegador.findElement(By.xpath("//*[@id=\"informationGenderDiv_0\"]/div/button")).click();
	Thread.sleep(2000);
	navegador.findElement(By.xpath("//*[@id=\"informationGenderDiv_0\"]/div/div/ul/li[3]/a/span[1]")).click();
	
	navegador.findElement(By.xpath("//*[@id=\"PassengerControlPassengerView_TextBoxBirthDate_0\"]")).sendKeys("23/03/1996");
	navegador.findElement(By.xpath("//*[@id=\"PassengerControlPassengerView_TextBoxEmail_0\"]")).sendKeys("teste@gmail.com");
	((RemoteWebDriver) navegador).executeScript("scrollBy(0,550)", "");
	navegador.findElement(By.xpath("//*[@id=\"PassengerControlPassengerView_LinkButtonSubmit\"]")).click();
}
}
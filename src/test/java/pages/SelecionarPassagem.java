package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelecionarPassagem {
	WebDriver navegador;
	
	//Construct
	public SelecionarPassagem(WebDriver navegador) {
		this.navegador = navegador;
		
	}
	public void passagem() throws InterruptedException {
	Thread.sleep(7000);
	navegador.findElement(By.xpath("(//*[@id=\"AvailabilityInputAvailabilityView_LinkButtonSubmit\"])[1]")).click();
	
}
}
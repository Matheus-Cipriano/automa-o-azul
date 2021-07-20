package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import junit.framework.Assert;

public class CheckBox {
	WebDriver navegador;
	
//Construct
public CheckBox(WebDriver navegador) {
	this.navegador = navegador;
}
public void infoCartao() throws InterruptedException {
	navegador.findElement(By.xpath("//*[@id=\"PaymentInputControlCheckoutView_ContactInputControlCheckoutView_TextBoxPostalCode\"]")).sendKeys("04551-000");
	navegador.findElement(By.xpath("//*[@id=\"PaymentInputControlCheckoutView_ContactInputControlCheckoutView_TextBoxAddressNumber\"]")).sendKeys("1910");
	navegador.findElement(By.xpath("//*[@id=\"PaymentInputControlCheckoutView_ContactInputControlCheckoutView_TextBoxOtherPhone\"]")).sendKeys("1198765432");
	((RemoteWebDriver) navegador).executeScript("scrollBy(0,950)", "");
	Thread.sleep(2000);
	navegador.findElement(By.xpath("//*[@id=\"PaymentInputControlCheckoutView_CheckboxTerms\"]")).click();
	Thread.sleep(1000);
	WebElement ativo = navegador.findElement(By.xpath("//button[@class='btn btn-action btn-next']"));
    Assert.assertTrue(ativo.isDisplayed());
}
}

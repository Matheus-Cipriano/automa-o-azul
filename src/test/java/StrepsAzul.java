import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.cucumber.java.pt.*;
import junit.framework.Assert;

public class StrepsAzul {
	private WebDriver navegador;
	By data_inicial = By.xpath("//*[@id=\"tab-one-way\"]/div[2]/div[1]/div/button");

	By data_in = By.xpath("//a[contains(.,'10')]");

	@Dado("que estou acesando o site")
	public void que_estou_acessando_o_site() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mathe\\eclipse-workspace\\automacao-teste-azul\\src\\test\\resources\\Driver\\chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.get("https://www.voeazul.com.br/");
		navegador.manage().window().maximize();
		navegador.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Dado("coloco local saida e entrada")
	public void coloco_local_saida_e_entrada() throws InterruptedException {
		
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

	@Dado("seleciono as datas")
	public void seleciono_as_datas() {
		navegador.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);navegador.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		navegador.findElement(By.xpath("//*[@id=\"tab-one-way\"]/div[2]/div[1]/div/button")).click();
		Random aleatorio = new Random();
        int dia = aleatorio.nextInt(120);
        LocalDate dataDePartida = LocalDate.now().plusDays(dia);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        navegador.findElement(By.xpath("//input[@id='field-7-departure1']")).sendKeys((dataDePartida.format(formato)).toString());

        navegador.findElement(By.id("searchTicketsButton")).click();

    } 

	@Dado("seleciono uma passagem")
	public void seleciono_uma_passagem() throws InterruptedException {
		Thread.sleep(7000);
		navegador.findElement(By.xpath("(//*[@id=\"AvailabilityInputAvailabilityView_LinkButtonSubmit\"])[1]")).click();
			
	}

	@Dado("digito os dados dos passageiros")
	public void digito_os_dados_dos_passageiros() throws InterruptedException {
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

	@Entao("seleciono uma poutrona disponivel")
	public void seleciono_uma_poutrona_disponivel() throws InterruptedException {
		List<String> letra = Arrays.asList("A", "B", "C", "D", "E", "F");
        String select = letra.get(new Random().nextInt(letra.size()));
        Random aleatorio = new Random();
        int poltrona = aleatorio.nextInt(27);
        navegador.findElement(By.xpath("//a[contains(@class,'seat -available') and @data-seatnumber='"+poltrona+""+select+"']")).click();
        Thread.sleep(3000);
        ((RemoteWebDriver) navegador).executeScript("scrollBy(0,500)", "");
        navegador.findElement(By.xpath("//*[@id='btnProsseguir']")).click();
        Thread.sleep(3000);
        ((RemoteWebDriver) navegador).executeScript("scrollBy(0,950)", "");
        navegador.findElement(By.xpath("//*[@id=\"btnContinue\"]")).click();
	}

	@Entao("clico na checkbox e confirmo a reserva")
	public void clico_na_checkbox_e_confirmo_a_reserva() throws InterruptedException {
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

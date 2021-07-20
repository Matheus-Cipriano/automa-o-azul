package steps;
import java.awt.Checkbox;
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
import pages.CheckBox;
import pages.DadosPassageiros;
import pages.Home;
import pages.SelecionarPassagem;
import pages.SelecionarPoltrona;

public class StrepsAzul {
	private WebDriver navegador;
	private Home home;
	private SelecionarPassagem selecionarpassagem;
	private DadosPassageiros dadospassageiros;
	private SelecionarPoltrona selecionarpoltrona;
	private CheckBox checkbox;
	
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
	home = new Home(navegador);	
	home.dadosPassagem();
	
	}

	@Dado("seleciono as datas")
	public void seleciono_as_datas() {
	home = new Home(navegador);
	home.informacaoData();

    } 

	@Dado("seleciono uma passagem")
	public void seleciono_uma_passagem() throws InterruptedException {
	selecionarpassagem = new SelecionarPassagem(navegador);
	selecionarpassagem.passagem();
			
	}

	@Dado("digito os dados dos passageiros")
	public void digito_os_dados_dos_passageiros() throws InterruptedException {
	dadospassageiros = new DadosPassageiros(navegador);
	dadospassageiros.dados();		
	}

	@Entao("seleciono uma poltrona disponivel")
	public void seleciono_uma_poutrona_disponivel() throws InterruptedException {
	selecionarpoltrona = new SelecionarPoltrona(navegador);
	selecionarpoltrona.poltrona();
	}

	@Entao("clico na checkbox e confirmo a reserva")
	public void clico_na_checkbox_e_confirmo_a_reserva() throws InterruptedException {
	checkbox = new CheckBox(navegador);
	checkbox.infoCartao();
	}
}

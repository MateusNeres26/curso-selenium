import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCNR {

	@Test
	public void Login() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		//driver.manage().window().maximize(); //maximizado
		driver.get("https://hml-cef.cartorionet.com/cartorionet/app/cricorp/authorized/authenticationController/showAuthenticationView?isOnlineRegistrationEnabled=true&isEstateManagementEnabled=false&isCreditorEnabled=true&operationNumberCaption=N%C2%BA+Opera%C3%A7%C3%A3o&speCaption=SPE&isUseEmolumentsRefundProcess=false&isMaster=false");
		driver.findElement(By.id("username")).sendKeys("pwilmer@catitech.com.br");
		driver.findElement(By.id("password")).sendKeys("b@cK0fF1c3");
		driver.findElement(By.id("login")).click();
		
		WebElement elements = driver.findElement(By.id("select-profile"));
		Select combos = new Select(elements);
		combos.selectByVisibleText("Administra��o Cati");
		
		
		WebElement element = driver.findElement(By.id("spe-select"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Entrar sem SPE / Centro de custo");
		combo.selectByVisibleText("(Cati) Regi�o Sul");
		combo.selectByVisibleText("(Cati) Regi�o Sudeste");
		combo.selectByVisibleText("(Cati) Regi�o Centro Oeste");
		combo.selectByVisibleText("(Cati) Regi�o Norte");
		driver.findElement(By.id("select-profile"));
		driver.findElement(By.id("choose-profile-btn")).click();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		Assert.assertEquals("Cart�rionet Registro | Home", driver.getTitle());
		//driver.quit();
		
	}
	
}

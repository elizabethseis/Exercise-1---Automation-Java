package TestAutomation;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class AutomationJava {
	
	
	@Test
	public static void OpenPage() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\elizabeth.perez\\git\\Exercise-1---Automation-Java\\demo.automation\\Drivers\\Chrome\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		String URL= "https://www.apple.com/mx";
		driver.get(URL);
		
		WebElement MacButton = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-mac']"));
		MacButton.click();
		String ValidateTexto = driver.findElement(By.xpath("//section[@class='section section-macbook-air']//h3[1]")).getText();
		System.out.println('\n'+"Message from Interface: "+ ValidateTexto);
		Assert.assertEquals("Ligera como siempre." + '\n'+"Poderosa como nunca.", ValidateTexto);	
		WebElement SearchBar = driver.findElement(By.xpath("//a[@id='ac-gn-link-search']"));
		SearchBar.click();
		WebElement SearchElement = driver.findElement(By.xpath("//input[@id='ac-gn-searchform-input']"));
		SearchElement.sendKeys("iPhone XR");
		SearchElement.sendKeys(Keys.ENTER); 
		WebDriverWait wait = new WebDriverWait (driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='accessories']")));
		String ActualTittle = driver.getTitle();
		String ExpectedTittle = "iPhone XR - Apple (MX)";
		System.out.println('\n'+"Page Tittle: "+ ActualTittle);
		AssertJUnit.assertEquals(ActualTittle, ExpectedTittle);
		WebElement Product = driver.findElement(By.xpath("//h2[@class='as-productname as-util-relatedlink'][contains(text(),'iPhone XR')]"));
		Product.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Pantalla')]")));
		Boolean Enabled = driver.findElement(By.xpath("//a[contains(text(),'Pantalla')]")).isEnabled();
		Assert.assertTrue(Enabled==true);
		System.out.println('\n'+"The Element Pantalla is enabled");
		Enabled = driver.findElement(By.xpath("//a[contains(text(),'Face ID')]")).isEnabled();
		System.out.println('\n'+"The Element Face ID is enabled");
		Enabled = driver.findElement(By.xpath("//a[contains(text(),'A12 Bionic')]")).isEnabled();
		System.out.println('\n'+"The Element A12 Bionic is enabled");
		Enabled = driver.findElement(By.xpath("//a[contains(text(),'Sólo el iPhone')]")).isEnabled();
		System.out.println('\n'+"The Element Sólo el iPhone is enabled");
		Enabled = driver.findElement(By.xpath("//a[contains(text(),'Especificaciones')]")).isEnabled();
		System.out.println('\n'+"The Element Especificaciones is enabled");
		Enabled = driver.findElement(By.xpath("//a[@class='ac-ln-button']")).isEnabled();
		System.out.println('\n'+"The Element Comprar is enabled");		
		driver.close();		
	}
}

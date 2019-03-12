package TestAutomation;
import org.testng.annotations.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@Test
public class AutomationJava {
	
	
	public static void OpenPage() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\elizabeth.perez\\eclipse-workspace\\demo.automation\\Drivers\\GeckoDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String URL= "https://www.apple.com/mx";
		driver.get(URL);
		
		WebElement MacButton = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-mac']"));
		MacButton.click();
		String ValidateTexto = driver.findElement(By.xpath("//section[@class='section section-macbook-air']//h3[1]")).getText();
		System.out.println('\n'+"Message from Interface: "+ ValidateTexto);
		Assert.assertTrue(ValidateTexto.contains("Ligera como siempre"));		
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
		Assert.assertEquals(ActualTittle, ExpectedTittle);
		WebElement Product = driver.findElement(By.xpath("//h2[@class='as-productname as-util-relatedlink'][contains(text(),'iPhone XR')]"));
		Product.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Pantalla')]")));
		Boolean Enabled = driver.findElement(By.xpath("//a[contains(text(),'Pantalla')]")).isEnabled();
		if (Enabled) {
			System.out.println('\n'+"The Element Pantalla is enabled");
		}
		else {
			System.out.println('\n'+"The Element Pantalla is not enabled");
		}
		Enabled = driver.findElement(By.xpath("//a[contains(text(),'Face ID')]")).isEnabled();
		if (Enabled) {
			System.out.println('\n'+"The Element Face ID is enabled");
		}
		else {
			System.out.println('\n'+"The Element Face ID is not enabled");
		}
		Enabled = driver.findElement(By.xpath("//a[contains(text(),'A12 Bionic')]")).isEnabled();
		if (Enabled) {
			System.out.println('\n'+"The Element A12 Bionic is enabled");
		}
		else {
			System.out.println('\n'+"The Element A12 Bionic is not enabled");
		}
		Enabled = driver.findElement(By.xpath("//a[contains(text(),'Sólo el iPhone')]")).isEnabled();
		if (Enabled) {
			System.out.println('\n'+"The Element Sólo el iPhone is enabled");
		}
		else {
			System.out.println('\n'+"The Element Sólo el iPhone is not enabled");
		}
		Enabled = driver.findElement(By.xpath("//a[contains(text(),'Especificaciones')]")).isEnabled();
		if (Enabled) {
			System.out.println('\n'+"The Element Especificaciones is enabled");
		}
		else {
			System.out.println('\n'+"The Element Especificaciones is not enabled");
		}
		Enabled = driver.findElement(By.xpath("//a[@class='ac-ln-button']")).isEnabled();
		if (Enabled) {
			System.out.println('\n'+"The Element Comprar is enabled");
		}
		else {
			System.out.println('\n'+"The Element Comprar is not enabled");
			
		}
		
		driver.close();
	
		
	}

}

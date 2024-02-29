package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ShoppingCartTest {
	
	public By username=By.id("user-name");
	public By password=By.id("password");
	public By btnLogin=By.id("login-button");
	public By errorMessage=By.xpath("//h3[@data-test='error']");
	public By btnAddToCart=By.id("add-to-cart-sauce-labs-backpack");
	public By btnCart=By.xpath("//div[@id='shopping_cart_container']/a");
	public By cartTitle=By.xpath("//div[@class='header_secondary_container']/span");
	public By btnCheckout=By.id("checkout");
	
	public By txtFirstName=By.id("first-name");
	public By txtLastName=By.id("last-name");
	public By txtPostalCode=By.id("postal-code");
	public By btnContinue=By.id("continue");
	
	public By btnFinish=By.id("finish");
	public By msgConfirOrder=By.xpath("//h2[@class='complete-header']");
	
	public String msgCartTitle="Your Cart";
	public String msgCheckoutTitle="Checkout: Your Information";
	public String msgCheckoutOverview="Checkout: Overview";
	
	public String msgCheckoutComplete="Checkout: Complete!";
	public String msgCompleteOrder="Thank you for your order!";
	
	
	
	protected static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<RemoteWebDriver>();
	public Capabilities cap;
	public WebDriver getDriver() {
		return driver.get();
	}
	
	@Parameters({"browser"})
	@Test
	public void TC_Purchase_Product_01(String browser) throws MalformedURLException, InterruptedException {
		if(browser.equalsIgnoreCase("chrome")) {
			cap=new ChromeOptions();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			cap=new FirefoxOptions();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			cap=new EdgeOptions();
		}
		
		driver.set(new RemoteWebDriver(new URL("http://localhost:4444/"),cap));
		getDriver().get("https://www.saucedemo.com/");
		getDriver().manage().window().maximize();
		Thread.sleep(2000);
		getDriver().findElement(username).sendKeys("standard_user");
		getDriver().findElement(password).sendKeys("secret_sauce");
		getDriver().findElement(btnLogin).click();
		Thread.sleep(2000);
		getDriver().findElement(btnAddToCart).click();
		Thread.sleep(1000);
		getDriver().findElement(btnCart).click();
		Thread.sleep(1000);
		getDriver().findElement(btnCheckout).click();
		getDriver().findElement(txtFirstName).sendKeys("Nagarjun");
		getDriver().findElement(txtLastName).sendKeys("Kasu");
		getDriver().findElement(txtPostalCode).sendKeys("500032");
		Thread.sleep(2000);
		getDriver().findElement(btnContinue).click();
		Thread.sleep(2000);
		getDriver().findElement(btnFinish).click();
		Thread.sleep(2000);
		getDriver().quit();
	}
	

}

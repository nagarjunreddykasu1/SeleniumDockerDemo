package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ShoppingCart {
	
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
	
	@Test(enabled=false)
	public void TC_Purchase_Product_01() throws MalformedURLException, InterruptedException {
		ChromeOptions options=new ChromeOptions();
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444"),options);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(username).sendKeys("standard_user");
		driver.findElement(password).sendKeys("secret_sauce");
		driver.findElement(btnLogin).click();
		Thread.sleep(2000);
		driver.findElement(btnCart).click();
		driver.findElement(btnCheckout).click();
		driver.findElement(txtFirstName).sendKeys("Nagarjun");
		driver.findElement(txtLastName).sendKeys("Kasu");
		driver.findElement(txtPostalCode).sendKeys("500032");
		Thread.sleep(2000);
		driver.findElement(btnContinue).click();
		Thread.sleep(2000);
		driver.findElement(btnFinish).click();
		Thread.sleep(2000);
	}
	
	@Test(enabled=true)
	public void TC_Purchase_Product_02() throws MalformedURLException {
		FirefoxOptions options=new FirefoxOptions();
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444"),options);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(username).sendKeys("standard_user");
		driver.findElement(password).sendKeys("secret_sauce");
		driver.findElement(btnLogin).click();
		driver.findElement(btnCart).click();
		driver.findElement(btnCheckout).click();
		driver.findElement(txtFirstName).sendKeys("Nagarjun");
		driver.findElement(txtLastName).sendKeys("Kasu");
		driver.findElement(txtPostalCode).sendKeys("500032");
		driver.findElement(btnContinue).click();
		driver.findElement(btnFinish).click();	
	}
	

}

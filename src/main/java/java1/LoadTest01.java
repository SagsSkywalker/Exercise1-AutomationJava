package java1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import SDET_java_maintenanceUnosquare.sdet_java.Program;

public class LoadTest01 {
	
	public WebDriver SetUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.apple.com.mx/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
	/*Driver Functions*/
	public void SendText(WebElement element, String value) 
	{
		element.sendKeys(value);
	}
	
	public void Click(WebElement element) 
	{
		element.click();
	}
	
	public void NavigateTo(WebDriver driver,String url) {
		driver.get(url);
	}
	
	public void ClickWhenEnabled(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/*Search and Text elements*/
	By MacButton = By.cssSelector("li.ac-gn-mac");
	By MacParaTi = By.xpath("//body/main[@id='main']/section[2]/div[1]/h2[1]");
	By SearchIcon = By.cssSelector("a.ac-gn-link-search");
	By SearchBox = By.xpath("//input[@id='ac-gn-searchform-input']");
	By SearchSubmit = By.cssSelector("#ac-gn-searchform-submit");
	
	/*Top Bar Elements*/
	By AppleIcon = By.xpath("//a[@id='ac-gn-firstfocus']");
	By iPadIcon = By.cssSelector("a.ac-gn-link-ipad");
	By iPhoneIcon = By.cssSelector("a.ac-gn-link-iphone");
	By WatchIcon = By.cssSelector("a.ac-gn-link-watch");
	By TVIcon = By.cssSelector("a.ac-gn-link-tv");
	By MusicIcon = By.cssSelector("a.ac-gn-link-music");
	By SuppIcon = By.cssSelector("a.ac-gn-link-support");
	By StoreIcon = By.cssSelector("a.ac-gn-link-bag");
	
	public static void main(String[] args) {
		
		LoadTest01 program = new LoadTest01();
		WebDriver driver = program.SetUp();
		WebElement element;
		
		element = driver.findElement(program.MacButton);
		program.Click(element);
		element = driver.findElement(program.MacParaTi);
		Assert.assertEquals(element.getAttribute("innerHTML"), "Encuentra la Mac<br class=\"large-hide medium-hide small-show\"> perfecta para ti.");
		element = driver.findElement(program.SearchIcon);
		program.Click(element);
		element = driver.findElement(program.SearchBox);
		program.SendText(element,"iPhone XR");
		element = driver.findElement(program.SearchSubmit);
		program.Click(element);
		Assert.assertEquals(driver.getTitle(), "iPhone XR - Apple (MX)");
		
		/*Validate Nav Bar*/
		element = driver.findElement(program.AppleIcon);
		program.ClickWhenEnabled(driver, element);
		element = driver.findElement(program.MacButton);
		program.ClickWhenEnabled(driver, element);
		element = driver.findElement(program.iPadIcon);
		program.ClickWhenEnabled(driver, element);
		element = driver.findElement(program.iPhoneIcon);
		program.ClickWhenEnabled(driver, element);
		element = driver.findElement(program.WatchIcon);
		program.ClickWhenEnabled(driver, element);
		element = driver.findElement(program.TVIcon);
		program.ClickWhenEnabled(driver, element);
		element = driver.findElement(program.MusicIcon);
		program.ClickWhenEnabled(driver, element);
		element = driver.findElement(program.SuppIcon);
		program.ClickWhenEnabled(driver, element);
		element = driver.findElement(program.SearchIcon);
		program.ClickWhenEnabled(driver, element);
		element = driver.findElement(program.StoreIcon);
		program.ClickWhenEnabled(driver, element);
	}
	
	

}

package JumiaTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginJumia {

	private static final WebDriver driver = null;

	@Test
	public void sanityTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jumia.com/");

		// Close Pop up
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/i")).click();
		driver.findElement(By.className("dy-lb-close")).click();

		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"account\"]/div[1]/a"));
		Actions action = new Actions((WebDriver) driver);
		action.moveToElement(element).build().perform();

		// Login Account

		driver.findElement(By.xpath("//*[@id=\"login-button\"]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"LoginForm_email\"]")).sendKeys("t3afolabi@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"LoginForm_password\"]")).sendKeys("Omolola1.1");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"form-account-login\"]/div[3]/div[1]/button")).click();
		Thread.sleep(3000);

		// ItemSEarch and VAlidation
		driver.findElement(By.xpath("//*[@id=\"header-search-input\"]")).sendKeys("pringles");
		driver.findElement(By.xpath("//*[@id=\"header-search-submit\"]")).click();

		Thread.sleep(5000);
		// Adding Item and checkingOut

		WebElement element1 = driver.findElement(By.xpath("/html/body/main/section/section[2]/div[14]/a"));
		Actions action1 = new Actions((WebDriver) driver);
		action1.moveToElement(element1).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/main/section/section[2]/div[14]/a/button")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"anon-popup\"]/div[2]/div[2]/a[2]")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[5]/div/a[2]")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"osh-opc-btn-save\"]/span")).click();
		
		//Close browser
		driver.close();
	}

}

package vudn.baitap.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BaitapSelenium_02 {
	public static void main(String[] args) {

		WebDriver driver;
		final String URL = "http://demo.guru99.com/test/newtours/register.php";
		final String username = "vudn";
		final String password = "123456";

		// Initial browser and navigate to URL
		System.setProperty("webdriver.chrome.driver", "/home/vudn/workspace/VuDN_BaitapSelenium/driver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);

		// Find element First Name
		WebElement txt_FirstName = driver.findElement(By.xpath("//input[@name='firstName']"));

		// Find element btn_Submit
		WebElement btn_Submit = driver.findElement(By.xpath("//input[@name='submit']"));

		// Input value using Action
		Actions action = new Actions(driver);
		action.click(txt_FirstName).sendKeys("Vu").sendKeys(Keys.TAB).sendKeys("Doan").sendKeys(Keys.TAB)
				.sendKeys("0905888888").sendKeys(Keys.TAB).sendKeys("vudn@gmail.com").sendKeys(Keys.TAB)
				.sendKeys("36 DTM").sendKeys(Keys.TAB).sendKeys("Thanh Khe").sendKeys(Keys.TAB).sendKeys("Thanh Khe")
				.sendKeys(Keys.TAB).sendKeys("51000").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(username)
				.sendKeys(Keys.TAB).sendKeys(password).sendKeys(Keys.TAB).sendKeys(password).click(btn_Submit).build()
				.perform();

		// Find element Note UserName label and check User name is displayed
		String expected = "Note: Your user name is " + username + ".";
		String actual = driver.findElement(By.xpath("//b[text()=' Note: Your user name is " + username + ".']"))
				.getText();

		if (expected.equals(actual)) {
			System.out.println("PASSED, " + actual + " is displayed ");
		} else {
			System.out.println("FAILED, Please check again");
		}

		// Find element sign_in link and click
		WebElement lnk_signin = driver.findElement(By.xpath("//a[@href='login.php']"));
		lnk_signin.click();

		// Find element Login User Name and input value
		WebElement txt_Login_Username = driver.findElement(By.xpath("//input[@name='userName']"));

		// Find element Login Submit and click
		WebElement btn_Login_Submit = driver.findElement(By.xpath("//input[@alt='Login']"));

		// Doing login with register account
		Actions action01 = new Actions(driver);
		action01.click(txt_Login_Username).sendKeys(username).sendKeys(Keys.TAB).sendKeys(password)
				.click(btn_Login_Submit).build().perform();

		driver.quit();

	}

}

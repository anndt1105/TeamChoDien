package vudn.baitap.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaitapSelenium_01 {

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

		// Find element First Name and input text
		WebElement txt_FirstName = driver.findElement(By.xpath("//input[@name='firstName']"));
		txt_FirstName.sendKeys("Vu");

		// Find element Last Name and input text
		WebElement txt_LastName = driver.findElement(By.xpath("//input[@name='lastName']"));
		txt_LastName.sendKeys("Doan");

		// Find element Phone and input text
		WebElement txt_Phone = driver.findElement(By.xpath("//input[@name='phone']"));
		txt_Phone.sendKeys("0905888888");

		// Find element Email and input text
		WebElement txt_Email = driver.findElement(By.xpath("//input[@name='userName']"));
		txt_Email.sendKeys("vudn@gmail.com");

		// Find element Address and input text
		WebElement txt_Address = driver.findElement(By.xpath("//input[@name='address1']"));
		txt_Address.sendKeys("36 DTM");

		// Find element City and input text
		WebElement txt_City = driver.findElement(By.xpath("//input[@name='city']"));
		txt_City.sendKeys("Da Nang");

		// Find element State and input text
		WebElement txt_State = driver.findElement(By.xpath("//input[@name='state']"));
		txt_State.sendKeys("Thanh Khe");

		// Find element PostalCode and input text
		WebElement txt_PostalCode = driver.findElement(By.xpath("//input[@name='postalCode']"));
		txt_PostalCode.sendKeys("51000");

		// Find element Country and select value
		WebElement dr_Country = driver.findElement(By.xpath("//select[@name='country']"));
		Select country = new Select(dr_Country);
		country.selectByValue("AUSTRIA");

		// Find element UserName and input value
		WebElement txt_UserName = driver.findElement(By.xpath("//input[@name='email']"));
		txt_UserName.sendKeys(username);

		// Find element Password and input value
		WebElement txt_Password = driver.findElement(By.xpath("//input[@name='password']"));
		txt_Password.sendKeys(password);

		// Find element ConfirmPassword and input value
		WebElement txt_ConfirmPassword = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
		txt_ConfirmPassword.sendKeys(password);

		// Find element Submit button and click
		WebElement btn_Submit = driver.findElement(By.xpath("//input[@name='submit']"));
		btn_Submit.click();
		
		// Find element Note UserName label and check User name is displayed
		String expected = "Note: Your user name is " + username + ".";
		String actual = driver.findElement(By.xpath("//b[text()=' Note: Your user name is " + username + ".']"))
				.getText();

		if (expected.equals(actual)) {
			System.out.println("PASSED, " + actual +" is displayed ");
		} else {
			System.out.println("FAILED, Please check again");
		}

		// Find element sign_in link and click
		WebElement lnk_signin = driver.findElement(By.xpath("//a[@href='login.php']"));
		lnk_signin.click();

		// Find element Login UserName and input value
		WebElement txt_Login_Username = driver.findElement(By.xpath("//input[@name='userName']"));
		txt_Login_Username.sendKeys(username);

		// Find element Login Password and input value
		WebElement txt_Login_Password = driver.findElement(By.xpath("//input[@name='password']"));
		txt_Login_Password.sendKeys(password);

		// Find element Login Submit and click
		WebElement btn_Login_Submit = driver.findElement(By.xpath("//input[@alt='Login']"));
		btn_Login_Submit.click();
		
		driver.quit();

	}

}

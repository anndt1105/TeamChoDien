import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestChap7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "E:\\Thuy\\Auto\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver","E:\\Thuy\\Auto\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		//set URL
		String baseURL="http://demo.guru99.com/test/newtours/register.php";
		
		//LaunchChrome and direct to URL
		driver.get(baseURL);
		
		Actions action = new Actions(driver);
		// set input value
				String firstName = "Minh Thuy";
				String lastName = "Tran";
				String phone = "0987654321";
				String email = "minhthuy100391@gmail.com";
				String address = "123 Nguyen Hoang";
				String city = "Da Nang";
				String state = "Da Nang";
				String postalCode = "010101";
				String userName = "minhthuytran";
				String password = "12345678";
				String cfmpassword = "12345678";
				
				//find and set value for elements
				action.sendKeys(driver.findElement(By.name("firstName")),firstName).sendKeys(Keys.TAB).perform();
				action.sendKeys(lastName).sendKeys(Keys.TAB).perform();
				action.sendKeys(phone).sendKeys(Keys.TAB).perform();
				action.sendKeys(email).sendKeys(Keys.TAB).perform();
				action.sendKeys(address).sendKeys(Keys.TAB).perform();
				action.sendKeys(city).sendKeys(Keys.TAB).perform();
				action.sendKeys(state).sendKeys(Keys.TAB).perform();
				action.sendKeys(postalCode).perform();
				
				Select countryElement = new Select(driver.findElement(By.name("country")));
				countryElement.selectByValue("VIETNAM");
				
				action.sendKeys(driver.findElement(By.name("email")),userName).sendKeys(Keys.TAB).perform();
				action.sendKeys(password).sendKeys(Keys.TAB).perform();
				action.sendKeys(cfmpassword).sendKeys(Keys.ENTER).perform();
				
				WebElement signInLink = driver.findElement(By.linkText("sign-in"));
				action.click(signInLink).build().perform();
				
				action.sendKeys(driver.findElement(By.name("userName")),userName).sendKeys(Keys.TAB).perform();;
				action.sendKeys(password).sendKeys(Keys.ENTER).perform();	
		
	}

}

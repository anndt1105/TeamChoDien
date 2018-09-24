package baitap;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Mouse_Keyboard_Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String exePath = "D:\\automationtest\\chromedriver_win32 (1)\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",exePath);
		WebDriver driver = new ChromeDriver();
		
		//Set baseUrl and launch browser
		String baseUrl = "http://demo.guru99.com/test/newtours/register.php";
		driver.get(baseUrl);
		
		// set input value
				String firstName = "NguyenDuc";
				String lastName = "Truong An";
				String phone = "09235123432";
				String email = "anndt1105@gmail.com";
				String address = "666 Nguyen Hoang";
				String city = "Da Nang";
				String state = "Da Nang";
				String postalCode = "010101";
				String userName = "anndt1105";
				String password = "12345678";
				String cfmpassword = "12345678";
		
		//find and set value for elements
				Actions action = new Actions(driver);
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

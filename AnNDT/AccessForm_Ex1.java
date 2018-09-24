package baitap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AccessForm_Ex1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/*String exePath = "D:\\geckodriver-v0.19.0-win64\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", exePath);
		WebDriver driver = new FirefoxDriver();*/
		
		String exePath = "D:\\automationtest\\chromedriver_win32 (1)\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",exePath);
		WebDriver driver = new ChromeDriver();
	
		
		String username = "anndt1105@gmail.com";
		String pass = "123456";
		
		//Set baseUrl and launch browser
		String baseUrl = "http://demo.guru99.com/test/newtours/register.php";
		driver.get(baseUrl);
		
		//Find and input information into Contact Information
		WebElement firstName = driver.findElement(By.name("firstName"));
		firstName.sendKeys("Nguyen Duc");
		
		WebElement lastName = driver.findElement(By.name("lastName"));
		lastName.sendKeys("Truong An");
		
		WebElement phone = driver.findElement(By.name("phone"));
		phone.sendKeys("0393455654");
		
		WebElement email = driver.findElement(By.id("userName"));
		email.sendKeys("anndt1105@gmail.com");
		
		//Find and input information into Mailing Information
		WebElement address = driver.findElement(By.name("address1"));
		address.sendKeys("314 Nguyen Hoang");
		
		WebElement city = driver.findElement(By.name("city"));
		city.sendKeys("Da Nang");
		
		WebElement state = driver.findElement(By.name("state"));
		state.sendKeys("Hai Chau");
		
		WebElement postalCode = driver.findElement(By.name("postalCode"));
		postalCode.sendKeys("00035");
		
		//Find and select option in SelectBox
		WebElement country = driver.findElement(By.name("country"));
		Select selectCountry = new Select(country);
		selectCountry.selectByVisibleText("VIETNAM");
		
		
		//Find and input information into User Information
		WebElement userName = driver.findElement(By.id("email"));
		userName.sendKeys(username);
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(pass);
		
		WebElement confirmPassword = driver.findElement(By.name("confirmPassword"));
		confirmPassword.sendKeys("123456");
		
		//Click button Submit
		WebElement submit = driver.findElement(By.name("submit"));
		submit.click();
		
		//Check if username is correct
		WebElement successText = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/font/b"));
		successText.getText();
		
		if (successText.getText().toLowerCase().contains(username.toLowerCase())) {
			System.out.println("---------Passed---------");
			
			//If user is correct click to link sign-in
			WebElement sign_in_link = driver.findElement(By.linkText("sign-in"));
			sign_in_link.click();
			
			//Sign-in to page
			WebElement loginName = driver.findElement(By.name("userName"));
			loginName.sendKeys(username);
			
			WebElement loginPass = driver.findElement(By.name("password"));
			loginPass.sendKeys(pass);
			
			WebElement loginBtn = driver.findElement(By.name("submit"));
			loginBtn.submit();
				
		}
		else System.out.println("--------Failed---------");;
		
		
		
		

	}

}

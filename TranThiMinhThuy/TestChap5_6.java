import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestChap5_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//find and set driver
		System.setProperty("webdriver.gecko.driver", "E:\\Thuy\\Auto\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//set URL
		String baseURL="http://demo.guru99.com/test/newtours/register.php";
		
		//LaunchChrome and direct to URL
		driver.get(baseURL);
		
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
		driver.findElement(By.name("firstName")).sendKeys(firstName);
		driver.findElement(By.name("lastName")).sendKeys(lastName);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("userName")).sendKeys(email);
		driver.findElement(By.name("address1")).sendKeys(address);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("postalCode")).sendKeys(postalCode);
		
		Select countryElement = new Select(driver.findElement(By.name("country")));
		countryElement.selectByValue("VIETNAM");
		
		driver.findElement(By.name("email")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirmPassword")).sendKeys(cfmpassword);
		
		//Click button Submit
		driver.findElement(By.name("submit")).click();
		
		//Check action Register
		String findName = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b")).getText();
		String findUsername = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/font/b")).getText();
		String nameUser = firstName+" "+lastName;
		if(findName.toLowerCase().contains(nameUser.toLowerCase()))
			System.out.println("====Name Register: Passed====");
		if (findUsername.toLowerCase().contains(userName.toLowerCase()))
			System.out.println("====Username Register: Passed====");
		else {
			System.out.println("====Username and Name Register: Failed====");
		}
//		String[] arrUsername = findUsername.split(" ");
//		if(findName.equals(nameRegist))
//			System.out.println("====Name Register: Passed");
//		else if (userName.equals(arrUsername[arrUsername.length-1])) {
//			System.out.println("====User Register: Passed");
//		}
//		else {
//			System.out.println("====Name Register: Failed"+userName+" va "+ arrUsername[arrUsername.length-1]);
//		}
		
		//Sign in action
		WebElement signInLink = driver.findElement(By.linkText("sign-in"));
		signInLink.click();
		//Input user name and pass
		driver.findElement(By.name("userName")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		
	}

}

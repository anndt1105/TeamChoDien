package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

public class BaiHai {
	public static void main(String[] args) {
		//Khai bao thuoc tinh
		String firstName = "Hoa";
		String[] info = new String[] {"Dang Cao", "01234567890", "caohoa@gmail.com",
				"16 Ly Thuong Kiet", "Da Nang", "Da Nang", "0000000", "caohoa13", "12345678"};
		
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		Actions action = new Actions(driver);
		
		//Di den guru99
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		
		//Dien thong tin
		WebElement fName = driver.findElement(By.name("firstName"));
		action.sendKeys(fName, firstName).sendKeys(Keys.TAB).build().perform();
		for(int i = 0; i <10; i++) {
			if(i == 7){
				action.sendKeys(Keys.TAB).build().perform();
			}
			if(i == 9){
				action.sendKeys(info[i-1]).sendKeys(Keys.TAB).build().perform();
				break;
			}	
			action.sendKeys(info[i]).sendKeys(Keys.TAB).build().perform();
		}
		WebElement country = driver.findElement(By.name("country"));
		Select countrySelect = new Select(country);
		countrySelect.selectByVisibleText("VIETNAM");
		
		//Submit
		WebElement submit = driver.findElement(By.name("submit"));
		action.sendKeys(submit, Keys.ENTER).build().perform();
		
		//Check name
		WebElement checkName = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b"));
		String nameIs = checkName.getText();
		if(nameIs.contains(firstName) && nameIs.contains(info[0])){
			//Sign in
			WebElement signIn = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font/a"));
			signIn.click();
			WebElement inPut = driver.findElement(By.name("userName"));
			action.sendKeys(inPut, info[7]).sendKeys(Keys.TAB).build().perform();
			action.sendKeys(info[8]).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		}
	}
}

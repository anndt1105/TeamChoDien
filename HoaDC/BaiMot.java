package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaiMot {
	public static void main(String[] args) {
		String firstName = "Hoa";
		String lastName = "Dang Cao";
		String phone = "01234567890";
		String mail = "caohoa@gmail.com";
		String address = "16 Ly Thuong Kiet";
		String city = "DaNang";
		String state ="Da Nang";
		String postalCode = "0000000";
		String userName = "caohoa13";
		String pass ="12345678";
		
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//di den guru99
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		
		//dien thong tin ca nhan
		WebElement fName = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input"));
		fName.sendKeys(firstName);
		
		WebElement lName = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/input"));
		lName.sendKeys(lastName);
		
		WebElement phoneNum = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/input"));
		phoneNum.sendKeys(phone);
		
		WebElement eMail= driver.findElement(By.xpath("//*[@id='userName']"));
		eMail.sendKeys(mail);
		
		WebElement add = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input"));
		add.sendKeys(address);
		
		WebElement citi = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td[2]/input"));
		citi.sendKeys(city);
		
		WebElement statE = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/input"));
		statE.sendKeys(state);
		
		WebElement postCode = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/input"));
		postCode.sendKeys(postalCode);
		
		WebElement country = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/select"));
		Select countrySelect = new Select(country);
		countrySelect.selectByVisibleText("VIETNAM");
		
		WebElement uName  = driver.findElement(By.id("email"));
		uName.sendKeys(userName);
		
		WebElement passW = driver.findElement(By.name("password"));
		passW.sendKeys(pass);
		
		WebElement rePass = driver.findElement(By.name("confirmPassword"));
		rePass.sendKeys(pass);
		
		WebElement submit = driver.findElement(By.name("submit"));
		submit.click();
		
		//Sign in
		WebElement checkName = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b"));
		String nameIs = checkName.getText();
		if(nameIs.contains(firstName) && nameIs.contains(lastName)){
			WebElement signIn = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font/a"));
			signIn.click();
		
			WebElement inputUName = driver.findElement(By.name("userName"));
			inputUName.sendKeys(userName);
		
			WebElement inputPass = driver.findElement(By.name("password"));
			inputPass.sendKeys(pass);
			
			WebElement submitSignIn = driver.findElement(By.name("submit"));
			submitSignIn.submit();
		}
	}
}

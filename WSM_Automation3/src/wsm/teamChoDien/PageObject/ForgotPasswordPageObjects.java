package wsm.teamChoDien.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPageObjects {
	
	private static WebElement element = null;
	
	//Finding element UI of Title
	public static WebElement txt_Title(WebDriver driver){
		element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/label"));
		return element;
	}
	
	//Finding element UI of user name field
	public static WebElement txt_Username(WebDriver driver){
		element = driver.findElement(By.id("user_email"));
		return element;
	}
	
	//Finding element UI of OK button
	public static WebElement btn_OK(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id='devise-forgot-password-form']/div[2]/button"));
		return element;
	}
	
	//Finding element UI of Cancel button
	public static WebElement btn_Cancel(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id='devise-forgot-password-form']/div[2]/a"));
		return element;
	}	
	
	//Finding element UI of Back to Login link
	public static WebElement link_BackToLogin(WebDriver driver){
		element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/a"));
		return element;
	}	
	
	// Finding element UI of Error message when Email is blank 
	public static WebElement msg_ErrorMessageEmailBlank(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='devise-forgot-password-form']/div[1]/p"));
		return element;
	}
}

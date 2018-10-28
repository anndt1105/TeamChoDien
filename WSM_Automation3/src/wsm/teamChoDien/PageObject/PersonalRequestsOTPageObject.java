package wsm.teamChoDien.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalRequestsOTPageObject {
	private static WebElement element = null;
	
	//Find title page Request Overtime
	public static WebElement txt_titleOT(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/h1"));
		return element;
	}
	
	//Find button Create Request Overtime 
	public static WebElement btn_createRequest(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[3]/a"));
		return element;
	}
	
	//Find button New request overtime
	public static WebElement txt_titleNewRequest(WebDriver driver) {
		element = driver.findElement(By.xpath("*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[1]/h3"));
		return element;
	}
	
	//Find field StaffName
	public static WebElement txb_staffName(WebDriver driver) {
		element = driver.findElement(By.id("employee_name"));
		return element;
	}
	//Find field Staff Code
	public static WebElement txb_staffCode(WebDriver driver) {
		element = driver.findElement(By.id("employee_code"));
		return element;
	}
	//Find field branch
	public static WebElement txb_branch(WebDriver driver) {
		element = driver.findElement(By.id("select2-chosen-1"));
		return element;
	}
	//Find field Group
	public static WebElement txb_group(WebDriver driver) {
		element = driver.findElement(By.id("select2-chosen-2"));
		return element;
	}
	//Find field other Group
	public static WebElement chb_otherGroup(WebDriver driver) {
		element = driver.findElement(By.id("choose_other_group"));
		return element;
	}
	//Find field Project
	public static WebElement txb_project(WebDriver driver) {
		element = driver.findElement(By.id("request_ot_project_name"));
		return element;
	}
	//Find field From
	public static WebElement txb_from(WebDriver driver) {
		element = driver.findElement(By.id("request_ot_from_time"));
		return element;
	}
	//Find field To
	public static WebElement txb_to(WebDriver driver) {
		element = driver.findElement(By.id("request_ot_end_time"));
		return element;
	}
	//Find field Reason
	public static WebElement txb_reason(WebDriver driver) {
		element = driver.findElement(By.id("request_ot_reason"));
		return element;
	}
	//Find field Reason
	public static WebElement btn_saveRequest(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"new_request_ot\"]/input[3]"));
		return element;
	}
}

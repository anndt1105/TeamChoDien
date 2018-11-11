package wsm.teamChoDien.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import wsm.teamChoDien.PageObject.DashboardPageObject;
import wsm.teamChoDien.PageObject.PersonalRequestsOTPageObject;
import wsm.teamChoDien.PageObject.WelcomePageObjects;

public class TransitionPageAction {
	public static void gotoLoginPage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(WelcomePageObjects.btn_Login(driver)));

		WelcomePageObjects.btn_Login(driver).click();
	}
	public static void gotoOvertimePage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.btn_personalRequest(driver)));
		
		DashboardPageObject.btn_personalRequest(driver).click();
		DashboardPageObject.btn_overtime(driver).click();
	}
	
	public static void gotoRequestOTPage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.btn_createRequest(driver)));

		PersonalRequestsOTPageObject.btn_createRequest(driver).click();
	}

}

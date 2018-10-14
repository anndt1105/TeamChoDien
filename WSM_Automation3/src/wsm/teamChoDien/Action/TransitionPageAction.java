package wsm.teamChoDien.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wsm.teamChoDien.PageObject.WelcomePageObjects;

public class TransitionPageAction {
	public static void gotoLoginPage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(WelcomePageObjects.btn_Login(driver)));

		WelcomePageObjects.btn_Login(driver).click();
	}

}

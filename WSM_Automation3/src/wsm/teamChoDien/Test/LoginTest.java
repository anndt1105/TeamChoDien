package wsm.teamChoDien.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import wsm.teamChoDien.Action.LoginAction;
import wsm.teamChoDien.Action.TransitionPageAction;
import wsm.teamChoDien.Utility.ConstantVariable;

public class LoginTest extends CommonTest {
	// Testcase01
		@Test
		public void b_loginWithValidAcount() throws Exception {

			// Go to Login Page
			TransitionPageAction.gotoLoginPage(driver);

			// Doing Login action with valid User name and password
			LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

			/*WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(CommonPage.lnk_WSMLogo(driver)));*/

			// Verify Result
			/*boolean expectedresult = CommonPage.lnk_WSMLogo(driver).isDisplayed();
			Assert.assertTrue(expectedresult);*/
	
		}

}

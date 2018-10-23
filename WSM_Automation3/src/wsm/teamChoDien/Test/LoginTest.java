package wsm.teamChoDien.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import wsm.teamChoDien.Action.ClosePopupDayOffAction;
import wsm.teamChoDien.Action.LoginAction;
import wsm.teamChoDien.Action.TransitionPageAction;
import wsm.teamChoDien.PageObject.DashboardPageObject;
import wsm.teamChoDien.Utility.ConstantVariable;

public class LoginTest extends CommonTest {
		// LOGIN_006
		@Test
		public void mess_loginWithValidAcount() throws Exception {

			// Go to Login Page
			TransitionPageAction.gotoLoginPage(driver);

			// Doing Login action with valid User name and password
			LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

			// Close popup Day off
			ClosePopupDayOffAction.closePopup(driver);
			
			//Get message
			String[] message=DashboardPageObject.mess_loginSuccess(driver).getText().split("\n");
			
			// Verify Result message successfully
			Assert.assertEquals(message[message.length-1], ConstantVariable.LOGIN_SUCCESSFULY_MESSAGE);
		}
		// LOGIN_007
		@Test
		public void title_loginWithValidAcount() throws Exception {

			// Go to Login Page
			TransitionPageAction.gotoLoginPage(driver);

			// Doing Login action with valid User name and password
			LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);
			
			Thread.sleep(1000);
			// Verify title of Tab
			Assert.assertEquals(driver.getTitle(),ConstantVariable.TAB_TITLE);
			
		}
		//TC LOGIN_008
		@Test
		public void back_loginWithValidAcount() throws Exception {

			// Go to Login Page
			TransitionPageAction.gotoLoginPage(driver);

			// Step 1+2: Doing Login action with valid User name and password
			LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

			Thread.sleep(1000);
			//Step 3: Click Back on browser
			driver.navigate().back();
			Thread.sleep(1000);
			
			// Verify Result message successfully
			Assert.assertEquals(driver.getTitle(),ConstantVariable.TAB_TITLE);
			
		}
		//TC LOGIN_009
		@Test
		public void newTab_loginWithValidAcount() throws Exception {

			// Go to Login Page
			TransitionPageAction.gotoLoginPage(driver);

			// Step 1+2: Doing Login action with valid User name and password
			LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);		
			Thread.sleep(1000);
			
			//Step 3+4+5:
		    driver.navigate().to("https://www.google.com/");
		    driver.navigate().to(ConstantVariable.URL);
		    
		    // Verify Result message successfully
			Assert.assertEquals(driver.getTitle(),ConstantVariable.TAB_TITLE);
			
		}

}

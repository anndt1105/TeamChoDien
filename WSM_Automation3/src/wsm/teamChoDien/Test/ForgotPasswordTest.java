package wsm.teamChoDien.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import wsm.teamChoDien.Action.TransitionPageAction;
import wsm.teamChoDien.PageObject.ForgotPasswordPageObjects;
import wsm.teamChoDien.PageObject.LoginPageObjects;
import wsm.teamChoDien.PageObject.WelcomePageObjects;
import wsm.teamChoDien.Utility.ConstantVariable;

public class ForgotPasswordTest extends CommonTest {
	//F001 ~ F004
	@Test
	public void checkComponent() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to reset password page by click on Forgot password link
		LoginPageObjects.link_ForgotPass(driver).click();

		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.txt_Title(driver)));

		// FOR_PASS 001
		// FOR_PASS 002~004
		// Check component

		// Title
		String title = ForgotPasswordPageObjects.txt_Title(driver).getText();
		Assert.assertEquals(ConstantVariable.FORGOTPASSWORD_TITLE, title);

		// Mail textbox
		Assert.assertTrue(ForgotPasswordPageObjects.txt_UserEmail(driver).isEnabled(), "Mail textbox failed");

		// OK button
		Assert.assertTrue(ForgotPasswordPageObjects.btn_OK(driver).isDisplayed(), "OK button failed");

		// Cancel button
		Assert.assertTrue(ForgotPasswordPageObjects.btn_Cancel(driver).isDisplayed(), "Cancel button failed");

		// Back to login link
		Assert.assertTrue(ForgotPasswordPageObjects.link_BackToLogin(driver).isDisplayed(),
				"Back to login link Failed");

		ForgotPasswordPageObjects.link_BackToLogin(driver).click();
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.btn_Login(driver)));

		Assert.assertTrue(LoginPageObjects.btn_Login(driver).isDisplayed(), "Click back to login link Failed");
	}
	
	//F005
	@Test
	public void requestSuccessfull() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to reset password page by click on Forgot password link
		LoginPageObjects.link_ForgotPass(driver).click();

		// FOR_PASS 005
		ForgotPasswordPageObjects.txt_UserEmail(driver).sendKeys(ConstantVariable.USERNAME);
		ForgotPasswordPageObjects.btn_OK(driver).click();
		Assert.assertEquals(ForgotPasswordPageObjects.msg_MessageSendSuccessfull(driver).getText(),
				ConstantVariable.SEND_SUCCESSFULL_MESSAGE, "FOR_PASS 005 Failed");
	}
	
	//F009 ~ F011
	@Test
	public void requestUnsuccessfull() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to reset password page by click on Forgot password link
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.btn_OK(driver)));

		// FOR_PASS 009
		ForgotPasswordPageObjects.btn_OK(driver).click();
		String actual_009 = ForgotPasswordPageObjects.msg_ErrorMessageEmailBlank(driver).getText();
		Assert.assertEquals(ConstantVariable.USERNAME_BLANK_MESSAGE, actual_009, "009_Click OK, mess appear Failed");

		// FOR_PASS 010
		ForgotPasswordPageObjects.txt_UserEmail(driver).sendKeys(ConstantVariable.USERNAME_INVALID);
		ForgotPasswordPageObjects.btn_OK(driver).click();
		String mess_010 = ForgotPasswordPageObjects.msg_ErrorMessageEmailBlank(driver).getText();
		Assert.assertEquals(ConstantVariable.USERNAME_INVALID_MESSAGE, mess_010, "010_Click OK, mess appear Failed");
		ForgotPasswordPageObjects.txt_UserEmail(driver).clear();

		// FOR_PASS 011
		ForgotPasswordPageObjects.txt_UserEmail(driver).sendKeys(ConstantVariable.USERNAME_NOT_EXIT);
		ForgotPasswordPageObjects.btn_OK(driver).click();
		String mess_011 = ForgotPasswordPageObjects.msg_emailNotFound(driver).getText();
		Assert.assertEquals(ConstantVariable.USERNAME_NOT_EXIST_MESSAGE, mess_011, "011_Click OK, mess appear Failed");
	}
}

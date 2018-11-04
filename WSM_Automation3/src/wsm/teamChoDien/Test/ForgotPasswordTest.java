package wsm.teamChoDien.Test;

import javax.swing.text.ChangedCharSetException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import wsm.teamChoDien.Action.SwitchChildWindown;
import wsm.teamChoDien.Action.TransitionPageAction;
import wsm.teamChoDien.PageObject.ChangePasswordPageObjects;
import wsm.teamChoDien.PageObject.ForgotPasswordPageObjects;
import wsm.teamChoDien.PageObject.LoginPageObjects;
import wsm.teamChoDien.PageObject.WelcomePageObjects;
import wsm.teamChoDien.PageObject.YopMailPageObject;
import wsm.teamChoDien.Utility.ConstantVariable;

public class ForgotPasswordTest extends CommonTest {

	// FOR_PASS_001
	@Test
	public void checkForgotPasswordLink() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Check Forgot password link
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.txt_Title(driver)));

		Assert.assertEquals(ForgotPasswordPageObjects.txt_Title(driver).getText(),
				ConstantVariable.FORGOTPASSWORD_TITLE);
	}

	// FOR_PASS_002
	// Title
	@Test
	public void checkForgotPasswordTitle() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to Forgot password page
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.txt_Title(driver)));

		// Check title
		Assert.assertEquals(ForgotPasswordPageObjects.txt_Title(driver).getText(),
				ConstantVariable.FORGOTPASSWORD_TITLE);
	}

	// Mail textbox
	@Test
	public void checkMailTextbox() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to Forgot password page
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.txt_UserEmail(driver)));

		// Check User mail textbox
		Assert.assertTrue(ForgotPasswordPageObjects.txt_UserEmail(driver).isEnabled());
	}

	// OK button
	@Test
	public void checkOKButtonOfForgotPassScr() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to Forgot password page
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.btn_OK(driver)));

		// Check OK button
		Assert.assertTrue(ForgotPasswordPageObjects.btn_OK(driver).isEnabled());
	}

	// Cancel Button
	@Test
	public void checkCancelButton() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to Forgot password page
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.btn_Cancel(driver)));

		// Check Cancel Button
		Assert.assertTrue(ForgotPasswordPageObjects.btn_Cancel(driver).isEnabled());
	}

	// Back to login link
	@Test
	public void checkBackToLoginLink() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to Forgot password page
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.link_BackToLogin(driver)));

		// Check Back to login link
		Assert.assertTrue(ForgotPasswordPageObjects.link_BackToLogin(driver).isDisplayed());
	}

	// FOR_PASS_004
	@Test
	public void checkClickBackToLoginLink() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to Forgot password page
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.link_BackToLogin(driver)));

		// Check Click Back to login link
		ForgotPasswordPageObjects.link_BackToLogin(driver).click();
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.btn_Login(driver)));

		// Check Login screen open successfully
		Assert.assertTrue(LoginPageObjects.btn_Login(driver).isEnabled());
	}

	// FOR_PASS_005
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

	// FOR_PASS 009
	@Test
	public void requestUnsuccessfullBlankEmail() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to reset password page by click on Forgot password link
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.btn_OK(driver)));

		// Verify that User is not able to Request forgot password with blank
		// Email
		ForgotPasswordPageObjects.btn_OK(driver).click();
		String actual_009 = ForgotPasswordPageObjects.msg_ErrorMessageEmailBlank(driver).getText();
		Assert.assertEquals(ConstantVariable.USERNAME_BLANK_MESSAGE, actual_009);

	}

	// FOR_PASS 010
	@Test
	public void requestUnsuccessfullValidEmail() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to reset password page by click on Forgot password link
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.btn_OK(driver)));

		// Verify that User is not able to Request forgot password with invaid
		// Email
		ForgotPasswordPageObjects.txt_UserEmail(driver).sendKeys(ConstantVariable.USERNAME_INVALID);
		ForgotPasswordPageObjects.btn_OK(driver).click();

		String mess_010 = ForgotPasswordPageObjects.msg_ErrorMessageEmailBlank(driver).getText();
		Assert.assertEquals(ConstantVariable.USERNAME_INVALID_MESSAGE, mess_010);
	}

	// FOR_PASS 011
	@Test
	public void requestUnsuccessfullEmailNotExist() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// Go to reset password page by click on Forgot password link
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.btn_OK(driver)));

		// Verify that User is not able to Request forgot password with valid
		// Email but not existing
		ForgotPasswordPageObjects.txt_UserEmail(driver).sendKeys(ConstantVariable.USERNAME_NOT_EXIT);
		ForgotPasswordPageObjects.btn_OK(driver).click();

		String mess_011 = ForgotPasswordPageObjects.msg_emailNotFound(driver).getText();
		Assert.assertEquals(ConstantVariable.USERNAME_NOT_EXIST_MESSAGE, mess_011);
	}

	// FOR_PASS_012 - Check Component Change Password Screen
	// Check Title
	@Test
	public void checkTitleChangePassword() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// go to Change Password page
		TransitionPageAction.gotoChangePasswordPage(driver);
		SwitchChildWindown.switchChildWindown(driver);
		wait.until(ExpectedConditions.visibilityOf(ChangePasswordPageObjects.lb_ChangePassword(driver)));

		// check Title
		Assert.assertEquals(ChangePasswordPageObjects.lb_ChangePassword(driver).getText(),
				ConstantVariable.CHANGE_PASSWORD_SCREEN_TITLE);
	}

	// Check Label New Password
	@Test
	public void checkLabelNewPassword() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// go to Change Password page
		TransitionPageAction.gotoChangePasswordPage(driver);
		SwitchChildWindown.switchChildWindown(driver);
		wait.until(ExpectedConditions.visibilityOf(ChangePasswordPageObjects.lb_NewPassword(driver)));

		// check New password label
		Assert.assertEquals(ChangePasswordPageObjects.lb_NewPassword(driver).getText(),
				ConstantVariable.NEW_PASSWORD_LABEL);
	}

	// Check New password textbox
	@Test
	public void checkNewPasswordTextbox() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// go to Change Password page
		TransitionPageAction.gotoChangePasswordPage(driver);
		SwitchChildWindown.switchChildWindown(driver);
		wait.until(ExpectedConditions.visibilityOf(ChangePasswordPageObjects.txb_NewPassword(driver)));

		// check New password textbox
		Assert.assertTrue((ChangePasswordPageObjects.txb_NewPassword(driver).isDisplayed()));
	}

	// Check Confirm new password label
	@Test
	public void checkLabelConfirmNewPassword() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// go to Change Password page
		TransitionPageAction.gotoChangePasswordPage(driver);
		SwitchChildWindown.switchChildWindown(driver);
		wait.until(ExpectedConditions.visibilityOf(ChangePasswordPageObjects.lb_ComfirmNewPassword(driver)));

		// check label Confirm NewPassword
		Assert.assertEquals(ChangePasswordPageObjects.lb_ComfirmNewPassword(driver).getText(),
				ConstantVariable.CONFIRM_NEW_PASSWORD_LABEL);
	}

	// check Confirm New password textbox
	@Test
	public void checkConfirmNewPasswordTextbox() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// go to Change Password page
		TransitionPageAction.gotoChangePasswordPage(driver);
		SwitchChildWindown.switchChildWindown(driver);
		wait.until(ExpectedConditions.visibilityOf(ChangePasswordPageObjects.txb_ConfirmNewPassword(driver)));

		// check Confirm New password textbox
		Assert.assertTrue((ChangePasswordPageObjects.txb_ConfirmNewPassword(driver).isDisplayed()));
	}

	@Test
	public void checkOKButtonOfChangePassScr() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// go to Change Password page
		TransitionPageAction.gotoChangePasswordPage(driver);
		SwitchChildWindown.switchChildWindown(driver);
		wait.until(ExpectedConditions.visibilityOf(ChangePasswordPageObjects.btn_OK(driver)));

		// check OK button
		Assert.assertTrue((ChangePasswordPageObjects.btn_OK(driver).isDisplayed()));
	}
}

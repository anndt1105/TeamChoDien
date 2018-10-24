package wsm.teamChoDien.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import wsm.teamChoDien.Action.InputEmail;
import wsm.teamChoDien.Action.TransitionPageAction;
import wsm.teamChoDien.PageObject.ForgotPasswordPageObjects;
import wsm.teamChoDien.PageObject.LoginPageObjects;
import wsm.teamChoDien.Utility.ConstantVariable;

public class ForgotPasswordTest extends CommonTest {

	@Test
	public void checkComponent() throws Exception {
		
		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		// Go to reset password page by click on Forgot password link
		TransitionPageAction.clickLinkForgotPassword(driver);

		Thread.sleep(3000);
		//FOR_PASS 001
		//FOR_PASS 002~004
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
		Assert.assertTrue(LoginPageObjects.btn_Login(driver).isDisplayed(),
				"Click back to login licnk Failed");
	}

	@Test
	public void requestSuccessfull() throws Exception {

		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		// Go to reset password page by click on Forgot password link
		TransitionPageAction.clickLinkForgotPassword(driver);
		
		// FOR_PASS 005
		InputEmail.inputEmail(driver, ConstantVariable.USERNAME);
		ForgotPasswordPageObjects.btn_OK(driver).click();
		Assert.assertEquals(ForgotPasswordPageObjects.msg_MessageSendSuccessfull(driver), 
				ConstantVariable.SEND_SUCCESSFULL_MESSAGE, "FOR_PASS 005 Failed");
	}
	@Test
	public void requestUnsuccessfull() throws Exception {
		
		// Go to login page
		TransitionPageAction.gotoLoginPage(driver);

		// Go to reset password page by click on Forgot password link
		TransitionPageAction.clickLinkForgotPassword(driver);
		Thread.sleep(2000);
		//FOR_PASS 009
		ForgotPasswordPageObjects.btn_OK(driver).click();
		String mess = ForgotPasswordPageObjects.msg_ErrorMessageEmailBlank(driver).getText();
		Assert.assertEquals(ConstantVariable.USERNAME_BLANK_MESSAGE, mess, "009_Click OK, mess appear Failed");
		
		//FOR_PASS 010
		InputEmail.inputEmail(driver, ConstantVariable.USERNAME_INVALID);
		ForgotPasswordPageObjects.btn_OK(driver).click();
		Assert.assertEquals(ConstantVariable.USERNAME_BLANK_MESSAGE, mess, "010_Click OK, mess appear Failed");
		
		//FOR_PASS 011
		InputEmail.inputEmail(driver, ConstantVariable.USERNAME_NOT_EXIT);
		ForgotPasswordPageObjects.btn_OK(driver).click();
		Assert.assertEquals(ConstantVariable.USERNAME_BLANK_MESSAGE, mess, "011_Click OK, mess appear Failed");
	}
}

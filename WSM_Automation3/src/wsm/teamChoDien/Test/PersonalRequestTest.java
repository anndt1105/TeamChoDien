package wsm.teamChoDien.Test;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import wsm.teamChoDien.Action.LoginAction;
import wsm.teamChoDien.Action.RequestOTAction;
import wsm.teamChoDien.Action.TransitionPageAction;
import wsm.teamChoDien.PageObject.LoginPageObjects;
import wsm.teamChoDien.PageObject.PersonalRequestsOTPageObject;
import wsm.teamChoDien.PageObject.RequestOvertimePageObject;
import wsm.teamChoDien.Utility.ConstantVariable;

public class PersonalRequestTest extends CommonTest {

	// PER_REQ_OT_018
	@Test
	public void invalid_requestInThePast() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/"
				+ (LocalDate.now().getMonthValue() - 1);
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";

		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		// Get message
		System.out.println("====" + PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).getText());

		System.out.println("====" + ConstantVariable.REQUEST_OT_DATE_IN_PAST_MESS);

		// Verify Result message successfully
		Assert.assertEquals(PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).getText(),
				ConstantVariable.REQUEST_OT_DATE_IN_PAST_MESS);
	}

	// PER_REQ_OT_019
	@Test
	public void invalid_requestProjectBlank() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + LocalDate.now().getMonthValue();
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";

		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID, " ",
				requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		// Get message
		boolean messDisplay = PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).isDisplayed();

		// Verify Result message successfully
		if (messDisplay = true) {
			Assert.assertEquals(PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).getText(),
					ConstantVariable.PROJECT_BLANK_MESS);
		} else {
			Assert.fail("Error message does not display");
		}
	}

	// PER_REQ_OT_020
	@Test
	public void invalid_requestFromDateBlank() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		
			// Input request OT
				ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + LocalDate.now().getMonthValue();
				ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
				String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";

				RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
						ConstantVariable.PROJECT_VALID, " ", requestDateTo, ConstantVariable.REASON_OT);

			// Get message
				boolean messDisplay = PersonalRequestsOTPageObject.mess_fromDATEBlank(driver).isDisplayed();

				// Verify Result message successfully
				if (messDisplay = true) {
					Assert.assertEquals(PersonalRequestsOTPageObject.mess_fromDATEBlank(driver).getText(),
							ConstantVariable.FROM_DATE_BLANK_MESS);
				} else {
					Assert.fail("Error message does not display");
				}
			}

	
	// PER_REQ_OT_021
	@Test
	public void invalid_requestToDateBlank() throws Exception {
		// Go to Login Page
				TransitionPageAction.gotoLoginPage(driver);

				// Doing Login action with valid User name and password
				LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

				// Go to request OT page
				TransitionPageAction.gotoOvertimePage(driver);
				TransitionPageAction.gotoRequestOTPage(driver);
		
			//Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, "", ConstantVariable.REASON_OT);

		// Get message
		boolean messDisplay = PersonalRequestsOTPageObject.mess_toDATEBlank(driver).isDisplayed();

		// Verify Result message successfully
		if (messDisplay = true) {
			Assert.assertEquals(PersonalRequestsOTPageObject.mess_toDATEBlank(driver).getText(),
					ConstantVariable.TO_DATE_BLANK_MESS);
		} else {
			Assert.fail("Error message does not display");
		}
		
		/*String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver)));
		
		

		// Get message
		String[] actual_message = PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver).getText().split("\n");

		// Verify Result message successfully
		Assert.assertEquals(actual_message[actual_message.length - 1],
				ConstantVariable.CREATE_REQUEST_OT_SUCCESSFULY_MESSAGE);*/
	}

	

	// PER_REQ_OT_022
	@Test
	public void invalid_requestReasonBlank() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/"
				+ (LocalDate.now().getMonthValue() - 1);
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";

		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, "");

		// Get message
		boolean messDisplay = PersonalRequestsOTPageObject.mess_reasonBlank(driver).isDisplayed();

		// Verify Result message
		if (messDisplay = true) {
			Assert.assertEquals(PersonalRequestsOTPageObject.mess_reasonBlank(driver).getText(),
					ConstantVariable.REASON_BLANK_MESS);
		} else {
			Assert.fail("Error message does not display");
		}
	}

	// PER_REQ_OT_023
	@Test
	public void invalid_duplicateRequest() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Create request OT in the first time
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		// Create request OT in the second time
		TransitionPageAction.gotoRequestOTPage(driver);
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);
		
		// Get message
		boolean messDisplay = PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).isDisplayed();

		// Verify Result message
		if (messDisplay = true) {
			Assert.assertEquals(PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).getText(),
					ConstantVariable.DUPLICATE_REQUEST_MESS);
		} else {
			Assert.fail("Error message does not display");
		}
	}
	
	// PER_REQ_OT_011
		@Test
		public void valid_NotCheckedOTGroup() throws Exception {
			// Go to Login Page
			TransitionPageAction.gotoLoginPage(driver);

			// Doing Login action with valid User name and password
			LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

			// Go to request OT page
			TransitionPageAction.gotoOvertimePage(driver);
			TransitionPageAction.gotoRequestOTPage(driver);

			// Input request OT
			ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
			ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
			String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
			String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
			RequestOTAction.requestOTGroup(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
					ConstantVariable.OT_GROUP_VALID, ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo,
					ConstantVariable.REASON_OT);

			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver)));

			// Get message
			String[] actual_message = PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver).getText().split("\n");

			// Verify Result message successfully
			Assert.assertEquals(actual_message[actual_message.length - 1],
					ConstantVariable.CREATE_REQUEST_OT_SUCCESSFULY_MESSAGE);
		}
			
	
	// PER_REQ_OT_012
		@Test
		public void valid_CheckedOTGroup() throws Exception {
			// Go to Login Page
			TransitionPageAction.gotoLoginPage(driver);

			// Doing Login action with valid User name and password
			LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

			// Go to request OT page
			TransitionPageAction.gotoOvertimePage(driver);
			TransitionPageAction.gotoRequestOTPage(driver);

			// Input request OT
			ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + LocalDate.now().getMonthValue();
			ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
			String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
			String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
			RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
					ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver)));
			

			// Get message
			String[] actual_message = PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver).getText().split("\n");

			// Verify Result message successfully
			Assert.assertEquals(actual_message[actual_message.length - 1],
					ConstantVariable.CREATE_REQUEST_OT_SUCCESSFULY_MESSAGE);
		}

	// PER_REQ_OT_013
	@Test
	public void valid_CurrentMonth() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver)));

		// Get message
		String[] actual_message = PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver).getText().split("\n");

		// Verify Result message successfully
		Assert.assertEquals(actual_message[actual_message.length - 1],
				ConstantVariable.CREATE_REQUEST_OT_SUCCESSFULY_MESSAGE);
	}

	// PER_REQ_OT_014
	@Test
	public void valid_FutureMonth() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/"
				+ (LocalDate.now().getMonthValue() + 1);
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver)));

		// Get message
		String[] actual_message = PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver).getText().split("\n");

		// Verify Result message successfully
		Assert.assertEquals(actual_message[actual_message.length - 1],
				ConstantVariable.CREATE_REQUEST_OT_SUCCESSFULY_MESSAGE);
	}

	// PER_REQ_OT_015
	@Test
	public void valid_RequestOTScreenDisplay() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(RequestOvertimePageObject.lb_title(driver)));

		// Verify that Request OT screen is displayed
		String actual_title = RequestOvertimePageObject.lb_title(driver).getText();
		String expected_title = ConstantVariable.REQUEST_OT_SCREEN_TITLE;
		Assert.assertEquals(actual_title, expected_title);
	}
	
	//PERSONAL_REQUEST_001
	@Test
	public void loginSessionOTPage() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		
		// Verify that Request OT screen is displayed
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(RequestOvertimePageObject.lb_title(driver)));
		String actual_title = RequestOvertimePageObject.lb_title(driver).getText();
		String expected_title = ConstantVariable.REQUEST_OT_SCREEN_TITLE;
		Assert.assertEquals(actual_title, expected_title);
	}
	
	//PERSONAL_REQUEST_002
	@Test
	public void noLoginSessionOTPage() throws Exception {
		// Go to request OT page by direct URL
		driver.get(ConstantVariable.OT_URL);
		
		//Verify Login page displays
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.txt_title(driver)));

		//Check Title
		String title = LoginPageObjects.txt_title(driver).getText();
		Assert.assertEquals(title, "LOGIN");		
	}
	
	//PERSONAL_REQUEST_003
	@Test
	public void requestOTPagedisplays() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);
		
		//Check title
		String title = PersonalRequestsOTPageObject.txt_titleOT(driver).getText();
		Assert.assertEquals(title, ConstantVariable.OT_title);
	}
	
	//PERSONAL_REQUEST_004
	@Test
	public void requestOTComponent() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		TransitionPageAction.gotoRequestOTPage(driver);
		
	}
}

package wsm.teamChoDien.Test;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import wsm.teamChoDien.Action.LoginAction;
import wsm.teamChoDien.Action.RequestOTAction;
import wsm.teamChoDien.Action.TransitionPageAction;
import wsm.teamChoDien.PageObject.DashboardPageObject;
import wsm.teamChoDien.PageObject.LoginPageObjects;
import wsm.teamChoDien.PageObject.PersonalRequestsOTPageObject;
import wsm.teamChoDien.PageObject.RequestOvertimePageObject;
import wsm.teamChoDien.Utility.ConstantVariable;

public class PersonalRequestTest extends CommonTest {

	// PER_REQ_OT_018
	@Test
	public void TC18_invalid_requestInThePast() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/"
				+ (LocalDate.now().getMonthValue() - 1);
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";

		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		// Because system is not validate in this case so this code to Delete request
		// for run another case below.
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		RequestOvertimePageObject.btn_deleteRequest(driver).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();

		// Get message when system validate on this case
		boolean messDisplay = PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).isDisplayed();

		// Verify Result message successfully
		if (messDisplay = true) {
			Assert.assertEquals(messDisplay, ConstantVariable.REQUEST_OT_DATE_IN_PAST_MESS);
		} else {
			Assert.fail("Error message does not display");
		}

	}

	// PER_REQ_OT_019
	@Test
	public void TC19_invalid_requestProjectBlank() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
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
	public void TC20_invalid_requestFromDateBlank() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
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
	public void TC21_invalid_requestToDateBlank() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";

		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, "", ConstantVariable.REASON_OT);
		PersonalRequestsOTPageObject.txb_to(driver).clear();

		// Get message
		boolean messDisplay = PersonalRequestsOTPageObject.mess_toDATEBlank(driver).isDisplayed();

		// Verify Result message successfully
		if (messDisplay = true) {
			Assert.assertEquals(PersonalRequestsOTPageObject.mess_toDATEBlank(driver).getText(),
					ConstantVariable.TO_DATE_BLANK_MESS);
		} else {
			Assert.fail("Error message does not display");
		}

	}

	// PER_REQ_OT_022
	@Test
	public void TC22_invalid_requestReasonBlank() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
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
	public void TC23_invalid_duplicateRequest() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Create request OT in the first time
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + (LocalDate.now().getDayOfMonth() - 1);
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		// Create request OT in the second time
		DashboardPageObject.popup_CloseDayOff(driver).click();
		TransitionPageAction.gotoRequestOTPage(driver);
		Thread.sleep(1000);
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

	// PER_REQ_OT_024
	@Test
	public void TC24_invalid_workingTimeRequest() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Create request OT in the first time
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + (LocalDate.now().getDayOfMonth() - 1);
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 13:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 16:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		// Because system is not validate in this case so this code to Delete request
		// for run another case below.
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		RequestOvertimePageObject.btn_deleteRequest(driver).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();

		// Get message when system validate this case
		boolean messDisplay = PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).isDisplayed();

		// Verify Result message
		if (messDisplay = true) {
			Assert.assertEquals(PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).getText(),
					ConstantVariable.WORKINGTIME_REQUEST_MESS);
		} else {
			Assert.fail("Error message does not display");
		}
	}

	// PER_REQ_OT_011
	@Test
	public void TC11_valid_NotCheckedOTGroup() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + (LocalDate.now().getDayOfMonth() - 2);
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOTGroup(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.OT_GROUP_VALID, ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo,
				ConstantVariable.REASON_OT);

		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver)));

		// Get message
		String[] actual_message = PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver).getText().split("\n");

		// Verify Result message successfully
		Assert.assertEquals(actual_message[actual_message.length - 1],
				ConstantVariable.CREATE_REQUEST_OT_SUCCESSFULY_MESSAGE);
	}

	// PER_REQ_OT_012
	@Test
	public void TC12_valid_CheckedOTGroup() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + LocalDate.now().getMonthValue();
		ConstantVariable.REQUEST_OT_DATE = "/" + (LocalDate.now().getDayOfMonth()-3);
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		// WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver)));

		// Get message
		String[] actual_message = PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver).getText().split("\n");

		// Verify Result message successfully
		Assert.assertEquals(actual_message[actual_message.length - 1],
				ConstantVariable.CREATE_REQUEST_OT_SUCCESSFULY_MESSAGE);
	}

	// PER_REQ_OT_013
	@Test
	public void TC13_valid_CurrentMonth() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);
		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + (LocalDate.now().getDayOfMonth()-4);
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		// WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver)));

		// Get message
		String[] actual_message = PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver).getText().split("\n");

		// Verify Result message successfully
		Assert.assertEquals(actual_message[actual_message.length - 1],
				ConstantVariable.CREATE_REQUEST_OT_SUCCESSFULY_MESSAGE);
	}

	// PER_REQ_OT_014
	@Test
	public void TC14_valid_FutureMonth() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/"
				+ (LocalDate.now().getMonthValue() + 1);
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		// WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver)));

		// Get message
		String[] actual_message = PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver).getText().split("\n");

		// Verify Result message successfully
		Assert.assertEquals(actual_message[actual_message.length - 1],
				ConstantVariable.CREATE_REQUEST_OT_SUCCESSFULY_MESSAGE);
	}

	// PER_REQ_OT_015
	@Test
	public void TC15_valid_RequestOTScreenDisplay() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + (LocalDate.now().getDayOfMonth()-5);
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		// Close day off popup
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		wait.until(ExpectedConditions.visibilityOf(RequestOvertimePageObject.lb_title(driver)));

		// Verify that Request OT screen is displayed
		String actual_title = RequestOvertimePageObject.lb_title(driver).getText();
		String expected_title = ConstantVariable.REQUEST_OT_SCREEN_TITLE;
		Assert.assertEquals(actual_title, expected_title);
	}

	// PERSONAL_REQUEST_001
	@Test
	public void TC1_loginSessionOTPage() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));

		// Verify that Request OT screen is displayed
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(RequestOvertimePageObject.lb_title(driver)));
		String actual_title = RequestOvertimePageObject.lb_title(driver).getText();
		String expected_title = ConstantVariable.REQUEST_OT_SCREEN_TITLE;
		Assert.assertEquals(actual_title, expected_title);
	}

	// PERSONAL_REQUEST_002
	@Test
	public void TC2_noLoginSessionOTPage() throws Exception {
		// Go to request OT page by direct URL
		driver.get(ConstantVariable.OT_URL);

		// Verify Login page displays
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.txt_title(driver)));

		// Check Title
		// String title = LoginPageObjects.txt_title(driver).getText();
		Assert.assertTrue(LoginPageObjects.btn_Login(driver).isDisplayed());
		;
	}

	// PERSONAL_REQUEST_003
	@Test
	public void TC3_requestOTPagedisplays() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Check title
		String title = PersonalRequestsOTPageObject.txt_titleNewRequest(driver).getText();
		Assert.assertEquals(title, ConstantVariable.OT_title);
	}

	// PERSONAL_REQUEST_004
	@Test
	public void TC4_groupEnable() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_group(driver)));

		// Verify that "Group" field is uneditable
		Assert.assertTrue(PersonalRequestsOTPageObject.txb_group(driver).isDisplayed());
	}

	// Check staff Name enable
	@Test
	public void TC04_staffNameEnable() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_staffName(driver)));

		// Verify that "Staff name" field is uneditable
		Assert.assertTrue(PersonalRequestsOTPageObject.txb_staffName(driver).isDisplayed());
	}

	// Check staff code enable
	@Test
	public void TC4_staffCodeEnable() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_staffCode(driver)));

		// Verify that "Staff code" field is uneditable
		Assert.assertTrue(PersonalRequestsOTPageObject.txb_staffCode(driver).isDisplayed());
	}

	// Check Branch enable
	@Test
	public void TC4_checkBranchEable() throws Exception {

		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_branch(driver)));

		// Verify that "Branch" data is correct
		Assert.assertTrue(PersonalRequestsOTPageObject.txb_branch(driver).isDisplayed());
	}

	// Check can check Do you OT for other group?
	@Test
	public void TC4_checkOtherGroup() throws Exception {

		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.chb_OTGroup(driver)));

		// Verify that can check Do you OT for other group?
		Assert.assertTrue(PersonalRequestsOTPageObject.chb_OTGroup(driver).isDisplayed());
	}

	// Check project enable
	@Test
	public void TC4_ProjectEable() throws Exception {

		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_project(driver)));

		// Verify that "Project" data is correct
		Assert.assertTrue(PersonalRequestsOTPageObject.txb_project(driver).isDisplayed());
	}

	// Check From enable
	@Test
	public void TC4_FromEable() throws Exception {

		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_from(driver)));

		// Verify that "From" data is correct
		Assert.assertTrue(PersonalRequestsOTPageObject.txb_from(driver).isDisplayed());
	}

	// Check To field enable
	@Test
	public void TC4_ToEable() throws Exception {

		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_to(driver)));

		// Verify that "From" data is correct
		Assert.assertTrue(PersonalRequestsOTPageObject.txb_to(driver).isDisplayed());
	}

	// PER_REQ_OT_005
	@Test
	public void TC5_checkboxDefault() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Verify that Do you OT for other group? checkbox is unselected by
		// default
		Assert.assertFalse(PersonalRequestsOTPageObject.chb_OTGroup(driver).isSelected());
	}

	// PER_REQ_OT_006
	// Check data staff Name
	@Test
	public void TC6_staffNameCorrect() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_staffName(driver)));

		// Verify that "Staff name" data is correct
		Assert.assertEquals(PersonalRequestsOTPageObject.txb_staffName(driver).getAttribute("value"),
				ConstantVariable.STAFF_NAME);
	}

	// PER_REQ_OT_007
	// Check data staff code
	@Test
	public void TC7_staffCodeCorrect() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_staffCode(driver)));

		// Verify that "Staff code" data is correct
		Assert.assertEquals(PersonalRequestsOTPageObject.txb_staffCode(driver).getAttribute("value"),
				ConstantVariable.STAFF_CODE);
	}

	// PER_REQ_OT_008
	// Check data Branch
	@Test
	public void TC8_checkBranch() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_branch(driver)));

		// Verify that "Branch" data is correct
		Assert.assertEquals(PersonalRequestsOTPageObject.txb_branch(driver).getAttribute("value"),
				ConstantVariable.BRANCH_VALID);
	}

	// PER_REQ_OT_009
	@Test
	public void TC9_clickOTForOtherGroupCheckbox() throws Exception {

		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.chb_OTGroup(driver)));

		// Click on Do you OT for other group checkbox
		PersonalRequestsOTPageObject.chb_OTGroup(driver).click();

		// Verify the displaying of Group other drop down
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.drd_OTGroup(driver)));
		Assert.assertTrue(PersonalRequestsOTPageObject.drd_OTGroup(driver).isDisplayed());
	}

	// PER_REQ_OT_010
	// @Test
	public void TC10_checkGroup() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Verify that "Group" dropdown list displays with correct data when
		// clicking on "Group" dropdown list
		Assert.assertEquals(PersonalRequestsOTPageObject.txb_group(driver).getAttribute("value"),
				ConstantVariable.GROUP_VALID);
	}
}

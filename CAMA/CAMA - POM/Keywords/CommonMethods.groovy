import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*
import org.eclipse.core.runtime.Assert as Assert

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



class CommonMethods {

	public static WebDriver driver;
	public static final int IMPLICIT_WAIT=10;
	public static final int EXPLICIT_WAIT=20;

	/**
	 * Refresh browser
	 */
	@Keyword
	public static refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	public static clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	public static List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}


	/**
	 * Print all from an array
	 * @param ar
	 */
	@Keyword
	public static void print(String[] ar) {
		for(int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
	}


	/**
	 * this method will return an object of Explicit wait with time set to 20 sec
	 *
	 * @return WebDriverWait
	 */
	@Keyword
	public static WebDriverWait getWait() {
		WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
		return wait;
	}

	/**
	 * this method will wait until given element becomes clickable
	 *
	 * @param element
	 */
	@Keyword
	public static void waitForClickability(WebElement element) {
		getWait().until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method waits for element to be visible
	 *
	 * @param element
	 */
	@Keyword
	public static void waitForVisibility(WebElement element) {
		getWait().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Method waits for alert to be present
	 */
	@Keyword
	public static void waitForAlert() {
		getWait().until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * this method will return an Object of JavascriptExecutor
	 *
	 * @return JavascriptExecutor
	 */
	@Keyword
	public static JavascriptExecutor getJSExecutor() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	/**
	 * this method will click using JavascriptExecutor
	 *
	 * @param element
	 */
	@Keyword
	public static void jsClick(WebElement element) {
		getJSExecutor().executeScript("arguments[0].click();", element);
	}

	/**
	 *
	 * @param pattern
	 * @return
	 */
	@Keyword
	public static String getTimeStamp(String pattern) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * This method will click on radio buttons or checkboxes by the given list of
	 * webelements and value
	 *
	 * @param radioOrCheckBoxes
	 * @param value
	 */
	@Keyword
	public static void clickRadioOrCheckbox(List<WebElement> radioOrCheckBoxes, String value) {
		String actualValue;
		for (WebElement radioOrCheckbox : radioOrCheckBoxes) {
			actualValue = radioOrCheckbox.getAttribute("value").trim();
			if (radioOrCheckbox.isEnabled() && actualValue.equals(value)) {
				jsClick(radioOrCheckbox);
				break;
			}
		}
	}

	/**
	 * This method will select an option from the dropdown by given webelement and
	 * visible text value
	 *
	 * @param dd
	 * @param visibleTextOrValue
	 */
	@Keyword
	public static void selectDDValue(WebElement dd, String visibleTextOrValue) {
		try {
			Select select = new Select(dd);
			List<WebElement> options = select.getOptions();
			for (WebElement option : options) {
				if (option.getText().equals(visibleTextOrValue)) {
					select.selectByVisibleText(visibleTextOrValue);
					break;
				}
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will select an option from the dropdown by the given webelement
	 * and index value
	 *
	 * @param dd
	 * @param index
	 */
	@Keyword
	public static void selectDDValue(WebElement dd, int index) {
		try {

			Select select = new Select(dd);
			List<WebElement> options = select.getOptions();

			int size = options.size();

			if (size > index) {
				select.selectByIndex(index);
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will switch to a frame by given frame webelement
	 *
	 * @param iFrame
	 */
	@Keyword
	public static void switchToFrame(WebElement iFrame) {
		try {
			driver.switchTo().frame(iFrame);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will switch to a frame by given index
	 *
	 * @param frameIndex
	 */
	@Keyword
	public static void switchToFrame(int frameIndex) {
		try {
			driver.switchTo().frame(frameIndex);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will switch to a frame by given frame name or id
	 *
	 * @param frameIndex
	 */
	@Keyword
	public static void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will switch to a child window
	 */
	@Keyword
	public static void switchToChildWindow() {

		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}

	/*
	 * This method will accept a simple alert
	 */
	@Keyword
	public static void Alert() {
		Alert alert = driver.switchTo().alert();
		waitForAlert();
		alert.accept();
	}

	/**
	 * This method hanldes confirmation alerts
	 */
	@Keyword
	public static void confirmationAlert() {
		Alert alert = driver.switchTo().alert();
		waitForAlert();
		alert.dismiss();
	}

	/**
	 * This method handles prompt alerts
	 */
	@Keyword
	public static void promptAlert(String key) {
		Alert alert = driver.switchTo().alert();
		waitForAlert();
		alert.sendKeys(key);
		alert.accept();
	}

	/**
	 * This method returns object of actions class type
	 */
	@Keyword
	public static Actions action() {
		Actions action = new Actions(driver);
		return action;
	}

	/**
	 * This Method moves the mouse's cursor to desire webelement
	 *
	 * @param target
	 */
	@Keyword
	public static void moveMouseTo(WebElement target) {
		try {
			action().moveToElement(target).perform();
		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method clicks on desired element using the Actions class click method
	 *
	 * @param target
	 */
	@Keyword
	public static void actionClick(WebElement target) {
		try {
			action().moveToElement(target).click().perform();
		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will double click on specified webelement
	 *
	 * @param target
	 */
	@Keyword
	public static void doubleClick(WebElement target) {
		try {
			action().doubleClick(target).perform();
		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will right click on specified webelement
	 *
	 * @param target
	 */
	@Keyword
	public static void rightClick(WebElement target) {
		try {
			action().contextClick(target).perform();
		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will drag a desired draggable element and drop it on desired
	 * droppable target
	 *
	 * @param draggable
	 * @param droppable
	 */
	@Keyword
	public static void dragAndDrop(WebElement draggable, WebElement droppable) {
		try {
			action().dragAndDrop(draggable, droppable).perform();
		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}
	}

	static String jsonFile;
	/**
	 * Read from a json file
	 * @param fileName
	 * @return
	 */
	@Keyword
	public static String readJson(String fileName) {

		try {
			jsonFile = new String(Files.readAllBytes(Paths.get(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonFile;
	}

	/**
	 * Verifies parcel number contains dashes and it is broken down into 5 parts (4-3-2-1-3)
	 * @param parcelNumber
	 */

	@Keyword
	public static void parcelNumberFormatVerifier(String parcelNumber) {

		String parcelFirst = parcelNumber.substring(0, 5);

		String parcelSecond = parcelNumber.substring(5, 9);

		String parcelThird = parcelNumber.substring(9, 12);

		String parcelFourth = parcelNumber.substring(12, 14);

		String parcelFifth = parcelNumber.substring(14, 17);

		String[] dashes = parcelNumber.split('[-]');

		int format = dashes.length;

		assertTrue(format == 5);

		assertTrue(parcelFirst.contains('-'));

		assertTrue(parcelSecond.contains('-'));

		assertTrue(parcelThird.contains('-'));

		assertTrue(parcelFourth.contains('-'));
	}

	//	@Keyword
	//	public static boolean isDateWithinRange(String dateToValidate, String dateFormat) {
	//
	//		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	//		sdf.setLenient(false);
	//		try {
	//
	//			Date currentDate =  Calendar.getInstance().getTime();
	//
	//			Date date = sdf.parse(dateToValidate);
	//
	//			Calendar monthsBeforeCurrentDate = Calendar.getInstance().
	//			monthsBeforeCurrentDate.add(Calendar.MONTH, -7);
	//
	//			/****************** Verbose *****************************/
	//			System.out.println("\n\ncurrentdDate : "
	//					+ currentDate);
	//			System.out.println("currentDateBeforeXMonths : "
	//					+ monthsBeforeCurrentDate.getTime());
	//			System.out.println("dateToValidate : "
	//					+ dateToValidate);
	//			/*********************************************************/
	//
	//			if (date.before(monthsBeforeCurrentDate.getTime())){
	//				System.out.println("More than 7 months ");
	//				return true;
	//			}else {
	//				System.out.println("Less than 7 months");
	//				return false;
	//			}
	//		} catch (ParseException e) {
	//			e.printStackTrace();
	//			return false;
	//		}
	//	}
}
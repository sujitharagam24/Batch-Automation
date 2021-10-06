import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import org.eclipse.core.runtime.Assert as Assert
import static org.junit.Assert.*

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Verify Date column items are sorted
 * @author bilguun.amarsaikhan
 *
 */

WebUI.callTestCase(findTestCase('My Work Page/US8761 - As a SBC user I can sort items in my work queue/Access the My Work Page'), [:], FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver()

ArrayList<Date> obtainedList = new ArrayList<Date>()

/*Locating the table rows' webelements and Initializing an array the size of the rows */
List<WebElement> dateList = WebUI.findWebElements(findTestObject('Object Repository/My Work Page Objectory/US0002/Date column items'), 5);

for (WebElement we : dateList) {
    obtainedList.add(we.getText());
	//System.out.println(we.getText());
}

Collections.sort(obtainedList, new Comparator<String>() {
	DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	@Override
	public int compare(String o1, String o2) {
	try {
	  return format.parse(o1).compareTo(format.parse(o2));
		} catch (ParseException e) {
		  throw new IllegalArgumentException(e);
		}
	}
	});

/* Click on Name Column to sort the items */
WebUI.click(findTestObject('Object Repository/My Work Page Objectory/US0002/Date column'))

ArrayList<Date> sortedList = new ArrayList<Date>()

List<WebElement> elementsList = WebUI.findWebElements(findTestObject('Object Repository/My Work Page Objectory/US0002/Date column items'), 5);

for (WebElement we : elementsList) {
    sortedList.add(we.getText()); 
	//System.out.println(we.getText());
}

assertEquals(obtainedList, sortedList)

WebUI.closeBrowser()
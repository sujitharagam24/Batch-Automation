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
 *
 * Search results Verify Recorded Date Column is Sorted on Search Result Page
 * @author menen.Desta
 *
 */


WebUI.callTestCase(findTestCase('Search Page/US8325 - As an SBC user I can search records in transfer workflow/Access the Search Page'), 
    [:], FailureHandling.STOP_ON_FAILURE)

def recDocNumber = '20190254823'

WebUI.setText(findTestObject('Object Repository/Search Page Objectory/US8325/Page_Transfer Workflow/Record Doc number From field'),
	recDocNumber)

def to = '20190254855'

WebUI.setText(findTestObject('Object Repository/Search Page Objectory/US8325/Record Doc Number To Field'), to)

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search Button'))

WebDriver driver = DriverFactory.getWebDriver()

ArrayList<String> obtainedList = new ArrayList<String>()


List<WebElement> dateList = WebUI.findWebElements(findTestObject('Object Repository/Search Page Objectory/US8325/Recorded Date Column Name Items'), 
    4)

for (WebElement we : dateList) {
    obtainedList.add(we.getText() 
        )
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


WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Recorded Date Column Name'))

ArrayList<String> sortedList = new ArrayList<String>()

List<WebElement> elementsList = WebUI.findWebElements(findTestObject('Object Repository/Search Page Objectory/US8325/Recorded Date Column Name Items'), 
    4)

for (WebElement we : elementsList) {
    sortedList.add(we.getText() 
        )
}

assertEquals(obtainedList, sortedList)

WebUI.closeBrowser()

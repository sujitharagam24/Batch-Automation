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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import static org.junit.Assert.*
import org.eclipse.core.runtime.Assert as Assert

/**
 * Script to sort the Queues by the "Req Type" column
 * @author Elian Blanco
 */

/*Instance of Selenium Webdriver (allows the use of selenium script within Katalon) */
WebDriver driver = DriverFactory.getWebDriver();

/*Locating the table rows' webelements and Initializing an array the size of the rows */
List<WebElement> QueueRows = driver.findElements(By.xpath('(//table[@class=\'mud-table-root\'])[1]/tbody/tr'));
String[] beforeSort_row = new String[QueueRows.size()];

/*Getting the text into the array */
for (int i = 0; i < QueueRows.size(); i++) {
	(beforeSort_row[i]) = QueueRows.get(i).getText().trim();
}

/*Clicking on the column header to sort the queue*/
WebElement reqTypeBtn = driver.findElement(By.xpath('(//span[@class=\'mud-button-root mud-table-sort-label\'])[7]'));
reqTypeBtn.click();

/*locating the table rows' webelement after sorting and initializing another array the size of the rows*/
QueueRows = driver.findElements(By.xpath('(//table[@class=\'mud-table-root\'])[1]/tbody/tr'));
String[] afterSortByreqType_row= new String[QueueRows.size()];

/*Getting the text into the array*/
for (int i = 0; i < QueueRows.size(); i++) {
	(afterSortByreqType_row[i]) = QueueRows.get(i).getText().trim();
}

/*Printing the sorted table */
CustomKeywords.'com.utility.CommonMethods.print'(afterSortByreqType_row);

/*Asserting that the column data after clicking on column header
 * is not the same as before */
assertNotEquals(beforeSort_row, afterSortByreqType_row);

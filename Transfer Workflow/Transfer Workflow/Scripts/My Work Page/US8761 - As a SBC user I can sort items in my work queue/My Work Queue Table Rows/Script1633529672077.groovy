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
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import static org.junit.Assert.*
import org.eclipse.core.runtime.Assert

/**
 * List all rows that are displayed in the Work Queues table
 * @author michele.jazo
 *
 */

WebUI.callTestCase(findTestCase('My Work Page/US8761 - As a SBC user I can sort items in my work queue/Access the My Work Page'), [:], FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver();

// list of table rows
List<WebElement> tableRowData= driver.findElements(By.xpath("(//table[@class='mud-table-root'])[1]/tbody/tr"));
String[] row = new String[tableRowData.size()];

// iterating over rows in the table and getting the text
for(int i=0; i < tableRowData.size(); i++) {
	row[i] =  tableRowData.get(i).getText().trim();
}

// print out all rows from Work Queues table
CustomKeywords.'com.utility.CommonMethods.print'(row);

// Asserting table rows are not empty
Assert.isNotNull(row);

WebUI.closeBrowser();
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
import com.utility.CommonMethods

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

WebUI.openBrowser(GlobalVariable.baseURL)
WebUI.maximizeWindow()
WebUI.click(findTestObject('Search Page Objectory/US8325/Dashboard Search Menu'))
WebUI.click(findTestObject('Search Page Objectory/US8325/Date Picker/input_To_mud-input-slot mud-input-root mud-_a991a4'))

WebUI.clearText(findTestObject('Object Repository/Search Page Objectory/US8325/Page_Transfer Workflow/Recorded Date From'))
WebUI.clearText(findTestObject('Object Repository/Search Page Objectory/US8325/Page_Transfer Workflow/Recorded Date To'))

WebUI.setText(findTestObject('Search Page Objectory/US8325/Date Picker/input_To_mud-input-slot mud-input-root mud-_a991a4'), 
    eventDateFrom1)

WebUI.click(findTestObject('Search Page Objectory/US8325/span_Search'))


WebDriver driver = DriverFactory.getWebDriver();
List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class='mud-table-root']/tbody/tr"));
String[] row = new String[tableRows.size()];

for(int i=0; i < tableRows.size(); i++) {
	row[i] = tableRows.get(i).getText();
}

CustomKeywords.'com.utility.CommonMethods.print'(row)

Assert.isNotNull(row)


WebUI.closeBrowser()
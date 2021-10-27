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
import static org.junit.Assert.*
import org.eclipse.core.runtime.Assert as Assert
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import static org.junit.Assert.*
import org.eclipse.core.runtime.Assert as Assert
import com.kms.katalon.core.testobject.TestObject as TestObject
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement

/**
 * Validation check occurs for Number field on the Accessor Panel 
 * @author bilguun.amarsaikhan
 *
 */
WebUI.openBrowser(GlobalVariable.baseURL, FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver();

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search tab'))

def numberValue = '15295';

WebUI.setText(findTestObject('Object Repository/Search Page Objectory/US8325/Tract Number field'), numberValue)

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search Button'))

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Open button for Number Field'))

WebUI.waitForPageLoad(10)

// Click on Assessor Information Title to open the section

WebUI.click(findTestObject('Workflow History Page/Feature 8308/Test Case8366/Assessor Information title'))

// Get the value of Event Date field 

def existingNumberValue = WebUI.getAttribute(findTestObject('Object Repository/Worksheet Page Objectory/US8478/Number field'), 'value')

/* Verify Event Dates are matching */
assertTrue(existingNumberValue.equals(numberValue));

WebUI.closeBrowser()
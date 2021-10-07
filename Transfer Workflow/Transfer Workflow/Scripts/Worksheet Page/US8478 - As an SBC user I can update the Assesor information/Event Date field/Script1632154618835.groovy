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
 * Validation check occurs for Recorded Date field on the Accessor Panel 
 * @author bilguun.amarsaikhan
 *
 */
WebUI.openBrowser(GlobalVariable.baseURL, FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver();

WebUI.maximizeWindow()

WebUI.click(findTestObject('Workflow History Page/US8314/Access the Workflow History Page/My Work Tab'))

WebUI.click(findTestObject('Workflow History Page/US8314/Access the Workflow History Page/svg_List'))

WebUI.waitForPageLoad(10)

WebUI.waitForElementVisible(findTestObject('Object Repository/Workflow History Page/US8314/Access the Workflow History Page/text'), 10);

/* Get the value of Recorded Date field */

def eventDate = WebUI.getText(findTestObject('Worksheet Page Objectory/US8478/Event Date'));

// Locate open button and click to open Worksheet Page

WebElement openButton = driver.findElement(By.xpath('(//span[@class=\'mud-icon-button-label\'])[81]'))

openButton.click();

// Click on Assessor Information Title to open the section

WebUI.click(findTestObject('Object Repository/Workflow History Page/Feature 8308/Test Case8366/Recorder Information title'))

// Get the value of Event Date field 

// def docNumber2 = driver.findElement(By.xpath("(//input[@type='text'])[13]")).getAttribute("value")

def eventDate2 = WebUI.getAttribute(findTestObject('Worksheet Page Objectory/US8478/Event Date on Assessor'), 'value')

/* Verify Event Dates are matching */
assertTrue(eventDate.equals(eventDate2))

//WebUI.closeBrowser()
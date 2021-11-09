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
 * Validation check occurs for Grantee and Grantor fields on the Recorder Panel 
 * @author bilguun.amarsaikhan
 *
 */
WebUI.openBrowser(GlobalVariable.baseURL, FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver();

WebUI.maximizeWindow()

//Click on My Work Tab

WebUI.click(findTestObject('Workflow History Page/US8314/Access the Workflow History Page/My Work Tab'))

//WebUI.waitForPageLoad(10)

//Click on Bankrupties button

WebUI.waitForElementVisible(findTestObject('Object Repository/Worksheet Page Objectory/Feature8308 - Recorded Information on Worksheet Page/Rush text'), 10);

WebUI.click(findTestObject('Object Repository/Worksheet Page Objectory/Feature8308 - Recorded Information on Worksheet Page/Bankruptcies List button'))

// Locate open button and click to open Worksheet Page

WebUI.click(findTestObject('Object Repository/Worksheet Page Objectory/Feature8308 - Recorded Information on Worksheet Page/Open button'))

// Click on Recorder Information Title to open the section

WebUI.click(findTestObject('Object Repository/Workflow History Page/Feature 8308/Test Case8366/Recorder Information title'))

// Click on Read Only option

//WebUI.click(findTestObject('Object Repository/Worksheet Page Objectory/Feature8308 - Recorded Information on Worksheet Page/Read Only'))

// Get the value of Grantee Owner field

def granteeOwner = WebUI.getAttribute(findTestObject('Object Repository/Worksheet Page Objectory/Feature8308 - Recorded Information on Worksheet Page/Grantee Owner'), 'value')

// Get the value of Grantee Name field 

def granteeName = WebUI.getAttribute(findTestObject('Object Repository/Worksheet Page Objectory/Feature8308 - Recorded Information on Worksheet Page/Grantee Name'), 'value')

//Next Step is to get Grantee Name and Owner on Workflow History Page by clicking on Status button and verify

WebUI.closeBrowser()
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
 * 
 * Home Page
 * @author bilguun.amarsaikhan
 *
 */

WebUI.openBrowser(GlobalVariable.baseURL, FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver()

WebUI.maximizeWindow()

// Click on Home button
WebUI.click(findTestObject('Object Repository/Home Page Objectory/US0001/Home button'))

// Get the text of h5 title
def actualHomeTitle = WebUI.getText(findTestObject('Object Repository/Home Page Objectory/US0001/h5_Hello, San Bernardino'))

def expectedHomeTitle = 'Hello, San Bernardino!'

// Verify page title is matching with expected
assertTrue(actualHomeTitle.equals(expectedHomeTitle))

// Click on My Work Tab
WebUI.click(findTestObject('Object Repository/Workflow History Page/US8314/Access the Workflow History Page/My Work Tab'))

// Get the text of h5 title 
<<<<<<< HEAD
def actualMyWorkTitle = WebUI.getText(findTestObject('Object Repository/My Work Page Objectory/US0002/My Work title'))
=======
def actualMyWorkTitle = WebUI.getText(findTestObject('Object Repository/My Work Page Objectory/US8761/My Work title'))
>>>>>>> 0ae875d8ff8af99bb4358cd08ebdcb83ef94cb8d

def expectedMyWorkTitle = 'My Work'

assertTrue(actualMyWorkTitle.equals(expectedMyWorkTitle))

// Click on Search Tab
WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Page_Transfer Workflow/div_Search'))

// Get the text of h5 title
def actualSearchTitle = WebUI.getText(findTestObject('Object Repository/Search Page Objectory/US8325/Search Title'))

def expectedSearchTitle = 'Search Criteria'

assertTrue(actualSearchTitle.equals(expectedSearchTitle))


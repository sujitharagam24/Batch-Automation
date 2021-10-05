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
 * Access the Recorder Information Panel on the Workflow History Page through Search Page  by History Button
 * @author bilguun.amarsaikhan
 *
 */
WebUI.openBrowser(GlobalVariable.baseURL, FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver()

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Page_Transfer Workflow/div_Search'))

WebUI.waitForPageLoad(10)

WebUI.waitForElementVisible(findTestObject('Object Repository/Search Page Objectory/US8325/Page_Transfer Workflow/Recorded Date From'), 10);

def dateValue = '09/21/2020'

WebUI.setText(findTestObject('Object Repository/Search Page Objectory/US8325/Page_Transfer Workflow/Recorded Date From'), 
    dateValue)

WebUI.click(findTestObject('Search Page Objectory/US8325/Search tab'))

WebUI.waitForPageLoad(10)

//WebUI.waitForElementVisible(findTestObject('Object Repository/Workflow History Page/Feature/Test Case8366/History button'), 10);

WebUI.click(findTestObject('Object Repository/Workflow History Page/Feature/Test Case8366/History button'))

WebUI.click(findTestObject('Object Repository/Workflow History Page/Feature/Test Case8366/Recorder Information title'))

def sectionTitle = 'Recorder Information'

def existingTitle = WebUI.getText(findTestObject('Object Repository/Workflow History Page/Feature/Test Case8366/Recorder Information title'))

assertTrue(sectionTitle.equals(existingTitle))

WebUI.closeBrowser()


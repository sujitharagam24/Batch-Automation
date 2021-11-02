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
import com.kms.katalon.core.testobject.TestObject as TestObject


/**
 *
 * Access the Workflow History Page and verify all the data on Assessor Information Panel match the search result data
 * @author bilguun.amarsaikhan
 *
 */

WebUI.openBrowser(GlobalVariable.baseURL, FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver();

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Page_Transfer Workflow/div_Search'))

WebUI.waitForPageLoad(10)

WebUI.waitForElementVisible(findTestObject('Object Repository/Search Page Objectory/US8325/Record Date From Input'), 10);

def dateValue = "09212020";

WebUI.setText(findTestObject('Object Repository/Search Page Objectory/US8325/Record Date From Input'), dateValue);

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search Button'));

WebUI.waitForElementVisible(findTestObject('Object Repository/Workflow History Page/Feature 8308/Test Case8366/History button'), 10);

//Get each of the inputs on the Search Result page 
def recordedDocOnSearch = WebUI.getText(findTestObject('Object Repository/Workflow History Page/US8480/RecordedDoc on Search'))

def docTypeOnSearch =  WebUI.getText(findTestObject('Object Repository/Workflow History Page/US8480/Doc Type on Search'))

def recordedDateOnSearch =  WebUI.getText(findTestObject('Object Repository/Workflow History Page/US8480/Recorded Date on Search'))

def leadAPNonSearch = WebUI.getText(findTestObject('Object Repository/Workflow History Page/US8480/Lead APN on Search'))

def tractOnSearch = WebUI.getText(findTestObject('Object Repository/Workflow History Page/US8480/Tract number or Parcel on Search'))

WebElement historybtn = driver.findElement(By.xpath('(//span[@class=\'mud-icon-button-label\'])[17]'))

historybtn.click();

WebUI.click(findTestObject('Object Repository/Workflow History Page/Feature 8308/Test Case8366/Assessor Information title'));

//Get each of the inputs on the Workflow History page
def recordedDocAIWH = WebUI.getAttribute(findTestObject('Object Repository/Workflow History Page/US8480/Recorded Doc AI on WH'), 'value')

def docTypeOnAIWH =  WebUI.getAttribute(findTestObject('Workflow History Page/US8480/Doc TYpe AI WH'), 'value')

def recordedDateOnAIWH =  WebUI.getAttribute(findTestObject('Object Repository/Workflow History Page/Feature 8308/Test Case8366/Event Date AI WH'), 'value')

def leadAPNonAIWH = WebUI.getAttribute(findTestObject('Object Repository/Workflow History Page/Feature 8308/Test Case8366/Lead APN AI Wh'), 'value')

def tractOnAIWH = WebUI.getAttribute(findTestObject('Object Repository/Workflow History Page/Feature 8308/Test Case8366/Tract number AI WH'), 'value')

assertTrue(recordedDocOnSearch.equals(recordedDocAIWH))
assertTrue(docTypeOnSearch.equals(docTypeOnAIWH))
assertTrue(recordedDateOnSearch.equals(recordedDateOnAIWH))
assertTrue(leadAPNonSearch.equals(leadAPNonAIWH))
assertTrue(tractOnSearch.equals(tractOnAIWH))

WebUI.closeBrowser();
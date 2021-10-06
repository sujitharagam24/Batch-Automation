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
 * Access the My Work Page
 * @author bilguun.amarsaikhan
 *
 */

WebUI.openBrowser(GlobalVariable.baseURL, FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver();

WebUI.maximizeWindow()

WebUI.click(findTestObject('Workflow History Page/US8314/Access the Workflow History Page/My Work Tab'))

def actualTitle  = WebUI.getText(findTestObject('Object Repository/My Work Page Objectory/US0002/My Work title'));

def expectedTitle = 'My Work';

def actualQueueTitle  = WebUI.getText(findTestObject('Object Repository/My Work Page Objectory/US0002/Work Queues Title'));

def expectedQueueTitle = 'Work Queues';

def actualQueueContentTitle  = WebUI.getText(findTestObject('Object Repository/My Work Page Objectory/US0002/Work Queue Contents Title'));

def exptectedQueueContentTitle = 'Work Queue Contents';

assertTrue(actualTitle.equals(expectedTitle));

assertTrue(actualQueueTitle.equals(expectedQueueTitle));

assertTrue(actualQueueContentTitle.equals(exptectedQueueContentTitle));


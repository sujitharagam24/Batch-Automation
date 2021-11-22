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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

/**
 * Click on Complete Radio button to complete a document on Workflow section
 * @author bilguun.amarsaikhan
 *
 */
WebUI.callTestCase(findTestCase('Workflow History Page/US8314 - As an SBC user I can complete a document in Transfer workflow/Access the Workflow History Page'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver();

/* Click on Workflow panel to expand*/
WebUI.click(findTestObject('Object Repository/Workflow History Page/Workflow Panel'))

/* Check Complete Radio button */
WebUI.click(findTestObject('Workflow History Page/US8314/Workflow Section/Complete Radio button'))

def clickedText = WebUI.getText(findTestObject('Workflow History Page/US8314/Workflow Section/Radio button text'))

def selectedText = "Complete"

/* Verify checked option is selected */
assertTrue(selectedText.contains(clickedText))

/*When Complete is selected 'Complete/DNP' drop down is enabled to select an option*/
/*Click on 'Complete/DNP' dropdown and select an option*/
WebUI.click(findTestObject('Object Repository/Workflow History Page/US8314/Workflow Section/Complete and DNP'))

WebUI.click(findTestObject('Object Repository/Workflow History Page/US8314/Workflow Section/Sales CPT with Sale'))

/*Verify buttons are enabled*/

WebElement wRUSH = driver.findElement(By.xpath('(//*[text()=\'Update WS w/RUSH\'])'))
assertTrue(wRUSH.isEnabled());

WebElement updateWS = driver.findElement(By.xpath('(//*[text()=\'Update WS\'])'))
assertTrue(updateWS.isEnabled());

WebUI.closeBrowser()


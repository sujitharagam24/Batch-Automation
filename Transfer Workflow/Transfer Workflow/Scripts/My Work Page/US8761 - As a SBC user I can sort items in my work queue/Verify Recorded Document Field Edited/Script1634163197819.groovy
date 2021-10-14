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
import org.eclipse.core.runtime.Assert as Assert
import static org.junit.Assert.*

/**
 *
 * Search results Verify Recorded Document Field Edited on the Accessor Panel
 * @author menen.Desta
 *
 */

WebUI.callTestCase(findTestCase('My Work Page/US8761 - As a SBC user I can sort items in my work queue/Access the My Work Page'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/My Work Page Objectory/US8761/Work Queue Document Open'));

WebUI.click(findTestObject('Object Repository/My Work Page Objectory/US8761/Work Queue Accessor Panel'));

WebUI.setText(findTestObject('Object Repository/My Work Page Objectory/US8761/Work Queues Record Doc Number Field'), 
    '5548@@@!!!abc123')

WebUI.click(findTestObject('Object Repository/My Work Page Objectory/US8761/Update Button'));

def expectedMsg = 'Recorded Document Number must not exceed 13 characters';

def actualMsg = WebUI.getText(findTestObject('Object Repository/My Work Page Objectory/US8761/Validation Message'));

assertTrue(actualMsg.contains(expectedMsg));

WebUI.closeBrowser();


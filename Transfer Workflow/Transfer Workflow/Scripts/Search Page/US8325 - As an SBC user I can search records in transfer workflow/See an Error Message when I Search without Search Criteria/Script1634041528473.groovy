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
import com.kms.katalon.core.testobject.TestObject as TestObject
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Verify error message when search without any input
 * @author bilguun.amarsaikhan
 *
 */

WebUI.callTestCase(findTestCase('Search Page/US8325 - As an SBC user I can search records in transfer workflow/Access the Search Page'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/button_Search'))

def expectedPopUpWindowTitle = 'Message from webpage';

def actualPopUpWindowTitle = WebUI.getText(findTestObject('Object Repository/Search Page Objectory/US8325/Pop up window title'));

assertTrue(expectedPopUpWindowTitle.equals(actualPopUpWindowTitle));

def expectedPopUpWindowMSG = 'You must supply search criteria.';

def actualPopUpWindowMGS = WebUI.getText(findTestObject('Object Repository/Search Page Objectory/US8325/Pop up window MSG'));

assertTrue(expectedPopUpWindowMSG.equals(actualPopUpWindowMGS));

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/OK button on PO up window'))

assertEquals(true, WebUI.verifyElementNotPresent(findTestObject('Object Repository/Search Page Objectory/US8325/OK button on PO up window'), 20));

WebUI.closeBrowser()

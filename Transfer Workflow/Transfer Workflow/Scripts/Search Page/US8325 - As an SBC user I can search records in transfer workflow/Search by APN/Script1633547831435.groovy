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

/**
 *
 * Access Search Page and search by APN
 * @author michele.jazo
 *
 */

WebUI.callTestCase(findTestCase('Search Page/US8325 - As an SBC user I can search records in transfer workflow/Access the Search Page'), 
    [:], FailureHandling.STOP_ON_FAILURE)

def apnNumber = '0333032190000';

WebUI.setText(findTestObject('Search Page Objectory/US8325/Search APN'), 
   apnNumber)

WebUI.click(findTestObject('Search Page Objectory/US8325/Search Button'))

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/td_20120470301'))

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/td_20200268028'))

RecordedDoc1 = WebUI.getText(findTestObject('Object Repository/Search Page Objectory/US8325/td_20120470301'))

compare = "20120470301"

WebUI.verifyMatch(RecordedDoc1, compare, false)

RecordedDoc2 = WebUI.getText(findTestObject('Object Repository/Search Page Objectory/US8325/td_20200268028'))

compare = "20200268028"

WebUI.verifyMatch(RecordedDoc2, compare, false)

def existingApnNumber = WebUI.getText(findTestObject('Object Repository/Search Page Objectory/US8325/td_0333-032-19-0000'))

existingApnNumber = existingApnNumber.replaceAll('-', '');

WebUI.verifyMatch(apnNumber, existingApnNumber, false)

WebUI.closeBrowser()


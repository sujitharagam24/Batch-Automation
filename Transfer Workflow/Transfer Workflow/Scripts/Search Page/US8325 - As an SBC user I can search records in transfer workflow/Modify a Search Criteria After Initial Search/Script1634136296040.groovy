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
import static org.junit.Assert.*
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
 * Search results Modify a Search Criteria After Initial Search
 * @author menen.Desta
 *
 */

WebUI.callTestCase(findTestCase('Search Page/US8325 - As an SBC user I can search records in transfer workflow/Access the Search Page'), 
    [:], FailureHandling.STOP_ON_FAILURE)

def recDocNumber = '20190254823'

WebUI.setText(findTestObject('Object Repository/Search Page Objectory/US8325/Page_Transfer Workflow/Record Doc number From field'), 
    recDocNumber);

def to = '20190254833'

WebUI.setText(findTestObject('Object Repository/Search Page Objectory/US8325/Record Doc Number To Field'),
	to);

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search Button'));

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search Criteria'));

WebUI.setText(findTestObject('Object Repository/Search Page Objectory/US8325/Search Trac Number'),
	'5994');

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search Button'));

def expectedMsg = '1-1';

def actualMsg = WebUI.getText(findTestObject('Object Repository/Search Page Objectory/US8325/Search Result 1 Message'));

assertTrue(actualMsg.contains(expectedMsg));

WebUI.closeBrowser();










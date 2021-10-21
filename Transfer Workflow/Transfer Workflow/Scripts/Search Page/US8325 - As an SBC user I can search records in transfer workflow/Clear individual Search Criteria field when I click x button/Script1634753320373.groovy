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

WebUI.callTestCase(findTestCase('Search Page/US8325 - As an SBC user I can search records in transfer workflow/Access the Search Page'), 
    [:], FailureHandling.STOP_ON_FAILURE)

def inputValue = '123456789';

// Recorded Doc # From field
WebUI.setText(findTestObject('Object Repository/Search Page Objectory/US8325/Page_Transfer Workflow/Record Doc number From field'), inputValue);

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search Criteria title'));

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/x button on search'));

assertTrue(WebUI.getText(findTestObject('Object Repository/Search Page Objectory/US8325/Page_Transfer Workflow/Recorded Date From')).isEmpty());

// Recorded Doc # To field
WebUI.setText(findTestObject('Object Repository/Search Page Objectory/US8325/Record Doc Number To Field'), inputValue);

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search Criteria title'));

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/x button on search'));

assertTrue(WebUI.getText(findTestObject('Object Repository/Search Page Objectory/US8325/Record Doc Number To Field')).isEmpty());

// Asr Doc # From field
WebUI.setText(findTestObject('Object Repository/Search Page Objectory/US8325/Asr Doc number From field'), inputValue);

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search Criteria title'));

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/x button on search'));

assertTrue(WebUI.getText(findTestObject('Object Repository/Search Page Objectory/US8325/Asr Doc number From field')).isEmpty());

// Asr Doc # To field
WebUI.setText(findTestObject('Object Repository/Search Page Objectory/US8325/Asr Doc number To field'), inputValue);

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search Criteria title'));

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/x button on search'));

assertTrue(WebUI.getText(findTestObject('Object Repository/Search Page Objectory/US8325/Asr Doc number To field')).isEmpty());

// Grantee field
WebUI.setText(findTestObject('Object Repository/Search Page Objectory/US8325/Grantee field'), inputValue);

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search Criteria title'));

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/x button on search'));

assertTrue(WebUI.getText(findTestObject('Object Repository/Search Page Objectory/US8325/Grantee field')).isEmpty());

// Grantor field
WebUI.setText(findTestObject('Object Repository/Search Page Objectory/US8325/Grantor field'), inputValue);

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search Criteria title'));

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/x button on search'));

assertTrue(WebUI.getText(findTestObject('Object Repository/Search Page Objectory/US8325/Grantor field')).isEmpty());

// Tract # field
WebUI.setText(findTestObject('Object Repository/Search Page Objectory/US8325/Search Trac Number'), inputValue);

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search Criteria title'));

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/x button on search'));

assertTrue(WebUI.getText(findTestObject('Object Repository/Search Page Objectory/US8325/Search Trac Number')).isEmpty());

// APN field
WebUI.setText(findTestObject('Object Repository/Search Page Objectory/US8325/Search APN'), inputValue);

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search Trac Number'));

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/x button on search'));

assertTrue(WebUI.getText(findTestObject('Object Repository/Search Page Objectory/US8325/Search APN')).isEmpty());

WebUI.closeBrowser();
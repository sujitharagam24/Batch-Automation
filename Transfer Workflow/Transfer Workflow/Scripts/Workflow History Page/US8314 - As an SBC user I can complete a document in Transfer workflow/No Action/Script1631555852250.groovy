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

/**
 * Click on No Action Radio button on Workflow section
 * @author bilguun.amarsaikhan
 *
 */
WebUI.callTestCase(findTestCase('Workflow History Page/US8314 - As an SBC user I can complete a document in Transfer workflow/Access the Workflow History Page'), 
    [:], FailureHandling.STOP_ON_FAILURE)

/* Check No Action Radio button */
WebUI.click(findTestObject('Workflow History Page/US8314/Workflow Section/No action radio button'))

def clickedText = WebUI.getText(findTestObject('Workflow History Page/US8314/Workflow Section/Radio button text'))

def selectedText = WebUI.getText(findTestObject('Object Repository/Workflow History Page/US8314/Workflow Section/Selected Option text'))

/* Verify checked option is selected */
//assertTrue(selectedText.contains(clickedText))

WebUI.closeBrowser()


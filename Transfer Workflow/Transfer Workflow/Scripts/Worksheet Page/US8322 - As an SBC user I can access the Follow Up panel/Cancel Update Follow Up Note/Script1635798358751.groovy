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
import com.kms.katalon.core.testobject.TestObject as TestObject

/**
 *
 * Access the Follow Up panel on the Worksheet page
 * Update a note and select option to cancel it
 * @author michele.jazo
 *
 */
	
WebUI.callTestCase(findTestCase('Worksheet Page/US8322 - As an SBC user I can access the Follow up panel/Access the Follow Up panel'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Follow Up Panel/span_Add a Note'))

WebUI.click(findTestObject('Follow Up Panel/svg_Update'))

WebUI.setText(findTestObject('Follow Up Panel/textarea_Comment'), 'Here is an edited comment.  Here is some more information that I can include in the update.')

WebUI.click(findTestObject('Follow Up Panel/span_Cancel'))

WebUI.click(findTestObject('Follow Up Panel/td_This is an edit'))

expected = "This"

result = WebUI.getText(findTestObject('Object Repository/Follow Up Panel/td_This is an edit'))

if (result.contains('This')) {
       result = 'This'
}

assertEquals(expected, result)

WebUI.closeBrowser()

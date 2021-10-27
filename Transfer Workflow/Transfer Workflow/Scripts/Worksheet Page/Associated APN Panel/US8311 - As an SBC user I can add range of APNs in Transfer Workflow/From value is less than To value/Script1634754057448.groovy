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
 * Access the Worksheet Page through My Work tab
 * Verify From value must be less than To value when adding an APN Range
 * @author michele.jazo
 *
 */

WebUI.callTestCase(findTestCase('Worksheet Page/Associated APN Panel/US8310 - As an SBC user I can add single APN in Transfer Workflow/Access the Worksheet and APN Panel'),
	[:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('APN Panel/p_Add APN'))

WebUI.click(findTestObject('Object Repository/APN Panel/APN Range/input_Add as Range_RadioOption'))

WebUI.click(findTestObject('APN Panel/APN Range/input_FromAPN_Range'))

WebUI.setText(findTestObject('APN Panel/APN Range/input_FromAPN_Range'),
	'9')

WebUI.setText(findTestObject('APN Panel/APN Range/input_ToAPN_Range'),
	'1')

WebUI.click(findTestObject('Object Repository/APN Panel/button_Add APN'))

msg = WebUI.getText(findTestObject('Object Repository/APN Panel/div_Associated APN added'))

System.out.println(msg)

if (!(msg.toString().contains('FROM value must be less than TO value.'))) {
	KeywordUtil.markFailed('APN message does not contain expected text.')
}

WebUI.closeBrowser()
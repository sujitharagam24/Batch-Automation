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
 * Verify Associated APN panel exists 
 * This script will add a range of 5 APNs
 
 *currently a bug exists and only the From and To APN are added. 
 *Five APN values should be added when this works correctly.
 
 * @author michele.jazo
 *
 */

WebUI.callTestCase(findTestCase('Worksheet Page/Associated APN Panel/US8310 - As an SBC user I can add single APN in Transfer Workflow/Access the Worksheet and APN Panel'),
	[:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('APN Panel/p_Add APN'))

WebUI.click(findTestObject('APN Panel/APN Range/input_Add as Range_RadioOption'))

WebUI.click(findTestObject('APN Panel/APN Range/input_FromAPN_Range'))

WebUI.setText(findTestObject('APN Panel/APN Range/input_FromAPN_Range'),
	'1110000000001')

WebUI.click(findTestObject('APN Panel/APN Range/input_ToAPN_Range'))

WebUI.setText(findTestObject('APN Panel/APN Range/input_ToAPN_Range'),
	'1110000000005')

WebUI.click(findTestObject('Object Repository/APN Panel/button_Add APN'))

//WebUI.click(findTestObject('Object Repository/APN Panel/div_Associated APN added'))

WebUI.click(findTestObject('Object Repository/APN Panel/span_Close'))

findTestObject('Object Repository/APN Panel/APN Range/td_1110000000000')

findTestObject('Object Repository/APN Panel/APN Range/td_1110000000004')

WebUI.closeBrowser()

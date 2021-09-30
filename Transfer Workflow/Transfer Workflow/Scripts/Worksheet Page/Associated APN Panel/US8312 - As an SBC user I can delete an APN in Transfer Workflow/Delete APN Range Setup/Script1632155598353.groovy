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
 * Test case is dependent on Add APN Range script to be completed successfully
 * @author michele.jazo
 *
 */

WebUI.callTestCase(findTestCase('Workflow History Page/US8314 - As an SBC user I can complete a document in Transfer workflow/Access the Workflow History Page'),
	[:], FailureHandling.STOP_ON_FAILURE)

//Find Associated APN panel
WebUI.click(findTestObject('APN Panel/strong_Associated APN Panel'))

WebUI.click(findTestObject('Object Repository/APN Panel/DeleteTrashIcon'))

WebUI.click(findTestObject('Object Repository/APN Panel/span_Delete'))

WebUI.click(findTestObject('Object Repository/APN Panel/div_Associated APN deleted'))

WebUI.closeBrowser()
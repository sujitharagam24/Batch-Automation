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
 * Access the Associated Documents Panel panel through My Work tab
 * Select a document that contains Associated APN data
 * Verify Associated Documents document type data is expected value
 * @author michele.jazo
 *
 */

WebUI.callTestCase(findTestCase('Workflow History Page/US8314 - As an SBC user I can complete a document in Transfer workflow/Access the Workflow History Page'),
	[:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Associated Documents/div_Associated Documents'))

WebUI.click(findTestObject('Object Repository/Associated Documents/Associated Documents Data/td_NP0250'))

doctype = WebUI.getText(findTestObject('Object Repository/Associated Documents/Associated Documents Data/td_NP0250'))

System.out.println(doctype)

compare = "NP0250"

WebUI.verifyMatch(doctype, compare, false)

WebUI.closeBrowser()
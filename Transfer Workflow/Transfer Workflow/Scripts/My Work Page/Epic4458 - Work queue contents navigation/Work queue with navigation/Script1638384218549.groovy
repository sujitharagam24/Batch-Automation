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
 * Verify that paging does not exist for queues with short lists
 * @author michele.jazo
 *
 */

WebUI.callTestCase(findTestCase('My Work Page/US0002/Access the My Work Page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/My Work Page Objectory/Navigation/td_Deed - Historical'))

WebUI.click(findTestObject('Object Repository/My Work Page Objectory/Navigation/td_Data Entry Clerk Supervisor'))

WebUI.click(findTestObject('Object Repository/My Work Page Objectory/Navigation/div_HLP_mud-table-pagination-actions'))

WebUI.click(findTestObject('Object Repository/My Work Page Objectory/Navigation/div_HLP_mud-table-pagination-actions'))

WebUI.click(findTestObject('Object Repository/My Work Page Objectory/Navigation/div_HLP_mud-table-pagination-actions'))

WebUI.click(findTestObject('Object Repository/My Work Page Objectory/Navigation/div_HLP_mud-table-pagination-actions'))

WebUI.closeBrowser()

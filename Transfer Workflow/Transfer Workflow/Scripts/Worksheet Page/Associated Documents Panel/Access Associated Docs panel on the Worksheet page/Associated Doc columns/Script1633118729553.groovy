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
 * Verify Associated APN panel column names exist
 * @author michele.jazo
 *
 */

WebUI.callTestCase(findTestCase('Worksheet Page/Associated Documents Panel/Access Associated Docs panel on the Worksheet page/Access the Worksheet and Associated Document Record'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Associated Documents/div_Associated Documents'))

WebUI.click(findTestObject('Object Repository/Associated Documents/th_Doc'))

docnumber = WebUI.getText(findTestObject('Object Repository/Associated Documents/th_Doc'))

System.out.println(docnumber)

compare = "Doc #"

WebUI.verifyMatch(docnumber, compare, false)

WebUI.click(findTestObject('Object Repository/Associated Documents/th_Doc Type'))

doctype = WebUI.getText(findTestObject('Object Repository/Associated Documents/th_Doc Type'))

System.out.println(doctype)

compare = "Doc Type"

WebUI.verifyMatch(doctype, compare, false)

WebUI.click(findTestObject('Object Repository/Associated Documents/th_Rec Date'))

recdate = WebUI.getText(findTestObject('Object Repository/Associated Documents/th_Rec Date'))

System.out.println(recdate)

compare = "Rec Date"

WebUI.verifyMatch(recdate, compare, false)

WebUI.click(findTestObject('Object Repository/Associated Documents/th_Lead APN'))

leadapn = WebUI.getText(findTestObject('Object Repository/Associated Documents/th_Lead APN'))

System.out.println(leadapn)

compare = "Lead APN"

WebUI.verifyMatch(leadapn, compare, false)

WebUI.click(findTestObject('Object Repository/Associated Documents/th_Multi APN'))

multiapn = WebUI.getText(findTestObject('Object Repository/Associated Documents/th_Multi APN'))

System.out.println(multiapn)

compare = "Multi APN"

WebUI.verifyMatch(multiapn, compare, false)

WebUI.click(findTestObject('Object Repository/Associated Documents/th_Tract'))

trac = WebUI.getText(findTestObject('Object Repository/Associated Documents/th_Tract'))

System.out.println(trac)

compare = "Tract #"

WebUI.verifyMatch(trac, compare, false)

WebUI.click(findTestObject('Object Repository/Associated Documents/th_WF Step'))

workflow = WebUI.getText(findTestObject('Object Repository/Associated Documents/th_WF Step'))

System.out.println(workflow)

compare = "WF Step"

WebUI.verifyMatch(workflow, compare, false)

WebUI.click(findTestObject('Object Repository/Associated Documents/th_Grantee'))

grantee = WebUI.getText(findTestObject('Object Repository/Associated Documents/th_Grantee'))

System.out.println(grantee)

compare = "WF Step"

WebUI.verifyMatch(workflow, compare, false)

WebUI.closeBrowser()

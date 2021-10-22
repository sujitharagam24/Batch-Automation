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

/**
 * As an Appraisal, I want to see the Subject Property modPIMS Notes in "In Process" tab
 * @author ellie.mirzaei
 */
WebUI.callTestCase(findTestCase('00 Supporting Scripts/Dashboard Script'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/01 Residential Property Appraisal/02 Dashboard Page Elements/01 Queue Tabs Elements/In Process Tab'))

WebUI.click(findTestObject('Object Repository/01 Residential Property Appraisal/02 Dashboard Page Elements/02 Queue Grid Column Elements/Detail button'))

String notesHeaderExpected = "Parcel Number Note Date Note User" 

String notesHeaderActual= WebUI.getText(findTestObject('Object Repository/01 Residential Property Appraisal/02 Dashboard Page Elements/02 Queue Grid Column Elements/Parcel Detail Dialogo Box/Notes Header'))

print("Actual Headers : " + notesHeaderActual + System.lineSeparator() + "Expected Headers : " + notesHeaderExpected)

assertEquals(notesHeaderExpected, notesHeaderActual)

WebUI.closeBrowser()


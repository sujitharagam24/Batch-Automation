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

/**As an Appraiser, I want the ability to create more than one valuation for a subject property
* @author Elian Blanco
* */

WebUI.callTestCase(findTestCase('00 Supporting Scripts/Dashboard Script'), [:], FailureHandling.STOP_ON_FAILURE);

WebUI.click(findTestObject('Object Repository/02 Dashboard Page Elements/02 Queues Elements/In Process Tab'));

WebUI.click(findTestObject('Object Repository/02 Dashboard Page Elements/02 Queues Elements/Parcel Number'));

WebUI.click(findTestObject('Object Repository/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Select Valuation Tab'));

WebUI.click(findTestObject('Object Repository/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Valuation Type Drop Down'));

String selectedValuationType = WebUI.getText(findTestObject('Object Repository/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Market Land'));

WebUI.click(findTestObject('Object Repository/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Market Land'));

WebUI.click(findTestObject('Object Repository/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Save Button Valuation Tab'));

WebUI.click(findTestObject('Object Repository/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Show Other Types switch button'));

WebUI.click(findTestObject('Object Repository/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Valuation Type Drop Down'));

String secondSelectedValuationType = WebUI.getText(findTestObject('Object Repository/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Interim Use'));

WebUI.click(findTestObject('Object Repository/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Interim Use'));

WebUI.click(findTestObject('Object Repository/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Save Button Valuation Tab'));

CommonMethods.tableDataVerifier("//tbody[@class='mud-table-body']/tr", selectedValuationType );

CommonMethods.tableDataVerifier("//tbody[@class='mud-table-body']/tr", secondSelectedValuationType );

WebUI.closeBrowser();

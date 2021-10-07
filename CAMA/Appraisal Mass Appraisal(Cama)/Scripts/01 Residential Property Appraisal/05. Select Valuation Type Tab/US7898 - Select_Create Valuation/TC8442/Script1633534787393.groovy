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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import static org.junit.Assert.*
import org.eclipse.core.runtime.Assert as Assert

/**As an Appraiser, I want the ability to select what valuation I want to perform on a subject property
 * @author Elian Blanco
 * */

WebUI.callTestCase(findTestCase('01 Residential Property Appraisal/01. Application Landing/Dashboard Script'), [:], FailureHandling.STOP_ON_FAILURE);

WebUI.click(findTestObject('01 Residential Property Appraisal/02 Dashboard Page Elements/01 Queue Tabs Elements/In Process Tab'));

WebUI.click(findTestObject('01 Residential Property Appraisal/02 Dashboard Page Elements/02 Queue Grid Column Elements/Parcel Number'));

WebUI.click(findTestObject('01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Select Valuation Tab'));

WebUI.click(findTestObject('01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Valuation Type Drop Down'));

WebUI.verifyElementText(findTestObject('01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Land Market Appraisal'), 'Land Market Appraisal');
WebUI.verifyElementClickable(findTestObject('01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Land Market Appraisal'));

WebUI.verifyElementText(findTestObject('01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Interim Use'), 'Interim Use');
WebUI.verifyElementClickable(findTestObject('01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Interim Use'));

WebUI.verifyElementText(findTestObject('01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Basic Income Approach'), 'Basic Income Approach');
WebUI.verifyElementClickable(findTestObject('01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Basic Income Approach'));

WebUI.verifyElementText(findTestObject('01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Discounted Cash Flow'), 'Discounted Cash Flow');
WebUI.verifyElementClickable(findTestObject('01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Discounted Cash Flow'));

WebUI.verifyElementText(findTestObject('01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Rent Loss'), 'Rent Loss');
WebUI.verifyElementClickable(findTestObject('01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Rent Loss'));

WebUI.verifyElementText(findTestObject('01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Apartments Income'), 'Apartments Income');
WebUI.verifyElementClickable(findTestObject('01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Apartments Income'));

WebUI.verifyElementText(findTestObject('01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Apartments Market'), 'Apartments Market');
WebUI.verifyElementClickable(findTestObject('01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Apartments Market'));

WebUI.verifyElementText(findTestObject('01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Cost Template - Site Improvements'), 'Cost Template - Site Improvements');
WebUI.verifyElementClickable(findTestObject('01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Cost Template - Site Improvements'));

WebUI.verifyElementText(findTestObject('Object Repository/01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Single Family Residential'), 'Single Family Residential');
WebUI.verifyElementClickable(findTestObject('Object Repository/01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Single Family Residential'));

WebUI.click(findTestObject('01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Apartments Income'));

def selectedValuation = WebUI.getText(findTestObject('Object Repository/01 Residential Property Appraisal/03 Appraisal Wizard Page Elements/02 Select Valuation Tab/Valuation Type dropdown text field'));

System.out.println(selectedValuation);

WebUI.closeBrowser()


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
 * User can access Appraisal History page by clicking Appraisal History button from Dashboard page
 * @author elian.blanco
 */
WebUI.openBrowser(GlobalVariable.Url);

WebUI.click(findTestObject('Object Repository/01 Navigation Page Elements/Dashboard Button'));

WebUI.verifyElementNotPresent(findTestObject('Object Repository/02 Dashboard Page Elements/02 Queues Elements/Appraisal History Grid') , 20);

WebUI.click(findTestObject('Object Repository/01 Navigation Page Elements/Appraisal History Button'));

String appraisalHistoryTitle = WebUI.getText(findTestObject('Object Repository/04 Appraisal History Page Elements/Appraisal History Title'));

assertEquals(appraisalHistoryTitle, "Appraisal History");

WebUI.closeBrowser();


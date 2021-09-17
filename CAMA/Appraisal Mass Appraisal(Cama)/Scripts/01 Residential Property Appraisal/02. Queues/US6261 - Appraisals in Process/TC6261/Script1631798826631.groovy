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

/**As an Appraiser, I want the ability to sort all columns in the In Process Queue.
 * @author Elian Blanco
 *  */

WebUI.callTestCase(findTestCase('01 Residential Property Appraisal/01. Application Landing/Dashboard Script'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('01 Residential Property Appraisal/02 Dashboard Page Elements/01 Queue Tabs Elements/In Process Tab'));

WebUI.callTestCase(findTestCase('01 Residential Property Appraisal/02. Queues/Queues Column sorting TCs/Sorting Queue by Parcel Column'),
	[:], FailureHandling.STOP_ON_FAILURE);

WebUI.callTestCase(findTestCase('01 Residential Property Appraisal/02. Queues/Queues Column sorting TCs/Sorting Queue by Lag column'),
	[:], FailureHandling.STOP_ON_FAILURE);

WebUI.callTestCase(findTestCase('01 Residential Property Appraisal/02. Queues/Queues Column sorting TCs/Sorting Queue by event date'),
	[:], FailureHandling.STOP_ON_FAILURE);

WebUI.callTestCase(findTestCase('01 Residential Property Appraisal/02. Queues/Queues Column sorting TCs/Sorting Queue by Event column'),
	[:], FailureHandling.STOP_ON_FAILURE);

WebUI.callTestCase(findTestCase('01 Residential Property Appraisal/02. Queues/Queues Column sorting TCs/Sorting Queue by Req type column'),
	[:], FailureHandling.STOP_ON_FAILURE);

WebUI.callTestCase(findTestCase('01 Residential Property Appraisal/02. Queues/Queues Column sorting TCs/Sorting Queue by Use column'),
	[:], FailureHandling.STOP_ON_FAILURE);

WebUI.callTestCase(findTestCase('01 Residential Property Appraisal/02. Queues/Queues Column sorting TCs/Sorting Queue by Event Key column'),
	[:], FailureHandling.STOP_ON_FAILURE);

WebUI.callTestCase(findTestCase('01 Residential Property Appraisal/02. Queues/Queues Column sorting TCs/Sorting Queue by Post Key column'),
	[:], FailureHandling.STOP_ON_FAILURE);

WebUI.callTestCase(findTestCase('01 Residential Property Appraisal/02. Queues/Queues Column sorting TCs/Sorting Queue by District column'),
	[:], FailureHandling.STOP_ON_FAILURE);

WebUI.closeBrowser();

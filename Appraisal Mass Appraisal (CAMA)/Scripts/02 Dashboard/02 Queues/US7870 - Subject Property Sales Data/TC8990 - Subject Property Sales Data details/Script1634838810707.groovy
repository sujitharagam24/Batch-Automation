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
import org.eclipse.core.runtime.Assert

/** As an Appraisal, I want to see the Subject Property Sales Data
 * @author Elian Blanco
 * */

WebUI.callTestCase(findTestCase('00 Supporting Scripts/Dashboard Script'), [:], FailureHandling.STOP_ON_FAILURE);

WebUI.click(findTestObject('Object Repository/02 Dashboard Page Elements/02 Queues Elements/Detail button'));

String parcelDetailHeaderExpected = "Parcel Number Sale Date Multi Bad Doc Amount Conf Amount Adj Amount Use";

String parcelDetailHeaderActual = WebUI.getText(findTestObject('02 Dashboard Page Elements/02 Queues Elements/01 Parcel Detail Dialog Box Elements/Sales Data Grid column Headers'));

System.out.println("Actual Headers : " + parcelDetailHeaderActual + System.lineSeparator() + "expected Header: " + parcelDetailHeaderExpected);

assertEquals(parcelDetailHeaderExpected, parcelDetailHeaderActual);
 
WebUI.closeBrowser();


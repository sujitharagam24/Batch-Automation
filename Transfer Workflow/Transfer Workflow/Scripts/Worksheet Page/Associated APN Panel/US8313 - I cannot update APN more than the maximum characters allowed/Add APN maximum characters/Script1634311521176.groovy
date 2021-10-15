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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import org.eclipse.core.runtime.Assert as Assert
import static org.junit.Assert.*
/**
 *
 * Access the Worksheet Page through My Work tab
 * Verify Associated APN panel exists and add single APN using more than the maximum characters
 * @author michele.jazo
 *
 */

WebUI.callTestCase(findTestCase('Worksheet Page/Associated APN Panel/US8310 - As an SBC user I can add single APN in Transfer Workflow/Access the Worksheet and APN Panel'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('APN Panel/p_Add APN'))

public static long digits() {
    while (true) {
        long numb = (long)(Math.random() * 100000000 * 1000000); 
            return numb;
    }
}

String RandomDigits =String.valueOf(digits());
			
WebUI.setText(findTestObject('APN Panel/input_Lead APN'), 
    RandomDigits)

WebUI.getWindowIndex()

index = WebUI.getWindowIndex()

findTestObject('Object Repository/APN Panel/Max Character Msg')

maxmsg = WebUI.getText(findTestObject('Object Repository/APN Panel/Max Character Msg'))

System.out.println(maxmsg)

if (!(maxmsg.toString().contains('Secondary APN Number must not exceed 13 characters.'))) {
	KeywordUtil.markFailed('APN maximium character limit message does not contain expected text.')
}

WebUI.click(findTestObject('Object Repository/APN Panel/button_Add APN'))

maxmsg = WebUI.getText(findTestObject('Object Repository/APN Panel/Max Character Msg'))

System.out.println(maxmsg)

if (!(maxmsg.toString().contains('Secondary APN Number must not exceed 13 characters.'))) {
	KeywordUtil.markFailed('APN maximium character limit message does not contain expected text.')
}

WebUI.click(findTestObject('Object Repository/APN Panel/span_Close'))

WebUI.click(findTestObject('APN Panel/td_No Associated APNs'))

WebUI.closeBrowser()

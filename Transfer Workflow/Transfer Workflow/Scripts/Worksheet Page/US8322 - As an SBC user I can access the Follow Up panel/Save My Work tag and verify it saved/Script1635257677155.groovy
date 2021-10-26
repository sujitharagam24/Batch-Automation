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
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import static org.junit.Assert.*
import org.eclipse.core.runtime.Assert as Assert
import com.kms.katalon.core.testobject.TestObject as TestObject

/**
 *
 * Access the Follow Up panel on the Worksheet page
 * Verify Select Notice drop-down value can be saved
 * @author michele.jazo
 *
 */

WebUI.callTestCase(findTestCase('Worksheet Page/US8322 - As an SBC user I can access the Follow up panel/Access the Follow Up panel'), 
    [:], FailureHandling.STOP_ON_FAILURE)

findTestObject('Object Repository/Follow Up Panel/MyWorkTagDropDown')

expected = "Roll Year"

WebUI.click(findTestObject('Follow Up Panel/div_Notice'))

WebUI.click(findTestObject('Object Repository/Follow Up Panel/p_RollYear'))

//WebUI.click(findTestObject('Follow Up Panel/SelectPage'))

WebUI.click(findTestObject('Follow Up Panel/UpdateWS_Button'))

// Continue test here and check if value has been saved once this has been implemented

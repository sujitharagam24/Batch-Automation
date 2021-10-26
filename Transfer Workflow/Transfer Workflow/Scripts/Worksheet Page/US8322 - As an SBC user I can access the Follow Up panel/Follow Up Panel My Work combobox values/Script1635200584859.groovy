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
 * Verify Select Notice drop-down contains all values as expected
 * @author michele.jazo
 *
 */

WebUI.callTestCase(findTestCase('Worksheet Page/US8322 - As an SBC user I can access the Follow up panel/Access the Follow Up panel'), 
    [:], FailureHandling.STOP_ON_FAILURE)

findTestObject('Object Repository/Follow Up Panel/MyWorkTagDropDown')

expected = "Priority"

WebUI.click(findTestObject('Follow Up Panel/div_Notice'))

result = WebUI.getText(findTestObject('Object Repository/Follow Up Panel/p_Priority'))

System.out.println(result)

assertEquals(expected, result)

expected = "Scanning"

result = WebUI.getText(findTestObject('Object Repository/Follow Up Panel/p_Scanning'))

System.out.println(result)

assertEquals(expected, result)

expected = "Prop 90"

result = WebUI.getText(findTestObject('Object Repository/Follow Up Panel/p_Prop90'))

System.out.println(result)

assertEquals(expected, result)

expected = "Prop 60"

//WebUI.click(findTestObject('Follow Up Panel/div_Notice'))

result = WebUI.getText(findTestObject('Object Repository/Follow Up Panel/p_Prop60'))

System.out.println(result)

assertEquals(expected, result)

expected = "Research"

result = WebUI.getText(findTestObject('Object Repository/Follow Up Panel/p_Research'))

System.out.println(result)

assertEquals(expected, result)

expected = "Response"

result = WebUI.getText(findTestObject('Object Repository/Follow Up Panel/p_Response'))

System.out.println(result)

assertEquals(expected, result)

expected = "Mapping"

result = WebUI.getText(findTestObject('Object Repository/Follow Up Panel/p_Mapping'))

System.out.println(result)

assertEquals(expected, result)

expected = "Roll Year"

result = WebUI.getText(findTestObject('Object Repository/Follow Up Panel/p_RollYear'))

System.out.println(result)

assertEquals(expected, result)

expected = "Roll Year"

result = WebUI.getText(findTestObject('Object Repository/Follow Up Panel/p_RollYear'))

System.out.println(result)

assertEquals(expected, result)

expected = "Supervisor"

result = WebUI.getText(findTestObject('Object Repository/Follow Up Panel/p_Supervisor'))

System.out.println(result)

assertEquals(expected, result)

expected = "Supervisor"

result = WebUI.getText(findTestObject('Object Repository/Follow Up Panel/p_Supervisor'))

System.out.println(result)

assertEquals(expected, result)

expected = "Supervisor"

result = WebUI.getText(findTestObject('Object Repository/Follow Up Panel/p_Supervisor'))

System.out.println(result)

assertEquals(expected, result)

expected = "Awaiting"

result = WebUI.getText(findTestObject('Object Repository/Follow Up Panel/p_Awaiting'))

System.out.println(result)

assertEquals(expected, result)

expected = "Mapping"

result = WebUI.getText(findTestObject('Object Repository/Follow Up Panel/p_Mapping'))

System.out.println(result)

assertEquals(expected, result)

expected = "Problem Deed"

result = WebUI.getText(findTestObject('Object Repository/Follow Up Panel/p_ProblemDeed'))

System.out.println(result)

assertEquals(expected, result)

expected = "Prop 193"

result = WebUI.getText(findTestObject('Object Repository/Follow Up Panel/p_Prop193'))

System.out.println(result)

assertEquals(expected, result)

expected = "Title Company"

result = WebUI.getText(findTestObject('Object Repository/Follow Up Panel/p_TitleCompany'))

System.out.println(result)

assertEquals(expected, result)

expected = "Prop 58"

result = WebUI.getText(findTestObject('Object Repository/Follow Up Panel/p_Prop58'))

System.out.println(result)

assertEquals(expected, result)

WebUI.closeBrowser()

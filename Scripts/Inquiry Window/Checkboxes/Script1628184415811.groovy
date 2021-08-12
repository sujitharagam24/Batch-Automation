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
import org.openqa.selenium.Point as Point

WebUI.callTestCase(findTestCase('Login/Login Success'), [('userID') : 'XARTE', ('password') : 'Bilguun1\r\n', ('inquirySubsystem') : 'C:\\Program Files\\PIMS\\Inquiry\\Inquiry.exe'
        , ('titleSubsystem') : 'C:\\Program Files\\PIMS\\Title\\title.exe', ('securitySubsystem') : 'C:\\Program Files\\PIMS\\Security\\npsecuritymgr.exe'
        , ('utilitySubsystem') : 'C:\\Program Files\\PIMS\\Utility\\Utility.exe'], FailureHandling.STOP_ON_FAILURE)

def notPresent = Windows.waitForElementNotPresent(findWindowsObject('Object Repository/Login/Edit'), 25)

assert notPresent

Windows.switchToWindow(findWindowsObject('Object Repository/Title/Window'))

Windows.click(findWindowsObject('Object Repository/Title/downArrowButton'))

Windows.sendKeys(findWindowsObject('Object Repository/Dashboard/parcelField'), '010830101')

Windows.setText(findWindowsObject('Object Repository/Dashboard/parcelField', [('xpath') : '//Edit[1]']), '010830101')

Windows.closeApplication()


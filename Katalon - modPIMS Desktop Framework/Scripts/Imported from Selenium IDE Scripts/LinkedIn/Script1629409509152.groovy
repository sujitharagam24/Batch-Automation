import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.driver.KatalonWebDriverBackedSelenium
import static com.kms.katalon.core.webui.driver.KatalonWebDriverBackedSelenium.*

import com.thoughtworks.selenium.Selenium
import org.openqa.selenium.Keys
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.WebDriver
import static org.junit.Assert.*
import java.util.concurrent.Callable
import java.util.regex.Pattern
import static org.apache.commons.lang3.StringUtils.join

'----------------------------------------------------'
'This test case script is generated by Katalon Studio'
'Generated date: 19-Aug-2021 03:45:09 PM'
'File path: C:\\Users\\aRath\\Downloads\\KatalonImport.side'
'Generated by: andrew.rath@arrayinfotech.com'
'----------------------------------------------------'

String baseUrl = "https://www.google.com"

WebUI.openBrowser('')

selenium = new KatalonWebDriverBackedSelenium(baseUrl)

"open | https://www.linkedin.com/ |  | "
selenium.open("https://www.linkedin.com/")

"setWindowSize | 1936x1056 |  | "
// Method setWindowSize is not supported

"click | linkText=Forgot password? |  | "
selenium.click("linkText=Forgot password?")

"click | id=app__container |  | "
selenium.click("id=app__container")

"type | id=username | andrew.rath@arrayinfotech.com | "
selenium.type("id=username", "andrew.rath@arrayinfotech.com")

"click | id=reset-password-submit-button |  | "
selenium.click("id=reset-password-submit-button")

"assertText | css=.body__banner--error > span | We couldn't find an account associated with andrew.rath@arrayinfotech.com. Please try with an alternate email or phone number. | "
assertEquals("We couldn't find an account associated with andrew.rath@arrayinfotech.com. Please try with an alternate email or phone number.", selenium.getText("css=.body__banner--error > span"))

"close |  |  | "
selenium.close()

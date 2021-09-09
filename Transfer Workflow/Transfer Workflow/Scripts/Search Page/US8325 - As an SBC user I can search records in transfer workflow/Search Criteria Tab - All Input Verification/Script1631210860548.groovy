import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.SelectorMethod as SelectorMethod
import com.thoughtworks.selenium.Selenium as Selenium
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.openqa.selenium.WebDriver as WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern as Pattern
import static org.apache.commons.lang3.StringUtils.join
import org.testng.asserts.SoftAssert as SoftAssert
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://devmodpimsapptransferworkflow.azurewebsites.net/search')

WebUI.setText(findTestObject('Search Page Objectory/US8325/Page_Transfer Workflow/Record Doc number From field'), '111111')

selenium.type('xpath=(//input[@type="text"])[2]', '222222')

selenium.type('xpath=(//input[@type="text"])[3]', '3')

selenium.type('xpath=(//input[@type="text"])[4]', '4')

selenium.type('xpath=(//input[@type="text"])[5]', '5')

selenium.type('xpath=(//input[@type="text"])[6]', '6')

selenium.type('xpath=(//input[@type="text"])[7]', '7')

selenium.type('xpath=(//input[@type="text"])[8]', '8')

selenium.type('xpath=(//input[@type="text"])[9]', '9')

selenium.type('xpath=(//input[@type="text"])[10]', '10')

selenium.type('xpath=(//input[@type="text"])[11]', '11')

selenium.type('xpath=(//input[@type="text"])[12]', '12')

selenium.type('xpath=(//input[@type="text"])[13]', '13')

selenium.type('xpath=(//input[@type="text"])[14]', '14')

